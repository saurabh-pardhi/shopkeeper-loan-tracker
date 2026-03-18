package com.loantracker.loantracker.service;

import com.loantracker.loantracker.dto.LoginRequest;
import com.loantracker.loantracker.dto.RegisterRequest;
import com.loantracker.loantracker.entity.Shopkeeper;
import com.loantracker.loantracker.exception.*;
import com.loantracker.loantracker.repository.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private ShopkeeperRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        if (repo.findByMobile(request.getMobile()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        Shopkeeper user = new Shopkeeper();
        user.setName(request.getName());
        user.setShopName(request.getShopName());
        user.setMobile(request.getMobile());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        user.setLocation(request.getLocation());

        repo.save(user);

        return "Registered successfully";
    }

    public String login(LoginRequest request) {

        Shopkeeper user = repo.findByMobile(request.getMobile())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }

        return "Login successful";
    }
}