/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.DocumentoException;
import um.facultad.rest.model.DocumentoEntity;
import um.facultad.rest.repository.DocumentoRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class DocumentoService {

	private final DocumentoRepository repository;

	public DocumentoEntity findByDocumentoId(Integer documentoId) {
		return repository.findByDocumentoId(documentoId).orElseThrow(() -> new DocumentoException(documentoId));
	}

}
