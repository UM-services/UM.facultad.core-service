package um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import um.facultad.rest.hexagonal.tesoreriaEstado.application.exception.TesoreriaEstadoException;
import um.facultad.rest.hexagonal.tesoreriaEstado.application.service.TesoreriaEstadoService;
import um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.web.dto.TesoreriaEstadoResponse;
import um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.web.mapper.TesoreriaEstadoDtoMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/tesoreriaEstado")
@RequiredArgsConstructor
public class TesoreriaEstadoController {

    private final TesoreriaEstadoService service;
    private final TesoreriaEstadoDtoMapper dtoMapper;

    @GetMapping("/unique/{facultadId}/{personaId}/{documentoId}")
    public ResponseEntity<TesoreriaEstadoResponse> findByUnique(@PathVariable Integer facultadId,
                                                                  @PathVariable BigDecimal personaId,
                                                                  @PathVariable Integer documentoId) {
        try {
            TesoreriaEstadoResponse response = dtoMapper.toResponse(service.findByUnique(facultadId, personaId, documentoId));
            return ResponseEntity.ok(response);
        } catch (TesoreriaEstadoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
