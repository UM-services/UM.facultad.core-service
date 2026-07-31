package um.facultad.rest.hexagonal.carreras.materia.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import um.facultad.rest.hexagonal.carreras.materia.application.service.MateriaService;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.web.dto.MateriaResponse;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.web.mapper.MateriaDtoMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materia")
@RequiredArgsConstructor
public class MateriaController {

    private final MateriaService service;
    private final MateriaDtoMapper dtoMapper;

    @GetMapping("/byplan/{facultadId}/{planId}")
    public ResponseEntity<List<MateriaResponse>> findAllByPlan(@PathVariable Integer facultadId,
                                                                @PathVariable Integer planId) {
        return ResponseEntity.ok(service.findAllByPlan(facultadId, planId).stream()
                .map(dtoMapper::toResponse)
                .toList());
    }

    @GetMapping("/unique/{facultadId}/{planId}/{materiaId}")
    public ResponseEntity<MateriaResponse> findByUnique(@PathVariable Integer facultadId,
                                                         @PathVariable Integer planId,
                                                         @PathVariable String materiaId) {
        try {
            return ResponseEntity.ok(dtoMapper.toResponse(service.findByUnique(facultadId, planId, materiaId)));
        } catch (MatchException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
