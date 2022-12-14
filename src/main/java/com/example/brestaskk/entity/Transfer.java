package com.example.brestaskk.entity;

import com.example.brestaskk.enums.CurrencyEnum;
import com.example.brestaskk.enums.TransferStatusEnum;
import com.example.brestaskk.enums.TransferTypeEnum;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transfer")
public class Transfer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "debitor_card_id")
    private Long debitorCardID;

    @Column(name = "creditor_card_id")
    private Long creditorCardID;

    @Column(name = "debitor_account_id")
    private Long debitorAccountID;

    @Column(name = "creditor_account_id")
    private Long creditorAccountID;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "debitor_currency",length = 3)
    @Enumerated(EnumType.STRING)
    private CurrencyEnum debitorCurrency;

    @Column(name = "creditor_currency",length = 3)
    @Enumerated(EnumType.STRING)
    private CurrencyEnum creditorCurrency;

    @Column(name = "transfer_type")
    @Enumerated(EnumType.ORDINAL)
    private TransferTypeEnum transferType;


    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private TransferStatusEnum status;


    @Column(name = "active")
    private Integer active=1;

    @Column(name = "create_date")
    private Date createDate= java.sql.Date.valueOf(LocalDate.now());

    public Transfer() {
    }

    public Transfer(Long id, Long debitorCardID, Long creditorCardID, Long debitorAccountID, Long creditorAccountID, BigDecimal amount, CurrencyEnum debitorCurrency, CurrencyEnum creditorCurrency, TransferTypeEnum transferType, TransferStatusEnum status, Integer active, Date createDate) {
        this.id = id;
        this.debitorCardID = debitorCardID;
        this.creditorCardID = creditorCardID;
        this.debitorAccountID = debitorAccountID;
        this.creditorAccountID = creditorAccountID;
        this.debitorCurrency = debitorCurrency;
        this.amount = amount;
        this.creditorCurrency = creditorCurrency;
        this.transferType = transferType;
        this.status = status;
        this.active = active;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDebitorCardID() {
        return debitorCardID;
    }

    public void setDebitorCardID(Long debitorCardID) {
        this.debitorCardID = debitorCardID;
    }

    public Long getCreditorCardID() {
        return creditorCardID;
    }

    public void setCreditorCardID(Long creditorCardID) {
        this.creditorCardID = creditorCardID;
    }

    public Long getDebitorAccountID() {
        return debitorAccountID;
    }

    public void setDebitorAccountID(Long debitorAccountID) {
        this.debitorAccountID = debitorAccountID;
    }

    public Long getCreditorAccountID() {
        return creditorAccountID;
    }

    public void setCreditorAccountID(Long creditorAccountID) {
        this.creditorAccountID = creditorAccountID;
    }

    public CurrencyEnum getDebitorCurrency() {
        return debitorCurrency;
    }

    public void setDebitorCurrency(CurrencyEnum debitorCurrency) {
        this.debitorCurrency = debitorCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Transfer setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public CurrencyEnum getCreditorCurrency() {
        return creditorCurrency;
    }

    public void setCreditorCurrency(CurrencyEnum creditorCurrency) {
        this.creditorCurrency = creditorCurrency;
    }

    public TransferTypeEnum getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferTypeEnum transferType) {
        this.transferType = transferType;
    }

    public TransferStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransferStatusEnum status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", debitorCardID=" + debitorCardID +
                ", creditorCardID=" + creditorCardID +
                ", debitorAccountID=" + debitorAccountID +
                ", creditorAccountID=" + creditorAccountID +
                ", debitorCurrency=" + debitorCurrency +
                ", amoun=" + amount +
                ", creditorCurrency=" + creditorCurrency +
                ", transferType=" + transferType +
                ", status=" + status +
                ", active=" + active +
                ", createDate=" + createDate +
                '}';
    }
}
