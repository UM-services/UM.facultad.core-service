/**
 * 
 */
package um.facultad.rest.repository.view;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.view.PreunivMatricResumen;
import um.facultad.rest.model.view.pk.PreunivMatricResumenPk;

/**
 * @author daniel
 *
 */
@Repository
public interface IPreunivMatricResumenRepository extends JpaRepository<PreunivMatricResumen, PreunivMatricResumenPk> {

	public List<PreunivMatricResumen> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

}
