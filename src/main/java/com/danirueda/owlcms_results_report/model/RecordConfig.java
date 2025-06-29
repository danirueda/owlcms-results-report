package com.danirueda.owlcms_results_report.model;

import lombok.Data;

import java.util.List;

@Data
public class RecordConfig {

    private List<String> recordOrder;
    private Boolean showAllCategoryRecords;
    private Boolean showAllFederations;

}
