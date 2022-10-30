package com.algosec.coffeemug.repository;

import com.algosec.coffeemug.entities.Mug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MugRepository extends JpaRepository<Mug, UUID> {

}
