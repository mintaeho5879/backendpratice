package com.green.practicememoserver;

import com.green.practicememoserver.config.model.ResultResponse;
import com.green.practicememoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
//공통 URL
@RequestMapping("/api/memo")
public class MemoController {
    private final MemoService memoService;

    //Create
    @PostMapping
    public ResultResponse<Integer> postMemo(@RequestBody MemoPostReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        int result = memoService.save(req);
        return new ResultResponse<>("삽입 성공", result);
    }

    //Read
    @GetMapping
    public ResultResponse<List<MemoGetRes>> getMemo(@ModelAttribute MemoGetReq req) { //쿼리스트링으로 받겠다.
        log.info("req={}", req);
        List<MemoGetRes> result = memoService.findAll(req);
        String message = String.format("rows: %d", result.size());
        return new ResultResponse<>(message, result);
    }

    @GetMapping("/{id}")
    public ResultResponse<MemoGetOneRes> getMemo(@PathVariable int id) {
        log.info("id={}", id);
        MemoGetOneRes result = memoService.findById(id);
        return new ResultResponse<>("조회 성공", result);
    }


    //Update
    @PutMapping
    public ResultResponse<Integer> putMemo(@RequestBody MemoPutReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        int result = memoService.modify(req);
        return new ResultResponse<>("수정 성공", result);
    }

    //Delete
    @DeleteMapping
    public ResultResponse<Integer> deleteMemo(@RequestParam int id) {
        log.info("id={}", id);
        int result = memoService.deleteById(id);
        return new ResultResponse<>("삭제 성공", result);
    }
}
