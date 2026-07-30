package um.facultad.rest.hexagonal.carreras.materia.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
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
        return new ResponseEntity<>(service.findAllByPlan(facultadId, planId).stream()
                .map(dtoMapper::toResponse)
                .toList(), HttpStatus.OK);
    }

    @GetMapping("/unique/{facultadId}/{planId}/{materiaId}")
    public ResponseEntity<MateriaResponse> findByUnique(@PathVariable Integer facultadId,
                                                         @PathVariable Integer planId,
                                                         @PathVariable String materiaId) {
        return new ResponseEntity<>(dtoMapper.toResponse(service.findByUnique(facultadId, planId, materiaId)),
                HttpStatus.OK);
    }

}
