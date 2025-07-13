package com.danirueda.owlcms_results_report.service;

import com.danirueda.owlcms_results_report.model.AgeGroup;
import com.danirueda.owlcms_results_report.model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    private List<AgeGroup> ageGroups = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        AgeGroup ageGroup = new AgeGroup();
        ageGroup.setKey("JR_IWF_F_15_20");
        ageGroup.setChampionshipName("JR");
        ageGroup.setGender("F");

        Category category = new Category();
        category.setId(1836027376523641597L);
        category.setCode("JR_F48");
        category.setGender("F");
        ageGroup.addCategory(category);

        category = new Category();
        category.setId(1836027376524854740L);
        category.setCode("JR_F53");
        category.setGender("F");
        ageGroup.addCategory(category);

        category = new Category();
        category.setId(1836027376524978469L);
        category.setCode("JR_F58");
        category.setGender("F");
        ageGroup.addCategory(category);

        ageGroups.add(ageGroup);

        ageGroup = new AgeGroup();
        ageGroup.setKey("JR_IWF_M_15_20");
        ageGroup.setChampionshipName("JR");
        ageGroup.setGender("M");

        category = new Category();
        category.setId(1836027376556567748L);
        category.setCode("JR_M60");
        category.setGender("M");
        ageGroup.addCategory(category);

        category = new Category();
        category.setId(1836027376556659644L);
        category.setCode("JR_M65");
        category.setGender("M");
        ageGroup.addCategory(category);

        category = new Category();
        category.setId(1836027376556738798L);
        category.setCode("JR_M71");
        category.setGender("M");
        ageGroup.addCategory(category);

        ageGroups.add(ageGroup);
    }

    @AfterEach
    public void tearDown() {
        ageGroups.clear();
    }

    @Test
    public void getCategoryIds() {
        String championshipName = "JR";
        String gender = "M";
        List<Long> expected = ageGroups.get(1).getCategories().stream().map(Category::getId).toList();

        List<Long> result = categoryService.getCategoryIds(ageGroups, championshipName, gender);

        assertEquals(expected, result);
    }

}
