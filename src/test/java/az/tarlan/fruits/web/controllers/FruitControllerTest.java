package az.tarlan.fruits.web.controllers;

import az.tarlan.fruits.utils.FruitUtils;
import az.tarlan.fruits.web.models.FruitDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FruitControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    FruitUtils fruitUtils;


    @Test
    void getFruitById() throws Exception {
        FruitDto fruitDto = fruitUtils.getValidFruitDto();
        String fruitDtoJson = objectMapper.writeValueAsString(fruitDto);

        MvcResult result = mockMvc.perform(post("/api/v1/fruit/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(fruitDtoJson)).andExpect(status().isCreated())
                .andReturn();

        String savedFruitId = result.getResponse().getHeader("Created-fruit-id");

        mockMvc.perform(get("/api/v1/fruit/"+ savedFruitId).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNewFruit() throws Exception {
        FruitDto fruitDto = fruitUtils.getValidFruitDto();
        String fruitDtoJson = objectMapper.writeValueAsString(fruitDto);

        mockMvc.perform(post("/api/v1/fruit/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(fruitDtoJson)).andExpect(status().isCreated());

    }
}