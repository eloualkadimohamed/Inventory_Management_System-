package com.Inventory.management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    private Long id;
    private Date date;
    private String description;
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
