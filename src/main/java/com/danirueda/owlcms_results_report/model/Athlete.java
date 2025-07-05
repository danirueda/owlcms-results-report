package com.danirueda.owlcms_results_report.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Athlete {

    private Long id;
    private List<Participation> participations = new ArrayList<>();
    private Long category;
    private BigDecimal bodyWeight;
    private BigDecimal scaleWeight;
    private Integer catSinclairRank;

    private String cleanJerk1ActualLift;
    private String cleanJerk1Change1;
    private String cleanJerk1Change2;
    private String cleanJerk1Declaration;
    private List<Integer> cleanJerk1LiftTime = new ArrayList<>();

    private String cleanJerk2ActualLift;
    private String cleanJerk2Change1;
    private String cleanJerk2Change2;
    private String cleanJerk2Declaration;
    private List<Integer> cleanJerk2LiftTime = new ArrayList<>();

    private String cleanJerk3ActualLift;
    private String cleanJerk3Change1;
    private String cleanJerk3Change2;
    private String cleanJerk3Declaration;
    private List<Integer> cleanJerk3LiftTime = new ArrayList<>();

    private String coach;
    private Integer combinedRank;
    private String custom1;
    private String custom2;
    private BigDecimal customScore;

    private Boolean eligibleForIndividualRanking;
    private Boolean eligibleForTeamRanking;

    private String federationCodes;
    private String firstName;
    private Integer[] fullBirthDate;
    private String gender;
    private Long group;
    private String lastName;
    private Integer lotNumber;
    private String membership;

    private Integer personalBestCleanJerk;
    private Integer personalBestSnatch;
    private Integer personalBestTotal;

    private Integer catQPointsRank;
    private Integer qualifyingTotal;

    private String snatch1ActualLift;
    private String snatch1Change1;
    private String snatch1Change2;
    private String snatch1Declaration;
    private List<Integer> snatch1LiftTime = new ArrayList<>();

    private String snatch2ActualLift;
    private String snatch2Change1;
    private String snatch2Change2;
    private String snatch2Declaration;
    private List<Integer> snatch2LiftTime = new ArrayList<>();

    private String snatch3ActualLift;
    private String snatch3Change1;
    private String snatch3Change2;
    private String snatch3Declaration;
    private List<Integer> snatch3LiftTime = new ArrayList<>();

    private Integer startNumber;
    private String subCategory;
    private String team;

    private Integer teamCleanJerkRank;
    private Integer teamCombinedRank;
    private Integer teamCustomRank;
    private Integer teamRobiRank;
    private Integer teamSinclairRank;
    private Integer teamSnatchRank;
    private Integer teamTotalRank;

    private String ageGroupDisplayName;
    private Integer entryTotal;
    private Integer total;

    private String cleanJerk1AutomaticProgression;
    private String snatch1AutomaticProgression;
    private String snatch2AutomaticProgression;
    private String snatch3AutomaticProgression;
    private String cleanJerk2AutomaticProgression;
    private String cleanJerk3AutomaticProgression;

    private String computedScoringSystem;
    private String club;
    private String requiredInitialAttempts;
    private String sessionPattern;

    public void addParticipation(Participation participation) {
        if (!participations.contains(participation)) {
            participations.add(participation);
        }
    }

}
