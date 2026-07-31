package um.facultad.rest.hexagonal.carreras.plan.infrastructure.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import um.facultad.rest.hexagonal.carreras.plan.application.exception.PlanException;
import um.facultad.rest.hexagonal.carreras.plan.application.service.PlanService;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.web.dto.PlanResponse;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.web.mapper.PlanDtoMapper;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService service;
    private final PlanDtoMapper planDtoMapper;

    @GetMapping("/")
    public ResponseEntity<List<PlanResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream()
                .map(planDtoMapper::toResponse)
                .toList());
    }

    @GetMapping("/unique/{facultadId}/{planId}")
    public ResponseEntity<PlanResponse> findByUnique(@PathVariable Integer facultadId, @PathVariable Integer planId) {
        try {
            return ResponseEntity.ok(planDtoMapper.toResponse(service.findByUnique(facultadId, planId)));
        } catch (PlanException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
