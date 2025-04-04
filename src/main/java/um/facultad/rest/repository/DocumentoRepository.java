/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Documento;

/**
 * @author daniel
 *
 */
@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

	public Optional<Documento> findByDocumentoId(Integer documentoId);

}
