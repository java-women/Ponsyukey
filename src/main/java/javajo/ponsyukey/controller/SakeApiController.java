package javajo.ponsyukey.controller;

import javajo.ponsyukey.model.SakeResponse;
import javajo.ponsyukey.service.SakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T15:29:30.596334700+09:00[Asia/Tokyo]")
@RestController
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
    public ResponseEntity<SakeResponse> getSakeDetail(String sakeId) {

            SakeResponse sakeResponse = sakeService.getSakeResponse(sakeId);
            return new ResponseEntity<SakeResponse>(sakeResponse, HttpStatus.OK);

    }

}
