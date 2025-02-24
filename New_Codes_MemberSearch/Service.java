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
    public AccountResponse getMemberById(String id, String nameFirst,String nameLast,String dateOfBirth,String phoneNumber)
    {
        MemberReponseV6 memberReponseV6 = null;
        if(id!=null){
            memberReponseV6 = memberClient.getMemberById(id).getBody();
        } else if (nameFirst!= null && nameLast != null && dateOfBirth != null) {
            memberReponseV6 = memberClient.getMemberByName(nameFirst,nameLast,dateOfBirth).getBody();

        }
        else if (phoneNumber != null){
            memberReponseV6 = memberClient.getMemberByPhoneNumber(phoneNumber).getBody();
        }
        // System.out.println(memberClient.getMemberById(id, token));
        AccountResponse accountResponse = new AccountResponse();
        List<Account> accounts = new ArrayList<>();


        if (memberReponseV6  != null  && memberReponseV6.getReadMembersResponse() != null ) {
            if (memberReponseV6.getReadMembersResponse().getMembers() != null && memberReponseV6.getReadMembersResponse().getMembers().getMember() != null && !memberReponseV6.getReadMembersResponse().getMembers().getMember().isEmpty()) {
                for (Member member : memberReponseV6.getReadMembersResponse().getMembers().getMember()) {
                    MemberIdentifier memberIdentifier = member.getMemberIdentifier();
                    if (memberIdentifier != null && memberIdentifier.getIdSource() != null && memberIdentifier.getIdSource().equals("41")) {
                        List<Memberships> memberships = member.getMemberships();
                        Account account = new Account();
                        Person person = member.getPerson();
                        logger.info("person info"+person);
                        logger.info("relationshipToMembership"+member.getRelationshipToSubscriber());
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
                        logger.info("account info added at 1st" +account);
                        //accounts.add(account);
                        Subscriber sb = member.getSubscriber();
                        if (sb != null && sb.getPerson() != null) {
                            Person p1 = sb.getPerson();
                            Account ac = new Account();
                            ac.setName(p1.getNameFirst() + " " + p1.getNameLast());
                            ac.setDob(p1.getDateOfBirth());
                            ac.setGender(p1.getGender());
                            List<Memberships> ms = sb.getMemberships() != null ? sb.getMemberships() : new ArrayList<>() ;

                            for (Memberships m2 : ms) {
                                MembershipIdentifier membershipIdentifier = m2.getMembershipIdentifier();
                                membershipIdentifier.setResourceId(membershipIdentifier.getIdSource() + "~" + membershipIdentifier.getIdValue());
                                ac.setCmmId(membershipIdentifier.getResourceId());
                                ac.setStatus(m2.getStatus());
                                EffectivePeriod effectivePeriod = m2.getEffectivePeriod();
                                ac.setStartDate(effectivePeriod.getDatetimeBegin());
                                ac.setEndDate(effectivePeriod.getDatetimeEnd());
                            }
                            accounts.add(ac);
                        }

                        List<Dependent> dependents = member.getDependents();
                        // logger.info("dependent info" + dependents);
                        if (dependents != null) {
                            for (Dependent dep : dependents) {
                                Person p1 = dep.getPerson();
                                Account ac = new Account();
                                ac.setName(p1.getNameFirst() + " " + p1.getNameLast());
                                ac.setDob(p1.getDateOfBirth());
                                ac.setGender(p1.getGender());
                                ac.setRelationshipToSubscriber(dep.getRelationshipToSubscriber());
                                //logger.info("dep.getMemberships() value is"+dep.getMemberships());
                                List<Memberships> ms = dep.getMemberships() != null ?  dep.getMemberships(): new ArrayList<>();
                                //logger.info("outside membership m2");
                                for (Memberships m2 : ms) {
                                    //logger.info("Inside membership m2");
                                    MembershipIdentifier membershipIdentifier = m2.getMembershipIdentifier();
                                    membershipIdentifier.setResourceId(membershipIdentifier.getIdSource() + "~" + membershipIdentifier.getIdValue());
                                    //logger.info("hardcoded value" +membershipIdentifier.getIdSource() + "~" + membershipIdentifier.getIdValue());
                                    //logger.info("resourceId is" +membershipIdentifier.getResourceId());
                                    ac.setCmmId(membershipIdentifier.getResourceId());
                                    // logger.info("set value of status is:"+m2.getStatus());
                                    ac.setStatus(m2.getStatus());
                                    //logger.info("effective period is"+m2.getEffectivePeriod());
                                    EffectivePeriod effectivePeriod = m2.getEffectivePeriod();
                                    ac.setStartDate(effectivePeriod.getDatetimeBegin());
                                    ac.setEndDate(effectivePeriod.getDatetimeEnd());
                                }
                                logger.info("account info added at last" +ac);
                                accounts.add(ac);
                            }
                        }
                    }
                }
            }
        }
        accountResponse.setAccounts(accounts);
        return accountResponse;
    }

}
