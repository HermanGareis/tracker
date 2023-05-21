package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.TimesheetEntity;

/**
 * Repository interface for managing `TimesheetEntity` entities.
 */
@Repository
public interface TimesheetRepository extends JpaRepository<TimesheetEntity, Integer> {

}
