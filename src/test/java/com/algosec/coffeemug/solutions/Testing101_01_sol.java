package com.algosec.coffeemug.solutions;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.services.MugService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
class Testing101_01_sol {

    MugService mugService = new MugService(null, null, null);

    @BeforeAll
    static void beforeAll() {
        LocalTime now = LocalTime.now();
        Assumptions.assumeTrue(now.isAfter(LocalTime.of(9,0)));
        Assumptions.assumeTrue(now.isBefore(LocalTime.of(17,0)));
    }
    
    @TestFactory
    Stream<DynamicTest> reverseDynamicTestsFromStream() {
        List<DrinkType> types = Lists.newArrayList(mugService.getDrinkType());
        
        return types.stream()
            .map(type ->
                DynamicTest.dynamicTest("Test coffee and milk amount of : " + type.name(), () -> {
                    Assertions.assertTrue(type.getCoffeeInGrams() >= 0);
                    Assertions.assertTrue(type.getMilkInMilliliters() <= 200);
                })
            );
    }
	
}
