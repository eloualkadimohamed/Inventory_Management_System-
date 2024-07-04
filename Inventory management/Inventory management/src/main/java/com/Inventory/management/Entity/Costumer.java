package com.Inventory.management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Costumer {
    @Id
    @SequenceGenerator(
            name = "costumer_sequence",
            sequenceName = "costumer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "costumer_sequence"
    )
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Boolean loyalty;
    @ManyToOne(
            cascade ={
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(
            name = "admin_id",
            referencedColumnName = "id"
    )
    private Admin admin_id;

}
