package com.example.brestaskk.controller;

import com.example.brestaskk.dto.request.CustomerRequest;
import com.example.brestaskk.dto.response.CustomerResponse;
import com.example.brestaskk.dto.response.ResponseModel;
import com.example.brestaskk.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping()
    public ResponseModel<List<CustomerResponse>> getAllCustomer(){
        return customerService.getAllCustomer();
    }
    @GetMapping("/{customerId}")
    public ResponseModel<CustomerResponse> getCustomerById(@PathVariable @Valid Long customerId){
        return customerService.getCustomerById(customerId);
    }
    @PostMapping("add")
    public ResponseModel<CustomerResponse> addCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }
    @PutMapping("/{customerId}")
    public ResponseModel<CustomerResponse> updateCustomer(@PathVariable @Valid Long customerId
            ,@RequestBody @Valid CustomerRequest customerRequest){
        return customerService.updateCustomer(customerId,customerRequest);
    }
    @DeleteMapping("/{customerId}")
    public ResponseModel<CustomerResponse> deleteCustomer(@PathVariable @Valid Long customerId){
        return customerService.deleteCustomer(customerId);
    }
}
