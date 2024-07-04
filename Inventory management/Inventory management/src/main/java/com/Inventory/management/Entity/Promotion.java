package com.Inventory.management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    @Id
    @SequenceGenerator(
            name = "promotion_sequence",
            sequenceName = "promotion_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "promotion_sequence"
    )
    private Long id;
    @OneToOne(
            cascade ={
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id"
    )
    private Product productId;
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
