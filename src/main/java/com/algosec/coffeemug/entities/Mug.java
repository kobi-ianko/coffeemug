package com.algosec.coffeemug.entities;

import com.algosec.coffeemug.constants.DrinkType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "MUG")
@AllArgsConstructor
@NoArgsConstructor
public class Mug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column
    @Enumerated(EnumType.STRING)
    private DrinkType drinkType;
    
    @Column
    private Date date;
}
