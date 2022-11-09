package com.algosec.coffeemug;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
class Testing101_04_TestsWithAssumptions {

    @Test
    void basicTestWithAssumptions() {
        Assumptions.assumeTrue(5 < 1);
        Assertions.assertEquals(5 + 1, 7);
     
        log.info("This is a basic test with assumptions.");
    }

    @Test
    void basicTest2WithAssumptions() {
        Assumptions.assumeTrue(5 > 1);
        Assertions.assertEquals(5 + 2, 7);

        log.info("This is a basic test2 with assumptions.");
    }
	
}
