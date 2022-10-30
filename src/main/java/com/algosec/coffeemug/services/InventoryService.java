package com.algosec.coffeemug.services;

import com.algosec.coffeemug.entities.Inventory;
import com.algosec.coffeemug.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    
    public Inventory getInventory() {
        return inventoryRepository.findAll().stream().sorted(new Comparator<Inventory>() {
            @Override
            public int compare(final Inventory o1, final Inventory o2) {
                if(o1.getDate().getTime() >= o2.getDate().getTime()) return -1;
                else return 1;
            }
        }).findFirst().orElse(new Inventory());
    }
    
    public void reduceInventory(float coffeeInGrams, float milkInMillis) {
        Inventory inventory = getInventory();
        
        Inventory newInventory = new Inventory();
        newInventory.setDate(new Date());
        newInventory.setCoffeeInKilos(inventory.getCoffeeInKilos() - (coffeeInGrams/1000));
        newInventory.setMilkInLiters(inventory.getMilkInLiters() - (milkInMillis/1000));
        inventoryRepository.save(newInventory);
        
    }

    public void addInventory(float coffeeInGrams, float milkInMillis) {
        Inventory inventory = getInventory();

        Inventory newInventory = new Inventory();
        newInventory.setDate(new Date());
        newInventory.setCoffeeInKilos(inventory.getCoffeeInKilos() + (coffeeInGrams/1000));
        newInventory.setMilkInLiters(inventory.getMilkInLiters() + (milkInMillis/1000));
        inventoryRepository.save(newInventory);

    }

}
