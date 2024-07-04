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
public class Vacation {
    @Id
    @SequenceGenerator(
            name = "vacation_sequence",
            sequenceName = "vacation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vacation_sequence"
    )
    private Long id;
    private Date start_date;
    private Date end_date;
    private String status;
    private String reason;
    @OneToOne(
            cascade ={
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id"
    )
    private Employee employeeId;
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
