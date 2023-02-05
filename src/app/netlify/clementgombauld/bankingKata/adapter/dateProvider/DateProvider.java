package app.netlify.clementgombauld.bankingKata.adapter.dateProvider;

import app.netlify.clementgombauld.bankingKata.core.dateProvider.IDateProvider;

import java.util.Date;

public class DateProvider implements IDateProvider {
    public Date now(){
        return new Date();
    }
}
