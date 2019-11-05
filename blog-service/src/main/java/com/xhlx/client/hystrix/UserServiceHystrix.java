package com.xhlx.client.hystrix;

import com.xhlx.client.UserServiceClient;
import com.xhlx.dto.RespDTO;
import com.xhlx.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserServiceClient {

    @Override
    public RespDTO<User> getUser(String token, String username) {
        System.out.println(token);
        System.out.println(username);
        return null;
    }
}
