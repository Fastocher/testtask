package com.example.demo.JWTConfig.service;


import com.example.demo.JWTConfig.impl.CustomUserDetails;
import com.example.demo.user.impl.entity.UserEntity;
import com.example.demo.user.impl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByFullname(username);
        System.out.println(userEntity);
        if (userEntity == null ) {
            throw new UsernameNotFoundException("Пользователь с именем "+ username +" не найден ");
        }
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }


}
