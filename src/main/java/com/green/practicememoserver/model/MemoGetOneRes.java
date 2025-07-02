package com.green.practicememoserver.model;

import lombok.Getter;

@Getter
public class MemoGetOneRes {

    private int id;
    private String title;
    private String content;
    private String createdAt;
}
