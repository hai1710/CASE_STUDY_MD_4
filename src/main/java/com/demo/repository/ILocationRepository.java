package com.demo.repository;

import com.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location,Long> {
    @Query("SELECT l FROM Location AS l WHERE l.name LIKE %:name%")
    List<Location> findLocationByName(String name);
}
