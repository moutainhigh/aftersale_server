package com.eservice.api.service.impl;

import com.eservice.api.dao.MaintainRecordMapper;
import com.eservice.api.model.maintain_record.MaintainRecord;
import com.eservice.api.model.maintain_record.MaintainRecordInfo;
import com.eservice.api.service.MaintainRecordService;
import com.eservice.api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
* Class Description: xxx
* @author Wilson Hu
* @date 2018/07/19.
*/
@Service
@Transactional
public class MaintainRecordServiceImpl extends AbstractService<MaintainRecord> implements MaintainRecordService {
    @Resource
    private MaintainRecordMapper maintainRecordMapper;

    public List<MaintainRecord> selectByNameplate(String nameplate){
        return maintainRecordMapper.selectByNameplate(nameplate);
    }

    public List<MaintainRecord> selectWaitProcessForGuest(String contacter){
        return maintainRecordMapper.selectWaitProcessForGuest(contacter);
    }

    public  List<MaintainRecordInfo> getMaintainRecordInfoList(String nameplate,
                                                               String orderNum,
                                                               String agent,
                                                               String maintainStatus,
                                                               String customerName,
                                                               String machineType,
                                                               String maintainChargePerson,
                                                               String query_start_time_maintain,
                                                               String query_finish_time_maintain,
                                                               boolean isFuzzy){
        return maintainRecordMapper.getMaintainRecordInfoList(
                nameplate,
                orderNum,
                machineType,
                agent,
                maintainStatus,
                customerName,
                maintainChargePerson,
                query_start_time_maintain,
                query_finish_time_maintain,
                isFuzzy);
    }
}
