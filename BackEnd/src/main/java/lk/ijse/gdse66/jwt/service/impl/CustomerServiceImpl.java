package lk.ijse.gdse66.jwt.service.impl;

import lk.ijse.gdse66.jwt.dto.CustomerDTO;
import lk.ijse.gdse66.jwt.entity.CustomerEntity;
import lk.ijse.gdse66.jwt.repo.CustomerRepo;
import lk.ijse.gdse66.jwt.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setId(UUID.randomUUID().toString());
        return modelMapper.map(customerRepo.save(modelMapper.map(customerDTO, CustomerEntity.class)), CustomerDTO.class);
    }
}