package com.danirueda.owlcms_results_report.model;

import lombok.Data;

import java.util.List;

@Data
public class Group {

    private Long id;
    private Long platform;
    private String announcer;
    private List<Integer> competitionTime;
    private String description;
    private Boolean done;
    private Boolean masters;
    private String jury1;
    private String jury2;
    private String jury3;
    private String jury4;
    private String jury5;
    private String marshall;
    private String marshal2;
    private String name;
    private String referee1;
    private String referee2;
    private String referee3;
    private String reserve;
    private String technicalController;
    private String technicalController2;
    private String timeKeeper;
    private String weighIn1;
    private String weighIn2;
    private String competitionDirector;
    private String competitionSecretary;
    private String competitionSecretary2;
    private List<Integer> weighInTime;
    private Integer cleanJerkBreakDuration;
    private List<Integer> firstSnatchTime;
    private List<Integer> firstCJTime;
    private List<Integer> lastSnatchDecisionTime;
    private List<Integer> lastCJDecisionTime;
    private String reserveJury;
    private Integer nbAthletes;
    private Integer nbAttemptedLifts;

}
