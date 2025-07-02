package com.green.practicememoserver.model;

import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;


@Getter
@ToString
public class MemoGetReq {
    private String searchText;
    private Integer page;

//    public MemoGetReq(@BindParam("search_text") String searchText, Integer page) {
//        this.searchText = searchText;
//        this.page = page;
//    }

    @ConstructorProperties({"search_text", "page"})
    public MemoGetReq(String searchText, Integer page) {
        this.searchText = searchText;
        this.page = page;
    }
}
