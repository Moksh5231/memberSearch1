package com.aetna.clinical.common.dto.test;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class Membership {
    @JsonProperty("membershipIdentifier")
    private MembershipIdentifier membershipIdentifier;

    @JsonProperty("status")
    private String status;

    public MembershipIdentifier getMembershipIdentifier() {
        return membershipIdentifier;
    }

    public void setMembershipIdentifier(MembershipIdentifier membershipIdentifier) {
        this.membershipIdentifier = membershipIdentifier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "membershipIdentifier=" + membershipIdentifier +
                ", status='" + status + '\'' +
                '}';
    }
}
