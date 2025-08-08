package com.livemilton.java.task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Task {

    private String id;
    private String title;
    private String description;
    private Boolean completed;

}
