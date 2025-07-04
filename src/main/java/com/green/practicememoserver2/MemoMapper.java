package com.green.practicememoserver2;

import com.green.practicememoserver2.model.MemoPostReq;
import com.green.practicememoserver2.model.MemoPutReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemoMapper {

    //c
    int save(MemoPostReq req);
    //r
    int modify(MemoPutReq req);
    //u

    //d

}