package com.safe.hsap.safe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safe.hsap.safe.model.BookingAgent;
@Repository
public interface BookingAgentRepository extends JpaRepository<BookingAgent, Long> {

}
