package com.air.pretotype.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.air.pretotype.model.Count;

public interface CountRepository extends JpaRepository<Count,Integer> {
	Optional<Count> findByDateInfo(LocalDate dateInfo);
}
