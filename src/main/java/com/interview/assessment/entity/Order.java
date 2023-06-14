package com.interview.assessment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    public int id;
    @Column(name = "EMAIL_ID")
    public String email;
    @Column(name = "CONTACT")
    public String phone_number;
    @Column(name = "COUNTRY")
    public String country;
    @Column(name = "WEIGHT")
    public String parcelWeight;
}
