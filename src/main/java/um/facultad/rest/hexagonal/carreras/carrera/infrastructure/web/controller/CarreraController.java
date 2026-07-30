package um.facultad.rest.hexagonal.carreras.carrera.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.carrera.application.service.CarreraService;
import um.facultad.rest.hexagonal.carreras.carrera.infrastructure.web.dto.CarreraResponse;
import um.facultad.rest.hexagonal.carreras.carrera.infrastructure.web.mapper.CarreraDtoMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carrera")
@RequiredArgsConstructor
public class CarreraController {

    private final CarreraService service;
    private final CarreraDtoMapper dtoMapper;

    @GetMapping("/")
    public ResponseEntity<List<CarreraResponse>> findAll() {
        List<CarreraResponse> responses = service.findAll().stream()
                .map(dtoMapper::toResponse)
                .toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/unique/{facultadId}/{planId}/{carreraId}")
    public ResponseEntity<CarreraResponse> findByUnique(@PathVariable Integer facultadId,
                                                         @PathVariable Integer planId,
                                                         @PathVariable Integer carreraId) {
        CarreraResponse response = dtoMapper.toResponse(service.findByUnique(facultadId, planId, carreraId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
