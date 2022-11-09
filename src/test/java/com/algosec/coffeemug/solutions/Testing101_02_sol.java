package com.algosec.coffeemug.solutions;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.entities.Inventory;
import com.algosec.coffeemug.entities.Mug;
import com.algosec.coffeemug.repository.InventoryRepository;
import com.algosec.coffeemug.repository.MugRepository;
import com.algosec.coffeemug.services.InventoryService;
import com.algosec.coffeemug.services.MugService;
import com.algosec.coffeemug.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension. class)
class Testing101_02_sol {

    
    @InjectMocks
    private InventoryService inventoryService;
    
    @Mock
    private InventoryRepository inventoryRepository;

    private Inventory inventory;
    
    @BeforeEach
    void init() {
        inventory = new Inventory(UUID.randomUUID(), new Date(), 5.432f, 2.345f);
        Inventory inventory2 = new Inventory(UUID.randomUUID(), Date.from(LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault()).toInstant()), 6.432f, 1.345f);
        Inventory inventory3 = new Inventory(UUID.randomUUID(), Date.from(LocalDateTime.now().minusDays(2).atZone(ZoneId.systemDefault()).toInstant()), 7.432f, 8.345f);
        Mockito.when(inventoryRepository.findAll()).thenReturn(List.of(inventory, inventory2, inventory3));
    }
    @Test
    public void inventoryTest()
        throws Exception {

        Assertions.assertEquals(inventoryService.getInventory().getCoffeeInKilos(), inventory.getCoffeeInKilos());
        Assertions.assertEquals(inventoryService.getInventory().getMilkInLiters(), inventory.getMilkInLiters());
        
    }
	
}
