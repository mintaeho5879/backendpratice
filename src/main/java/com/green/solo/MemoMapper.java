package com.green.solo;

import com.green.solo.model.MemoGetOneRes;
import com.green.solo.model.MemoGetRes;
import com.green.solo.model.MemoPostReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemoMapper {
    int save(MemoPostReq req);
    List<MemoGetRes> findAll();
    int modify(MemoPostReq req);
    int delete(int id);
    MemoGetOneRes findOne(int id);
}
