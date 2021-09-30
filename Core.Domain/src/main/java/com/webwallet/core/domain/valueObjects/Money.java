package com.webwallet.core.domain.valueObjects;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Money {
    @Column(name = "amount", insertable = false, updatable = false)
    private BigDecimal amount; // <2>
    @Column(name = "currency", insertable = false, updatable = false)
    private String currency;

    public Money() {

    }

    public Money(@NotNull BigDecimal amount, @NotNull
            String  currency) { // <4>
        this.amount = validate(amount);
        this.currency = validate(currency);
    }



    public @NotNull BigDecimal getAmount() { // <6>
        return amount;
    }

    public @NotNull String getCurrency() {
        return currency;
    }


    @Override
    public boolean equals(Object o) { // <7>
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money that = (Money) o;
        return amount.equals(that.amount)
                && currency.equals(that.currency);
    }

    @Override
    public int hashCode() { // <8>
        return Objects.hash(amount, currency);
    }

    public static @NotNull String validate(@NotNull String currency) {
        if (!isValid(currency)) {
            throw new IllegalArgumentException("Invalid currency: " + currency);
        }
        return Objects.requireNonNull(currency, "Currency cannot be null");
    }

    public static @NotNull BigDecimal validate(@NotNull BigDecimal amount) {
        if (!isValid(amount)) {
            throw new IllegalArgumentException("Invalid amount: " + amount);
        }
        return Objects.requireNonNull(amount, "Amount cannot be null");
    }

    public static boolean isValid(@NotNull String currency) {
        return currency.length() == 3;
    }


    public static boolean isValid(@NotNull BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) >= 0;
    }


}
