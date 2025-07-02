package com.green.practicememoserver;

import com.green.practicememoserver.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    //insert, update, delete
    int save(MemoPostReq p);
    List<MemoGetRes> findAll(MemoGetReq p);
    MemoGetOneRes findById(int id);
    int modify(MemoPutReq p);
    int deleteById(int id);
}
