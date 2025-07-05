package com.danirueda.owlcms_results_report.service;

import com.danirueda.owlcms_results_report.model.Athlete;
import com.danirueda.owlcms_results_report.model.Participation;
import com.danirueda.owlcms_results_report.model.ParticipationId;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class LoadDataServiceTest {

    @Autowired
    private LoadDataService loadDataService;

    @Test
    public void loadAthletes() {
        JsonArray athletesData = getAthletesData();
        JsonObject athletes = new JsonObject();
        athletes.add("athletes", athletesData);
        List<Athlete> expected = getExpectedAthletes(athletesData);

        List<Athlete> result = loadDataService.loadAthletes(athletes);

        assertEquals(expected, result);
    }

    @Test
    public void loadCompetition() {
        fail("TODO");
    }

    @Test
    public void loadPlatforms() {
        fail("TODO");
    }

    @Test
    public void loadGroups() {
        fail("TODO");
    }

    @Test
    public void loadAgeGroups() {
        fail("TODO");
    }

    @Test
    public void loadRecords() {
        fail("TODO");
    }

    @Test
    public void loadRecordConfig() {
        fail("TODO");
    }

    private JsonArray getAthletesData() {
        JsonArray athleteList = new JsonArray();

        // ===== Athlete 1: Grace Clemons =====
        JsonObject athlete = new JsonObject();
        athlete.addProperty("id", 1836027652199299338L);
        athlete.addProperty("firstName", "Grace");
        athlete.addProperty("lastName", "Clemons");
        athlete.addProperty("gender", "F");
        athlete.addProperty("bodyWeight", 62.75);
        athlete.addProperty("scaleWeight", 63.0);
        athlete.addProperty("club", "WCA");

        JsonArray birthDate = new JsonArray();
        birthDate.add(1990);
        birthDate.add(1);
        birthDate.add(1);
        athlete.add("fullBirthDate", birthDate);

        JsonArray participations = new JsonArray();
        participations.add(getParticipationData(1836027652199299338L, 1836027376525444104L, new BigDecimal("161.0"), "IWF"));
        participations.add(getParticipationData(1836027652199299338L, 1836027376528265008L, new BigDecimal("161.0"), "DEFAULT"));
        athlete.add("participations", participations);

        athleteList.add(athlete);

        // ===== Athlete 2: Tami Lott =====
        athlete = new JsonObject();
        athlete.addProperty("id", 1836027652200602377L);
        athlete.addProperty("firstName", "Tami");
        athlete.addProperty("lastName", "Lott");
        athlete.addProperty("gender", "F");
        athlete.addProperty("bodyWeight", 67.15);
        athlete.addProperty("scaleWeight", 67.4);
        athlete.addProperty("club", "WCA");

        birthDate = new JsonArray();
        birthDate.add(2001);
        birthDate.add(1);
        birthDate.add(1);
        athlete.add("fullBirthDate", birthDate);

        participations = new JsonArray();
        participations.add(getParticipationData(1836027652200602377L, 1836027376525561424L, new BigDecimal("145.0"), "IWF"));
        participations.add(getParticipationData(1836027652200602377L, 1836027376528384029L, new BigDecimal("145.0"), "DEFAULT"));
        athlete.add("participations", participations);

        athleteList.add(athlete);

        // ===== Athlete 3: Ingrid Reeves =====
        athlete = new JsonObject();
        athlete.addProperty("id", 1836027652200719260L);
        athlete.addProperty("firstName", "Ingrid");
        athlete.addProperty("lastName", "Reeves");
        athlete.addProperty("gender", "F");
        athlete.addProperty("bodyWeight", 75.15);
        athlete.addProperty("scaleWeight", 75.4);
        athlete.addProperty("club", "WCB");

        birthDate = new JsonArray();
        birthDate.add(2008);
        birthDate.add(1);
        birthDate.add(1);
        athlete.add("fullBirthDate", birthDate);

        participations = new JsonArray();
        participations.add(getParticipationData(1836027652200719260L, 1836027376488027509L, new BigDecimal("163.0"), "U"));
        participations.add(getParticipationData(1836027652200719260L, 1836027376528489342L, new BigDecimal("163.0"), "DEFAULT"));
        participations.add(getParticipationData(1836027652200719260L, 1836027376525355205L, new BigDecimal("163.0"), "IWF"));
        participations.add(getParticipationData(1836027652200719260L, 1836027376525668592L, new BigDecimal("163.0"), "IWF"));
        athlete.add("participations", participations);

        athleteList.add(athlete);

        return athleteList;
    }

    private List<Athlete> getExpectedAthletes(JsonArray athletesData) {
        List<Athlete> result = new ArrayList<>();
        Athlete athlete;
        JsonObject athleteData;
        for (JsonElement item : athletesData) {
            athleteData = item.getAsJsonObject();
            athlete = new Athlete();
            athlete.setId(athleteData.get("id").getAsLong());
            athlete.setFirstName(athleteData.get("firstName").getAsString());
            athlete.setLastName(athleteData.get("lastName").getAsString());
            athlete.setGender(athleteData.get("gender").getAsString());
            athlete.setBodyWeight(new BigDecimal(athleteData.get("bodyWeight").getAsString()));
            athlete.setScaleWeight(new BigDecimal(athleteData.get("scaleWeight").getAsString()));
            athlete.setClub(athleteData.get("club").getAsString());
            athlete.setFullBirthDate(new Integer[] {
                    athleteData.get("fullBirthDate").getAsJsonArray().get(0).getAsInt(),
                    athleteData.get("fullBirthDate").getAsJsonArray().get(1).getAsInt(),
                    athleteData.get("fullBirthDate").getAsJsonArray().get(2).getAsInt()
            });

            for (JsonElement participation : athleteData.get("participations").getAsJsonArray()) {
                athlete.addParticipation(getParticipation(participation.getAsJsonObject()));
            }

            result.add(athlete);
        }

        return result;
    }

    private JsonObject getParticipationData(long athleteId, long categoryId, BigDecimal categoryScore, String type) {
        JsonObject participation = new JsonObject();
        participation.addProperty("athlete", athleteId);
        participation.addProperty("category", categoryId);
        participation.addProperty("cleanJerkRank", 1);
        participation.addProperty("totalRank", 1);
        participation.addProperty("categoryScoreRank", 1);
        participation.addProperty("combinedRank", 0);
        participation.addProperty("customRank", 0);
        participation.addProperty("snatchRank", 1);
        participation.addProperty("teamCJRank", 0);
        participation.addProperty("teamCombinedRank", 0);
        participation.addProperty("teamMember", false);
        participation.addProperty("teamRobiRank", 0);
        participation.addProperty("teamSinclairRank", 0);
        participation.addProperty("teamSnatchRank", 0);
        participation.addProperty("teamTotalRank", 0);
        participation.addProperty("categoryScore", categoryScore);
        participation.addProperty("championshipType", type);

        JsonObject participationId = new JsonObject();
        participationId.addProperty("athleteId", athleteId);
        participationId.addProperty("categoryId", categoryId);
        participation.add("id", participationId);

        return participation;
    }

    private Participation getParticipation(JsonObject participationData) {
        Participation result = new Participation();
        result.setAthlete(participationData.get("athlete").getAsLong());
        result.setCategory(participationData.get("category").getAsLong());
        result.setCleanJerkRank(participationData.get("cleanJerkRank").getAsInt());
        result.setTotalRank(participationData.get("totalRank").getAsInt());
        result.setCategoryScoreRank(participationData.get("categoryScoreRank").getAsInt());
        result.setCombinedRank(participationData.get("combinedRank").getAsInt());
        result.setCustomRank(participationData.get("customRank").getAsInt());
        result.setSnatchRank(participationData.get("snatchRank").getAsInt());
        result.setTeamCJRank(participationData.get("teamCJRank").getAsInt());
        result.setTeamCombinedRank(participationData.get("teamCombinedRank").getAsInt());
        result.setTeamMember(participationData.get("teamMember").getAsBoolean());
        result.setTeamRobiRank(participationData.get("teamRobiRank").getAsInt());
        result.setTeamSinclairRank(participationData.get("teamSinclairRank").getAsInt());
        result.setTeamSnatchRank(participationData.get("teamSnatchRank").getAsInt());
        result.setTeamTotalRank(participationData.get("teamTotalRank").getAsInt());
        result.setCategoryScore(new BigDecimal(participationData.get("categoryScore").getAsString()));
        result.setChampionshipType(participationData.get("championshipType").getAsString());

        ParticipationId participationId = new ParticipationId();
        participationId.setAthleteId(participationData.get("id").getAsJsonObject().get("athleteId").getAsLong());
        participationId.setCategoryId(participationData.get("id").getAsJsonObject().get("categoryId").getAsLong());

        result.setId(participationId);

        return result;
    }



}
