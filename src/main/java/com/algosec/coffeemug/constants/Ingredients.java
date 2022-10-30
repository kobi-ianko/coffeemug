package com.algosec.coffeemug.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Ingredients {

    COFFE(20),
    MILK(5);
    
    private int priceInUsdPerKiloOrLiter;
    
    
}
