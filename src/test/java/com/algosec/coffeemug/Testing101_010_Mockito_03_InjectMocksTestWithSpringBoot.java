package com.algosec.coffeemug;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.entities.Inventory;
import com.algosec.coffeemug.entities.Mug;
import com.algosec.coffeemug.repository.MugRepository;
import com.algosec.coffeemug.services.InventoryService;
import com.algosec.coffeemug.services.MugService;
import com.algosec.coffeemug.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.UUID;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension. class)
class Testing101_010_Mockito_03_InjectMocksTestWithSpringBoot {

    
    @InjectMocks
    private MugService mugService;
    
    @Mock
    private MugRepository mugRepository;

    @Mock
    private InventoryService inventoryService;
    @Mock
    private OrderService orderService;

    @Test
    public void injectMocksTest()
        throws Exception {

        Mug m = new Mug(UUID.randomUUID(), DrinkType.AMERICANO, new Date());
        Mockito.when(mugRepository.save(ArgumentMatchers.any())).thenReturn(m);

        Inventory inventory = new Inventory(UUID.randomUUID(), new Date(), 1f, 1f);
        Mockito.when(inventoryService.getInventory()).thenReturn(inventory);

        Mockito.doNothing().when(inventoryService)
        .reduceInventory(ArgumentMatchers.anyFloat(), ArgumentMatchers.anyFloat());
        
        mugService.getDrink(DrinkType.AMERICANO);
            
    }
	
}
