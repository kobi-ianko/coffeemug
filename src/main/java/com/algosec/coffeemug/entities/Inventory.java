package com.algosec.coffeemug.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "INVENTORY")
public class Inventory {

    @Id
    @GeneratedValue
    private UUID id;
    
    @Column
    private Date date;
    
    @Column
    private float coffeeInKilos;
    
    @Column
    private float MilkInLiters;
    
}