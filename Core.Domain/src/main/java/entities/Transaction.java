package entities;

import enums.TransactionType;
import valueObjects.Money;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Date;

public class Transaction {
    private Integer id;
    private Money amount;
    private TransactionType transactionType;
    private String source;
    private String destination;
    private Money walletBalance;
    private Date transactionDateTime;
    @OneToMany
    @JoinColumn(name = "jmbgValue", nullable = false)
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
