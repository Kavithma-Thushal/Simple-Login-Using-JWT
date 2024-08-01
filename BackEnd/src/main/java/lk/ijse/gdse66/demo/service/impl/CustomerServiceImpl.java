package lk.ijse.gdse66.demo.service.impl;

import lk.ijse.gdse66.demo.dto.CustomerDTO;
import lk.ijse.gdse66.demo.entity.CustomerEntity;
import lk.ijse.gdse66.demo.repo.CustomerRepo;
import lk.ijse.gdse66.demo.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    CustomerRepo customerRepo;
    ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper mapper) {
        this.customerRepo = customerRepo;
        this.mapper = mapper;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setId(UUID.randomUUID().toString());
        return mapper.map(customerRepo.save(mapper.map(customerDTO, CustomerEntity.class)), CustomerDTO.class);
    }
}