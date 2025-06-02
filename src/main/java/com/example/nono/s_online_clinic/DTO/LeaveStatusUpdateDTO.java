package com.example.nono.s_online_clinic.DTO;


import com.example.nono.s_online_clinic.model.LeaveStatus;
import lombok.Data;

@Data
public class LeaveStatusUpdateDTO {
    private Long leaveId;
    private LeaveStatus status;
    private String updatedBy;

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
