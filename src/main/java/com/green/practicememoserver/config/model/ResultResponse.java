package com.green.practicememoserver.config.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResultResponse<T> { // 타입이 들어올때 결정이 된다.
    private String resultMessage;
    private T resultData;
}
