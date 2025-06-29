package com.danirueda.owlcms_results_report.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Slf4j
@Service
public class LoadDataService {

    @Value("${database.path}")
    private String database;

    public void loadDatabase() {
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new FileReader(database))) {
            JsonObject config = gson.fromJson(reader, JsonObject.class);
            log.info("Loaded database as JSON Object");
            log.info(config.toString());
        } catch (IOException e) {
            log.error("Error loading database file.", e);
        }
    }

}
