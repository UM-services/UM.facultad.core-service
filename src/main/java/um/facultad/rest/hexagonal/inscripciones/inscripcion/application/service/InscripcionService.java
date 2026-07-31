package um.facultad.rest.hexagonal.inscripciones.inscripcion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.application.exception.InscripcionPagoException;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.application.exception.InscripcionException;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in.*;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.model.InscripcionPago;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.entity.DomicilioEntity;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.infrastructure.persistence.entity.InscripcionPagoEntity;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.entity.PersonaEntity;
import um.facultad.rest.model.dto.InscripcionFullDto;
import um.facultad.rest.hexagonal.personas.domicilio.application.service.DomicilioService;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.application.service.InscripcionPagoService;
import um.facultad.rest.hexagonal.personas.persona.application.service.PersonaService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InscripcionService {

    private final FindInscripcionByLectivoUseCase findInscripcionByLectivoUseCase;
    private final FindInscripcionByCursoUseCase findInscripcionByCursoUseCase;
    private final FindInscripcionByCursoSinProvisoriaUseCase findInscripcionByCursoSinProvisoriaUseCase;
    private final FindInscripcionAnterioresUseCase findInscripcionAnterioresUseCase;
    private final FindInscripcionByUniqueUseCase findInscripcionByUniqueUseCase;
    private final SaveAllInscripcionUseCase saveAllInscripcionUseCase;
    private final InscripcionPagoService inscripcionPagoService;
    private final PersonaService personaService;
    private final DomicilioService domicilioService;

    public List<Inscripcion> findAllByLectivo(Integer facultadId, Integer lectivoId) {
        return findInscripcionByLectivoUseCase.findByLectivo(facultadId, lectivoId);
    }

    public List<Inscripcion> findAllByCurso(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso) {
        return findInscripcionByCursoUseCase.findByCurso(facultadId, lectivoId, geograficaId, curso);
    }

    public List<Inscripcion> findAllByCursoSinProvisoria(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso) {
        return findInscripcionByCursoSinProvisoriaUseCase.findByCursoSinProvisoria(facultadId, lectivoId, geograficaId, curso);
    }

    public List<Inscripcion> findAllAnteriores(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId) {
        return findInscripcionAnterioresUseCase.findAnteriores(personaId, documentoId, facultadId, lectivoId);
    }

    public Inscripcion findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        return findInscripcionByUniqueUseCase.findByUnique(facultadId, personaId, documentoId, lectivoId)
                .orElseThrow(() -> new InscripcionException(facultadId, personaId, documentoId, lectivoId));
    }

    public List<Inscripcion> saveAll(List<Inscripcion> inscriptos) {
        return saveAllInscripcionUseCase.saveAll(inscriptos);
    }

    public InscripcionFullDto findInscripcionFull(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        Inscripcion inscripcion;
        try {
            inscripcion = findByUnique(facultadId, personaId, documentoId, lectivoId);
        } catch (InscripcionException e) {
            inscripcion = null;
        }
        InscripcionPago inscripcionPago;
        Persona personaPago;
        Domicilio domicilioPago;
        try {
            inscripcionPago = inscripcionPagoService.findByUnique(facultadId, personaId, documentoId, lectivoId);
            personaPago = personaService.findByPersonaIdAndDocumentoId(inscripcionPago.getPersonaIdPagador(), inscripcionPago.getDocumentoId());
            domicilioPago = domicilioService.findByPersonaIdAndDocumentoId(personaPago.getPersonaId(), personaPago.getDocumentoId());
        } catch (InscripcionPagoException e) {
            inscripcionPago = null;
            personaPago = null;
            domicilioPago = null;
        }

        return InscripcionFullDto.builder()
                .inscripcion(inscripcion)
                .inscripcionPago(inscripcionPago)
                .personaPago(personaPago)
                .domicilioPago(domicilioPago)
                .build();
    }


}
