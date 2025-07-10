package com.danirueda.owlcms_results_report.dto.score.elite;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class FemaleElitePointsDTO extends BaseElitePointsDTO {

    @CsvBindByName(column = "40")
    private BigDecimal category40Points;

    @CsvBindByName(column = "44")
    private BigDecimal category44Points;

    @CsvBindByName(column = "48")
    private BigDecimal category48Points;

    @CsvBindByName(column = "53")
    private BigDecimal category53Points;

    @CsvBindByName(column = "58")
    private BigDecimal category58Points;

    @CsvBindByName(column = "63")
    private BigDecimal category63Points;

    @CsvBindByName(column = "69")
    private BigDecimal category69Points;

    @CsvBindByName(column = ">69")
    private BigDecimal category69ToInfinityPoints;

    @CsvBindByName(column = "77")
    private BigDecimal category77Points;

    @CsvBindByName(column = ">77")
    private BigDecimal category77ToInfinityPoints;

    @CsvBindByName(column = "86")
    private BigDecimal category86Points;

    @CsvBindByName(column = ">86")
    private BigDecimal category86ToInfinityPoints;

}
