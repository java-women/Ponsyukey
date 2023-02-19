package javajo.ponsyukey.controller;

import javajo.ponsyukey.model.CreateSaketomoRequest;
import javajo.ponsyukey.model.SaketomoRequestResponse;
import javajo.ponsyukey.service.SaketomoService;
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
public class SaketomoApiController implements SaketomoApi {

    private final NativeWebRequest request;

    @Autowired
    private SaketomoService saketomoService;

    @org.springframework.beans.factory.annotation.Autowired
    public SaketomoApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<SaketomoRequestResponse> getSaketomo(String saketomoId) {
        SaketomoRequestResponse saketomoResponse = saketomoService.getSaketomoResponse(saketomoId);
        return new ResponseEntity<SaketomoRequestResponse>(saketomoResponse, HttpStatus.OK);
    }

    // TODO 本当は、CreateSaketomoRequest の中で Validationをしたかったが自動生成のためできない。
    @Override
    public ResponseEntity<SaketomoRequestResponse> createSaketomo(CreateSaketomoRequest createSaketomoRequest) {
        SaketomoRequestResponse saketomo = saketomoService.createSaketomo(createSaketomoRequest);
        return new ResponseEntity<SaketomoRequestResponse>(saketomo, HttpStatus.OK);
    }
}
