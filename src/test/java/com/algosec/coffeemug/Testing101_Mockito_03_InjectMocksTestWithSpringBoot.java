//package com.algosec.coffeemug;
//
//import com.algosec.coffeemug.constants.DrinkType;
//import com.algosec.coffeemug.constants.Ingredients;
//import com.algosec.coffeemug.entities.Mug;
//import com.algosec.coffeemug.repository.MugRepository;
//import com.algosec.coffeemug.services.InventoryService;
//import com.algosec.coffeemug.services.MugService;
//import com.algosec.coffeemug.services.OrderService;
//import javassist.expr.NewArray;
//import lombok.extern.slf4j.Slf4j;
//import org.hamcrest.CoreMatchers;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.Date;
//import java.util.UUID;
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest(
//    classes = CoffeemugApplication.class)
//@TestPropertySource(
//    locations = "classpath:application-test.properties")
//class Testing101_Mockito_03_InjectMocksTestWithSpringBoot {
//
//    
//    @InjectMocks
//    private MugService mugService;
//
//    @Mock
//    private MugRepository mugRepository;
////    @SpyBean
////    @Autowired
////    private InventoryService inventoryService;
//    @Mock
//    private OrderService orderService;
//
//    @Test
//    public void givenOneCoffeeMug_thenStatus200AndMilkIsOneLiter()
//        throws Exception {
//
//        Mockito.doNothing().when(orderService).placeOrder(Ingredients.COFFE, 1);
//        Mockito.doNothing().when(orderService).placeOrder(Ingredients.MILK, 1);
//        
//        Mug m = new Mug(UUID.randomUUID(), DrinkType.AMERICANO, new Date());
//        Mockito.when(mugRepository.save(ArgumentMatchers.any())).thenReturn(m);
////        inventoryService.getInventory();
////        inventoryService.reduceInventory(drinkType.getCoffeeInGrams(), drinkType.getMilkInMilliliters());
//        
//        
//        mugService.getDrink(DrinkType.AMERICANO);
//            
//    }
//
//
//    @TestConfiguration
//    @ComponentScan(basePackages = {"com.algosec.coffeemug.***"})
//    static class Configuration {
//
//    }
//	
//}
