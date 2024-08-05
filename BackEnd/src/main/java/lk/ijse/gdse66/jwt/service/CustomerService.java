package lk.ijse.gdse66.jwt.service;

import lk.ijse.gdse66.jwt.dto.CustomerDTO;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
}