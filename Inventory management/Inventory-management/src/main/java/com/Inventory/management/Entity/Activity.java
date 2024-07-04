package com.Inventory.management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    private Long id;
    private Date date;
    private String description;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "admin_id",
            referencedColumnName = "id"
    )
    private Admin admin_id;
}
