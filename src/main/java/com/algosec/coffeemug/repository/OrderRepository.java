package com.algosec.coffeemug.repository;

import com.algosec.coffeemug.entities.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<PlaceOrder, UUID> {

    public Set<PlaceOrder> findByDateAfter(Date date);

}
