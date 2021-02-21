package javajo.ponsyukey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-21T07:14:50.757524300Z[UTC]")
@Controller
@RequestMapping("${openapi..base-path:}")
public class ReviewApiController implements ReviewApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ReviewApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
