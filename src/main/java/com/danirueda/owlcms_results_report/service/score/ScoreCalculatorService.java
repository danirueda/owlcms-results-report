package com.danirueda.owlcms_results_report.service.score;

import com.danirueda.owlcms_results_report.dto.score.AthleteScoreResultDTO;
import com.danirueda.owlcms_results_report.model.AgeGroup;
import com.danirueda.owlcms_results_report.model.Athlete;

import java.util.List;

public interface ScoreCalculatorService {

    List<AthleteScoreResultDTO> calculateIndividualRank(String championshipName, String gender,
                                                        List<Athlete> athletes, List<AgeGroup> ageGroups);

}
