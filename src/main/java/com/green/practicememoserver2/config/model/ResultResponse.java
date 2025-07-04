package com.green.practicememoserver2.config.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ResultResponse<T> {
    private String resultMessage;
    private T resultData;
}
