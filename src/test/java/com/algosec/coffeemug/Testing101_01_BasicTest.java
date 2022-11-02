package com.algosec.coffeemug;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class Testing101_01_BasicTest {

	@Test
	void basicTest() {
        log.info("This is a basic test.");
	}

}
