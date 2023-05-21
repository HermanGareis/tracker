package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.RuoloEntity;

/**
 * Repository interface for managing `RuoloEntity` entities.
 */
@Repository
public interface RuoloRepository extends JpaRepository<RuoloEntity, Integer> {

}
