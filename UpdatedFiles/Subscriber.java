package com.aetna.clinical.common.dto.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class Subscriber {
    @JsonProperty("person")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "person=" + person +
                '}';
    }
}
