package um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.infrastructure.persistence.repository.JpaInscripcionPagoRepository;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Pagador;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.PagadorPort;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaPagadorPortAdapter implements PagadorPort {

    private final JpaInscripcionPagoRepository inscripcionPagoRepository;

    @Override
    public Optional<Pagador> findPagador(BigDecimal personaId, Integer documentoId) {
        return inscripcionPagoRepository
                .findTopByPersonaIdAndDocumentoIdOrderByLectivoIdDesc(personaId, documentoId)
                .map(inscripcionPago -> Pagador.builder()
                        .personaId(inscripcionPago.getPersonaIdPagador())
                        .documentoId(inscripcionPago.getDocumentoIdPagador())
                        .build());
    }

}
