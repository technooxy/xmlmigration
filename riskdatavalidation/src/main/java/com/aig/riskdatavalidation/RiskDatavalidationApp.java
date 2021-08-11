package com.aig.riskdatavalidation;

import com.aig.riskdatavalidation.excelparser.RiskSpreadSheetReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class RiskDatavalidationApp {

    @Autowired
    RiskSpreadSheetReader riskSpreadSheetReader;

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(RiskDatavalidationApp.class, args);
        RiskSpreadSheetReader service = applicationContext.getBean(RiskSpreadSheetReader.class);
        service.reader();
    }
}

