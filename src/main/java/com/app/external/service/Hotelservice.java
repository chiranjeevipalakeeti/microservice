package com.app.external.service;

import com.app.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HOTELSERVICE")
public interface Hotelservice {
    @GetMapping("/api/hotel/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
