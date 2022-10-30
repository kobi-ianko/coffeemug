package com.algosec.coffeemug.controllers;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.constants.Ingredients;
import com.algosec.coffeemug.entities.Inventory;
import com.algosec.coffeemug.services.InventoryService;
import com.algosec.coffeemug.services.MugService;
import com.algosec.coffeemug.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CoffeeMugController {
    
    private final MugService mugService;
    private final OrderService orderService;
    private final InventoryService inventoryService;
    
    @GetMapping("drink")
    public void getDrink(@RequestParam DrinkType drinkType) {
        mugService.getDrink(drinkType);
    }

    @GetMapping("order")
    public void placeOrder(Ingredients ingredients, int amount) {
        orderService.placeOrder(ingredients, amount);
    }
    @GetMapping("expenses")
    public float getMonthlyExpenses() {
        return orderService.getLastDaysExpense(30);
    }

    @GetMapping("inventory")
    public Inventory getInventory() {
        return inventoryService.getInventory();
    }

}
