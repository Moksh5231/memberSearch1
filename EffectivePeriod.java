package com.aetna.clinical.common.dto.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class EffectivePeriod {

    @JsonProperty("datetimeBegin")
    private String datetimeBegin;
    @JsonProperty("datetimeEnd")
    private String datetimeEnd;

    public String getDatetimeBegin() {
        return datetimeBegin;
    }

    public void setDatetimeBegin(String datetimeBegin) {
        this.datetimeBegin = datetimeBegin;
    }

    public String getDatetimeEnd() {
        return datetimeEnd;
    }

    public void setDatetimeEnd(String datetimeEnd) {
        this.datetimeEnd = datetimeEnd;
    }

    @Override
    public String toString() {
        return "EffectivePeriod{" +
                "datetimeBegin='" + datetimeBegin + '\'' +
                ", datetimeEnd='" + datetimeEnd + '\'' +
                '}';
    }
}
