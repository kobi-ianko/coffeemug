package com.algosec.coffeemug;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@SpringBootTest
class Testing101_06_TestsWithDynamicTests {

    @TestFactory
    Stream<DynamicTest> reverseDynamicTestsFromStream() {
        List<String> in = List.of("I", "have", "a", "dream");
        List<String> out = List.of("I", "evah", "a", "maerd");
        return in.stream()
            .map(word ->
                DynamicTest.dynamicTest("Test reverse " + word, () -> {
                    int id = in.indexOf(word);
                    Assertions.assertEquals(out.get(id), new StringBuilder(word).reverse().toString());
                })
            );
    }
	
}
