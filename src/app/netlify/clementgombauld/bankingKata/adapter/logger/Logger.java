package app.netlify.clementgombauld.bankingKata.adapter.logger;

import app.netlify.clementgombauld.bankingKata.core.logger.ILogger;

public class Logger implements ILogger {
    public void log(String dateAmountBalance){
        System.out.println(dateAmountBalance);
    }
}
