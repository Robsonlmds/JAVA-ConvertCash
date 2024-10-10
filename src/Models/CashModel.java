package Models;

import java.util.Map;
import java.util.NoSuchElementException;

public class CashModel {

    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public CashModel(String result, String base_code, Map<String, Double> conversion_rates) {
        this.result = result;
        this.base_code = base_code;
        this.conversion_rates = conversion_rates;
    }

    public double findCoin(String moeda) {
        if (!conversion_rates.containsKey(moeda.toUpperCase())) {
            throw new NoSuchElementException("Uma das Moedas não encontradas.");
        }
        return conversion_rates.get(moeda.toUpperCase());
    }

    @Override
    public String toString() {
        return "Base: " + base_code + ", Result: " + result + ", Taxas: " + conversion_rates.toString();
    }

}