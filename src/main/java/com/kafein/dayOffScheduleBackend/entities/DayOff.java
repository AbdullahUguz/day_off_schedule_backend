package com.kafein.dayOffScheduleBackend.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "days_off")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class DayOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Value("${custom.dayOff.initialValue}")
    private Integer initialDayOff;

    @Value("${custom.dayOff.remainingDayOffValue}")
    private Float remainingDayOff;

    @OneToMany(mappedBy = "dayOff",cascade = CascadeType.ALL)
    private List<DayOffDetail> dayOffDetailList = new ArrayList<>();
}
