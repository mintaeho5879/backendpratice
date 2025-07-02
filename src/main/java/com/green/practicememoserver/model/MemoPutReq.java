package com.green.practicememoserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class MemoPutReq {
    private int id;
    private String title;
    private String content;
}
