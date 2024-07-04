package com.Inventory.management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String image;
    private String company;
    private String country;
    private String email;
    private String phone;
    private String password;
    private String active;

}
