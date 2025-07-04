package com.green.practicememoserver2;

import com.green.practicememoserver2.config.model.ResultResponse;
import com.green.practicememoserver2.model.MemoPostReq;
import com.green.practicememoserver2.model.MemoPutReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoMapper memoMapper;
    //c
    public int save(MemoPostReq req) { return memoMapper.save(req); }

    //r

    //u
    public int modify(MemoPutReq req) { return memoMapper.modify(req); }
    //d

}