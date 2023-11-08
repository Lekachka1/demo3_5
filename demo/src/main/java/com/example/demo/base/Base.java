package com.example.demo.base;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
public class Base {
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public Base(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void baseUsers() {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        roleService.save(adminRole);
        roleService.save(userRole);
        User admin = new User("Teff",29,"asdfg@Gmail.com","admin","user", Set.of(adminRole, userRole));
        userService.addUser(admin);
        User userUser = new User("Brown",43, "filp@mail.ru", "usert", "admin", Set.of(userRole));
        userService.addUser(userUser);

        User user = new User("Bear",37, "vbvbvbvb@mail.ru", "user", "admin", Set.of(userRole));
        userService.addUser(user);
    }
}
