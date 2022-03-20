package javajo.ponsyukey.controller;

import javajo.ponsyukey.controller.exception.BadRequestException;
import javajo.ponsyukey.model.Error;
import javajo.ponsyukey.model.SakeResponse;
import javajo.ponsyukey.service.SakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T15:29:30.596334700+09:00[Asia/Tokyo]")
@Controller
@RequestMapping("${openapi..base-path:}")
public class SakeApiController implements SakeApi {

    private final NativeWebRequest request;

    @Autowired
    private SakeService sakeService;

    @org.springframework.beans.factory.annotation.Autowired
    public SakeApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<SakeResponse> getSakeDetail(String sakeId) throws BadRequestException {
        try {
            SakeResponse sakeResponse = sakeService.getSakeResponse(sakeId);
            return new ResponseEntity<SakeResponse>(sakeResponse, HttpStatus.OK);

        } catch (Exception e) {
            Error error = new Error();
            error.setMessage("エラーだよ");
            throw new BadRequestException(error);
        }
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request, java.lang.Error error) {
        System.out.println("テスト〜〜〜〜");
        return new ResponseEntity(null);
    }
}
