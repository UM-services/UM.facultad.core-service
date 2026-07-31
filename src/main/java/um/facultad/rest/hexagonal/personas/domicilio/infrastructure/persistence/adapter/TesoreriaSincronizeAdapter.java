package um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import um.facultad.rest.exception.SetupApiException;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.TesoreriaSincronizePort;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.entity.DomicilioEntity;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.mapper.DomicilioMapper;
import um.facultad.rest.model.SetupApiEntity;
import um.facultad.rest.repository.SetupApiRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class TesoreriaSincronizeAdapter implements TesoreriaSincronizePort {

    private final SetupApiRepository setupApiRepository;
    private final DomicilioMapper domicilioMapper;

    @Override
    public void sincronize(Domicilio domicilio) {
        RestTemplate restTemplate = new RestTemplate();
        SetupApiEntity setupApi = setupApiRepository.findTopByOrderBySetupId()
                .orElseThrow(SetupApiException::new);
        String url = "http://" + setupApi.getApiservertesoreria() + ":" + setupApi.getApiporttesoreria()
                + "/domicilio/sincronize";
        DomicilioEntity otherDomicilio = restTemplate.postForObject(
                url, domicilioMapper.toEntity(domicilio), DomicilioEntity.class);
        log.debug("Tesoreria response -> {}", otherDomicilio);
    }

}
