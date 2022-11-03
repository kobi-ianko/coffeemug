package com.algosec.coffeemug;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.entities.Mug;
import com.algosec.coffeemug.repository.MugRepository;
import com.algosec.coffeemug.services.MugService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = CoffeemugApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
    locations = "classpath:application-test.properties")
class Testing101_IntegrationTests_01_BasicTestWithSpringBoot {

    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private MugService mugService;

    @Test
    public void givenOneCoffeMug_whenInventory_thenStatus200AndMilkIsOneLiter()
        throws Exception {
        
        mugService.getDrink(DrinkType.AMERICANO);

        mvc.perform(MockMvcRequestBuilders.get("/inventory")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("milkInLiters", CoreMatchers.is(1.0)));
            
    }
	
}
