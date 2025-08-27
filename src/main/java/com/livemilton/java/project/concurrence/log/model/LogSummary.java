package com.livemilton.java.project.concurrence.log.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@ToString
public class LogSummary {

    private int totalEntries;
    private int errorCount;
    private Set<String> uniqueUsers;
    private double averageResponseTime;
    private Map<Integer, Long> errorCountsByCode;



}
