package com.example.brestaskk.dto.request;

import com.example.brestaskk.enums.CustomerTypeEnum;

public class CustomerRequest {

    private String name;
    private String surname;
    private String fatherName;
    private String fin;
    private String voen;
    private Integer age;
    private String address;
    private CustomerTypeEnum customerType;

    public CustomerRequest() {
    }

    public CustomerRequest(String name, String surname, String fatherName, String fin, String voen, Integer age, String address, CustomerTypeEnum customerType) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.fin = fin;
        this.voen = voen;
        this.age = age;
        this.address = address;
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getVoen() {
        return voen;
    }

    public void setVoen(String voen) {
        this.voen = voen;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerTypeEnum getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypeEnum customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", fin='" + fin + '\'' +
                ", voen='" + voen + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", customerType=" + customerType +
                '}';
    }
}
