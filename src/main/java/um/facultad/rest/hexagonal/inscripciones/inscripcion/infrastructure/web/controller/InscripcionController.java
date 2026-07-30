package um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.application.exception.InscripcionException;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.application.service.InscripcionService;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.web.dto.InscripcionResponse;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.web.mapper.InscripcionDtoMapper;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

    private final InscripcionService service;
    private final InscripcionDtoMapper inscripcionDtoMapper;

    public InscripcionController(InscripcionService service, InscripcionDtoMapper inscripcionDtoMapper) {
        this.service = service;
        this.inscripcionDtoMapper = inscripcionDtoMapper;
    }

    @GetMapping("/lectivo/{facultadId}/{lectivoId}")
    public ResponseEntity<List<InscripcionResponse>> findAllByLectivo(@PathVariable Integer facultadId,
                                                                       @PathVariable Integer lectivoId) {
        var inscriptos = service.findAllByLectivo(facultadId, lectivoId)
                .stream()
                .map(inscripcionDtoMapper::toResponse)
                .toList();
        return new ResponseEntity<>(inscriptos, HttpStatus.OK);
    }

    @GetMapping("/curso/{facultadId}/{lectivoId}/{geograficaId}/{curso}")
    public ResponseEntity<List<InscripcionResponse>> findAllByCurso(@PathVariable Integer facultadId,
                                                                     @PathVariable Integer lectivoId,
                                                                     @PathVariable Integer geograficaId,
                                                                     @PathVariable Integer curso) {
        var inscriptos = service.findAllByCurso(facultadId, lectivoId, geograficaId, curso)
                .stream()
                .map(inscripcionDtoMapper::toResponse)
                .toList();
        return new ResponseEntity<>(inscriptos, HttpStatus.OK);
    }

    @GetMapping("/cursosinprovisoria/{facultadId}/{lectivoId}/{geograficaId}/{curso}")
    public ResponseEntity<List<InscripcionResponse>> findAllByCursoSinProvisoria(@PathVariable Integer facultadId,
                                                                                  @PathVariable Integer lectivoId,
                                                                                  @PathVariable Integer geograficaId,
                                                                                  @PathVariable Integer curso) {
        var inscriptos = service.findAllByCursoSinProvisoria(facultadId, lectivoId, geograficaId, curso)
                .stream()
                .map(inscripcionDtoMapper::toResponse)
                .toList();
        return new ResponseEntity<>(inscriptos, HttpStatus.OK);
    }

    @GetMapping("/unique/{facultadId}/{personaId}/{documentoId}/{lectivoId}")
    public ResponseEntity<InscripcionResponse> findByUnique(@PathVariable Integer facultadId,
                                                             @PathVariable BigDecimal personaId,
                                                             @PathVariable Integer documentoId,
                                                             @PathVariable Integer lectivoId) {
        try {
            var inscripcion = service.findByUnique(facultadId, personaId, documentoId, lectivoId);
            return new ResponseEntity<>(inscripcionDtoMapper.toResponse(inscripcion), HttpStatus.OK);
        } catch (InscripcionException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

}
