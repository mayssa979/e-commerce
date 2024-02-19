package org.example;

public class Wallet {
    private String walletRef;
    private double amount;

    public void setWalletRef(String walletRef) {
        this.walletRef = walletRef;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    private Currency currency;

    public Wallet(String walletRef, double amount, Currency currency) {
        this.walletRef = walletRef;
        this.amount = amount;
        this.currency = currency;
    }

    public String getWalletRef() {
        return walletRef;
    }
    public void addAmount(double amount, Currency currency, ExchangeRate exchangeRateMap) {

        if(this.currency==currency){
            this.amount+=amount;

        }else{
            double exchange =exchangeRateMap.getExchangeRate(currency.getDisplayName(),this.currency.getDisplayName());
            this.amount=this.amount+this.amount*exchange;
        }

    }
    public double getAmount(Currency targetCurrency,ExchangeRate exchangeRateMap) {
        if(this.currency.equals(targetCurrency)){
            return this.amount;
        }else{
            double exchange=exchangeRateMap.getExchangeRate(targetCurrency.getDisplayName(),this.currency.getDisplayName());
            this.amount=this.amount*exchange;
            return this.amount;
        }

    }

}
