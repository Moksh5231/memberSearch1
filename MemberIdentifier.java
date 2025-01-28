package com.aetna.clinical.common.dto.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



public class MemberIdentifier {

    @JsonProperty("idSource")
    private String idSource;

    @JsonProperty("idValue")
    private String idValue;
    @JsonProperty("idType")
    private String idType;

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

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    @Override
    public String toString() {
        return "MemberIdentifier{" +
                "idSource='" + idSource + '\'' +
                ", idValue='" + idValue + '\'' +
                ", idType='" + idType + '\'' +
                '}';
    }
}

