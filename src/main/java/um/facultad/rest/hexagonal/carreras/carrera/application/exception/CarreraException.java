package um.facultad.rest.hexagonal.carreras.carrera.application.exception;

public class CarreraException extends RuntimeException {

    private static final long serialVersionUID = 4678567191299089760L;

    public CarreraException() {
        super("Carrera not found");
    }

    public CarreraException(Integer facultadId, Integer planId, Integer carreraId) {
        super("Cannot find Carrera " + facultadId + "/" + planId + "/" + carreraId);
    }

}
