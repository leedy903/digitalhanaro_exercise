package org.conan.myboot.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(value = MessageSourceController.class)
class MessageSourceControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("[GET] /say/hello?lang=ko-kr")
    void sayHelloInKo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/say/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("lang", "ko-kr"))
                .andExpect(status().isOk())
                .andExpect(content().string("안녕!"))
                .andDo(print());
    }

    @Test
    @DisplayName("[GET] /say/hello?lang=en-us")
    void sayHelloInEn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/say/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("lang", "en-us"))
                .andExpect(status().isOk())
                .andExpect(content().string("hi!"))
                .andDo(print());
    }

}