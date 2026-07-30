package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.application.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.in.SaveAllInscripcionesDetalleUseCase;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.out.InscripcionDetalleRepository;

@Component
@RequiredArgsConstructor
public class SaveAllInscripcionesDetalleUseCaseImpl implements SaveAllInscripcionesDetalleUseCase {

    private final InscripcionDetalleRepository repository;

    @Override
    public List<InscripcionDetalle> saveAll(List<InscripcionDetalle> inscripcionesDetalle) {
        return repository.saveAll(inscripcionesDetalle);
    }

}
