/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package javajo.ponsyukey.controller;

import javajo.ponsyukey.model.CreateSaketomo;
import javajo.ponsyukey.model.Error;
import javajo.ponsyukey.model.SaketomoResponse;
import javajo.ponsyukey.model.SaketomoWithAuth;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-15T16:50:50.747712+09:00[Asia/Tokyo]")
@Validated
@Api(value = "saketomo", description = "the saketomo API")
public interface SaketomoApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /saketomo : 会員登録API
     *
     * @param createSaketomo 会員登録に必要な情報 (required)
     * @return http ステータスコード 200 ok。バリデーションエラー時も200でレスポンスする (status code 200)
     *         or http ステータスコード 400 error (status code 400)
     *         or http ステータスコード 500 error (status code 500)
     */
    @ApiOperation(value = "会員登録API", nickname = "createSaketomo", notes = "", response = Object.class, tags={ "saketomo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "http ステータスコード 200 ok。バリデーションエラー時も200でレスポンスする", response = Object.class),
        @ApiResponse(code = 400, message = "http ステータスコード 400 error", response = Error.class),
        @ApiResponse(code = 500, message = "http ステータスコード 500 error", response = Error.class) })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/saketomo",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Object> createSaketomo(@ApiParam(value = "会員登録に必要な情報", required = true) @Valid @RequestBody CreateSaketomo createSaketomo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /saketomo/{saketomoId} : 会員情報取得API
     *
     * @param saketomoId  (required)
     * @return http ステータスコード 200 ok。バリデーションエラー時も200でレスポンスする (status code 200)
     *         or http ステータスコード 400 error (status code 400)
     *         or http ステータスコード 500 error (status code 500)
     */
    @ApiOperation(value = "会員情報取得API", nickname = "getSaketomo", notes = "", response = SaketomoResponse.class, tags={ "saketomo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "http ステータスコード 200 ok。バリデーションエラー時も200でレスポンスする", response = SaketomoResponse.class),
        @ApiResponse(code = 400, message = "http ステータスコード 400 error", response = Error.class),
        @ApiResponse(code = 500, message = "http ステータスコード 500 error", response = Error.class) })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/saketomo/{saketomoId}",
        produces = { "application/json" }
    )
    default ResponseEntity<SaketomoResponse> getSaketomo(@ApiParam(value = "", required = true) @PathVariable("saketomoId") String saketomoId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"saketomo\" : { \"image\" : \"icon1\", \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /saketomo/{saketomoId} : 会員編集API
     *
     * @param saketomoId  (required)
     * @param saketomoWithAuth 会員編集に必要な情報 (required)
     * @return http ステータスコード 200 ok。バリデーションエラー時も200でレスポンスする (status code 200)
     *         or http ステータスコード 400 error (status code 400)
     *         or http ステータスコード 500 error (status code 500)
     */
    @ApiOperation(value = "会員編集API", nickname = "updateSaketomo", notes = "", response = Object.class, tags={ "saketomo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "http ステータスコード 200 ok。バリデーションエラー時も200でレスポンスする", response = Object.class),
        @ApiResponse(code = 400, message = "http ステータスコード 400 error", response = Error.class),
        @ApiResponse(code = 500, message = "http ステータスコード 500 error", response = Error.class) })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/saketomo/{saketomoId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Object> updateSaketomo(@ApiParam(value = "", required = true) @PathVariable("saketomoId") String saketomoId,@ApiParam(value = "会員編集に必要な情報", required = true) @Valid @RequestBody SaketomoWithAuth saketomoWithAuth) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
