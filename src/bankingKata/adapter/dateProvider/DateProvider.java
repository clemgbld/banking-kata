package bankingKata.adapter.dateProvider;

import bankingKata.core.dateProvider.IDateProvider;

import java.util.Date;

public class DateProvider implements IDateProvider {
    public Date now(){
        return new Date();
    }
}
