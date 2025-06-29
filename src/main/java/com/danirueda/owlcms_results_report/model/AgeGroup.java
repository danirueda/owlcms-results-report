package com.danirueda.owlcms_results_report.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AgeGroup {

    private String key;
    private Boolean active;
    private String code;
    private Integer maxAge;
    private Integer minAge;
    private String ageDivision;
    private String championshipName;
    private List<Category> categories;
    private String gender;
    private BigDecimal qualificationTotal;
    private Boolean alreadyGendered;
    private String scoringSystem;
    private String championshipType;
    private String bestAthleteScoringSystem;
    private Boolean medals;
    private String bestAthleteScoringSystemTitle;
    private String translatedGender;


}
