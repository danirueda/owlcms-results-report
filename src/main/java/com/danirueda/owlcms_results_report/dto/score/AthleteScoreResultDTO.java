package com.danirueda.owlcms_results_report.dto.score;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AthleteScoreResultDTO {

    private Integer position;

    private Integer birthYear;

    private Integer category;

    private String completeName;

    private String federation;

    private String club;

    private BigDecimal score;

}
