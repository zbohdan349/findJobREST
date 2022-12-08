package com.findJob.app.service;

import com.findJob.app.model.Account;
import com.findJob.app.repo.AccountRepo;
import com.findJob.app.security.AuthRequest;
import com.findJob.app.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    private AccountRepo accountRepo;

    public HashMap<String,String> login(@RequestBody AuthRequest request) {

        Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );
            Account account = (Account) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(account);
            HashMap<String,String> response = new HashMap<>();
            response.put("email", account.getEmail());
            response.put("accessToken",accessToken);
            response.put("role",account.getRole().name());

        return response;
    }

    public Account getCurrentAccount(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return accountRepo.findByEmail(((UserDetails)principal).getUsername()).get();
    }
}
