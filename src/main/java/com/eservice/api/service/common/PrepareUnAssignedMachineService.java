package com.eservice.api.service.common;

import com.eservice.api.model.machine.Machine;
import com.eservice.api.model.machine.MachineInfosInProcessDb;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HT
 */
@Service
public class PrepareUnAssignedMachineService {

    private Connection aftersaleMysqlConn;

    private Connection sinsimMysqlConn;

    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 售后数据库
     */
    @Value("${spring.datasource.url}")
    private String aftersale_db_url;

    @Value("${spring.datasource.username}")
    private String user_aftersale_db;

    @Value("${spring.datasource.password}")
    private String password_aftersale_db = "hello123!";

    /**
     * 生产部数据库
     */
    @Value("${spring.datasource_sinsim_db.url}")
    private String sinsim_db_url;

    @Value("${spring.datasource_sinsim_db.username}")
    private String user_sinsim_db;

    @Value("${spring.datasource_sinsim_db.password}")
    private String password_sinsim_db;

    private Logger logger = Logger.getLogger(PrepareUnAssignedMachineService.class);

    private List<MachineInfosInProcessDb> installedNotBoundedMachineList = new ArrayList<>();
    /**
     * 每 60min 发一次
     */
    @Scheduled(fixedRate = 1000 * 60 * 15 )
    public void prepareUnAssignedMachine() {
        try {
            aftersaleMysqlConn = DriverManager.getConnection(aftersale_db_url,user_aftersale_db,password_aftersale_db);
            sinsimMysqlConn = DriverManager.getConnection(sinsim_db_url,user_sinsim_db,password_sinsim_db);
            ResultSet rs1 = aftersaleMysqlConn.prepareStatement("SELECT * FROM machine").executeQuery();
            ResultSet rs2 = sinsimMysqlConn.prepareStatement(" select m.*,mo.needle_num,mo.head_num,mo.head_distance,mo.x_distance,mo.y_distance,mo.order_num, mt.name as machine_type_name,c.contract_num,c.customer_name" +
                    " from  machine m " +
                    "left join machine_order mo on mo.id=m.order_id " +
                    "left join machine_type mt on mt.id=m.machine_type " +
                    "left join contract c on c.id = mo.contract_id " +
                    "where m.status='" + com.eservice.api.service.common.Constant.MACHINE_INSTALLED + "' ").executeQuery();
            List<MachineInfosInProcessDb> installedMachineList = new ArrayList<>();
            List<Machine> boundMachineList = new ArrayList<>();
            while(rs2.next()) {
                MachineInfosInProcessDb machine = new MachineInfosInProcessDb();
                machine.setOrderId(rs2.getInt("order_id"));
                machine.setNameplate(rs2.getString("nameplate"));
                machine.setMachineType(rs2.getInt("machine_type"));
                machine.setOrderNum(rs2.getString("order_num"));
                installedMachineList.add(machine);
            }

            while(rs1.next()) {
                Machine machine = new Machine();
                machine.setStatus(rs1.getString("status"));
                machine.setCustomer(rs1.getInt("customer"));
                machine.setNameplate(rs1.getString("nameplate"));
                machine.setOrderNum(rs1.getString("order_num"));
                boundMachineList.add(machine);
            }
            installedNotBoundedMachineList.clear();
            if(installedMachineList.size() > boundMachineList.size()) {
                for (MachineInfosInProcessDb item: installedMachineList) {
                    boolean exist = false;
                    for (int i = 0; i < boundMachineList.size() && !exist; i++) {
                        if(item.getNameplate() != null && item.getNameplate().equals(boundMachineList.get(i).getNameplate())) {
                            exist = true;
                        }
                    }
                    if(!exist) {
                        installedNotBoundedMachineList.add(item);
                    }
                }
            }

            aftersaleMysqlConn.close();
            sinsimMysqlConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("Query data exception: " + e.toString());
        }
    }

    public List<MachineInfosInProcessDb> getInstalledNotBoundMachineList() {
        return installedNotBoundedMachineList;
    }
}
