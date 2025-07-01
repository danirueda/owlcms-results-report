package com.danirueda.owlcms_results_report.service;

import com.danirueda.owlcms_results_report.model.*;
import com.danirueda.owlcms_results_report.model.Record;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@Service
public class LoadDataService {

    @Value("${database.path}")
    private String database;

    private final Gson CONVERTER = new Gson();

    public void loadDatabase() {
        try (JsonReader reader = new JsonReader(new FileReader(database))) {
            JsonObject data = CONVERTER.fromJson(reader, JsonObject.class);
            log.info("Loaded database as JSON Object");
            log.info(data.toString());
            List<Athlete> athletes = loadAthletes(data);
            Competition competition = loadCompetition(data);
            List<Platform> platforms = loadPlatforms(data);
            List<Group> groups = loadGroups(data);
            List<AgeGroup> ageGroups = loadAgeGroups(data);
            List<Record> records = loadRecords(data);
            RecordConfig recordConfig = loadRecordConfig(data);
            log.info("nothing");
        } catch (IOException e) {
            log.error("Error loading database file.", e);
        }
    }

    protected List<Athlete> loadAthletes(JsonObject data) {
        Type athleteList = new TypeToken<List<Athlete>>(){}.getType();

        return CONVERTER.fromJson(data.get("athletes"), athleteList);
    }

    protected Competition loadCompetition(JsonObject data) {
        Type competition = new TypeToken<Competition>(){}.getType();

        return CONVERTER.fromJson(data.get("competition"), competition);
    }

    protected List<Platform> loadPlatforms(JsonObject data) {
        Type platformList = new TypeToken<List<Platform>>(){}.getType();

        return CONVERTER.fromJson(data.get("platforms"), platformList);
    }

    protected List<Group> loadGroups(JsonObject data) {
        Type groupList = new TypeToken<List<Group>>(){}.getType();

        return CONVERTER.fromJson(data.get("groups"), groupList);
    }

    protected List<AgeGroup> loadAgeGroups(JsonObject data) {
        Type ageGroupList = new TypeToken<List<AgeGroup>>(){}.getType();

        return CONVERTER.fromJson(data.get("ageGroups"), ageGroupList);
    }

    protected List<Record> loadRecords(JsonObject data) {
        Type recordList = new TypeToken<List<Record>>(){}.getType();

        return CONVERTER.fromJson(data.get("records"), recordList);
    }

    protected RecordConfig loadRecordConfig(JsonObject data) {
        Type recordConfig = new TypeToken<RecordConfig>(){}.getType();

        return CONVERTER.fromJson(data.get("recordConfig"), recordConfig);
    }

}
