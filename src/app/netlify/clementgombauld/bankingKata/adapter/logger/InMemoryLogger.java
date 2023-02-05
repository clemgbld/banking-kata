package app.netlify.clementgombauld.bankingKata.adapter.logger;

import  app.netlify.clementgombauld.bankingKata.core.logger.ILogger;
import  app.netlify.clementgombauld.bankingKata.tests.Spy;

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
