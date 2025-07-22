package com.techrally.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techrally.api.domain.event.Event;
import com.techrally.api.domain.event.EventRequestDto;
import com.techrally.api.service.EventService;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Event> create(@RequestParam("title") String title,
    @RequestParam(value = "description", required = false) String description,
    @RequestParam("date") Long date,
    @RequestParam("city") String city,
    @RequestParam("uf") String uf,
    @RequestParam("remote") boolean remote,
    @RequestParam("eventUrl") String eventUrl,
    @RequestParam(value = "image", required = false) MultipartFile image) {
        EventRequestDto eventRequestDto = new EventRequestDto(title, description, date, city, uf, remote, eventUrl, image);
        Event newEvent = this.eventService.createEvent(eventRequestDto);   
        return ResponseEntity.ok(newEvent);
    }
}
