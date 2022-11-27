package com.example.brestaskk.entity;

import com.example.brestaskk.enums.CardStatusEnum;
import com.example.brestaskk.enums.CurrencyEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "card_number",unique = true)
    private Long cardNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "currency",length = 3)
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;


    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private CardStatusEnum status=CardStatusEnum.ACTIVE;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "active")
    private Integer active = 1;

    @Column(name = "create_date")
    private Date createDate= java.sql.Date.valueOf(LocalDate.now());

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

    public Card() {
    }

    public Card(Long id, Long cardNumber, BigDecimal balance, CurrencyEnum currency, CardStatusEnum status, Date expireDate, Integer active, Date createDate, Account account) {
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
        return "Card{" +
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
