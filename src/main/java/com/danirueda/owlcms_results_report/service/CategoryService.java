package com.danirueda.owlcms_results_report.service;

import com.danirueda.owlcms_results_report.model.AgeGroup;
import com.danirueda.owlcms_results_report.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    public List<Long> getCategoryIds(List<AgeGroup> ageGroups, String championshipName, String gender) {
        List<Long> categoryIds = new ArrayList<>();
        for (AgeGroup ageGroup : ageGroups) {
            if (ageGroup.getChampionshipName().equals(championshipName)
                    && ageGroup.getGender().equals(gender)) {
                categoryIds.addAll(ageGroup.getCategories().stream().map(Category::getId).toList());
            }
        }

        return categoryIds;
    }
}
