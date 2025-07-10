package com.danirueda.owlcms_results_report.dto.score.elite;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class MaleElitePointsDTO extends BaseElitePointsDTO {

    @CsvBindByName(column = "52")
    private BigDecimal category52Points;

    @CsvBindByName(column = "56")
    private BigDecimal category56Points;

    @CsvBindByName(column = "60")
    private BigDecimal category60Points;

    @CsvBindByName(column = "65")
    private BigDecimal category65Points;

    @CsvBindByName(column = "71")
    private BigDecimal category71Points;

    @CsvBindByName(column = "79")
    private BigDecimal category79Points;

    @CsvBindByName(column = "88")
    private BigDecimal category88Points;

    @CsvBindByName(column = ">88")
    private BigDecimal category88ToInfinityPoints;

    @CsvBindByName(column = "94")
    private BigDecimal category94Points;

    @CsvBindByName(column = ">94")
    private BigDecimal category94ToInfinityPoints;

    @CsvBindByName(column = "110")
    private BigDecimal category110Points;

    @CsvBindByName(column = ">110")
    private BigDecimal category110ToInfinityPoints;

}
