package com.aetna.clinical.common.service;

import com.aetna.clinical.common.dto.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aetna.clinical.common.client.MemberClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberClient memberClient;

    private static Logger logger = LoggerFactory.getLogger(MemberService.class);
public AccountResponse getMemberById(String id, String token)
{

   // System.out.println(memberClient.getMemberById(id, token));
    logger.info( "details are :"
            + memberClient.getMemberById(id,token).getBody());
     MemberReponseV6 memberReponseV6 =  memberClient.getMemberById(id,token).getBody();
     AccountResponse accountResponse = new AccountResponse();
     List<Account> accounts = new ArrayList<>();

     if(memberReponseV6.getReadMembersResponse()!= null){
         if(memberReponseV6.getReadMembersResponse().getMembers()!=null && memberReponseV6.getReadMembersResponse().getMembers().getMember()!=null && !memberReponseV6.getReadMembersResponse().getMembers().getMember().isEmpty()){
             for(Member member: memberReponseV6.getReadMembersResponse().getMembers().getMember()) {
                 MemberIdentifier memberIdentifier = member.getMemberIdentifier();
                 if (memberIdentifier != null && memberIdentifier.getIdSource() != null && memberIdentifier.getIdSource().equals("41")) {
                   List<Memberships> memberships = member.getMemberships();
                     Account account = new Account();
                     Person person = member.getPerson();
                     account.setName(person.getNameFirst() + " " + person.getNameLast());
                     account.setDob(person.getDateOfBirth());
                     account.setGender(person.getGender());
                     account.setRelationshipToSubscriber(member.getRelationshipToSubscriber());
                     for (Memberships m1 : memberships) {
                         MembershipIdentifier membershipIdentifier = m1.getMembershipIdentifier();
                         membershipIdentifier.setResourceId(membershipIdentifier.getIdSource() + "~" + membershipIdentifier.getIdValue());
                         account.setCmmId(membershipIdentifier.getResourceId());
                         account.setStatus(m1.getStatus());
                         EffectivePeriod effectivePeriod = m1.getEffectivePeriod();
                         account.setStartDate(effectivePeriod.getDatetimeBegin());
                         account.setEndDate(effectivePeriod.getDatetimeEnd());
                     }
                     accounts.add(account);
                 }
             }
         }
     }
     accountResponse.setAccounts(accounts);
     return accountResponse;
}

}

