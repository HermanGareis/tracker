package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.OrdineClienteEntity;

/**
 * Repository interface for managing `OrdineClienteEntity` entities.
 */
@Repository
public interface OrdineClienteRepository extends JpaRepository<OrdineClienteEntity, Integer> {

}
