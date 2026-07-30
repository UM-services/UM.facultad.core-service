package um.facultad.rest.hexagonal.carreras.carrera.infrastructure.web.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;
import um.facultad.rest.hexagonal.carreras.carrera.infrastructure.web.dto.CarreraResponse;

@Component
public class CarreraDtoMapper {

    public CarreraResponse toResponse(Carrera domain) {
        if (domain == null) return null;
        CarreraResponse.CarreraResponseBuilder builder = CarreraResponse.builder()
                .facultadId(domain.getFacultadId())
                .planId(domain.getPlanId())
                .carreraId(domain.getCarreraId())
                .bloqueId(domain.getBloqueId())
                .planNombre(domain.getPlan() != null ? domain.getPlan().getNombre() : null);
        if (domain.getNombre() != null) builder.nombre(domain.getNombre());
        if (domain.getIniciales() != null) builder.iniciales(domain.getIniciales());
        if (domain.getTitulo() != null) builder.titulo(domain.getTitulo());
        if (domain.getTrabajoFinal() != null) builder.trabajoFinal(domain.getTrabajoFinal());
        if (domain.getResolucion() != null) builder.resolucion(domain.getResolucion());
        if (domain.getChequeraUnica() != null) builder.chequeraUnica(domain.getChequeraUnica());
        if (domain.getObligatorias() != null) builder.obligatorias(domain.getObligatorias());
        if (domain.getOptativas() != null) builder.optativas(domain.getOptativas());
        if (domain.getVigente() != null) builder.vigente(domain.getVigente());
        return builder.build();
    }
}
