package com.aetna.clinical.common.dto.test;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class MembershipIdentifier {
    @JsonProperty("resourceId")
    private String resourceId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "MembershipIdentifier{" +
                "resourceId='" + resourceId + '\'' +
                '}';
    }
}
