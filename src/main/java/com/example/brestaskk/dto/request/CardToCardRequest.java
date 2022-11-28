package com.example.brestaskk.dto.request;

import com.example.brestaskk.enums.CurrencyEnum;

import java.math.BigDecimal;

public class CardToCardRequest {
    private Long creditorCardID;
    private Long debitorCardID;

    private CurrencyEnum debitorCurrency;
    private BigDecimal amount;

    public CardToCardRequest() {
    }

    public CardToCardRequest(Long creditorCardID, Long debitorCardID, BigDecimal amount) {
        this.creditorCardID = creditorCardID;
        this.debitorCardID = debitorCardID;
        this.amount = amount;
    }

    public Long getCreditorCardID() {
        return creditorCardID;
    }

    public void setCreditorCardID(Long creditorCardID) {
        this.creditorCardID = creditorCardID;
    }

    public Long getDebitorCardID() {
        return debitorCardID;
    }

    public void setDebitorCardID(Long debitorCardID) {
        this.debitorCardID = debitorCardID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CardToCardRequest{" +
                "creditorCardID=" + creditorCardID +
                ", debitorCardID=" + debitorCardID +
                ", amount=" + amount +
                '}';
    }
}
