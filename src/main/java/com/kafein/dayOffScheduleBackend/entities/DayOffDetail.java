package com.kafein.dayOffScheduleBackend.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kafein.dayOffScheduleBackend.config.dateConfig.CustomLocalDateTimeDeserializer;
import com.kafein.dayOffScheduleBackend.config.dateConfig.CustomLocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "day_off_details")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class DayOffDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime startDate;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime endDate;

    private String explanation;

    private Float usedDayOff;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "day_off_id")
    private DayOff dayOff;
}
