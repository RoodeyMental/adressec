package com.baeldung.keycloak;

import com.baeldung.keycloak.model.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class WebController {

    @Autowired
    private AddressRepository ar;

    @GetMapping("/address")
    public String address(Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        model.addAttribute("address", new Address());
        return "address";
    }

    @PostMapping("/address")
    public void save(@ModelAttribute Address address, Model model){
        System.out.println(address);
        ar.save(address);
    }


    @GetMapping(path = "/")
    public String index(Model model) {
        Iterable<Address> addresses = ar.findAll();
        model.addAttribute("adresses", addresses);
        return "index";
    }
}
