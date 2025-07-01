package com.green.solo;

import com.green.solo.config.model.ResultResponse;
import com.green.solo.model.MemoGetOneRes;
import com.green.solo.model.MemoGetRes;
import com.green.solo.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/memo")
public class MemoController {
    private final MemoService memoService;
    private final MemoMapper memoMapper;
    //C
        @PostMapping
        public ResultResponse<Integer> postMemo(@RequestBody MemoPostReq req){
            int result = memoService.save(req);
            String result2 = (result == 1) ? "등록성공" : "등록실패";

            return new ResultResponse<>(result2, result);
        }
    //R
        @GetMapping
        public ResultResponse<List<MemoGetRes>> getMemo(){
            List<MemoGetRes> result = memoService.findAll();
            return new ResultResponse<>("조회성공",result);
        }

    //R 하나씩
        @GetMapping("/{id}")
        public ResultResponse<MemoGetOneRes> getMemo(@PathVariable int id){
            MemoGetOneRes result = memoService.findOne(id);
            return new ResultResponse<>("조회성공", result);
        }
    //U
        @PutMapping
        public ResultResponse<Integer> putMemo(@RequestBody MemoPostReq req){
            int result = memoService.modify(req);
            String result2 = (result == 1) ? "수정성공" : "수정실패";
            return new ResultResponse<>(result2, result);
        }
    //D
        @DeleteMapping
        public ResultResponse<Integer> deleteMemo(@RequestParam int id){
            int result = memoService.delete(id);
            String result2 = (result == 1) ? "삭제성공" : "삭제실패";
            return new ResultResponse<>(result2, result);
        }
}
