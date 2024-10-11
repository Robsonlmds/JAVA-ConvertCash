package Controllers;

import Models.CashModel;

public class CheckConvert {

    public CashModel consultationChange() {
        CheckExchange checkExchange = new CheckExchange();
        return checkExchange.searchFeesExchange();
    }
}