package com.example.web.entity;

import com.example.web.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "user_table")
public class UserEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true) // unique 제약조건 추가
    private String userEmail;

    @Column
    private String userPassword;

    @Column
    private String userName;

    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserPassword(userDTO.getUserPassword());
        userEntity.setUserName(userDTO.getUserName());
        return userEntity;
    }

    public static UserEntity toUpdateUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserPassword(userDTO.getUserPassword());
        userEntity.setUserName(userDTO.getUserName());
        return userEntity;
    }

}
