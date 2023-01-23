package bankingKata.adapter.logger;

import  bankingKata.core.logger.ILogger;
import  bankingKata.tests.Spy;

public class InMemoryLogger implements ILogger {
    private final Spy spy;
    public InMemoryLogger(Spy spy) {
        this.spy = spy;
    }

    @Override
    public void log(String dateAmountBalance) {
       spy.recordValue(dateAmountBalance);
    }
}
