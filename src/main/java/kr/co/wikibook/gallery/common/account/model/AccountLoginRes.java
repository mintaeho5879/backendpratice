package kr.co.wikibook.gallery.common.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountLoginRes {
    private int id;
    @JsonIgnore
    private String loginPw;
}
