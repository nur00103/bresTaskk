package com.example.brestaskk.dto.response;

import com.example.brestaskk.entity.Account;
import com.example.brestaskk.enums.CardStatusEnum;
import com.example.brestaskk.enums.CurrencyEnum;

import java.math.BigDecimal;
import java.util.Date;

public class CardResponse {

    private Long id;
    private Long cardNumber;
    private BigDecimal balance;
    private CurrencyEnum currency;
    private CardStatusEnum status;
    private Date expireDate;
    private Integer active;
    private Date createDate;
    private Account account;

    public CardResponse() {
    }

    public CardResponse(Long id, Long cardNumber, BigDecimal balance, CurrencyEnum currency, CardStatusEnum status, Date expireDate, Integer active, Date createDate, Account account) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.currency = currency;
        this.status = status;
        this.expireDate = expireDate;
        this.active = active;
        this.createDate = createDate;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
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

    public CardStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CardStatusEnum status) {
        this.status = status;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "CardResponse{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", balance=" + balance +
                ", currency=" + currency +
                ", status=" + status +
                ", expireDate=" + expireDate +
                ", active=" + active +
                ", createDate=" + createDate +
                ", account=" + account +
                '}';
    }
}
