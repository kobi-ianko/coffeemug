package com.algosec.coffeemug;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class Testing101_03_TestsWithAssertions {

	@Test
	void basicTestWithAssert() {
        Assertions.assertTrue(5 == 5);
        log.info("This is a basic test with assertion.");
	}

    @Test
    void basicTestWithGroupAssert() {
            int[] numbers = {0, 1, 2, 3, 4};
            Assertions.assertAll("numbers",
                () -> Assertions.assertEquals(numbers[0], 0),
                () -> Assertions.assertEquals(numbers[3], 3),
                () -> Assertions.assertEquals(numbers[4], 4)
            );
     
        log.info("This is a basic test with assertion.");
    }
	
}
