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
public class Product {
     @Id
     @SequenceGenerator(
             name = "product_sequence",
             sequenceName = "product_sequence",
             allocationSize = 1
     )
     @GeneratedValue(
             strategy = GenerationType.SEQUENCE,
             generator = "product_sequence"
     )
     private Long id;
     private String image;
     private Integer quantity;
     private String price;
     private String name;
     private String code;
     private String delivery_time;
     private Date date;
     @ManyToOne(
             cascade ={
                     CascadeType.DETACH,
                     CascadeType.MERGE,
                     CascadeType.PERSIST,
                     CascadeType.REFRESH
             }
     )
     @JoinColumn(
             name = "supplier_id",
             referencedColumnName = "id"
     )
     private Supplier supplier_id;
     @ManyToOne(
             cascade ={
                     CascadeType.DETACH,
                     CascadeType.MERGE,
                     CascadeType.PERSIST,
                     CascadeType.REFRESH
             }
     )
     @JoinColumn(
             name = "wareHouse_id",
             referencedColumnName = "id"
     )
     private WareHouse wareHouse_id;
     @ManyToOne(
             cascade ={
                     CascadeType.DETACH,
                     CascadeType.MERGE,
                     CascadeType.PERSIST,
                     CascadeType.REFRESH
             }
     )
     @JoinColumn(
             name = "category_id",
             referencedColumnName = "id"
     )
     private Category category_id;
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
