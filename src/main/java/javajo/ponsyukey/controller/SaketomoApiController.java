package javajo.ponsyukey.controller;

import javajo.ponsyukey.model.CreateSaketomo;
import javajo.ponsyukey.model.Saketomo;
import javajo.ponsyukey.model.SaketomoResponse;
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

    public ResponseEntity<SaketomoResponse> getSaketomo(String saketomoId) {
        SaketomoResponse saketomoResponse = saketomoService.getSaketomoResponse(saketomoId);
        return new ResponseEntity<SaketomoResponse>(saketomoResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Saketomo> createSaketomo(CreateSaketomo createSaketomo) {
        return new ResponseEntity<Saketomo>(new Saketomo(), HttpStatus.OK);
    }
}
