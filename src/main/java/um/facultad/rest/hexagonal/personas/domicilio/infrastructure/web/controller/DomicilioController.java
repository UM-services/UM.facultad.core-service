package um.facultad.rest.hexagonal.personas.domicilio.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.facultad.rest.hexagonal.personas.domicilio.application.service.DomicilioService;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.web.dto.DomicilioRequest;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.web.dto.DomicilioResponse;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.web.mapper.DomicilioDtoMapper;

import java.math.BigDecimal;

@RestController
@RequestMapping("/domicilio")
@RequiredArgsConstructor
public class DomicilioController {

    private final DomicilioService service;
    private final DomicilioDtoMapper dtoMapper;

    @GetMapping("/{personaId}/{documentoId}")
    public ResponseEntity<DomicilioResponse> findByPersonaIdAndDocumentoId(@PathVariable BigDecimal personaId,
                                                                           @PathVariable Integer documentoId) {
        return ResponseEntity.ok(dtoMapper.toResponse(service.findByPersonaIdAndDocumentoId(personaId, documentoId)));
    }

    @GetMapping("/pagador/{personaId}/{documentoId}")
    public ResponseEntity<DomicilioResponse> findByPagador(@PathVariable BigDecimal personaId,
                                                           @PathVariable Integer documentoId) {
        return ResponseEntity.ok(dtoMapper.toResponse(service.findByPagador(personaId, documentoId)));
    }

    @PostMapping("/")
    public ResponseEntity<DomicilioResponse> add(@RequestBody DomicilioRequest request) {
        return ResponseEntity.ok(dtoMapper.toResponse(service.add(dtoMapper.toDomain(request), true)));
    }

    @PutMapping("/{personaId}/{documentoId}")
    public ResponseEntity<DomicilioResponse> update(@RequestBody DomicilioRequest request,
                                                    @PathVariable BigDecimal personaId,
                                                    @PathVariable Integer documentoId) {
        return ResponseEntity.ok(dtoMapper.toResponse(service.update(dtoMapper.toDomain(request), personaId, documentoId, true)));
    }

    @PostMapping("/sincronize")
    public ResponseEntity<DomicilioResponse> sincronize(@RequestBody DomicilioRequest request) {
        return ResponseEntity.ok(dtoMapper.toResponse(service.sincronize(dtoMapper.toDomain(request))));
    }

}
