package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.application.service.InscripcionDetalleService;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.web.dto.InscripcionDetalleResponse;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.web.mapper.InscripcionDetalleDtoMapper;

@RestController
@RequestMapping("/inscripciondetalle")
@RequiredArgsConstructor
public class InscripcionDetalleController {

	private final InscripcionDetalleService service;
	private final InscripcionDetalleDtoMapper mapper;

	@GetMapping("/persona/{personaId}/{documentoId}/{facultadId}/{lectivoId}")
	public ResponseEntity<List<InscripcionDetalleResponse>> findAllByPersona(@PathVariable BigDecimal personaId,
																			 @PathVariable Integer documentoId,
																			 @PathVariable Integer facultadId,
																			 @PathVariable Integer lectivoId) {
		return ResponseEntity.ok(service.findAllByPersona(personaId, documentoId, facultadId, lectivoId)
				.stream()
				.map(mapper::toResponse)
				.toList());
	}
}
