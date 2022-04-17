package javajo.ponsyukey.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T15:29:30.596334700+09:00[Asia/Tokyo]")
@RestController
@RequestMapping("${openapi..base-path:}")
public class SaketomoApiController implements SaketomoApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SaketomoApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
