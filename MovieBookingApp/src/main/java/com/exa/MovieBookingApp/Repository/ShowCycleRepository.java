package com.exa.MovieBookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exa.MovieBookingApp.Entity.ShowCycle;

@Repository
public interface ShowCycleRepository extends JpaRepository<ShowCycle, Integer>{

}
