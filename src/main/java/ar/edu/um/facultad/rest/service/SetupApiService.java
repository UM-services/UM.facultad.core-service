/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.SetupApiNotFoundException;
import ar.edu.um.facultad.rest.model.SetupApi;
import ar.edu.um.facultad.rest.repository.ISetupApiRepository;

/**
 * @author daniel
 *
 */
@Service
public class SetupApiService {
	@Autowired
	private ISetupApiRepository repository;

	public SetupApi findLast() {
		return repository.findTopByOrderBySetupId().orElseThrow(() -> new SetupApiNotFoundException());
	}
}
