package com.kafein.dayOffScheduleBackend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    private int dayOff=20;

    private int remainingDayOff;

}
