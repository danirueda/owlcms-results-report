package com.danirueda.owlcms_results_report.dto.score.elite;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseElitePointsDTO {

    @CsvBindByName(column = "kg")
    private Integer kilos;

}
