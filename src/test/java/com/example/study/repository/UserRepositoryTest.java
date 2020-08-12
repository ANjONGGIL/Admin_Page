package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void create(){
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser:" + newUser);
    }
    @Test
    @Transactional
    void read(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser->{
            selectUser.getOrderDetailList().stream().forEach(detail ->{
                Item item = detail.getItem();
                System.out.println(item);
            });
        });
    }
    @Test
    @Transactional
    void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }
    @Test
    @Transactional
    void delete(){
        Optional<User> user = userRepository.findById(2L);

        assertTrue(user.isPresent());

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        if (deleteUser.isPresent()){
            System.out.println("데이터 존재 :" +deleteUser.get());
        }else {
            System.out.println("데이터 삭제");
        }
    }

}