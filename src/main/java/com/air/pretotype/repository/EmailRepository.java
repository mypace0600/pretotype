package com.air.pretotype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.air.pretotype.model.UserEmail;

public interface EmailRepository  extends JpaRepository<UserEmail,Integer> {
}
