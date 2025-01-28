package com.aetna.clinical.common.dto.mappers;

import lombok.Data;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Member {

    @JsonProperty("person")
    private Person person;
    @JsonProperty("memberships")
    private List<Memberships> memberships;
    @JsonProperty("memberIdentifier")
    private MemberIdentifier memberIdentifier;

    @JsonProperty("relationshipToSubscriber")
    private String relationshipToSubscriber;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Memberships> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Memberships> memberships) {
        this.memberships = memberships;
    }

    public MemberIdentifier getMemberIdentifier() {
        return memberIdentifier;
    }

    public void setMemberIdentifier(MemberIdentifier memberIdentifier) {
        this.memberIdentifier = memberIdentifier;
    }

    public String getRelationshipToSubscriber() {
        return relationshipToSubscriber;
    }

    public void setRelationshipToSubscriber(String relationshipToSubscriber) {
        this.relationshipToSubscriber = relationshipToSubscriber;
    }

    @Override
    public String toString() {
        return "Member{" +
                "person=" + person +
                ", memberships=" + memberships +
                ", memberIdentifier=" + memberIdentifier +
                ", relationshipToSubscriber='" + relationshipToSubscriber + '\'' +
                '}';
    }
}
