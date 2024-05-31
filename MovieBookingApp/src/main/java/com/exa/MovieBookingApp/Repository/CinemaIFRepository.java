package com.exa.MovieBookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exa.MovieBookingApp.Entity.CinemaIF;

@Repository
public interface CinemaIFRepository extends JpaRepository<CinemaIF, Integer> {

}
