package com.fantasy.sangoUser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String Account;
    private String Password;
    private String _id;
    private String Nickname;
}
