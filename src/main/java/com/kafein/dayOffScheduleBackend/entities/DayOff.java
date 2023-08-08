package com.kafein.dayOffScheduleBackend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "days_off")
public class DayOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer dayOff;

    private Float remainingDayOff;

    private String explanation;

    @OneToOne(mappedBy = "dayOff")
    private Employee employee;
}
