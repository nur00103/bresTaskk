package com.example.brestaskk.service;

import com.example.brestaskk.dto.request.CustomerRequest;
import com.example.brestaskk.dto.response.CustomerResponse;
import com.example.brestaskk.dto.response.ResponseModel;
import com.example.brestaskk.entity.Customer;

import java.util.List;

public interface CustomerService {
    ResponseModel<List<CustomerResponse>> getAllCustomer();

    ResponseModel<CustomerResponse> getCustomerById(Long customerId);

    ResponseModel<CustomerResponse> addCustomer(CustomerRequest customerRequest);

    ResponseModel<CustomerResponse> updateCustomer(Long customerId, CustomerRequest customerRequest);

    ResponseModel<CustomerResponse> deleteCustomer(Long customerId);
    public CustomerResponse convertToResponse(Customer customer);
    public Customer requestToEntity(CustomerRequest customerRequest);

    public boolean checkCustomerData(Long customerId, CustomerRequest customerRequest);

    public boolean checkCustomerDataRequest(CustomerRequest customerRequest);
}
