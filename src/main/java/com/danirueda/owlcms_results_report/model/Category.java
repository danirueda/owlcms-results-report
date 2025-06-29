package com.danirueda.owlcms_results_report.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Category {

    private Long id;
    private BigDecimal maximumWeight;
    private BigDecimal minimumWeight;
    private Boolean active;
    private String ageGroup;
    private String code;
    private String gender;
    private String name;
    private Integer qualifyingTotal;
    private Integer wrJr;
    private Integer wrSr;
    private Integer wrYth;
    private String upperBound;
    private String translatedGender;

}
