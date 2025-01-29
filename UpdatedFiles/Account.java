package com.aetna.clinical.common.dto.test;

public class Account {
    private String cmmId;
    private String name;

    private String dob;
    private String status;
    private  String startDate;

    private String endDate;

    public String getCmmId() {
        return cmmId;
    }

    public void setCmmId(String cmmId) {
        this.cmmId = cmmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cmmId='" + cmmId + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", status='" + status + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
