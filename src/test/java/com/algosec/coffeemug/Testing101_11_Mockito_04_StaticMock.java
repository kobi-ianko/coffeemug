package com.algosec.coffeemug;

import com.algosec.coffeemug.services.WeightAndVolumeUtils;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@TestPropertySource(
    locations = "classpath:application-test.properties")
class Testing101_11_Mockito_04_StaticMock {

    @Test
    public void mockStaticTest() {

        try (MockedStatic<WeightAndVolumeUtils> utilities = Mockito.mockStatic(WeightAndVolumeUtils.class)) {
            utilities.when(() -> WeightAndVolumeUtils.kiloIntoLbs(ArgumentMatchers.anyDouble())).thenReturn(1.123);

            Assertions.assertThat(WeightAndVolumeUtils.kiloIntoLbs(666) == 1.123);
        }
    }
}
