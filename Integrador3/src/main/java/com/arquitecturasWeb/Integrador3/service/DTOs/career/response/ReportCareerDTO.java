package com.arquitecturasWeb.Integrador3.service.DTOs.career.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReportCareerDTO {
    private final String career_name;
    private final BigDecimal count_enrolled;
    private final BigDecimal count_graduated;
    private final Long year;

    public ReportCareerDTO(String name, BigDecimal count_enrolled, BigDecimal count_graduated, Long year) {
        this.career_name = name;
        this.count_enrolled = count_enrolled;
        this.count_graduated = count_graduated;
        this.year = year;
    }
}
