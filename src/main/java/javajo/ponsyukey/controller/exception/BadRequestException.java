package javajo.ponsyukey.controller.exception;

import javajo.ponsyukey.model.Error;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

    private static final long serialVersionUID = 1L;

    public BadRequestException(Error error) {
        super(error.toString());
    }
}
