package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.entity.ClienteEntity;

/**
 * Repository interface for managing `ClienteEntity` entities.
 */
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

	/**
	 * Checks if a codice fiscale already exists in the `ClienteEntity` table.
	 *
	 * @param codiceFiscale The codice fiscale to check.
	 * @return `true` if the codice fiscale exists, `false` otherwise.
	 */
	@Query("" + "SELECT CASE WHEN COUNT(c) > 0 THEN " + "TRUE ELSE FALSE END " + "FROM ClienteEntity c "
			+ "WHERE c.codiceFiscale = ?1")
	Boolean selectExistsCodiceFiscale(String codiceFiscale);

}
