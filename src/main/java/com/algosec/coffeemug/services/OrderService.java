package com.algosec.coffeemug.services;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.constants.Ingredients;
import com.algosec.coffeemug.entities.PlaceOrder;
import com.algosec.coffeemug.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryService inventoryService;
    
    public void placeOrder(Ingredients ingredients, int amount) {
        
        PlaceOrder placeOrder = new PlaceOrder();
        placeOrder.setDate(new Date());
        
        if(ingredients.equals(Ingredients.COFFE)) {
            placeOrder.setCoffeeInKilos(amount);
            placeOrder.setPrice(amount*ingredients.getPriceInUsdPerKiloOrLiter());
            inventoryService.addInventory(amount*1000, 0);
        }

        if(ingredients.equals(Ingredients.MILK)) {
            placeOrder.setMilkInLiters(amount);
            placeOrder.setPrice(amount*ingredients.getPriceInUsdPerKiloOrLiter());
            inventoryService.addInventory(0, amount*1000);
        }

        orderRepository.save(placeOrder);
        
    }
    
    public float getLastDaysExpense(int days) {
        LocalDate date = LocalDate.now().minusDays(days);
        Set<PlaceOrder> orders = orderRepository.findByDateAfter(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        
        return orders.stream().collect(Collectors.summingDouble(PlaceOrder::getPrice)).floatValue();
    }

}
