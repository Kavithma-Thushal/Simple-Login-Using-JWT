package lk.ijse.gdse66.jwt.controller;

import lk.ijse.gdse66.jwt.dto.CustomerDTO;
import lk.ijse.gdse66.jwt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
@CrossOrigin
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
    }
}