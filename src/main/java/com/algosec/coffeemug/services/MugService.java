package com.algosec.coffeemug.services;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.constants.Ingredients;
import com.algosec.coffeemug.entities.Inventory;
import com.algosec.coffeemug.entities.Mug;
import com.algosec.coffeemug.repository.MugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class MugService {

    private final MugRepository mugRepository;
    private final InventoryService inventoryService;
    private final OrderService orderService;
    
    @Transactional
    public void getDrink(DrinkType drinkType) {

        if(drinkType == null) return;
        Inventory inventory = inventoryService.getInventory();
        if(inventory.getCoffeeInKilos() <1) {
            //place order
            orderService.placeOrder(Ingredients.COFFE, 1);
            
        }
        if(inventory.getMilkInLiters() <1) {
            //place order
            orderService.placeOrder(Ingredients.MILK, 1);
        }
        
        Mug m = new Mug();
        m.setDrinkType(drinkType);
        m.setDate(new Date());
        mugRepository.save(m);
        
        inventoryService.reduceInventory(drinkType.getCoffeeInGrams(), drinkType.getMilkInMilliliters());
    }

}
