/**
 * 
 */
package ar.edu.um.facultad.rest.repository.view;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.view.PreunivMatricResumen;
import ar.edu.um.facultad.rest.model.view.pk.PreunivMatricResumenPk;

/**
 * @author daniel
 *
 */
@Repository
public interface IPreunivMatricResumenRepository extends JpaRepository<PreunivMatricResumen, PreunivMatricResumenPk> {

	public List<PreunivMatricResumen> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

}
