package javajo.ponsyukey.controller;

import javajo.ponsyukey.model.BreweryResponse;
import javajo.ponsyukey.model.SakeResponse;
import javajo.ponsyukey.service.SakeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class SakeApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SakeService service;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void 酒情報取得_sakeIdが正しい値の場合httpステータスコード200が返却されること() throws Exception {
        this.mockMvc.perform(get("/sake/1")).andDo(print()).andExpect(status().isOk());
    }

    @Nested
    class 酒情報取得_sakeIdのデータ存在していた場合正しいResponseBodyが返却されること{
        private SakeResponse response;

        @BeforeEach
        void setUp(){
            response = new SakeResponse();
            response.setId(UUID.randomUUID());
            response.setAlcohol(15.0F);
            response.setDescription("おいしい");
            response.setImage("https://ponsyukey.jp/1.jpg");
            response.setPolishingRatio(40.0F);
            response.setType("吟醸");
            response.setName("じゃばじょぽんしゅ");
            BreweryResponse brewery = new BreweryResponse();
            brewery.setName("javajo");
            brewery.setPrefecture("青森県");
            response.setBrewery(brewery);
            List<String> taste = List.of("すっきり", "洗練された", "スモークチーズっぽい");
            response.setTaste(taste);
        }

        @Test
        void test() throws Exception {
//            //TODO サービスモックにデータを登録
//            when(service.getSakeResponse()).thenReturn(sakeResponse);
//
//            //TODO モックレスポンスを取得 => actual
//            mockMvc.perform(get("/sake/1")).andExpect(jsonPath("$.resultCode").value("200"));

        }
    }

    @Test
    void 酒情報取得_sakeIdのデータ存在していなかった場合正しいResponseBodyが返却されること(){
        //ToDo 正しいresponseBodyは？
    }




}