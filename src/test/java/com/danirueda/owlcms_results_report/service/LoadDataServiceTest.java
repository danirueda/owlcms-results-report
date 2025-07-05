package com.danirueda.owlcms_results_report.service;

import com.danirueda.owlcms_results_report.model.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
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
        JsonObject competitionData = getCompetitionData();
        JsonObject competition = new JsonObject();
        competition.add("competition", competitionData);
        Competition expected = getExpectedCompetition(competitionData);

        Competition result = loadDataService.loadCompetition(competition);

        assertEquals(expected, result);
    }

    @Test
    public void loadPlatforms() {
        JsonArray platformsData = getPlatformsData();
        JsonObject platforms = new JsonObject();
        platforms.add("platforms", platformsData);
        List<Platform> expected = getExpectedPlatforms(platformsData);

        List<Platform> result = loadDataService.loadPlatforms(platforms);

        assertEquals(expected, result);
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

    private JsonArray getPlatformsData() {
        JsonArray result = new JsonArray();

        JsonObject platform = new JsonObject();
        platform.addProperty("id", 1836027061987287429L);
        platform.addProperty("name", "A");
        platform.addProperty("nbC_2_5", 1);
        platform.addProperty("nbL_10", 1);
        platform.addProperty("nbL_15", 1);
        platform.addProperty("nbL_20", 1);
        platform.addProperty("nbL_25", 3);
        platform.addProperty("nbL_2_5", 1);
        platform.addProperty("nbL_5", 1);
        platform.addProperty("nbS_0_5", 1);
        platform.addProperty("nbS_1", 1);
        platform.addProperty("nbS_1_5", 1);
        platform.addProperty("nbS_2", 1);
        platform.addProperty("nbS_2_5", 1);
        platform.addProperty("nbS_5", 1);
        platform.addProperty("nonStandardBarWeight", 0);
        platform.addProperty("nbB_5", 0);
        platform.addProperty("nbB_10", 0);
        platform.addProperty("nbB_15", 1);
        platform.addProperty("nbB_20", 1);
        platform.addProperty("showDecisionLights", false);
        platform.addProperty("showTimer", false);
        platform.addProperty("soundMixerName", "Usar el sonido del Navegador");
        platform.addProperty("nonStandardBarAvailable", false);

        result.add(platform);

        return result;
    }

    private List<Platform> getExpectedPlatforms(JsonArray platformsData) {
        List<Platform> result = new ArrayList<>();

        Platform platform;
        JsonObject platformData;
        for (JsonElement item : platformsData) {
            platform = new Platform();
            platformData = item.getAsJsonObject();

            platform.setId(platformData.get("id").getAsLong());
            platform.setName(platformData.get("name").getAsString());
            platform.setNbC_2_5(platformData.get("nbC_2_5").getAsInt());
            platform.setNbL_10(platformData.get("nbL_10").getAsInt());
            platform.setNbL_15(platformData.get("nbL_15").getAsInt());
            platform.setNbL_20(platformData.get("nbL_20").getAsInt());
            platform.setNbL_25(platformData.get("nbL_25").getAsInt());
            platform.setNbL_2_5(platformData.get("nbL_2_5").getAsInt());
            platform.setNbL_5(platformData.get("nbL_5").getAsInt());
            platform.setNbS_0_5(platformData.get("nbS_0_5").getAsInt());
            platform.setNbS_1(platformData.get("nbS_1").getAsInt());
            platform.setNbS_1_5(platformData.get("nbS_1_5").getAsInt());
            platform.setNbS_2(platformData.get("nbS_2").getAsInt());
            platform.setNbS_2_5(platformData.get("nbS_2_5").getAsInt());
            platform.setNbS_5(platformData.get("nbS_5").getAsInt());
            platform.setNonStandardBarWeight(platformData.get("nonStandardBarWeight").getAsInt());
            platform.setNbB_5(platformData.get("nbB_5").getAsInt());
            platform.setNbB_10(platformData.get("nbB_10").getAsInt());
            platform.setNbB_15(platformData.get("nbB_15").getAsInt());
            platform.setNbB_20(platformData.get("nbB_20").getAsInt());
            platform.setShowDecisionLights(platformData.get("showDecisionLights").getAsBoolean());
            platform.setShowTimer(platformData.get("showTimer").getAsBoolean());
            platform.setSoundMixerName(platformData.get("soundMixerName").getAsString());
            platform.setNonStandardBarAvailable(platformData.get("nonStandardBarAvailable").getAsBoolean());

            result.add(platform);
        }

        return result;
    }

    private JsonObject getCompetitionData() {
        JsonObject competition = new JsonObject();

        competition.addProperty("id", 86);
        competition.addProperty("ageGroupsFileName", "ES-AgeGroups_es_ES.xlsx");
        competition.addProperty("announcerLiveDecisions", true);
        competition.add("cardsTemplateFileName", JsonNull.INSTANCE);
        competition.addProperty("competitionCity", "Calatayud");

        JsonArray competitionDate = new JsonArray();
        competitionDate.add(2025);
        competitionDate.add(6);
        competitionDate.add(28);
        competition.add("competitionDate", competitionDate);

        competition.add("competitionEndDate", JsonNull.INSTANCE);
        competition.addProperty("competitionName", "Top Competition");
        competition.addProperty("competitionOrganizer", "FAH");
        competition.addProperty("competitionSite", "Some place around the world");
        competition.addProperty("customScore", false);
        competition.addProperty("enforce20kgRule", false);
        competition.addProperty("federation", "Real Federación Española de Halterofilia");
        competition.addProperty("federationAddress", " ");
        competition.add("federationEMail", JsonNull.INSTANCE);
        competition.addProperty("federationWebSite", " ");
        competition.add("finalPackageTemplateFileName", JsonNull.INSTANCE);
        competition.addProperty("genderOrder", true);
        competition.addProperty("fixedOrder", false);
        competition.add("juryTemplateFileName", JsonNull.INSTANCE);
        competition.addProperty("masters", false);
        competition.addProperty("mastersGenderEquality", false);
        competition.addProperty("maxTeamSize", 10);
        competition.addProperty("maxPerCategory", 10);
        competition.add("protocolTemplateFileName", JsonNull.INSTANCE);
        competition.add("resultsTemplateFileName", JsonNull.INSTANCE);
        competition.add("introductionTemplateFileName", JsonNull.INSTANCE);
        competition.addProperty("refereeWakeUpDelay", 1500);
        competition.addProperty("roundRobinOrder", false);
        competition.addProperty("snatchCJTotalMedals", false);
        competition.addProperty("weighInFormTemplateFileName", "WeighInForm-A4.xlsx");
        competition.addProperty("emptyProtocolTemplateFileName", "EmptyWithDeclaration-A4.xlsx");
        competition.addProperty("startListTemplateFileName", "Sessions-A4.xlsx");
        competition.add("scheduleTemplateFileName", JsonNull.INSTANCE);
        competition.addProperty("useBirthYear", true);
        competition.addProperty("automaticCJBreak", false);
        competition.addProperty("useCategorySinclair", false);
        competition.addProperty("sinclairYear", 2024);
        competition.addProperty("useOldBodyWeightTieBreak", false);
        competition.addProperty("jurySize", 3);
        competition.addProperty("longerBreakMax", 6);
        competition.addProperty("longerBreakDuration", 10);
        competition.addProperty("shorterBreakMin", 9);
        competition.addProperty("shorterBreakDuration", 10);
        competition.add("categoriesListTemplateFileName", JsonNull.INSTANCE);
        competition.add("bodyWeightListTemplateFileName", JsonNull.INSTANCE);
        competition.add("officialsListTemplateFileName", JsonNull.INSTANCE);
        competition.add("teamsListTemplateFileName", JsonNull.INSTANCE);
        competition.add("recordOrder", JsonNull.INSTANCE);
        competition.addProperty("scoringSystem", "BW_SINCLAIR");
        competition.addProperty("displayScores", false);
        competition.addProperty("displayScoreRanks", false);
        competition.add("checkInTemplateFileName", JsonNull.INSTANCE);
        competition.addProperty("displayByAgeGroup", false);
        competition.addProperty("announcerControlledJuryDecision", true);
        competition.add("currentRecordsTemplateFileName", JsonNull.INSTANCE);
        competition.addProperty("masters20kg", false);
        competition.add("technicalOfficialsTemplateFileName", JsonNull.INSTANCE);
        competition.addProperty("imwa", true);
        competition.addProperty("deduct250g", true);
        competition.addProperty("computedFinalPackageTemplateFileName", "Total-A4.xls");
        competition.addProperty("sinclair", false);
        competition.addProperty("genderInclusive", false);
        competition.addProperty("invitedIfBornBefore", 0);
        competition.addProperty("localizedCompetitionDate", "28/6/2025");
        competition.addProperty("translatedScoringSystemName", "Sinclair");
        competition.add("mensTeamSize", JsonNull.INSTANCE);
        competition.add("womensTeamSize", JsonNull.INSTANCE);

        return competition;
    }

    private Competition getExpectedCompetition(JsonObject competitionData) {
        Competition result = new Competition();


        result.setId(competitionData.get("id").getAsInt());
        result.setAgeGroupsFileName(competitionData.get("ageGroupsFileName").getAsString());
        result.setAnnouncerLiveDecisions(competitionData.get("announcerLiveDecisions").getAsBoolean());
        result.setCardsTemplateFileName(null);
        result.setCompetitionCity("Calatayud");
        result.setCompetitionDate(new Integer[] {
                competitionData.get("competitionDate").getAsJsonArray().get(0).getAsInt(),
                competitionData.get("competitionDate").getAsJsonArray().get(1).getAsInt(),
                competitionData.get("competitionDate").getAsJsonArray().get(2).getAsInt()
        });

        result.setCompetitionEndDate(null);
        result.setCompetitionName(competitionData.get("competitionName").getAsString());
        result.setCompetitionOrganizer(competitionData.get("competitionOrganizer").getAsString());
        result.setCompetitionSite(competitionData.get("competitionSite").getAsString());
        result.setCustomScore(competitionData.get("customScore").getAsBoolean());
        result.setEnforce20kgRule(competitionData.get("enforce20kgRule").getAsBoolean());
        result.setFederation(competitionData.get("federation").getAsString());
        result.setFederationAddress(competitionData.get("federationAddress").getAsString());
        result.setFederationEMail(null);
        result.setFederationWebSite(competitionData.get("federationWebSite").getAsString());
        result.setFinalPackageTemplateFileName(null);
        result.setGenderOrder(competitionData.get("genderOrder").getAsBoolean());
        result.setFixedOrder(competitionData.get("fixedOrder").getAsBoolean());
        result.setJuryTemplateFileName(null);
        result.setMasters(competitionData.get("masters").getAsBoolean());
        result.setMastersGenderEquality(competitionData.get("mastersGenderEquality").getAsBoolean());
        result.setMaxTeamSize(competitionData.get("maxTeamSize").getAsInt());
        result.setMaxPerCategory(competitionData.get("maxPerCategory").getAsInt());
        result.setProtocolTemplateFileName(null);
        result.setResultsTemplateFileName(null);
        result.setIntroductionTemplateFileName(null);
        result.setRefereeWakeUpDelay(competitionData.get("refereeWakeUpDelay").getAsInt());
        result.setRoundRobinOrder(competitionData.get("roundRobinOrder").getAsBoolean());
        result.setSnatchCJTotalMedals(competitionData.get("snatchCJTotalMedals").getAsBoolean());
        result.setWeighInFormTemplateFileName(competitionData.get("weighInFormTemplateFileName").getAsString());
        result.setEmptyProtocolTemplateFileName(competitionData.get("emptyProtocolTemplateFileName").getAsString());
        result.setStartListTemplateFileName(competitionData.get("startListTemplateFileName").getAsString());
        result.setScheduleTemplateFileName(null);
        result.setUseBirthYear(competitionData.get("useBirthYear").getAsBoolean());
        result.setAutomaticCJBreak(competitionData.get("automaticCJBreak").getAsBoolean());
        result.setUseCategorySinclair(competitionData.get("useCategorySinclair").getAsBoolean());
        result.setSinclairYear(competitionData.get("sinclairYear").getAsInt());
        result.setUseOldBodyWeightTieBreak(competitionData.get("useOldBodyWeightTieBreak").getAsBoolean());
        result.setJurySize(competitionData.get("jurySize").getAsInt());
        result.setLongerBreakMax(competitionData.get("longerBreakMax").getAsInt());
        result.setLongerBreakDuration(competitionData.get("longerBreakDuration").getAsInt());
        result.setShorterBreakMin(competitionData.get("shorterBreakMin").getAsInt());
        result.setShorterBreakDuration(competitionData.get("shorterBreakDuration").getAsInt());
        result.setCategoriesListTemplateFileName(null);
        result.setBodyWeightListTemplateFileName(null);
        result.setOfficialsListTemplateFileName(null);
        result.setTeamsListTemplateFileName(null);
        result.setRecordOrder(null);
        result.setScoringSystem(competitionData.get("scoringSystem").getAsString());
        result.setDisplayScores(competitionData.get("displayScores").getAsBoolean());
        result.setDisplayScoreRanks(competitionData.get("displayScoreRanks").getAsBoolean());
        result.setCheckInTemplateFileName(null);
        result.setDisplayByAgeGroup(competitionData.get("displayByAgeGroup").getAsBoolean());
        result.setAnnouncerControlledJuryDecision(competitionData.get("announcerControlledJuryDecision").getAsBoolean());
        result.setCurrentRecordsTemplateFileName(null);
        result.setMasters20kg(competitionData.get("masters20kg").getAsBoolean());
        result.setTechnicalOfficialsTemplateFileName(null);
        result.setImwa(competitionData.get("imwa").getAsBoolean());
        result.setDeduct250g(competitionData.get("deduct250g").getAsBoolean());
        result.setComputedFinalPackageTemplateFileName(competitionData.get("computedFinalPackageTemplateFileName").getAsString());
        result.setSinclair(competitionData.get("sinclair").getAsBoolean());
        result.setGenderInclusive(competitionData.get("genderInclusive").getAsBoolean());
        result.setInvitedIfBornBefore(competitionData.get("invitedIfBornBefore").getAsInt());
        result.setLocalizedCompetitionDate(competitionData.get("localizedCompetitionDate").getAsString());
        result.setTranslatedScoringSystemName(competitionData.get("translatedScoringSystemName").getAsString());
        result.setMensTeamSize(null);
        result.setWomensTeamSize(null);

        return result;
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
