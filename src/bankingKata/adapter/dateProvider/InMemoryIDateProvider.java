package bankingKata.adapter.dateProvider;

import bankingKata.core.dateProvider.IDateProvider;

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
