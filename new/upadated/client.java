package com.aetna.clinical.common.client;

import com.aetna.clinical.common.util.Constants;
import com.aetna.clinical.common.dto.mappers.MemberReponseV6;
import com.aetna.clinical.common.util.GenericHelper;
import com.aetna.clinical.common.util.MembersHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import com.aetna.clinical.common.dto.mappers.ReadMembersResponse;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class MemberClient {

    private final RestClient restClient;

    @Autowired
    //private GenericHelper genericHelper;
    private MembersHelper memberHelper;

    @Autowired
    private static Logger logger = LoggerFactory.getLogger(MemberClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public MemberClient() {
        restClient = RestClient.builder()
                .baseUrl("https://qaapi01.aetna.com")
                .build();


    }

    String finalMembersServiceApicUrl = null;

    public ResponseEntity<MemberReponseV6> getMemberById(String memberId) {
        ResponseEntity<MemberReponseV6> response = null;
        try {
        String pathVariable = "healthcare/qapath1/hcb/v6/members";
        // String token1 = String.valueOf(memberHelper.buildMembersHttpHeader());
        HttpHeaders httpHeaders = memberHelper.buildMembersHttpHeader();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> membersEntity = new HttpEntity<String>(httpHeaders);
        logger.info("token value is :" + httpHeaders);
        String membersServiceUrl = "&responseExpansionLevel=Expanded&fromDate=2022-01-24&toDate=2025-10-25&voidedCoverageRequiredInd=Y&needCommPrefAttributes=Y&psRequiredInd=Y&validHSAMemberships=Y&individualLevelSearchInd=Y&medicaidInd=Y";
        //finalMembersServiceApicUrl = "https://qaapi01.aetna.com/healthcare/qapath1/hcb/v6/members?memberId=" + memberId + membersServiceUrl;
        finalMembersServiceApicUrl = "https://qaapi01.int.aetna.com/healthcare/qapath1/hcb/at/v6/members?memberId=" + memberId + membersServiceUrl;
        logger.info("URL:" + finalMembersServiceApicUrl);
        response = restTemplate.exchange(finalMembersServiceApicUrl, HttpMethod.GET, membersEntity, MemberReponseV6.class);

        }
        catch(Exception genericException) {
            logger.error("GenericException in Member Search service layer for error message - {}>>>" ,  genericException.getMessage());
            throw genericException;
        }
        return response;
    }

    public ResponseEntity<MemberReponseV6> getMemberByPhoneNumber(String phoneNumber) {
        ResponseEntity<MemberReponseV6> response = null;
        try {
        String pathVariable = "healthcare/qapath1/hcb/v6/members";
        // String token1 = String.valueOf(memberHelper.buildMembersHttpHeader());
        HttpHeaders httpHeaders = memberHelper.buildMembersHttpHeader();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> membersEntity = new HttpEntity<String>(httpHeaders);
        logger.info("token value is :" + httpHeaders);
        String membersServiceUrl = "&responseExpansionLevel=Expanded&fromDate=2022-01-24&toDate=2025-10-25&voidedCoverageRequiredInd=Y&needCommPrefAttributes=Y&psRequiredInd=Y&validHSAMemberships=Y&medicaidInd=Y&individual";
        finalMembersServiceApicUrl = "https://qaapi01.int.aetna.com/healthcare/qapath1/hcb/at/v6/members?phoneNumber=" + phoneNumber + membersServiceUrl;
        logger.info("URL:" + finalMembersServiceApicUrl);
        response = restTemplate.exchange(finalMembersServiceApicUrl, HttpMethod.GET, membersEntity, MemberReponseV6.class);
        }
        catch(Exception genericException) {
            logger.error("GenericException in Member Search service layer for error message - {}>>>" ,  genericException.getMessage());
            throw genericException;
        }
        return response;
    }

    public ResponseEntity<MemberReponseV6> getMemberByName(String fName, String lName, String dob) {
        ResponseEntity<MemberReponseV6> response = null;
        try {
        String pathVariable = "healthcare/qapath1/hcb/v6/members";
        // String token1 = String.valueOf(memberHelper.buildMembersHttpHeader());
        HttpHeaders httpHeaders = memberHelper.buildMembersHttpHeader();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> membersEntity = new HttpEntity<String>(httpHeaders);
        logger.info("token value is :" + httpHeaders);
        String membersServiceUrl = "&responseExpansionLevel=Expanded&fromDate=2022-01-24&toDate=2025-10-25&voidedCoverageRequiredInd=Y&needCommPrefAttributes=Y&psRequiredInd=Y&validHSAMemberships=Y&individualLevelSearchInd=Y&medicaidInd=Y";
        finalMembersServiceApicUrl = "https://qaapi01.int.aetna.com/healthcare/qapath1/hcb/at/v6/members?nameFirst=" + fName +"&nameLast="+ lName + "&dateOfBirth=" +dob+membersServiceUrl;
        logger.info("URL:" + finalMembersServiceApicUrl);
        response = restTemplate.exchange(finalMembersServiceApicUrl, HttpMethod.GET, membersEntity, MemberReponseV6.class);
        }
        catch(Exception genericException) {
            logger.error("GenericException in Member Search service layer for error message - {}>>>" ,  genericException.getMessage());
            throw genericException;
        }
        return response;
    }
}

