package wifi4eu.wifi4eu.common.dto.model;

import javax.persistence.*;
import java.util.List;

public class VoucherAssignmentDTO {

    private Integer id;
    private UserDTO user;
    private Long executionDate;
    private int status;
    private CallDTO call;
    private List<VoucherSimulationDTO> voucherSimulations;

    public VoucherAssignmentDTO() {
    }

    public VoucherAssignmentDTO(Integer id, UserDTO user, Long executionDate, int status, CallDTO call, List<VoucherSimulationDTO> voucherSimulations) {
        this.id = id;
        this.user = user;
        this.executionDate = executionDate;
        this.status = status;
        this.call = call;
        this.voucherSimulations = voucherSimulations;
    }

    public VoucherAssignmentDTO(UserDTO user, Long executionDate, int status, CallDTO call, List<VoucherSimulationDTO> voucherSimulations) {
        this.user = user;
        this.executionDate = executionDate;
        this.status = status;
        this.call = call;
        this.voucherSimulations = voucherSimulations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Long getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Long executionDate) {
        this.executionDate = executionDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CallDTO getCall() {
        return call;
    }

    public void setCall(CallDTO call) {
        this.call = call;
    }

    public List<VoucherSimulationDTO> getVoucherSimulations() {
        return voucherSimulations;
    }

    public void setVoucherSimulations(List<VoucherSimulationDTO> voucherSimulations) {
        this.voucherSimulations = voucherSimulations;
    }
}
