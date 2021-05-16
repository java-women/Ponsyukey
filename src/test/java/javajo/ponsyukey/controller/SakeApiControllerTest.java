package javajo.ponsyukey.controller;

import javajo.ponsyukey.model.Sake;
import javajo.ponsyukey.model.SakeBrewery;
import javajo.ponsyukey.model.SakeResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class SakeApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

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
        @BeforeEach
        void setUp(){
            Sake sake = new Sake();
            sake.setId(UUID.randomUUID());
            sake.setAlcohol(15.0F);
            sake.setDescription("おいしい");
            sake.setImage("https://ponsyukey.jp/1.jpg");
            sake.setPolishingRatio(40.0F);
            sake.setType("吟醸");
            sake.setName("じゃばじょぽんしゅ");
            SakeBrewery brewery = new SakeBrewery();
            brewery.setName("javajo");
            brewery.setPrefecture("青森県");
            sake.setBrewery(brewery);
            List<String> taste = List.of("すっきり", "洗練された", "スモークチーズっぽい");
            sake.setTaste(taste);

            //testのexpectedデータを生成する
            String expected = "{}";

        }

        @Test
        void test() throws Exception {
            //TODO サービスモックにデータを登録

            //TODO モックレスポンスを取得 => actual
            mockMvc.perform(get("/sake/1")).andDo(   );

            //ToDo 正しいresponseBody -> SakeResponse DTO のJSONに正しい値が設定されて返却されること
            assertEquals("", "");
        }
    }

    @Test
    void 酒情報取得_sakeIdのデータ存在していなかった場合正しいResponseBodyが返却されること(){
        //ToDo 正しいresponseBodyは？
    }




}