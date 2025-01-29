package com.aetna.clinical.common.dto.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class Person {
    @JsonProperty("nameFirst")
    private String nameFirst;

    @JsonProperty("nameLast")
    private String nameLast;

    @JsonProperty("dateOfBirth")
    private String dateOfBirth; // Use LocalDate if preferred

    @JsonProperty("gender")
    private String gender;

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameFirst='" + nameFirst + '\'' +
                ", nameLast='" + nameLast + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
