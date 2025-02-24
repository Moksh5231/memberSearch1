package com.aetna.clinical.controller;

import com.aetna.clinical.common.dto.Testing;
import com.aetna.clinical.common.dto.mappers.AccountResponse;
import com.aetna.clinical.common.dto.mappers.MemberReponseV6;
import jdk.jfr.ContentType;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aetna.clinical.common.service.MemberService;

import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class memberSearchController {

    @Autowired
    private MemberService memberService;

   /* @Autowired
    LoggerAsyncService asyncLogger;*/


    private static Logger logger = LoggerFactory.getLogger(memberSearchController.class);

    @PostMapping("/memberSearch")
    public Map<String, Object> testConnectionToSf() {
        Testing data = new Testing(1, "Sample API response  Hello World");
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("data", data);
        response.put("status", "success");
        response.put("message", "Hello World");
        return response;
    }

    @GetMapping(value = "/memberSearch", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AccountResponse> getMemberById(@RequestParam(value = "memberId", required = false) String id, @RequestParam(value = "nameFirst", required = false) String nameFirst, @RequestParam(value = "nameLast", required = false) String nameLast, @RequestParam(value = "dateOfBirth", required = false) String dateOfBirth, @RequestParam(value = "phoneNumber", required = false) String phoneNumber) {
    //public AccountResponse getMemberById(@RequestParam(value = "memberId", required = false) String id, @RequestParam(value = "nameFirst", required = false) String nameFirst, @RequestParam(value = "nameLast", required = false) String nameLast, @RequestParam(value = "dateOfBirth", required = false) String dateOfBirth, @RequestParam(value = "phoneNumber", required = false) String phoneNumber) {
        logger.info("Entered into membersearch");
        StopWatch membersearchTime = null;
        try {
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyymmddhhmmss");
            String timestamp = df.format(date);
            membersearchTime = new StopWatch();

            membersearchTime.start();

            String METHOD_NAME = "getMemberById from memberSearchController";
            logger.info("  METHOD_NAME={} " + METHOD_NAME);
            // memberService.getMemberById(id,token);
            //return memberService.getMemberById(id,nameFirst,nameLast,dateOfBirth,phoneNumber);
            return new ResponseEntity<AccountResponse>(memberService.getMemberById(id,nameFirst,nameLast,dateOfBirth,phoneNumber), HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (!membersearchTime.isStopped()) {
                membersearchTime.stop();
                // asyncLogger.logControllerStatements("ProviderEnablement response for memberId/proxyId - [{}], Transaction Id - {}, ResponseTime - {} ms, response - {}", logger, encService.encrypt(objectConverter.convertToJson(providerEnablementResponse)), encryptedInputId, transactionId, providerEnablementTime);
            }
        }

    }
}


