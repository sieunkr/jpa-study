package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final GetHotelSummaryService getHotelSummaryService;

    public DemoApplication(GetHotelSummaryService getHotelSummaryService) {
        this.getHotelSummaryService = getHotelSummaryService;
    }

    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {


        HotelSummary hotelSummary = getHotelSummaryService.getHotelSummary("1");
        System.out.println("ㅌ");
    }
}
