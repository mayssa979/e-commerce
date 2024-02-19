package org.example;

import java.util.HashMap;
import java.util.Map;
public class ExchangeRate {
    private Map<String, Map<String, Double>> ratesMap;
    public ExchangeRate(Map<String, Map<String, Double>> ratesMap) {
        this.ratesMap = ratesMap;
        this.initExchangeRates();
    }
    public ExchangeRate() {
        this.ratesMap = new HashMap<>();
        this.initExchangeRates();
    }



    public void addExchangeRate(String baseCurrency, String
            targetCurrency, double exchangeRate) {

        ratesMap

                .computeIfAbsent(baseCurrency, k -> new

                        HashMap<>())

                .put(targetCurrency, exchangeRate);
    }
    public Double getExchangeRate(String baseCurrency, String
            targetCurrency) {
        return ratesMap

                .getOrDefault(baseCurrency, new HashMap<>())
                .get(targetCurrency);

    }

public void initExchangeRates(){
    this.addExchangeRate("USD", "EUR", 0.93);
    this.addExchangeRate("USD", "TND", 3.13);
    this.addExchangeRate("EUR", "USD", 1.07);
    this.addExchangeRate("EUR", "TND", 3.63);
    this.addExchangeRate("TND", "USD", 0.32);
    this.addExchangeRate("TND", "EUR", 0.30);
//printAllExchangeRates();
}
}
