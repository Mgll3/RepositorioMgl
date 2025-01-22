package com.webShop.back.services;


import com.webShop.back.modelo.DTO.*;
import com.webShop.back.modelo.Entidad.*;
import com.webShop.back.persistencia.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SecurityService securityService;

    @Transactional
    public User createUser(RegisterDTO dtoRegistrer) {
        User user = new User();
        user.setEmail(dtoRegistrer.getEmail());
        user.setPassword(securityService.passwordEncoder(dtoRegistrer.getPassword()));
        user.setName(dtoRegistrer.getName());
        user.setLastname(dtoRegistrer.getLastname());
        user.setAddress(dtoRegistrer.getAddress());

        // Asignar el tipo de usuario 1 en base de datos osea "USER"
        user.setUserType(new UserType(1L));

        // Guardar el usuario en la base de datos
        return userRepository.save(user);

    }

    @Transactional
    public Boolean existsEmail(String email) {

        return userRepository.existsByUseremail(email);
    }

    @Transactional
    public AthAnswerDTO authenticate(LoginDTO LoginDTO) {
        String token = securityService.authenticate(LoginDTO);
        User user = userRepository.searchEmail(LoginDTO.getEmail());
        return new AthAnswerDTO(token, user.getName(), user.getLastname(), user.getUserType().getType());
    }

    @Transactional
    public AthAnswerDTO getUserSession(HttpServletRequest request) {
        String email = securityService.getEmail(request);
        
        User user = userRepository.searchEmail(email);
        AthAnswerDTO answer = new AthAnswerDTO(user.getName(), user.getLastname(), user.getUserType().getType());
        return answer;
    }

}
