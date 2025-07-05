package com.danirueda.owlcms_results_report.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private List<Category> categories = new ArrayList<>();
    private String gender;
    private Integer qualificationTotal;
    private Boolean alreadyGendered;
    private String scoringSystem;
    private String championshipType;
    private String bestAthleteScoringSystem;
    private Boolean medals;
    private String bestAthleteScoringSystemTitle;
    private String translatedGender;

    public void addCategory(Category category) {
        if (!categories.contains(category)) {
            categories.add(category);
        }
    }

}
