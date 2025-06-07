package com.example.nono.s_online_clinic.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class LeaveStatsDTO {
    private int pendingLeaves;
    private int approvedLeaves;
    private int rejectedLeaves;
    private int leaveBalance;


    public LeaveStatsDTO(int remainingBalance) {
    }

    public LeaveStatsDTO(int pendingLeaves, int approvedLeaves, int rejectedLeaves, int leaveBalance) {
        this.pendingLeaves = pendingLeaves;
        this.approvedLeaves = approvedLeaves;
        this.rejectedLeaves = rejectedLeaves;
        this.leaveBalance = leaveBalance;
    }

    public int getPendingLeaves() {
        return pendingLeaves;
    }

    public void setPendingLeaves(int pendingLeaves) {
        this.pendingLeaves = pendingLeaves;
    }

    public int getApprovedLeaves() {
        return approvedLeaves;
    }




    public void setApprovedLeaves(int approvedLeaves) {
        this.approvedLeaves = approvedLeaves;
    }

    public int getRejectedLeaves() {
        return rejectedLeaves;
    }

    public void setRejectedLeaves(int rejectedLeaves) {
        this.rejectedLeaves = rejectedLeaves;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
}
