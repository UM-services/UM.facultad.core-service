package um.facultad.rest.service;

import org.springframework.stereotype.Service;
import um.facultad.rest.exception.InscripcionPagoException;
import um.facultad.rest.model.InscripcionPago;
import um.facultad.rest.repository.InscripcionPagoRepository;

import java.math.BigDecimal;

@Service
public class InscripcionPagoService {

    private final InscripcionPagoRepository repository;

    public InscripcionPagoService(InscripcionPagoRepository repository) {
        this.repository = repository;
    }

    public InscripcionPago findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        return repository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId).orElseThrow(() -> new InscripcionPagoException(facultadId, personaId, documentoId, lectivoId));
    }

}
