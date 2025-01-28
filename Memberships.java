package com.aetna.clinical.common.dto.mappers;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Memberships {

    @JsonProperty("status")
    private String status;
    @JsonProperty("effectivePeriod")
    private EffectivePeriod effectivePeriod;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EffectivePeriod getEffectivePeriod() {
        return effectivePeriod;
    }

    public void setEffectivePeriod(EffectivePeriod effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }

    @Override
    public String toString() {
        return "Memberships{" +
                "status='" + status + '\'' +
                ", effectivePeriod=" + effectivePeriod +
                '}';
    }
}
