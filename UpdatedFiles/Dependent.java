package com.aetna.clinical.common.dto.test;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class Dependent {
    @JsonProperty("person")
    private Person person;

    @JsonProperty("memberIdentifier")
    private MemberIdentifier memberIdentifier;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public MemberIdentifier getMemberIdentifier() {
        return memberIdentifier;
    }

    public void setMemberIdentifier(MemberIdentifier memberIdentifier) {
        this.memberIdentifier = memberIdentifier;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "person=" + person +
                ", memberIdentifier=" + memberIdentifier +
                '}';
    }
}
