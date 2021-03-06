package com.eservice.api.model.repair_record;

import javax.persistence.Column;
import java.util.Date;

public class RepairRecordInfo extends RepairRecord {

    public String getRepairActualInfoId() {
        return repairActualInfoId;
    }

    public void setRepairActualInfoId(String repairActualInfoId) {
        this.repairActualInfoId = repairActualInfoId;
    }

    private String repairActualInfoId;

    /**
     * 对应的订单号,来自sinsim_db.machine_order.order_num
     */
    @Column(name = "order_num")
    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getMachineCustomerId() {
        return machineCustomerId;
    }

    public void setMachineCustomerId(String machineCustomerId) {
        this.machineCustomerId = machineCustomerId;
    }

    private String machineCustomerId;

    /**
     * customer索引转换实际名字,来自 machine.customer-->user.name
     */
    private String machineCustomerName;

    public String getMachineCustomerName() {
        return machineCustomerName;
    }

    public void setMachineCustomerName(String machineCustomerName) {
        this.machineCustomerName = machineCustomerName;
    }

    /**
     * 索引转换实际名字,来自 machine.customer-->user-->agent.name
     */
    private String machineAgentName;

    public String getMachineAgentName() {
        return machineAgentName;
    }

    public void setMachineAgentName(String machineAgentName){
        this.machineAgentName = machineAgentName;
    }

    /**
     * 代理商ID号
     */
    private String machineAgentId;

    public String getMachineAgentId() {
        return machineAgentId;
    }

    public void setMachineAgentId(String machineAgentId) {
        this.machineAgentId = machineAgentId;
    }

    /**
     * 客户的公司ID
     */
    private String machineCustomerCompanyId;

    public String getMachineCustomerCompanyId() {
        return machineCustomerCompanyId;
    }

    public void setMachineCustomerCompanyId(String machineCustomerCompanyId) {
        this.machineCustomerCompanyId = machineCustomerCompanyId;
    }

    /**
     * 出厂日期（就是发货日期），老机器允许空
     */
    @Column(name = "facory_date")
    private Date facoryDate;


    public Date getFacoryDate() {
        return facoryDate;
    }

    public void setFacoryDate(Date facoryDate) {
        this.facoryDate = facoryDate;
    }

    /**
     * 故障部位ID列表,具体名称由前台解析
     */
    private String issuePositionList;

    public String getIssuePositionList() {
        return issuePositionList;
    }

    public void setIssuePositionList(String issuePositionNameList){
        this.issuePositionList = issuePositionNameList;
    }

    /**
     * 维修员
     */
    private String repairChargePersonName;

    public void setRepairChargePersonName(String repairChargePersonName) {
        this.repairChargePersonName = repairChargePersonName;
    }

    public String getRepairChargePersonName() {
        return repairChargePersonName;
    }

    /**
     * customer索引转换实际名字,来自 machine.customer-->user.phone
     */
    private String machineCustomerPhone;

    public void setMachineCustomerPhone(String machineCustomerPhone) {
        this.machineCustomerPhone = machineCustomerPhone;
    }

    public String getMachineCustomerPhone() {
        return machineCustomerPhone;
    }

    /**
     * 机器的客户的代理商的电话,来自 machine.customer-->user-->agent.phone
     */
    private String machineAgentPhone;

    public void setMachineAgentPhone(String machineAgentPhone) {
        this.machineAgentPhone = machineAgentPhone;
    }

    public String getMachineAgentPhone() {
        return machineAgentPhone;
    }

    /**
     * 机型
     */
    private String machineType;

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMachineType() {
        return machineType;
    }

    /**
     * 针数
     */
//    @Column(name = "needle_num")
    private String needleNum;

    public String getNeedleNum() {
        return needleNum;
    }

    public void setNeedleNum(String needleNum) {
        this.needleNum = needleNum;
    }

    /**
     * 头数
     */
//    @Column(name = "head_num")
    private String headNum;

    public String getHeadNum() {
        return headNum;
    }

    public void setHeadNum(String headNum) {
        this.headNum = headNum;
    }

//    @Column(name = "head_distance")
    private String headDistance;

    public String getHeadDistance() {
        return headDistance;
    }

    public void setHeadDistance(String headDistance) {
        this.headDistance = headDistance;
    }

//    @Column(name = "x_distance")
    private String xDistance;

    public String getxDistance() {
        return xDistance;
    }

    public void setxDistance(String xDistance) {
        this.xDistance = xDistance;
    }

//    @Column(name = "y_distance")
    private String yDistance;

    public String getyDistance() {
        return yDistance;
    }

    public void setyDistance(String yDistance) {
        this.yDistance = yDistance;
    }

    /**
     * 该次维修的维修联系人
     */
    private String customerNameInRepairRecord;

    /**
     * 该次维修的维修联系人电话
     */
    private String customerPhoneInRepairRecord;

    public void setCustomerPhoneInRepairRecord(String customerPhoneInRepairRecord) {
        this.customerPhoneInRepairRecord = customerPhoneInRepairRecord;
    }

    public String getCustomerPhoneInRepairRecord(){
        return customerPhoneInRepairRecord;
    }

    public String getCustomerNameInRepairRecord() {
        return customerNameInRepairRecord;
    }

    public void setCustomerNameInRepairRecord(String customerNameInRepairRecord){
        this.customerNameInRepairRecord = customerNameInRepairRecord;
    }
    /**
     * 该次维修的维修联系人地址（不是机器的地址）
     */
    private String customerAddressInRepairRecord;

    public void setCustomerAddressInRepairRecord(String customerAddressInRepairRecord) {
        this.customerAddressInRepairRecord = customerAddressInRepairRecord;
    }

    public String getCustomerAddressInRepairRecord() {
        return customerAddressInRepairRecord;
    }

    /**
     * 报修信息的标题
     */
    private String repairRequestTitle;

    public void setRepairRequestTitle(String repairRequestTitle){
        this.repairRequestTitle = repairRequestTitle;
    }

    public String getRepairRequestTitle(){
        return repairRequestTitle;
    }

    /**
     * 报修信息的内容描述
     */
    private String repairRequestContent;

    public void setRepairRequestContent(String repairRequestContent){
        this.repairRequestContent = repairRequestContent;
    }

    public String getRepairRequestContent(){
        return repairRequestContent;
    }

    /**
     * 报修信息的语音（保存的地址）
     */
    private String repairRequestVoice;

    public String getRepairRequestVoice(){
        return repairRequestVoice;
    }

    public void setRepairRequestVoice(String repairRequestVoice){
        this.repairRequestVoice = repairRequestVoice;
    }


    /**
     * 报修信息的照片（保存的地址）
     */
    private String repairRequestPictures;

    public void setRepairRequestPictures(String repairRequestPictures) {
        this.repairRequestPictures = repairRequestPictures;
    }

    public String getRepairRequestPictures() {
        return repairRequestPictures;
    }

    /**
     * 实际维修的问题描述
     */
    private String repairActualIssueDescription;

    public String getRepairActualIssueDescription() {
        return repairActualIssueDescription;
    }

    public void setRepairActualIssueDescription(String repairActualIssueDescription) {
        this.repairActualIssueDescription = repairActualIssueDescription;
    }

    /**
     * 实际维修的处理方法
     */
    private String repairActualMethod;

    public String getRepairActualMethod() {
        return repairActualMethod;
    }

    public void setRepairActualMethod(String repairActualMethod) {
        this.repairActualMethod = repairActualMethod;
    }

    /**
     * 实际维修的处理方法
     */
    private String afterResolvePictures;

    public void setAfterResolvePictures(String afterResolvePictures) {
        this.afterResolvePictures = afterResolvePictures;
    }

    public String getAfterResolvePictures() {
        return afterResolvePictures;
    }

    /**
     * 维修员负责人电话
     */
    private String repairChargePersonPhone;

    public void setRepairChargePersonPhone(String repairChargePersonPhone) {
        this.repairChargePersonPhone = repairChargePersonPhone;
    }

    public String getRepairChargePersonPhone() {
        return repairChargePersonPhone;
    }

    /**
     * 客户评价信息中的分数
     */
    private String repairFeedbackCustomerMark;

    public void setRepairFeedbackCustomerMark(String repairFeedbackCustomerMark) {
        this.repairFeedbackCustomerMark = repairFeedbackCustomerMark;
    }

    public String getRepairFeedbackCustomerMark() {
        return repairFeedbackCustomerMark;
    }

    /**
     * 客户评价信息中的建议内容
     */
    private String repairFeedbackCustomerSuggestion;

    public void setRepairFeedbackCustomerSuggestion(String repairFeedbackCustomerSuggestion) {
        this.repairFeedbackCustomerSuggestion = repairFeedbackCustomerSuggestion;
    }

    public String getRepairFeedbackCustomerSuggestion() {
        return repairFeedbackCustomerSuggestion;
    }

    /**
     * 客户评价信息中的维修结果
     */
    private String repairFeedbackRepairResult;

    public void setRepairFeedbackRepairResult(String repairFeedbackRepairResult) {
        this.repairFeedbackRepairResult = repairFeedbackRepairResult;
    }

    public String getRepairFeedbackRepairResult() {
        return repairFeedbackRepairResult;
    }

    //老机器的铭牌号照片
    private String repairRequestNameplatePicture;

    public String getRepairRequestNameplatePicture() {
        return repairRequestNameplatePicture;
    }

    public void setRepairRequestNameplatePicture(String repairRequestNameplatePicture) {
        this.repairRequestNameplatePicture = repairRequestNameplatePicture;
    }

    /**
     * 还需要返回 machine的ID，因为要让维修员更新老机器的信息时用到。
     */
    private Integer machineId;

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }
}
