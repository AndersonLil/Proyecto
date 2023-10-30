package com.ecommerce.rbt.service;

import com.ecommerce.rbt.dao.RoleDao;
import com.ecommerce.rbt.dao.UserDao;
import com.ecommerce.rbt.entity.Role;
import com.ecommerce.rbt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("admin123"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setNumero_cell("123456789");
        adminUser.setEmail("admin@gmail.com");
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaNac = dateFormat.parse("01-01-2000");
            adminUser.setFecha_Nac(fechaNac);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);


        User user = new User();
        user.setUserName("jorge");
        user.setUserPassword(getEncodedPassword("user123"));
        user.setUserFirstName("Jorge");
        user.setUserLastName("Rodriguez");
        user.setNumero_cell("987654321");
        user.setEmail("user@gmail.com");
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaNac = dateFormat.parse("04-01-2004");
            user.setFecha_Nac(fechaNac);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        user.setNumero_cell(user.getNumero_cell());
        user.setEmail(user.getEmail());
        user.setFecha_Nac(user.getFecha_Nac());

        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
