package app.netlify.clementgombauld.bankingKata.tests;

public class Spy {
    private String value;

    public  String getRecordedValue() {
        return value;
    }

    public void recordValue(String dateAmountBalance) {
        value = dateAmountBalance;
    }
}
