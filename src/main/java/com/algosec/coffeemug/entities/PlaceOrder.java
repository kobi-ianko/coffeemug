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
@Table(name = "PLACE_ORDER")
public class PlaceOrder {

    @Id
    @GeneratedValue
    private UUID id;
    
    @Column
    private Date date;
    
    @Column
    private int coffeeInKilos;
    
    @Column
    private int MilkInLiters;
    
    @Column
    private float price; 
    
}
