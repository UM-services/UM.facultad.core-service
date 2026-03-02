/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.DocumentoEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Integer> {

	public Optional<DocumentoEntity> findByDocumentoId(Integer documentoId);

}
