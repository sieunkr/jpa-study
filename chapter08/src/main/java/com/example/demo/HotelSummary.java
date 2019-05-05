package com.example.demo;

import java.util.List;

public class HotelSummary {

    private Hotel hotel;
    private List<Review> latestReviews;

    public HotelSummary(Hotel hotel, List<Review> latestReviews){
        this.hotel = hotel;
        this.latestReviews = latestReviews;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public List<Review> getLatestReviews() {
        return latestReviews;
    }
}
