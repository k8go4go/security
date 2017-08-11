package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.demo.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long>{
	List<Journal> findByCreatedAfter(@Param("after") @DateTimeFormat(iso=ISO.DATE) Date after);
	
	List<Journal> findByCreatedBetween(@Param("after") @DateTimeFormat(iso=ISO.DATE) Date after, 
			                           @Param("before") @DateTimeFormat(iso=ISO.DATE) Date before);
	
	List<Journal> findBySummaryContaining(@Param("word") String word);
	List<Journal> findByTitleContaining(@Param("word") String word);
}
