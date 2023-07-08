package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.dto.UserSignUpDto;
import com.example.demo.dto.UserUpdateDto;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public UserResponseDto getUserIdx(Long idx) {
        try {
            Optional<User> user = userRepository.findUserByUserId(idx);
            if(user.isPresent()) {
                UserResponseDto userResponseDto = new UserResponseDto(user.get().getEmail(), user.get().getName());
                return userResponseDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean signUp(UserSignUpDto userSignUpDto) {
        try {
            //TODO: User 중복인지 검사 (생략)
            User user = new User(userSignUpDto.getEmail(), userSignUpDto.getName());
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteUser(long idx) {
        try {
            Optional<User> user = userRepository.findUserByUserId(idx);
            if(user.isPresent()) {
                userRepository.delete(user.get());
                return true;
            }
            else return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public boolean UpdateUser(long idx, UserUpdateDto userUpdateDto) {
        try {
            Optional<User> user = userRepository.findUserByUserId(idx);
            if (user.isPresent()) {
                user.get().setEmail(userUpdateDto.getEmail());
                user.get().setName(userUpdateDto.getName());
                userRepository.save(user.get());
                return true;
            } else return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
