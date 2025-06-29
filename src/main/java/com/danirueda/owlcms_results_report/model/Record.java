package com.danirueda.owlcms_results_report.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Record {

    private BigDecimal athleteBW;
    private Long id;
    private BigDecimal recordValue;
    private String ageGrp;
    private Integer ageGrpLower;
    private Integer ageGrpUpper;
    private String athleteName;
    private Integer bwCatLower;
    private Integer bwCatUpper;
    private String eventLocation;
    private String gender;
    private String recordFederation;
    private String recordLift;
    private String recordName;
    private Integer recordYear;
    private String fileName;
    private String bwCatString;
    private String recordDateAsString;
    private String translatedGender;
    private String translatedLift;
    private String key;


}
