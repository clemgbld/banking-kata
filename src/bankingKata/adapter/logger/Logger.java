package bankingKata.adapter.logger;

import bankingKata.core.logger.ILogger;

public class Logger implements ILogger {
    public void log(String dateAmountBalance){
        System.out.println(dateAmountBalance);
    }
}
