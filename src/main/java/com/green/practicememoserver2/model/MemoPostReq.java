package com.green.practicememoserver2.model;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemoPostReq {
    private String title;
    private String content;

}
