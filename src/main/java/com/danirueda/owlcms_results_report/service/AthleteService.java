package com.danirueda.owlcms_results_report.service;

import com.danirueda.owlcms_results_report.model.Athlete;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AthleteService {

    public List<Athlete> getAthletesInCategories(List<Athlete> athletes, List<Long> categoriesIds) {
        List<Athlete> result = new ArrayList<>();
        for (Athlete athlete : athletes) {
            for (Long categoryId : categoriesIds) {
                if (!result.contains(athlete) && athleteParticipatesInCategory(athlete, categoryId)) {
                    result.add(athlete);
                }
            }
        }

        return result;
    }

    public Boolean athleteParticipatesInCategory(Athlete athlete, Long categoryId) {
        return athlete.getParticipations().stream().anyMatch(participation ->
            participation.getId().getCategoryId().equals(categoryId)
        );
    }

}
