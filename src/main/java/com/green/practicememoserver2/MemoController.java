package com.green.practicememoserver2;

import com.green.practicememoserver2.config.model.ResultResponse;
import com.green.practicememoserver2.model.MemoPostReq;
import com.green.practicememoserver2.model.MemoPutReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/memo")
public class MemoController {
    private final MemoService memoService;

    //c
    @PostMapping
    public ResultResponse<Integer> postMemo(@RequestBody MemoPostReq req) {
        int result = memoService.save(req);
        return new ResultResponse<>("등록 성공", result);
    }
    //r

    //u
    @PutMapping
    public ResultResponse<Integer> putMemo(@RequestBody MemoPutReq req) {
        int result = memoService.modify(req);
        return new ResultResponse<>("수정 성공", result);
    }
    //d
}