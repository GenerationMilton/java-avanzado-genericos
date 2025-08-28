package com.livemilton.java.project.concurrence.log.service;

import com.livemilton.java.project.concurrence.log.model.LogEntry;
import com.livemilton.java.project.concurrence.log.model.LogSummary;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@AllArgsConstructor
public class LogProcessorTask implements Callable<LogSummary> {

    private final List<LogEntry> logEntries;


    @Override
    public LogSummary call() throws Exception {

        int totalEntries = logEntries.size();

        //statusCode >= 400
        List<LogEntry> errorsLogs = logEntries.stream().filter( logEntry -> logEntry.getStatusCode() >= 400).toList();
        int errorCount = errorsLogs.size();

        Set<String> uniqueUsers = logEntries.stream()
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());

        /*
        double averageResponseTime = logEntries.stream()
                .map(LogEntry::getResponseTimeMs)
                .collect(Collectors.averagingInt(Integer::intValue));
        */

        double averageResponseTime = logEntries.stream()
                .mapToInt(LogEntry::getResponseTimeMs)
                .average()
                .orElse(0.0);

        Map<Integer, Long > errorCountsByCode = errorsLogs.stream()
                .collect(Collectors.groupingBy(
                        LogEntry::getStatusCode,
                        Collectors.counting()
                ));



        return new LogSummary(totalEntries, errorCount, uniqueUsers, averageResponseTime, errorCountsByCode);
    }


}
