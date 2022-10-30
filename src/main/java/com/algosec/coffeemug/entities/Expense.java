//package com.algosec.coffeemug.entities;
//
//import lombok.Data;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import java.util.Date;
//import java.util.UUID;
//
//@Data
//@Entity
//@Table(name = "EXPENSES")
//public class Expense {
//
//    @Id
//    @GeneratedValue
//    private UUID id;
//
//    @ManyToOne
//    private Mug mug;
//    
//    @Column
//    private Date date;
//    
//    @Column
//    private float priceInUsd;
//
//    public Expense() {
//    }
//}
