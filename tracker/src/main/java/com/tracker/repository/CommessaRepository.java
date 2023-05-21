package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.CommessaEntity;

/**
 * Repository interface for managing `CommessaEntity` entities.
 */
@Repository
public interface CommessaRepository extends JpaRepository<CommessaEntity, Integer> {

}
