package com.blackbeast.booklibrary.services;

import com.blackbeast.booklibrary.domain.Role;
import com.blackbeast.booklibrary.domain.User;
import com.blackbeast.booklibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void createUser(String username, String password) {
        if (username != null && password != null) {
            User user = userRepository.getUser(username);

            if (user == null) {
                PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();

                User newUser = new User(username, pe.encode(password));
                userRepository.addUser(newUser);

            }
        }
    }
    public void addRoleToUser(String username, String roleName){
        if(username !=null && roleName != null){
            User user = userRepository.getUser(username);
            System.out.println(">>>>>>> "+ user.getRoles()==null);

            if(user!=null){
                Role role = new Role(roleName);
                userRepository.addRoleToUser(user, role);
            }
        }
    }
    public User getUser(String username){
        return userRepository.getUser(username);
    }

    public User getLoggedUser(){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        if(auth != null){
            String username = auth.getName();
            return getUser(username);
        }else
            return null;




            }

}
