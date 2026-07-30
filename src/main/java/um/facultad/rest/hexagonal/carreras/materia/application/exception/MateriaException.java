package um.facultad.rest.hexagonal.carreras.materia.application.exception;

public class MateriaException extends RuntimeException {

	private static final long serialVersionUID = 837556299233053937L;

	public MateriaException() {
		super("Materia not found");
	}

	public MateriaException(Integer facultadId, Integer planId, String materiaId) {
		super("Cannot find Materia " + facultadId + "/" + planId + "/" + materiaId);
	}

}
