/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.DocumentoNotFoundException;
import ar.edu.um.facultad.rest.model.Documento;
import ar.edu.um.facultad.rest.repository.IDocumentoRepository;

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
