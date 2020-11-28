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
    private CustomerDAO customerDAO;

    @Autowired
    private AddressRepository ar;

    @GetMapping("/address")
    public String address(Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        model.addAttribute("address", new Address());
        return "address";
    }

    @PostMapping("/address")
    public String save(@ModelAttribute Address address, Model model){
        System.out.println(address);
        ar.save(address);
        return "index";
    }


    @GetMapping(path = "/")
    public String index() {
        System.out.println(ar.findAll());
        return "index";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        addCustomers();
        Iterable<Customer> customers = customerDAO.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());
        return "customers";
    }

    // add customers for demonstration
    public void addCustomers() {

        Customer customer1 = new Customer();
        customer1.setAddress("1111 foo blvd");
        customer1.setName("Foo Industries");
        customer1.setServiceRendered("Important services");
        customerDAO.save(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("2222 bar street");
        customer2.setName("Bar LLP");
        customer2.setServiceRendered("Important services");
        customerDAO.save(customer2);

        Customer customer3 = new Customer();
        customer3.setAddress("33 main street");
        customer3.setName("Big LLC");
        customer3.setServiceRendered("Important services");
        customerDAO.save(customer3);
    }
}
