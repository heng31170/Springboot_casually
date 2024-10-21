package com.zaizi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    Integer id;
    String username;
    String password;
    String name;
    Short gender;
    String image;
    Short job;
    LocalDate entrydate;
    Integer deptId;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
