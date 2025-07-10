package com.danirueda.owlcms_results_report.service.score;

import com.danirueda.owlcms_results_report.dto.score.AthleteScoreResultDTO;
import com.danirueda.owlcms_results_report.dto.score.elite.FemaleElitePointsDTO;
import com.danirueda.owlcms_results_report.dto.score.elite.MaleElitePointsDTO;
import com.danirueda.owlcms_results_report.model.Athlete;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EliteScoreCalculatorService implements ScoreCalculatorService {

    private List<FemaleElitePointsDTO> femaleElitePoints = new ArrayList<>();
    private List<MaleElitePointsDTO> maleElitePoints = new ArrayList<>();

    @PostConstruct
    public void loadEliteTables() {
        loadFemaleElitePointsTable();
        loadMaleElitePointsTable();
        log.info("Aux");
    }

    public List<AthleteScoreResultDTO> calculateIndividualRank(List<Athlete> athletes) {
        return null; // TODO
    }

    protected BigDecimal getMaleElitePoints(String category, Integer kilos) {
        if (kilos <= 0) {
            return null;
        }

        FemaleElitePointsDTO femaleElitePointsDTO = femaleElitePoints.get(kilos - 1);

        return null; // TODO
    }

    private void loadFemaleElitePointsTable() {
        Resource resource = new ClassPathResource("score/elite/female-elite-table.csv");
        try (Reader reader = Files.newBufferedReader(resource.getFile().toPath())) {

            CsvToBean<FemaleElitePointsDTO> femaleElitePointsDTOCsvToBean = new CsvToBeanBuilder<FemaleElitePointsDTO>(reader)
                    .withType(FemaleElitePointsDTO.class)
                    .withSeparator(';')
                    .build();

            femaleElitePoints = femaleElitePointsDTOCsvToBean.parse();
            log.info("Female elite points loaded successfully.");
        } catch (Exception ex) {
            log.error("Error loading female elite points. Classification will be not calculated.", ex);
        }
    }

    private void loadMaleElitePointsTable() {
        Resource resource = new ClassPathResource("score/elite/male-elite-table.csv");
        try (Reader reader = Files.newBufferedReader(resource.getFile().toPath())) {

            CsvToBean<MaleElitePointsDTO> maleElitePointsDTOCsvToBean = new CsvToBeanBuilder<MaleElitePointsDTO>(reader)
                    .withType(MaleElitePointsDTO.class)
                    .withSeparator(';')
                    .build();

            maleElitePoints = maleElitePointsDTOCsvToBean.parse();
            log.info("Male elite points loaded successfully.");
        } catch (Exception ex) {
            log.error("Error loading female elite points. Classification will be not calculated.", ex);
        }
    }

}
