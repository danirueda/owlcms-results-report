package com.danirueda.owlcms_results_report.model;

import lombok.Data;

@Data
public class Platform {

    private Long id;
    private String name;
    private Integer nbC_2_5;
    private Integer nbL_10;
    private Integer nbL_15;
    private Integer nbL_20;
    private Integer nbL_25;
    private Integer nbL_2_5;
    private Integer nbL_5;
    private Integer nbS_0_5;
    private Integer nbS_1;
    private Integer nbS_1_5;
    private Integer nbS_2;
    private Integer nbS_2_5;
    private Integer nbS_5;
    private Integer nonStandardBarWeight;
    private Integer nbB_5;
    private Integer nbB_10;
    private Integer nbB_15;
    private Integer nbB_20;
    private Boolean showDecisionLights;
    private Boolean showTimer;
    private String soundMixerName;
    private Boolean nonStandardBarAvailable;

}
