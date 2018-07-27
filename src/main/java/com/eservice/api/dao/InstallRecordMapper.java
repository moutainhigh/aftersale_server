package com.eservice.api.dao;

import com.eservice.api.core.Mapper;
import com.eservice.api.model.install_record.InstallRecord;
import com.eservice.api.model.install_record.InstallRecordInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

public interface InstallRecordMapper extends Mapper<InstallRecord> {

    List<InstallRecord> selectWaitProcessForGuest(@Param("contacter") String contacter);

    InstallRecord selectByNameplate(@Param("nameplate")String nameplate);

    List<InstallRecordInfo> getInstallDetail(@Param("nameplate")String nameplate);
}