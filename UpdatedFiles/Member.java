package com.aetna.clinical.common.dto.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


public class Member {
    @JsonProperty("memberIdentifier")
    private MemberIdentifier memberIdentifier;

    @JsonProperty("person")
    private Person person;

    @JsonProperty("memberships")
    private List<Membership> memberships;

    @JsonProperty("dependents")
    private List<Dependent> dependents;

    @JsonProperty("subscriber")
    private Subscriber subscriber;

    public MemberIdentifier getMemberIdentifier() {
        return memberIdentifier;
    }

    public void setMemberIdentifier(MemberIdentifier memberIdentifier) {
        this.memberIdentifier = memberIdentifier;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberIdentifier=" + memberIdentifier +
                ", person=" + person +
                ", memberships=" + memberships +
                ", dependents=" + dependents +
                ", subscriber=" + subscriber +
                '}';
    }
}
