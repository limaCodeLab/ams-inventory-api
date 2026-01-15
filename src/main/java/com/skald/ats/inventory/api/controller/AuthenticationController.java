package com.skald.ats.inventory.api.controller;

import com.skald.ats.inventory.api.dto.UserDTO;
import com.skald.ats.inventory.api.model.users.User;
import com.skald.ats.inventory.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticacao", description = "Gerenciamento de autenticacao de usuarios")
public class AuthenticationController {

    private final UserService service;

    @Autowired
    public AuthenticationController(UserService service) {
        this.service = service;
    }


    @GetMapping
    @Operation(summary = "Retorna todos os usuarios cadastrados")
    public ResponseEntity<List<User>> findAllUsers(){
       List<User> userList = service.findaAllUser();
       return ResponseEntity.ok().body(userList);
    }

    @Operation(summary = "Cadastra um novo usuario")
    @PostMapping( headers = "Content-Type=application/json")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO userDTO) {
        User item = service.insertUser(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(item);
    }

}
