package com.example.demo.controller;

import com.example.demo.dto.UserResponseDto;
import com.example.demo.dto.UserSignUpDto;
import com.example.demo.dto.UserUpdateDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @Controller // MVC 패턴을 사용할 때 스프링한테 이게 컨트롤러 다. 일단 요청이 들어오면 이 컨트롤러에서 찾아봄
@RestController // 그냥 컨트롤러는 여러가지 이미지, url 등을 리턴해줄 수 있음. 레스트는 스프링에서 리턴을 RESTful 하게 json으로 리턴.
@RequestMapping("/api") // 도메인/api로 들어오는 모든 리퀘스트를 이 친구가 매핑해준다.

public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("/user")
//    public Long getUser(@RequestParam("idx") long user_idx){ //user의 정보를 조회하는 컨트롤러
//        // UserResponseDto userResponseDto = userService.getUserIdx(user_idx);
//        return user_idx;
//    }

//    @GetMapping("/user/{idx}")
//    public Long getUser(@PathVariable("idx") long user_idx){ //user의 정보를 조회하는 컨트롤러
//        UserResponseDto userResponseDto = userService.getUserIdx(user_idx);
//        return user_idx;
//    }

    // Create
    @PostMapping("/user")
    public ResponseEntity signup(@RequestBody UserSignUpDto userSignUpDto) {
        if (userService.signUp(userSignUpDto)) {
            return ResponseEntity.ok("회원가입 완료");
        } else return ResponseEntity.accepted().body("회원가입 실패");
    }

    // Read
    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestParam("userIDX") long user_idx){ //user의 정보를 조회하는 컨트롤러
        UserResponseDto userResponseDto = userService.getUserIdx(user_idx);
        if (userResponseDto != null) {
            return ResponseEntity.ok(userResponseDto);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/user/{idx}")
    public ResponseEntity deleteUser(@PathVariable("idx") long user_idx) {
        if (userService.deleteUser(user_idx)) {
            return ResponseEntity.ok("삭제 성공");
        } else return ResponseEntity.accepted().body("삭제 실패");
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestParam("userIDX") long user_idx, @RequestBody UserUpdateDto userUpdateDto ) {
        if (userService.UpdateUser(user_idx, userUpdateDto)) {
            return ResponseEntity.ok("변경 완료");
        } else return ResponseEntity.accepted().body("변경 실패");

    }


}

