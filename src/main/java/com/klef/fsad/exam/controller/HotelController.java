package com.klef.fsad.exam.controller;

import com.klef.fsad.exam.model.Hotel;
import com.klef.fsad.exam.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/update/{id}")
    public String updateHotel(@PathVariable Long id, @RequestParam String status) {
        return hotelService.updateHotelStatus(id, status);
    }
}
