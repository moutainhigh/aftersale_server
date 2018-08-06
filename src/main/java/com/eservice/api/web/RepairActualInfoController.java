package com.eservice.api.web;
import com.eservice.api.core.Result;
import com.eservice.api.core.ResultGenerator;
import com.eservice.api.model.parts_info.PartsInfo;
import com.eservice.api.model.repair_actual_info.RepairActualInfo;
import com.eservice.api.model.repair_record.RepairRecord;
import com.eservice.api.service.PartsInfoService;
import com.eservice.api.service.RepairActualInfoService;
import com.eservice.api.service.common.Constant;
import com.eservice.api.service.impl.RepairActualInfoServiceImpl;
import com.eservice.api.service.impl.RepairRecordServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
* Class Description: xxx
* @author Wilson Hu
* @date 2018/08/04.
*/
@RestController
@RequestMapping("/repair/actual/info")
public class RepairActualInfoController {
    @Resource
    private RepairActualInfoServiceImpl repairActualInfoService;
    @Resource
    PartsInfoService partsInfoService;
    @Resource
    private RepairRecordServiceImpl repairRecordService;

    /**
     * 在上传实际维修情况时，也同时上传了要寄回的配件，更新record状态
     */
    @PostMapping("/add")
    public Result add(@RequestBody @NotNull RepairActualInfo repairActualInfo, @RequestBody @NotNull  PartsInfo partsInfo) {
        try {
            repairActualInfoService.saveAndGetID(repairActualInfo);

            partsInfo.setRepairActualInfoId(repairActualInfo.getId());
            partsInfoService.update(partsInfo);

            RepairRecord repairRecord = repairRecordService.findById(repairActualInfo.getRepairRecordId());
            repairRecord.setStatus(Constant.REPAIR_STATUS_REPAIR_OK);
            repairRecordService.update(repairRecord);
        } catch (Exception ex) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultGenerator.genFailResult("数据更新出错！" + ex.getMessage());
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        repairActualInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody @NotNull RepairActualInfo repairActualInfo) {
        repairActualInfoService.update(repairActualInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam @NotNull Integer id) {
        RepairActualInfo repairActualInfo = repairActualInfoService.findById(id);
        return ResultGenerator.genSuccessResult(repairActualInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<RepairActualInfo> list = repairActualInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
