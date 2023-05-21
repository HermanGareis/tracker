package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.entity.UtenteEntity;

/**
 * Repository interface for managing `UtenteEntity` entities.
 */
@Repository
public interface UtenteRepository extends JpaRepository<UtenteEntity, Integer> {

	/**
	 * Checks if an email already exists in the `UtenteEntity` table.
	 *
	 * @param email The email to check.
	 * @return `true` if the email exists, `false` otherwise.
	 */
	@Query("" + "SELECT CASE WHEN COUNT(u) > 0 THEN " + "TRUE ELSE FALSE END " + "FROM UtenteEntity u "
			+ "WHERE u.email = ?1")
	Boolean selectExistsEmail(String email);
}
