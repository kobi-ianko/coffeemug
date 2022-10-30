package com.algosec.coffeemug.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DrinkType {

    ESPRESSO(7, 0),
    CAPUCCINO(14, 60),
    AMERICANO(14, 0),
    DOPPIO(14, 0),
    MACCHIATO(14, 5),
    LONGO(21, 0),
    FLAT_WHAITE(14, 120),
    LATTE(14, 150);
    
    private int coffeeInGrams;
    private int milkInMilliliters;

}
