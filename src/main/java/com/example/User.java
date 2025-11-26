package com.example;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class User {
    private String name;
    private int age;
    private Gender gender;
    private double weight;
    private double height;
    @Singular
    private List<String> occupations;
}