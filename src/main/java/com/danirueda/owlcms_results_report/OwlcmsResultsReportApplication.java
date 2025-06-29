package com.danirueda.owlcms_results_report;

import com.danirueda.owlcms_results_report.service.LoadDataService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OwlcmsResultsReportApplication {

	@Autowired
	private LoadDataService loadDataService;

	@PostConstruct
	public void postConstruct() {
		loadDataService.loadDatabase();
	}

	public static void main(String[] args) {
		SpringApplication.run(OwlcmsResultsReportApplication.class, args);
	}

}
