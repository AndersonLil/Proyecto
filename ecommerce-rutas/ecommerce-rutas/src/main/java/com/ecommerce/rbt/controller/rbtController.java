package com.ecommerce.rbt.controller;

import com.ecommerce.rbt.entity.rbtRequest;
import com.ecommerce.rbt.entity.rbtResponse;
import com.ecommerce.rbt.service.rbtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class rbtController {

    @Autowired
    private rbtService jwtService;

    @PostMapping({"/authenticate"})
    public rbtResponse createJwtToken(@RequestBody rbtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
