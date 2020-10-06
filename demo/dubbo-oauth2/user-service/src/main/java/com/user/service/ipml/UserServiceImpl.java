package com.user.service.ipml;

import com.user.service.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    public String sayHello() {
        return "hello";
    }
}
