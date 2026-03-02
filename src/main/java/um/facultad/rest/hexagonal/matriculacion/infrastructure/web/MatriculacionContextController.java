package um.facultad.rest.hexagonal.matriculacion.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.facultad.rest.hexagonal.matriculacion.domain.model.MatriculacionContext;
import um.facultad.rest.hexagonal.matriculacion.domain.ports.in.GenerateMatriculacionContextUseCase;

import java.math.BigDecimal;

@RestController
@RequestMapping("/matriculacion/context")
@RequiredArgsConstructor
public class MatriculacionContextController {

    private final GenerateMatriculacionContextUseCase generateMatriculacionContextUseCase;

    @GetMapping("/persona/{personaId}/documento/{documentoId}/lectivo/{lectivoId}/facultad/{facultadId}")
    public ResponseEntity<MatriculacionContext> makeContext(@PathVariable BigDecimal personaId, @PathVariable Integer documentoId, @PathVariable Integer lectivoId, @PathVariable Integer facultadId) {
        return ResponseEntity.ok(generateMatriculacionContextUseCase.generateContextByPersonaAndLectivo(personaId, documentoId, lectivoId, facultadId));
    }

}
