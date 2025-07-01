package com.green.solo;

import com.green.solo.model.MemoGetOneRes;
import com.green.solo.model.MemoGetRes;
import com.green.solo.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoMapper memoMapper;

    public int save(MemoPostReq req){
        return memoMapper.save(req);
    }
    public int modify(MemoPostReq req){
        return memoMapper.modify(req);
    }
    public int delete(int id){
        return memoMapper.delete(id);
    }
    public List<MemoGetRes> findAll() {
        return memoMapper.findAll();
    }
    public MemoGetOneRes findOne(int id){
        return memoMapper.findOne(id);
    }
}
