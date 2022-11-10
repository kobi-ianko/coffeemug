package com.algosec.coffeemug.solutions;

import com.algosec.coffeemug.CoffeemugApplication;
import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.entities.Inventory;
import com.algosec.coffeemug.repository.InventoryRepository;
import com.algosec.coffeemug.services.MugService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = CoffeemugApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
    locations = "classpath:application-test.properties")
class Testing101_03_sol {

    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private MugService mugService;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    public void InventoryTest()
        throws Exception {

        inventoryRepository.save(Inventory.builder().coffeeInKilos(0).MilkInLiters(0).date(new Date()).build());
        
        mvc.perform(MockMvcRequestBuilders.get("/inventory")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("coffeeInKilos", CoreMatchers.is(0.0))).andDo(MockMvcResultHandlers.print());
            
        mugService.getDrink(DrinkType.AMERICANO);

        mvc.perform(MockMvcRequestBuilders.get("/inventory")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("coffeeInKilos", Matchers.greaterThan(0.0))).andDo(MockMvcResultHandlers.print());
            
    }
	
}
