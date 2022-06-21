package com.tasks.coursemanagment.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginn")
//TODO: for jwt authorization
//TODO :  not used
public class LoginController {

    /*@PostMapping
    public ResponseEntity login(@RequestBody LoginRequest login){

        boolean valid = service.existsByUserNameAndPassword(login.getUserName90,login.getPassword())
        if(valid )
            return jwt;
        throw RunTimeException("InValid username/password");
    }*/
}
