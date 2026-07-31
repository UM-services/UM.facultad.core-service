/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.SetupApiException;
import um.facultad.rest.model.SetupApiEntity;
import um.facultad.rest.repository.SetupApiRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class SetupApiService {
	private final SetupApiRepository repository;

	public SetupApiEntity findLast() {
		return repository.findTopByOrderBySetupId().orElseThrow(() -> new SetupApiException());
	}
}
