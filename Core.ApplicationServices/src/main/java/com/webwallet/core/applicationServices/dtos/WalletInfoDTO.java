package com.webwallet.core.applicationServices.dtos;

import com.webwallet.core.domain.enums.BankType;

import java.math.BigDecimal;
import java.util.List;

public class WalletInfoDTO {
    private String jmbg;
    private String firstName;
    private String lastName;
    private String bankAccount;
    private BankType bankType;
    private BigDecimal balanceAmount;
    private String balanceCurrency;

    private BigDecimal usedDepositThisMonthAmount;
    private String usedDepositThisMonthCurrency;
    private BigDecimal maximalDepositAmount;
    private String maximalDepositCurrency;

    private BigDecimal usedWithdrawThisMonthAmount;
    private String usedWithdrawThisMonthCurrency;
    private BigDecimal maximalWithdrawAmount;
    private String maximalWithdrawCurrency;

    private Boolean isBlocked;
    private List<TransactionDTO> transactionDTOS;

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getBalanceCurrency() {
        return balanceCurrency;
    }

    public void setBalanceCurrency(String balanceCurrency) {
        this.balanceCurrency = balanceCurrency;
    }

    public BigDecimal getUsedDepositThisMonthAmount() {
        return usedDepositThisMonthAmount;
    }

    public void setUsedDepositThisMonthAmount(BigDecimal usedDepositThisMonthAmount) {
        this.usedDepositThisMonthAmount = usedDepositThisMonthAmount;
    }

    public String getUsedDepositThisMonthCurrency() {
        return usedDepositThisMonthCurrency;
    }

    public void setUsedDepositThisMonthCurrency(String usedDepositThisMonthCurrency) {
        this.usedDepositThisMonthCurrency = usedDepositThisMonthCurrency;
    }

    public BigDecimal getMaximalDepositAmount() {
        return maximalDepositAmount;
    }

    public void setMaximalDepositAmount(BigDecimal maximalDepositAmount) {
        this.maximalDepositAmount = maximalDepositAmount;
    }

    public String getMaximalDepositCurrency() {
        return maximalDepositCurrency;
    }

    public void setMaximalDepositCurrency(String maximalDepositCurrency) {
        this.maximalDepositCurrency = maximalDepositCurrency;
    }

    public BigDecimal getUsedWithdrawThisMonthAmount() {
        return usedWithdrawThisMonthAmount;
    }

    public void setUsedWithdrawThisMonthAmount(BigDecimal usedWithdrawThisMonthAmount) {
        this.usedWithdrawThisMonthAmount = usedWithdrawThisMonthAmount;
    }

    public String getUsedWithdrawThisMonthCurrency() {
        return usedWithdrawThisMonthCurrency;
    }

    public void setUsedWithdrawThisMonthCurrency(String usedWithdrawThisMonthCurrency) {
        this.usedWithdrawThisMonthCurrency = usedWithdrawThisMonthCurrency;
    }

    public BigDecimal getMaximalWithdrawAmount() {
        return maximalWithdrawAmount;
    }

    public void setMaximalWithdrawAmount(BigDecimal maximalWithdrawAmount) {
        this.maximalWithdrawAmount = maximalWithdrawAmount;
    }

    public String getMaximalWithdrawCurrency() {
        return maximalWithdrawCurrency;
    }

    public void setMaximalWithdrawCurrency(String maximalWithdrawCurrency) {
        this.maximalWithdrawCurrency = maximalWithdrawCurrency;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public List<TransactionDTO> getTransactionDTOS() {
        return transactionDTOS;
    }

    public void setTransactionDTOS(List<TransactionDTO> transactionDTOS) {
        this.transactionDTOS = transactionDTOS;
    }
}
