package com.mree.todo.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.mree.todo.core.service.IUserService;

@SpringBootApplication
public class SpringDemoApplication extends SpringBootServletInitializer {// implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringDemoApplication.class);
    @Autowired
    private IUserService userService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringDemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    // @Override
    // public void run(String... params) throws Exception {
    // UserInfo admin = new UserInfo();
    // admin.setName("System");
    // admin.setSurname("Admin");
    // admin.setUsername("admin");
    // admin.setPassword("admin");
    //
    // userService.create(admin);
    // }
}
