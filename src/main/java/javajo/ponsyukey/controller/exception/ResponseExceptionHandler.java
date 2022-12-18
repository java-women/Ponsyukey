package javajo.ponsyukey.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javajo.ponsyukey.model.Error;

/**
 * Exceptionの自作ハンドラー群
 */
@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ResponseExceptionHandler.class);

    /**
     *  RuntimeException用のハンドラー。HTTPステータス400に集約
     * @param ex RuntimeException. エラーメッセージを設定しておいてください
     * @return ErrorフォーマットJSON
     */
    @ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Error> handleBadRequestException(RuntimeException ex) {
        Error error = new Error();
        error.setMessage("リクエスト内容に不備がありました。内容を確認し、再実行してください。不具合が修正されない場合は運営者に連絡してください。");

        logger.error(ex.getMessage());

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
        error.setMessage("システム内部に不備が発生しました。運営者に連絡してください。");

        logger.error(ex.getMessage());

        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
