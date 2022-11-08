package com.algosec.coffeemug;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.entities.Mug;
import com.algosec.coffeemug.repository.MugRepository;
import com.algosec.coffeemug.services.MugService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension. class)
@TestPropertySource(
    locations = "classpath:application-test.properties")
class Testing101_Mockito_02_TheSpyAnnotation {
    
    @Spy
    private MugService mugService = new MugService(null, null, null);
    
    @Test
    public void spyTest()
        throws Exception {
        
        Mockito.doNothing().when(mugService).getDrink(DrinkType.FLAT_WHITE);
        mugService.getDrink(DrinkType.FLAT_WHITE);
        mugService.getDrinkType();
            
    }
}
