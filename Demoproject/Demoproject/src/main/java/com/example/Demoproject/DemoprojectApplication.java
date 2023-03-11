package com.example.Demoproject;

import com.example.Demoproject.model.Coin;
import com.example.Demoproject.repo.CoinRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DemoprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoprojectApplication.class, args);
	}
}
