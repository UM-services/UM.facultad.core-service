/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class PlanNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4417726584777145805L;

	public PlanNotFoundException(Integer facultadId, Integer planId) {
		super("Cannot find Plan " + facultadId + "/" + planId);
	}

}
