package javajo.ponsyukey.controller.exception;

import javajo.ponsyukey.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exceptionの自作ハンドラー群
 */
@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     *  RuntimeException用のハンドラー。HTTPステータス400に集約
     * @param ex RuntimeException. エラーメッセージを設定しておいてください
     * @return ErrorフォーマットJSON
     */
    @ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Error> handleBadRequestException(RuntimeException ex) {
        Error error = new Error();
        error.setMessage(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception用のハンドラー。HTTPステータス500に集約
     * @param ex Exception. エラーメッセージを設定しておいてください
     * @return ErrorフォーマットJSON
     */
    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Error> handleInternalServerException(Exception ex) {
        Error error = new Error();
        error.setMessage(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
