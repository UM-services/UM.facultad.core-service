/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class PlanException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4417726584777145805L;

	public PlanException(Integer facultadId, Integer planId) {
		super("Cannot find Plan " + facultadId + "/" + planId);
	}

}
