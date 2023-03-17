package com.air.pretotype.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.air.pretotype.model.UserEmail;
import com.air.pretotype.model.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor,Integer> {

	Optional<Visitor> findByClientAddress(String clientAddress);

	@Query(nativeQuery = true,value = "SELECT SUM(visitCount) FROM Visitor WHERE visitCount = 1")
	int firstVisitCount();

	@Query(value = "SELECT SUM(visitCount) FROM Visitor where 1=1", nativeQuery = true)
	int totalVisitCount();

}
