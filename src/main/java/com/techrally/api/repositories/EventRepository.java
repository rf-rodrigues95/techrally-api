package com.techrally.api.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.techrally.api.domain.event.Event;

public interface EventRepository extends JpaRepository<Event, UUID> {
    
    // Custom query methods can be defined here if needed
    // For example, to find events by title:
    // List<Event> findByTitleContaining(String title);
    
    // Or to find events by date range:
    // List<Event> findByDateBetween(Date startDate, Date endDate);

}
