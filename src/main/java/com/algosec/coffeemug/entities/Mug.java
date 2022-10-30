package com.algosec.coffeemug.entities;

import com.algosec.coffeemug.constants.DrinkType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "MUG")
public class Mug {

    @Id
    @GeneratedValue
    private UUID id;
    
    @Column
    @Enumerated(EnumType.STRING)
    private DrinkType drinkType;
    
    @Column
    private Date date;
}
