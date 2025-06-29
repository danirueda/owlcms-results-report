package com.danirueda.owlcms_results_report.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Participation {

    private Long athlete;
    private Long category;
    private Integer cleanJerkRank;
    private Integer totalRank;
    private Integer categoryScoreRank;
    private Integer combinedRank;
    private Integer customRank;

    private ParticipationId id;

    private Integer snatchRank;
    private Integer teamCJRank;
    private Integer teamCombinedRank;
    private Boolean teamMember;
    private Integer teamRobiRank;
    private Integer teamSinclairRank;
    private Integer teamSnatchRank;
    private Integer teamTotalRank;

    private BigDecimal categoryScore;
    private String championshipType;

}
