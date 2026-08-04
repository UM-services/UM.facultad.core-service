package um.facultad.rest.service.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import um.facultad.rest.hexagonal.carreras.carrera.application.service.CarreraService;
import um.facultad.rest.hexagonal.carreras.materia.application.service.MateriaService;
import um.facultad.rest.hexagonal.carreras.plan.application.service.PlanService;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.application.service.InscripcionService;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.application.service.InscripcionDetalleService;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.personas.persona.application.service.PersonaService;
import um.facultad.rest.service.DocumentoService;
import um.facultad.rest.service.FacultadService;
import um.facultad.rest.service.GeograficaService;
import um.facultad.rest.service.LectivoService;
import um.facultad.rest.service.MateriaCarreraService;
import um.facultad.rest.service.MateriaCursoService;
import um.facultad.rest.service.RegularidadService;
import um.facultad.rest.model.dto.PendienteInfo;

@ExtendWith(MockitoExtension.class)
class PendienteInfoServiceTest {

    private static final Integer FACULTAD_ID = 1;
    private static final Integer LECTIVO_ID = 2;
    private static final Integer GEOGRAFICA_ID = 3;
    private static final BigDecimal PERSONA_ID = BigDecimal.ONE;
    private static final Integer DOCUMENTO_ID = 4;

    @Mock
    private FacultadService facultadservice;
    @Mock
    private LectivoService lectivoservice;
    @Mock
    private GeograficaService geograficaservice;
    @Mock
    private DocumentoService documentoservice;
    @Mock
    private PersonaService personaservice;
    @Mock
    private InscripcionService inscripcionservice;
    @Mock
    private PlanService planservice;
    @Mock
    private CarreraService carreraservice;
    @Mock
    private InscripcionDetalleService inscripciondetalleservice;
    @Mock
    private MateriaService materiaservice;
    @Mock
    private MateriaCarreraService materiacarreraservice;
    @Mock
    private MateriaCursoService materiacursoservice;
    @Mock
    private RegularidadService regularidadservice;

    @InjectMocks
    private PendienteInfoService service;

    @Test
    void devuelveRespuestaParcialCuandoFallaUnaCargaBase() {
        when(facultadservice.findByFacultadId(FACULTAD_ID)).thenThrow(new RuntimeException("facultad no disponible"));
        when(inscripcionservice.findByUnique(FACULTAD_ID, PERSONA_ID, DOCUMENTO_ID, LECTIVO_ID))
                .thenThrow(new RuntimeException("inscripcion no disponible"));

        PendienteInfo result = service.findByAlumno(FACULTAD_ID, LECTIVO_ID, GEOGRAFICA_ID, PERSONA_ID,
                DOCUMENTO_ID);

        assertThat(result).isNotNull();
        assertThat(result.getFacultad()).isNull();
        assertThat(result.getInscripcion()).isNull();
        assertThat(result.getDetalles()).isEmpty();
        assertThat(result.getMaterias()).isEmpty();
        assertThat(result.getMateriascarrera()).isEmpty();
        assertThat(result.getMateriascurso()).isEmpty();
        assertThat(result.getRegularidades()).isEmpty();
        assertThat(result.getInscripciones()).isEmpty();
    }

    @Test
    void continuaConElRestoCuandoFallaUnaCargaDependiente() {
        Inscripcion inscripcion = Inscripcion.builder()
                .facultadId(FACULTAD_ID)
                .planId(10)
                .carreraId(20)
                .build();
        when(inscripcionservice.findByUnique(FACULTAD_ID, PERSONA_ID, DOCUMENTO_ID, LECTIVO_ID))
                .thenReturn(inscripcion);
        when(materiacarreraservice.findAllByCarrera(FACULTAD_ID, 10, 20))
                .thenThrow(new RuntimeException("materias no disponibles"));

        PendienteInfo result = service.findByAlumno(FACULTAD_ID, LECTIVO_ID, GEOGRAFICA_ID, PERSONA_ID,
                DOCUMENTO_ID);

        assertThat(result.getInscripcion()).isSameAs(inscripcion);
        assertThat(result.getMateriascarrera()).isEmpty();
        assertThat(result.getMateriascurso()).isEmpty();
        assertThat(result.getRegularidades()).isEmpty();
    }
}
