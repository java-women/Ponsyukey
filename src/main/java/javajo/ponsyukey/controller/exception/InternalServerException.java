package javajo.ponsyukey.controller.exception;

public class InternalServerException extends Exception{

    private static final long serialVersionUID = 1L;

    public InternalServerException(String errorMsg) {
        super(errorMsg);
    }
}
