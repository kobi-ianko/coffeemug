package com.algosec.coffeemug;

import com.algosec.coffeemug.constants.DrinkType;
import com.algosec.coffeemug.entities.Mug;
import com.algosec.coffeemug.repository.MugRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RunWith(SpringRunner.class)
@TestPropertySource(
    locations = "classpath:application-test.properties")
@DataJpaTest
class Testing101_IntegrationTests_03_TestConfigurationWithSpringBoot {
    
    @Autowired
    @Qualifier("customMugRepository")
    private MugRepository mugRepository;

    @Test
    public void givenOneCoffeeMugWithConfiguration_whenCustomPrintIsPrinted()
        throws Exception {
        
        Mug mug = new Mug(null, DrinkType.AMERICANO, new Date());
        mugRepository.save(mug);
            
    }

    @TestConfiguration
    static class Configuration {
        @Bean("customMugRepository")
        public MugRepository customMugRepository() {
            return new MugRepository() {
                @Override
                public List<Mug> findAll() {
                    return null;
                }

                @Override
                public List<Mug> findAll(final Sort sort) {
                    return null;
                }

                @Override
                public List<Mug> findAllById(final Iterable<UUID> uuids) {
                    return null;
                }

                @Override
                public <S extends Mug> List<S> saveAll(final Iterable<S> entities) {
                    return null;
                }

                @Override
                public void flush() {

                }

                @Override
                public <S extends Mug> S saveAndFlush(final S entity) {
                    return null;
                }

                @Override
                public <S extends Mug> List<S> saveAllAndFlush(final Iterable<S> entities) {
                    return null;
                }

                @Override
                public void deleteAllInBatch(final Iterable<Mug> entities) {

                }

                @Override
                public void deleteAllByIdInBatch(final Iterable<UUID> uuids) {

                }

                @Override
                public void deleteAllInBatch() {

                }

                @Override
                public Mug getOne(final UUID uuid) {
                    return null;
                }

                @Override
                public Mug getById(final UUID uuid) {
                    return null;
                }

                @Override
                public <S extends Mug> List<S> findAll(final Example<S> example) {
                    return null;
                }

                @Override
                public <S extends Mug> List<S> findAll(final Example<S> example, final Sort sort) {
                    return null;
                }

                @Override
                public Page<Mug> findAll(final Pageable pageable) {
                    return null;
                }

                @Override
                public <S extends Mug> S save(final S entity) {
                    log.info("I\"m not the original MugRepository");
                    return null;
                }

                @Override
                public Optional<Mug> findById(final UUID uuid) {
                    return Optional.empty();
                }

                @Override
                public boolean existsById(final UUID uuid) {
                    return false;
                }

                @Override
                public long count() {
                    return 0;
                }

                @Override
                public void deleteById(final UUID uuid) {

                }

                @Override
                public void delete(final Mug entity) {

                }

                @Override
                public void deleteAllById(final Iterable<? extends UUID> uuids) {

                }

                @Override
                public void deleteAll(final Iterable<? extends Mug> entities) {

                }

                @Override
                public void deleteAll() {

                }

                @Override
                public <S extends Mug> Optional<S> findOne(final Example<S> example) {
                    return Optional.empty();
                }

                @Override
                public <S extends Mug> Page<S> findAll(final Example<S> example, final Pageable pageable) {
                    return null;
                }

                @Override
                public <S extends Mug> long count(final Example<S> example) {
                    return 0;
                }

                @Override
                public <S extends Mug> boolean exists(final Example<S> example) {
                    return false;
                }
                // implement methods
            };
        }
    }
}
