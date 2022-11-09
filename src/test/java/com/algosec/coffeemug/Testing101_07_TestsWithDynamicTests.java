package com.algosec.coffeemug;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.services.MugService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@Slf4j

class Testing101_07_TestsWithDynamicTests {

    MugService mugService = new MugService(null, null, null);

    @TestFactory
    Stream<DynamicTest> reverseDynamicTestsFromStream() {
        List<DrinkType> types = Lists.newArrayList(mugService.getDrinkType());
        List<String> names = List.of("ESPRESSO", "CAPUCCINO", "LATTE");
        List<Integer> amountOfCoffee = List.of(7, 14,14);
        return names.stream()
            .map(coffee ->
                DynamicTest.dynamicTest("Test coffee amount: " + coffee, () -> {
                    int coffeeAmount = amountOfCoffee.get(names.indexOf(coffee));
                    Assertions.assertEquals(types.stream().filter(type -> type.name().
                    equals(coffee)).findFirst().get().getCoffeeInGrams(), coffeeAmount);
                })
            );
    }
	
}
