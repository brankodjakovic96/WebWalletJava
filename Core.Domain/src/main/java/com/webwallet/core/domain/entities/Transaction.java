package com.webwallet.core.domain.entities;

import com.webwallet.core.domain.enums.TransactionType;
import com.webwallet.core.domain.valueObjects.Money;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    private Integer id;
    @Embedded
    private Money amount;
    private TransactionType transactionType;
    private String source;
    private String destination;
    @Embedded
    private Money walletBalance;
    private Date transactionDateTime;
    @ManyToOne
    @JsonIgnore
    private Wallet wallet;


    public Transaction() {
    }

    public Transaction(Money amount, TransactionType transactionType, String source, String destination, Money walletBalance, Wallet wallet) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.source = source;
        this.destination = destination;
        this.walletBalance = walletBalance;
        this.wallet = wallet;
        this.transactionDateTime = new Date();
    }
}
