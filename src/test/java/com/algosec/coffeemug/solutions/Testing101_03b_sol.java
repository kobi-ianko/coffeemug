package com.algosec.coffeemug.solutions;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.entities.Mug;
import com.algosec.coffeemug.repository.MugRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@TestPropertySource(
    locations = "classpath:application-test.properties")
@DataJpaTest
class Testing101_03b_sol {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MugRepository mugRepository;

    @Test
    public void givenOneCoffeeMug_whenDbHoldsOurMug()
        throws Exception {

        List<Mug> mugs = new ArrayList<>();
        for(int i=0 ;i<10; i++) {
            Mug mug = new Mug(null, DrinkType.values()[(i % (DrinkType.values().length-1) )], new Date());
            mugs.add(mug);
        }
        mugRepository.saveAll(mugs);

        Assertions.assertEquals(entityManager.getEntityManager()
                .createNativeQuery("select count(*) from MUG;").getSingleResult()
            , BigInteger.valueOf(10));
    }

}
