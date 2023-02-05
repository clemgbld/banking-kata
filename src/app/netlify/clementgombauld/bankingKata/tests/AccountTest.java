package app.netlify.clementgombauld.bankingKata.tests;

import app.netlify.clementgombauld.bankingKata.adapter.dateProvider.InMemoryIDateProvider;
import app.netlify.clementgombauld.bankingKata.adapter.logger.InMemoryLogger;
import app.netlify.clementgombauld.bankingKata.core.dateProvider.IDateProvider;
import app.netlify.clementgombauld.bankingKata.core.logger.ILogger;
import app.netlify.clementgombauld.bankingKata.core.useCases.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;


class AccountTest {

    private Spy spy;

    @BeforeEach
    public void buildSpy(){
        this.spy = new Spy();
    }
    @Test
    public void shouldPrintNothingWhenNoDepositOrWithdrawalHasBeenDone(){
        DateBuilder dateBuilder = new DateBuilder(2006, Calendar.JANUARY, 27);
        Account account = buildAccount(spy,dateBuilder.build());
        account.printStatement();
        Assertions.assertEquals("Date         Amount        Balance",spy.getRecordedValue());
    }

    @Test
    public void shouldBeAbleToMakeOneDeposit(){
        DateBuilder dateBuilder = new DateBuilder(2006, Calendar.JANUARY, 27);
        Account account = buildAccount(spy,dateBuilder.build());
        account.deposit(45.00);
        account.printStatement();
        Assertions.assertEquals("Date         Amount        Balance\n27/01/2006     +45.0         45.0",spy.getRecordedValue());
    }

    @Test
    public void shouldBeAbleToMakeADepositWithGenericDate(){
        DateBuilder dateBuilder = new DateBuilder(2006, Calendar.JANUARY, 28);
        Account account = buildAccount(spy,dateBuilder.build());
        account.deposit(45.00);
        account.printStatement();
        Assertions.assertEquals("Date         Amount        Balance\n28/01/2006     +45.0         45.0",spy.getRecordedValue());
    }



    @Test
    public void shouldBeAbleToMakeADepositWithGenericDeposit(){
        DateBuilder dateBuilder = new DateBuilder(2006, Calendar.JANUARY, 28);
        Account account = buildAccount(spy,dateBuilder.build());
        account.deposit(155.0);
        account.printStatement();
        Assertions.assertEquals("Date         Amount        Balance\n28/01/2006     +155.0         155.0",spy.getRecordedValue());
    }

    @Test
    public void shouldBeAbleToMakeMultipleDeposits(){
        DateBuilder dateBuilder = new DateBuilder(2006, Calendar.JANUARY, 28);
        Account account = buildAccount(spy,dateBuilder.build());
        account.deposit(45.00);
        account.deposit(55.00);


        account.printStatement();
         Assertions.assertEquals("Date         Amount        Balance\n28/01/2006     +55.0         100.0\n28/01/2006     +45.0         45.0",spy.getRecordedValue());
    }

    @Test
    public void shouldBeAbleToWithDrawMoney(){
        DateBuilder dateBuilder = new DateBuilder(2006, Calendar.JANUARY, 28);
        Account account = buildAccount(spy,dateBuilder.build());
        account.deposit(45.00);
        account.withdraw(10.00);
        account.printStatement();
        Assertions.assertEquals("Date         Amount        Balance\n28/01/2006     -10.0         35.0\n28/01/2006     +45.0         45.0",spy.getRecordedValue());
    }


    private record DateBuilder(int year, int month, int day) {

        public Date build() {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);

                return calendar.getTime();
            }
        }

    private static Account buildAccount(Spy spy,Date date) {
        ILogger logger = new InMemoryLogger(spy);
        IDateProvider dateProvider = new InMemoryIDateProvider(date);
        return new Account(logger,dateProvider);
    }
}