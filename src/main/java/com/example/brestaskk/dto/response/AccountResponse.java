package com.example.brestaskk.dto.response;

import com.example.brestaskk.entity.Card;
import com.example.brestaskk.entity.Customer;
import com.example.brestaskk.enums.AccountStatusEnum;
import com.example.brestaskk.enums.CurrencyEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AccountResponse {
    private Long id;
    private String iban;
    private String accountNumber;
    private BigDecimal balance;
    private CurrencyEnum currency;
    private AccountStatusEnum status;
    private Date createDate;
    private Integer active;
    private Long customerId;
    private List<Card> cardList;

    public AccountResponse() {
    }

    public AccountResponse(Long id, String iban, String accountNumber, BigDecimal balance, CurrencyEnum currency, AccountStatusEnum status, Date createDate, Integer active, Long customerId) {
        this.id = id;
        this.iban = iban;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.status = status;
        this.createDate = createDate;
        this.active = active;
        this.customerId =customerId;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public AccountStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AccountStatusEnum status) {
        this.status = status;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "AccountResponse{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                ", status=" + status +
                ", createDate=" + createDate +
                ", active=" + active +
                ", customerId=" + customerId +
                '}';
    }
}
