package com.algosec.coffeemug;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.entities.Mug;
import com.algosec.coffeemug.repository.MugRepository;
import com.algosec.coffeemug.services.MugService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@RunWith(SpringRunner.class)
@TestPropertySource(
    locations = "classpath:application-test.properties")
@DataJpaTest
class Testing101_IntegrationTests_02_BasicTestDataLayerWithSpringBoot {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MugRepository mugRepository;

    @Test
    public void givenOneCoffeeMug_whenDbHoldsOurMug()
        throws Exception {
        
        Mug mug = new Mug(null, DrinkType.AMERICANO, new Date());
        mugRepository.save(mug);

        Assertions.assertEquals((String)entityManager.getEntityManager()
        .createNativeQuery("select DRINK_TYPE from MUG limit 1;").getSingleResult()
        ,(DrinkType.AMERICANO.name()));

            
    }
	
}
