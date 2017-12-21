import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ying2ra on 7/6/17.
 */
public class AccountTest {
    // balance of a newly created account is the amount provided to the constructor.
    @org.junit.Test
    public void testInit() throws Exception
    {

    }

    // supplying a negative number to deposit and withdraw doesn't change the account's balance.
    @org.junit.Test
    public void testInvalidArgs() throws Exception {
        Account a = new Account(5);
        a.deposit(-5);
        assertEquals(a.getBalance(), 5);
        a.withdraw(-10);
        assertEquals(a.getBalance(),5);
    }

    // attempt to withdraw more money than the account contains doesn't change the account's balance.
    @Test
    public void testOverdraft() throws Exception {
        Account a = new Account(100);
        a.withdraw(101);
        assertEquals(a.getBalance(),100);
    }

    // account balance reflects the result of a legal call to deposit.
    @Test
    public void testDeposit() throws Exception {
        Account a = new Account(100);
        a.deposit(50);
        assertEquals(a.getBalance(), 100+50);
    }

    // account balance reflects the result of a legal call to withdraw.
    @Test
    public void merge() throws Exception {
        Account a = new Account(100);
        a.withdraw(50);
        assertEquals(a.getBalance(), 100-50);
    }

}