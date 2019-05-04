package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SightDetail {

    //최범균님 JPA 책 참고


    @Column(name = "hours_op")
    private String hoursOfOperation;
    private String holidays;
    private String facilities;

    public SightDetail() {
    }

    public SightDetail(String hoursOfOperation, String holidays, String facilities) {
        this.hoursOfOperation = hoursOfOperation;
        this.holidays = holidays;
        this.facilities = facilities;
    }

    public String getHoursOfOperation() {
        return hoursOfOperation;
    }

    public void setHoursOfOperation(String hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }

    public String getHolidays() {
        return holidays;
    }

    public void setHolidays(String holidays) {
        this.holidays = holidays;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
}
