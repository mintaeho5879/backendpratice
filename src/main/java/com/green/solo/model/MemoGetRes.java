package com.green.solo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemoGetRes {
    private int id;
    private String title;
    private String content;
}
