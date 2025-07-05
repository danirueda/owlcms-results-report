package com.danirueda.owlcms_results_report.model;

import lombok.Data;

import java.util.List;

@Data
public class Competition {

    private Integer id;
    private String ageGroupsFileName;
    private Boolean announcerLiveDecisions;
    private String cardsTemplateFileName;
    private String competitionCity;
    private Integer[] competitionDate;
    private String competitionEndDate;
    private String competitionName;
    private String competitionOrganizer;
    private String competitionSite;
    private Boolean customScore;
    private Boolean enforce20kgRule;
    private String federation;
    private String federationAddress;
    private String federationEMail;
    private String federationWebSite;
    private String finalPackageTemplateFileName;
    private Boolean genderOrder;
    private Boolean fixedOrder;
    private String juryTemplateFileName;
    private Boolean masters;
    private Boolean mastersGenderEquality;
    private Integer maxTeamSize;
    private Integer maxPerCategory;
    private String protocolTemplateFileName;
    private String resultsTemplateFileName;
    private String introductionTemplateFileName;
    private Integer refereeWakeUpDelay;
    private Boolean roundRobinOrder;
    private Boolean snatchCJTotalMedals;
    private String weighInFormTemplateFileName;
    private String emptyProtocolTemplateFileName;
    private String startListTemplateFileName;
    private String scheduleTemplateFileName;
    private Boolean useBirthYear;
    private Boolean automaticCJBreak;
    private Boolean useCategorySinclair;
    private Integer sinclairYear;
    private Boolean useOldBodyWeightTieBreak;
    private Integer jurySize;
    private Integer longerBreakMax;
    private Integer longerBreakDuration;
    private Integer shorterBreakMin;
    private Integer shorterBreakDuration;
    private String categoriesListTemplateFileName;
    private String bodyWeightListTemplateFileName;
    private String officialsListTemplateFileName;
    private String teamsListTemplateFileName;
    private String recordOrder;
    private String scoringSystem;
    private Boolean displayScores;
    private Boolean displayScoreRanks;
    private String checkInTemplateFileName;
    private Boolean displayByAgeGroup;
    private Boolean announcerControlledJuryDecision;
    private String currentRecordsTemplateFileName;
    private Boolean masters20kg;
    private String technicalOfficialsTemplateFileName;
    private Boolean imwa;
    private Boolean deduct250g;
    private String computedFinalPackageTemplateFileName;
    private Boolean sinclair;
    private Boolean genderInclusive;
    private Integer invitedIfBornBefore;
    private String localizedCompetitionDate;
    private String translatedScoringSystemName;
    private Integer mensTeamSize;
    private Integer womensTeamSize;


}
