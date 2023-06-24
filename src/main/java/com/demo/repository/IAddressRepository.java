package com.demo.repository;

import com.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository  extends JpaRepository<Location,Long> {
}
