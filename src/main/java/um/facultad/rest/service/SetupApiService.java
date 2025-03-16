/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.SetupApiException;
import um.facultad.rest.model.SetupApi;
import um.facultad.rest.repository.SetupApiRepository;

/**
 * @author daniel
 *
 */
@Service
public class SetupApiService {
	@Autowired
	private SetupApiRepository repository;

	public SetupApi findLast() {
		return repository.findTopByOrderBySetupId().orElseThrow(() -> new SetupApiException());
	}
}
