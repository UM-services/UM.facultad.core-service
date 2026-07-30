package um.facultad.rest.hexagonal.tesoreriaEstado.application.service;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.tesoreriaEstado.application.exception.TesoreriaEstadoException;
import um.facultad.rest.hexagonal.tesoreriaEstado.domain.model.TesoreriaEstado;
import um.facultad.rest.hexagonal.tesoreriaEstado.domain.ports.in.FindTesoreriaEstadoByUniqueUseCase;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TesoreriaEstadoService {

    private final FindTesoreriaEstadoByUniqueUseCase findTesoreriaEstadoByUniqueUseCase;

    public TesoreriaEstado findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId) {
        return findTesoreriaEstadoByUniqueUseCase.findByUnique(facultadId, personaId, documentoId)
                .orElseThrow(() -> new TesoreriaEstadoException(facultadId, personaId, documentoId));
    }
}
