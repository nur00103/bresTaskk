package com.example.brestaskk.dto.request;

import com.example.brestaskk.enums.CurrencyEnum;

import java.math.BigDecimal;

public class CardRequest {

    private Long cardNumber;
    private BigDecimal balance;
    private CurrencyEnum currency;
    private Long accountId;

    public CardRequest() {
    }

    public CardRequest(Long cardNumber, BigDecimal balance, CurrencyEnum currency, Long accountId) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.currency = currency;
        this.accountId = accountId;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "CardRequest{" +
                "cardNumber=" + cardNumber +
                ", balance=" + balance +
                ", currency=" + currency +
                ", accountId=" + accountId +
                '}';
    }
}
