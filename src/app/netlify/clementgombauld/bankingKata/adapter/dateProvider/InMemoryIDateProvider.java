package app.netlify.clementgombauld.bankingKata.adapter.dateProvider;

import app.netlify.clementgombauld.bankingKata.core.dateProvider.IDateProvider;

import java.util.Date;

public class InMemoryIDateProvider implements IDateProvider {
    private Date date;
    public InMemoryIDateProvider(Date date) {
        this.date = date;
    }

    public Date now(){
        return date;
    }
}
