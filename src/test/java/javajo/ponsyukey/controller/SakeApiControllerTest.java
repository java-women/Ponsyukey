package javajo.ponsyukey.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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

    @Test
    void 酒情報取得_sakeIdのデータ存在していた場合正しいResponseBodyが返却されること() {
        //ToDo正しいresponseBodyは？
    }

    @Test
    void 酒情報取得_sakeIdのデータ存在していなかった場合正しいResponseBodyが返却されること(){
        //ToDo正しいresponseBodyは？
    }



}