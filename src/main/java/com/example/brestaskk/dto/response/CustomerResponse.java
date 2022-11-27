package com.example.brestaskk.dto.response;

import com.example.brestaskk.entity.Account;
import com.example.brestaskk.enums.CustomerTypeEnum;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CustomerResponse {
    private Long id;
    private String name;
    private String surname;
    private String fatherName;
    private String fin;
    private String voen;
    private Integer age;
    private String address;
    private Date createDate;
    private Integer active;
    private CustomerTypeEnum customerType;
    private List<Account> account;

    public CustomerResponse() {
    }

    public CustomerResponse(Long id, String name, String surname, String fatherName, String fin, String voen, Integer age, String address, Date createDate, Integer active, CustomerTypeEnum customerType, List<Account> account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.fin = fin;
        this.voen = voen;
        this.age = age;
        this.address = address;
        this.createDate = createDate;
        this.active = active;
        this.customerType = customerType;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccounts(List<Account> account) {
        this.account = account;
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
        return "CustomerResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", fin='" + fin + '\'' +
                ", voen='" + voen + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                ", active=" + active +
                ", customerType=" + customerType +
                ", account=" + account +
                '}';
    }
}
