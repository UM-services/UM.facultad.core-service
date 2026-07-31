package um.facultad.rest.hexagonal.personas.persona.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.facultad.rest.hexagonal.personas.persona.application.service.PersonaService;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.web.dto.PersonaResponse;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.web.mapper.PersonaDtoMapper;

import java.math.BigDecimal;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService service;
    private final PersonaDtoMapper dtoMapper;

    @GetMapping("/{personaId}/{documentoId}")
    public ResponseEntity<PersonaResponse> findByPersonaIdAndDocumentoId(@PathVariable BigDecimal personaId,
                                                                         @PathVariable Integer documentoId) {
        return ResponseEntity.ok(dtoMapper.toResponse(service.findByPersonaIdAndDocumentoId(personaId, documentoId)));
    }

}
