package com.kafein.dayOffScheduleBackend.dto;

import com.kafein.dayOffScheduleBackend.entities.DayOffDetail;
import lombok.Data;

@Data
public class DayOffDetailRequestDto {
    private DayOffDetail dayOffDetail;
    private Integer dayOffId;
}
