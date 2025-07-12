package com.danirueda.owlcms_results_report.service.score;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EliteScoreCalculatorServiceTest {

    @Autowired
    private EliteScoreCalculatorService eliteScoreCalculatorService;

    @Test
    public void getFemaleElitePointsNotExistingCategory() {
        String category = "288";
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 115);

        assertNull(result);
    }

    @Test
    public void getFemaleElitePointsZeroKilos() {
        String category = "40";
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 0);

        assertNull(result);
    }

    @Test
    public void getFemaleElitePointsNegativeKilos() {
        String category = "40";
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, -40);

        assertNull(result);
    }

    @Test
    public void getFemaleElitePointsCategory40() {
        String category = "40";
        BigDecimal expected = new BigDecimal("64.25");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 115);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory40ToManyKilos() {
        String category = "40";
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 520);

        assertNull(result);
    }

    @Test
    public void getFemaleElitePointsCategory44() {
        String category = "44";
        BigDecimal expected = new BigDecimal("35.83");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 67);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory44TopPoints() {
        String category = "44";
        BigDecimal expected = new BigDecimal("100.00");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 187);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory48() {
        String category = "48";
        BigDecimal expected = new BigDecimal("54.77");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 109);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory53() {
        String category = "53";
        BigDecimal expected = new BigDecimal("62.33");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 134);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory58() {
        String category = "58";
        BigDecimal expected = new BigDecimal("60.26");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 138);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory63() {
        String category = "63";
        BigDecimal expected = new BigDecimal("70.66");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 171);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory69() {
        String category = "69";
        BigDecimal expected = new BigDecimal("62.26");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 160);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory69ToInfinity() {
        String category = ">69";
        BigDecimal expected = new BigDecimal("60.20");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 177);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory77ToInfinity() {
        String category = ">77";
        BigDecimal expected = new BigDecimal("40.14");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 118);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory86() {
        String category = "86";
        BigDecimal expected = new BigDecimal("68.15");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 199);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory86ToInfinity() {
        String category = ">86";
        BigDecimal expected = new BigDecimal("68.13");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 218);

        assertEquals(expected, result);
    }

    @Test
    public void getFemaleElitePointsCategory86ToInfinityOneKilo() {
        String category = ">86";
        BigDecimal expected = new BigDecimal("0.31");
        BigDecimal result = eliteScoreCalculatorService.getFemaleElitePoints(category, 1);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsNotExistingCategory() {
        String category = "288";
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 115);

        assertNull(result);
    }

    @Test
    public void getMaleElitePointsZeroKilos() {
        String category = "52";
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 0);

        assertNull(result);
    }

    @Test
    public void getMaleElitePointsNegativeKilos() {
        String category = "52";
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, -40);

        assertNull(result);
    }

    @Test
    public void getMaleElitePointsCategory52() {
        String category = "52";
        BigDecimal expected = new BigDecimal("39.93");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 115);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory52ToManyKilos() {
        String category = "52";
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 520);

        assertNull(result);
    }

    @Test
    public void getMaleElitePointsCategory56() {
        String category = "56";
        BigDecimal expected = new BigDecimal("40.07");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 119);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory56TopPoints() {
        String category = "56";
        BigDecimal expected = new BigDecimal("100.00");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 297);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory60() {
        String category = "60";
        BigDecimal expected = new BigDecimal("60.06");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 185);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory65() {
        String category = "65";
        BigDecimal expected = new BigDecimal("62.04");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 201);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory71() {
        String category = "71";
        BigDecimal expected = new BigDecimal("48.54");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 166);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory79() {
        String category = "79";
        BigDecimal expected = new BigDecimal("67.49");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 245);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory88() {
        String category = "88";
        BigDecimal expected = new BigDecimal("45.05");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 173);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory88ToInfinity() {
        String category = ">88";
        BigDecimal expected = new BigDecimal("20.80");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 88);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory94() {
        String category = "94";
        BigDecimal expected = new BigDecimal("68.01");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 270);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory94ToInfinity() {
        String category = ">94";
        BigDecimal expected = new BigDecimal("40.66");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 172);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory110() {
        String category = "110";
        BigDecimal expected = new BigDecimal("26.82");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 114);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory110ToInfinity() {
        String category = ">110";
        BigDecimal expected = new BigDecimal("70.20");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 318);

        assertEquals(expected, result);
    }

    @Test
    public void getMaleElitePointsCategory110ToInfinityOneKilo() {
        String category = ">110";
        BigDecimal expected = new BigDecimal("0.22");
        BigDecimal result = eliteScoreCalculatorService.getMaleElitePoints(category, 1);

        assertEquals(expected, result);
    }

}
