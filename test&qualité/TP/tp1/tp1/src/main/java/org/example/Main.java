package org.example;

import static org.example.Currency.TND;
import static org.example.Currency.USD;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        ExchangeRate exchange=new ExchangeRate();
        Wallet wallet=new Wallet("wallet1",500.0,TND);
        wallet.addAmount(20.0,USD,exchange);
        wallet.getAmount(TND,exchange);
    }
}