package com.example.jpa;

import java.util.List;

import lombok.Data;

@Data
public class Filter {
    private String field;
    private QueryOperator operator;
    private String value;
    private List<String> values;//Used in case of IN operator
  }
  