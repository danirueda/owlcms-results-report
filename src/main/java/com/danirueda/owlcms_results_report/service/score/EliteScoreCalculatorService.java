package com.danirueda.owlcms_results_report.service.score;

import com.danirueda.owlcms_results_report.dto.score.AthleteScoreResultDTO;
import com.danirueda.owlcms_results_report.dto.score.elite.FemaleElitePointsDTO;
import com.danirueda.owlcms_results_report.dto.score.elite.MaleElitePointsDTO;
import com.danirueda.owlcms_results_report.model.AgeGroup;
import com.danirueda.owlcms_results_report.model.Athlete;
import com.danirueda.owlcms_results_report.model.Category;
import com.danirueda.owlcms_results_report.service.AthleteService;
import com.danirueda.owlcms_results_report.service.CategoryService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EliteScoreCalculatorService implements ScoreCalculatorService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AthleteService athleteService;

    private List<FemaleElitePointsDTO> femaleElitePoints = new ArrayList<>();
    private List<MaleElitePointsDTO> maleElitePoints = new ArrayList<>();

    @PostConstruct
    public void loadEliteTables() {
        loadFemaleElitePointsTable();
        loadMaleElitePointsTable();
    }

    public List<AthleteScoreResultDTO> calculateIndividualRank(String championshipName, String gender,
                                                               List<Athlete> athletes, List<AgeGroup> ageGroups) {
        List<AthleteScoreResultDTO> result = new ArrayList<>();
        List<Long> championshipCategoriesIds = categoryService.getCategoryIds(ageGroups, championshipName, gender);
        List<Athlete> getCategoryAthletes = athleteService.getAthletesInCategories(athletes, championshipCategoriesIds);

        return result;
    }

    protected BigDecimal getMaleElitePoints(String category, Integer kilos) {
        kilos = kilos - 1;
        if (kilos < 0 || kilos > maleElitePoints.size()) {
            return null;
        }

        BigDecimal result = null;
        MaleElitePointsDTO maleElitePointsDTO = maleElitePoints.get(kilos);
        if (category.equals("52")) {
            result = maleElitePointsDTO.getCategory52Points();
        } else if (category.equals("56")) {
            result = maleElitePointsDTO.getCategory56Points();
        } else if (category.equals("60")) {
            result = maleElitePointsDTO.getCategory60Points();
        } else if (category.equals("65")) {
            result = maleElitePointsDTO.getCategory65Points();
        } else if (category.equals("71")) {
            result = maleElitePointsDTO.getCategory71Points();
        } else if (category.equals("79")) {
            result = maleElitePointsDTO.getCategory79Points();
        } else if (category.equals("88")) {
            result = maleElitePointsDTO.getCategory88Points();
        } else if (category.equals(">88")) {
            result = maleElitePointsDTO.getCategory88ToInfinityPoints();
        } else if (category.equals("94")) {
            result = maleElitePointsDTO.getCategory94Points();
        } else if (category.equals(">94")) {
            result = maleElitePointsDTO.getCategory94ToInfinityPoints();
        } else if (category.equals("110")) {
            result = maleElitePointsDTO.getCategory110Points();
        } else if (category.equals(">110")) {
            result = maleElitePointsDTO.getCategory110ToInfinityPoints();
        }

        return result;
    }

    protected BigDecimal getFemaleElitePoints(String category, Integer kilos) {
        kilos = kilos - 1;
        if (kilos < 0 || kilos > femaleElitePoints.size()) {
            return null;
        }

        BigDecimal result = null;
        FemaleElitePointsDTO femaleElitePointsDTO = femaleElitePoints.get(kilos);
        if (category.equals("40")) {
            result = femaleElitePointsDTO.getCategory40Points();
        } else if (category.equals("44")) {
            result = femaleElitePointsDTO.getCategory44Points();
        } else if (category.equals("48")) {
            result = femaleElitePointsDTO.getCategory48Points();
        } else if (category.equals("53")) {
            result = femaleElitePointsDTO.getCategory53Points();
        } else if (category.equals("58")) {
            result = femaleElitePointsDTO.getCategory58Points();
        } else if (category.equals("63")) {
            result = femaleElitePointsDTO.getCategory63Points();
        } else if (category.equals("69")) {
            result = femaleElitePointsDTO.getCategory69Points();
        } else if (category.equals(">69")) {
            result = femaleElitePointsDTO.getCategory69ToInfinityPoints();
        } else if (category.equals("77")) {
            result = femaleElitePointsDTO.getCategory77Points();
        } else if (category.equals(">77")) {
            result = femaleElitePointsDTO.getCategory77ToInfinityPoints();
        } else if (category.equals("86")) {
            result = femaleElitePointsDTO.getCategory86Points();
        } else if (category.equals(">86")) {
            result = femaleElitePointsDTO.getCategory86ToInfinityPoints();
        }

        return result;
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
