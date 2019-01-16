package com.mree.app.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mree.app.core.common.model.UserInfo;
import com.mree.app.core.common.ref.UserStatus;
import com.mree.app.core.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringDemoApplication extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(SpringDemoApplication.class);
    @Autowired
    private IUserService userService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringDemoApplication.class);
    }

    public static void main(String[] args) {

        UserInfo i = new UserInfo();
        i.setName("System");
        i.setSurname("User");
        i.setPassword("system");
        i.setUsername("system");
        i.setStatus(UserStatus.ACTIVE);

        try {
            System.out.println(new ObjectMapper().writeValueAsString(i));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        SpringApplication.run(SpringDemoApplication.class, args);
    }

}
