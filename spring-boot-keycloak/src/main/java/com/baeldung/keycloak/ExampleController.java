package com.baeldung.keycloak;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ExampleController {

    @GetMapping(path="test")
    public String testString(){
        return "it actually workedd22";
    }
}
