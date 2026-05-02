package com.klef.fsad.exam.service;

import com.klef.fsad.exam.model.Hotel;
import com.klef.fsad.exam.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public String updateHotelStatus(Long id, String status) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            hotel.setStatus(status);
            hotelRepository.save(hotel);
            return "Hotel Status Updated Successfully";
        } else {
            return "Hotel ID Not Found";
        }
    }
}
