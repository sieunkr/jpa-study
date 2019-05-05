package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHotelSummaryService {

    private final HotelRepository hotelRepository;
    private final ReviewRepository reviewRepository;

    public GetHotelSummaryService(HotelRepository hotelRepository, ReviewRepository reviewRepository) {
        this.hotelRepository = hotelRepository;
        this.reviewRepository = reviewRepository;
    }

    public HotelSummary getHotelSummary(String hotelId){

        Hotel hotel = hotelRepository.find(hotelId);
        List<Review> reviews = reviewRepository.findByHotel(hotel, 0, 2);
        return new HotelSummary(hotel, reviews);
    }
}
