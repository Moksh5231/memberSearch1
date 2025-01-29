package com.aetna.clinical.common.dto.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class Response {

    @JsonProperty("accounts")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Response{" +
                "account=" + account +
                '}';
    }
}

