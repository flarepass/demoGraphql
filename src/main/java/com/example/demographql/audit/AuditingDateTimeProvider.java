package com.example.demographql.audit;

import org.springframework.data.auditing.DateTimeProvider;

import java.util.Calendar;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
public class AuditingDateTimeProvider implements DateTimeProvider {

    @Override
    public Calendar getNow() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar;
    }
}