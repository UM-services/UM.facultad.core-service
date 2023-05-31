/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.DocumentoNotFoundException;
import um.facultad.rest.model.Documento;
import um.facultad.rest.repository.IDocumentoRepository;

/**
 * @author daniel
 *
 */
@Service
public class DocumentoService {

	@Autowired
	private IDocumentoRepository repository;

	public Documento findByDocumentoId(Integer documentoId) {
		return repository.findByDocumentoId(documentoId).orElseThrow(() -> new DocumentoNotFoundException(documentoId));
	}

}
