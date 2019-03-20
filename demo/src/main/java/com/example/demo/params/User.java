package com.example.demo.params;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String id;

    private String username;

    private String password;
    private String email;
    private Date lastPasswordResetDate;
    private List<String> roles;

}
