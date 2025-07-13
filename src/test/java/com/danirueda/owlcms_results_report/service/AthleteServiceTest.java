package com.danirueda.owlcms_results_report.service;

import com.danirueda.owlcms_results_report.model.Athlete;
import com.danirueda.owlcms_results_report.model.Category;
import com.danirueda.owlcms_results_report.model.Participation;
import com.danirueda.owlcms_results_report.model.ParticipationId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AthleteServiceTest {

    @Autowired
    private AthleteService athleteService;

    private List<Athlete> athletes = new ArrayList<>();

    private List<Long> categoryIds = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        categoryIds.add(12356L);
        categoryIds.add(789101112L);
        categoryIds.add(8563214L);
        categoryIds.add(222555888L);
        categoryIds.add(333666999L);

        Athlete athlete = new Athlete();
        athlete.setId(288L);
        athlete.setFirstName("Wiley");
        athlete.setLastName("Price");

        Participation participation = new Participation();
        participation.setId(new ParticipationId(athlete.getId(), categoryIds.get(0)));
        athlete.addParticipation(participation);

        athletes.add(athlete);

        athlete = new Athlete();
        athlete.setId(289L);
        athlete.setFirstName("Michelle");
        athlete.setLastName("Meadows");

        participation = new Participation();
        participation.setId(new ParticipationId(athlete.getId(), categoryIds.get(1)));
        athlete.addParticipation(participation);

        participation = new Participation();
        participation.setId(new ParticipationId(athlete.getId(), categoryIds.get(2)));
        athlete.addParticipation(participation);

        athletes.add(athlete);

        athlete = new Athlete();
        athlete.setId(290L);
        athlete.setFirstName("Aimee");
        athlete.setLastName("Weeks");

        participation = new Participation();
        participation.setId(new ParticipationId(athlete.getId(), categoryIds.get(3)));
        athlete.addParticipation(participation);

        participation = new Participation();
        participation.setId(new ParticipationId(athlete.getId(), categoryIds.get(4)));
        athlete.addParticipation(participation);

        athletes.add(athlete);
    }

    @AfterEach
    public void tearDown() {
        athletes.clear();
        categoryIds.clear();
    }

    @Test
    public void getAthletesInCategories() {
        List<Athlete> expected = athletes.subList(0, 2);
        List<Long> categoriesIds = categoryIds.subList(0, 3);

        List<Athlete> result = athleteService.getAthletesInCategories(athletes, categoriesIds);

        assertEquals(expected, result);
    }

    @Test
    public void athleteParticipatesInCategory() {
        Athlete athlete = athletes.get(1);
        Long categoryId = categoryIds.get(1);

        assertTrue(athleteService.athleteParticipatesInCategory(athlete, categoryId));
    }

    @Test
    public void athleteParticipatesInCategory_DoesNotParticipate() {
        Athlete athlete = athletes.get(1);
        Long categoryId = categoryIds.get(0);

        assertFalse(athleteService.athleteParticipatesInCategory(athlete, categoryId));
    }

}
