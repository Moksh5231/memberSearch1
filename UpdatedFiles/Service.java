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

    public AccountResponse getMemberById(String id, String token) {

        // System.out.println(memberClient.getMemberById(id, token));
        logger.info("details are :"
                + memberClient.getMemberById(id, token).getBody());
        MemberReponseV6 memberReponseV6 = memberClient.getMemberById(id, token).getBody();
        AccountResponse accountResponse = new AccountResponse();
        List<Account> accounts = new ArrayList<>();

        if (memberReponseV6.getReadMembersResponse() != null) {
            if (memberReponseV6.getReadMembersResponse().getMembers() != null && memberReponseV6.getReadMembersResponse().getMembers().getMember() != null && !memberReponseV6.getReadMembersResponse().getMembers().getMember().isEmpty()) {
                for (Member member : memberReponseV6.getReadMembersResponse().getMembers().getMember()) {
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
                        Subscriber sb = member.getSubscriber();
                        if (sb != null && sb.getPerson() != null) {
                            Person p1 = sb.getPerson();
                            Account ac = new Account();
                            ac.setName(p1.getNameFirst() + " " + p1.getNameLast());
                            ac.setDob(p1.getDateOfBirth());
                            ac.setGender(p1.getGender());
                            List<Memberships> ms = sb.getMemberships() != null ? new ArrayList<>() : sb.getMemberships();

                            for (Memberships m2 : ms) {
                                MembershipIdentifier membershipIdentifier = m2.getMembershipIdentifier();
                                membershipIdentifier.setResourceId(membershipIdentifier.getIdSource() + "~" + membershipIdentifier.getIdValue());
                                ac.setCmmId(membershipIdentifier.getResourceId());
                                ac.setStatus(m2.getStatus());
                                EffectivePeriod effectivePeriod = m2.getEffectivePeriod();
                                ac.setStartDate(effectivePeriod.getDatetimeBegin());
                                ac.setEndDate(effectivePeriod.getDatetimeEnd());
                            }
                           // accounts.add(ac);
                        }

                        List<Dependent> dependents = member.getDependents();
                        if (dependents != null) {
                            for (Dependent dep : dependents) {
                                Person p1 = dep.getPerson();
                                Account ac = new Account();
                                ac.setName(p1.getNameFirst() + " " + p1.getNameLast());
                                ac.setDob(p1.getDateOfBirth());
                                ac.setGender(p1.getGender());
                                ac.setRelationshipToSubscriber(dep.getRelationshipToSubscriber());
                                List<Memberships> ms = dep.getMemberships() != null ? new ArrayList<>() : dep.getMemberships();

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
                        }
                    }
                }
            }
        }
            accountResponse.setAccounts(accounts);
            return accountResponse;
        }

    }
