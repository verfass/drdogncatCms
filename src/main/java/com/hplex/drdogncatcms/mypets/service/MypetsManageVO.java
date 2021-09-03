package com.hplex.drdogncatcms.mypets.service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class MypetsManageVO extends MypetsDefaultVO {

    private static final long serialVersionUID = 4412712346517816630L;

    private String seq;
    private String memberSeq;
    private String petName;
    private String petType;
    private String petSize;
    private String petSex;
    private String petDesexualizationAt;
    private String petBirthday;
    private String petWithday;
    private String petWeight;
    private String petKind;
    private String petLifePlace;
    private String petBmi;
    private String petUrineTimes;
    private String petDefecationTimes;
    private String petVaccine1State;
    private String petVaccine2State;
    private String petFamilyType;
    private String petPetsAmount;
    private String petAloneTimes;
    private String petWalkTimes;
    private String petPastDisease;
    private String petAllergy;
    private String petRegNumber;
    private String petTrouble;
    private String petPic;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;

}
