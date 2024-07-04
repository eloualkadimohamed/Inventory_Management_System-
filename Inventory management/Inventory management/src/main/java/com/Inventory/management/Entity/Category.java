package com.Inventory.management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private Long id;
    private String name;
    private String status;
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
