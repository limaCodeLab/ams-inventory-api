package com.skald.ats.inventory.api.service;

import com.skald.ats.inventory.api.dto.UserDTO;
import com.skald.ats.inventory.api.model.users.User;
import com.skald.ats.inventory.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository repository;

    final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    @Transactional
    public User saveUser(User user) {
        return repository.save(user);
    }


    public List<User> findaAllUser(){
        return repository.findAll();
    }

    public User insertUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        return saveUser(user);
    }

}
