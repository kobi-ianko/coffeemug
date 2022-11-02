package com.algosec.coffeemug;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class Testing101_05_TestsWithExceptions {

    @Test
    void shouldThrowException() {
        Throwable exception = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not supported");
        });
        Assertions.assertEquals("Not supported", exception.getMessage());
    }
	
}
