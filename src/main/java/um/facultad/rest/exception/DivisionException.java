/**
 * 
 */
package um.facultad.rest.exception;

import java.text.MessageFormat;

/**
 * @author daniel
 *
 */
public class DivisionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8957722031432200677L;

	public DivisionException(Integer facultadId, Integer divisionId) {
		super(MessageFormat.format("Cannot find Division {0}/{1}", facultadId, divisionId));
	}

}
