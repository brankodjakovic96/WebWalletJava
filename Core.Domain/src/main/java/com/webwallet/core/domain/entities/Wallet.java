package com.webwallet.core.domain.entities;

import com.webwallet.core.domain.valueObjects.Jmbg;
import com.webwallet.core.domain.valueObjects.Money;
import com.webwallet.core.domain.enums.BankType;
import com.webwallet.core.domain.valueObjects.converters.JmbgAttributeConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    private String jmbgValue;
    @Convert(converter = JmbgAttributeConverter.class)
    private Jmbg jmbg;
    private String firstName;
    private String lastName;
    private String bankAccount;
    private String PIN;
    private BankType bankType;
    @Embedded
    private Money balance;

    @OneToMany(mappedBy = "wallet")
    private List<Transaction> transactions;
    private Date walletCreatedDateTime;
    private Date lastTransactionDateTime;
    private Date lastTransferDateTime;
    @Embedded
    private Money usedDepositThisMonth;
    @Embedded
    private Money usedWithdrawThisMonth;
    private Boolean isBlocked;
    private String _password;

    public Wallet() {
        this.transactions = new ArrayList<>();
    }

    public Wallet(Jmbg jmbg, String firstName, String lastName, String bankAccount, String PIN, BankType bankType, String _password, String currency) {
        this.jmbgValue = jmbg.toString();
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankAccount = bankAccount;
        this.PIN = PIN;
        this.bankType = bankType;
        this._password = _password;
        this.transactions = new ArrayList<>();
        this.walletCreatedDateTime = new Date();
        this.balance = currency.isEmpty() || currency == null ? new Money(BigDecimal.ZERO, "RSD") : new Money(BigDecimal.ZERO, currency);
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public BankType getBankType() {
        return bankType;
    }

    public Boolean checkPassword(String password){
        return _password.equals(password);
    }

    public Jmbg getJmbg() {
        return jmbg;
    }

    public String getPIN() {
        return PIN;
    }

    public Money getBalance() {
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
