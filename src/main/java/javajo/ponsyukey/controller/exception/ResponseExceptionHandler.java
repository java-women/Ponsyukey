package javajo.ponsyukey.controller.exception;

import javajo.ponsyukey.controller.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(BadRequestException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request, Error error) {
//        return super.handleExceptionInternal(ex, error.toString(), null, HttpStatus.BAD_REQUEST, request);
//    }

//    @ExceptionHandler
//    public ResponseEntity<Object> handleInternalServerErrorException(ConstraintViolationException ex, WebRequest request, String message) {
//        Error error = new Error();
//        error.setMessage(message);
//        return super.handleExceptionInternal(ex, error, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
}
