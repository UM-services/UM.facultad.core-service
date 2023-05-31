/**
 * 
 */
package um.facultad.rest.repository.view;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.view.PreunivResumen;
import um.facultad.rest.model.view.pk.PreunivResumenPk;

/**
 * @author daniel
 *
 */
@Repository
public interface IPreunivResumenRepository extends JpaRepository<PreunivResumen, PreunivResumenPk> {

	public List<PreunivResumen> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId, Sort sort);

}
