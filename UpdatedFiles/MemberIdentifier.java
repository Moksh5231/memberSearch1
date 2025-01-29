package com.aetna.clinical.common.dto.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class MemberIdentifier {
    @JsonProperty("idSource")
    private String idSource;

    @JsonProperty("idValue")
    private String idValue;

    public String getIdSource() {
        return idSource;
    }

    public void setIdSource(String idSource) {
        this.idSource = idSource;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    @Override
    public String toString() {
        return "MemberIdentifier{" +
                "idSource='" + idSource + '\'' +
                ", idValue='" + idValue + '\'' +
                '}';
    }
}
