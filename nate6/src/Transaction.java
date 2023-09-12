import java.util.Date;

/**
 * Created by Nathan on 3/25/14.
 */
public class Transaction
{
    String bankName;
    int accountNumber;
    double amount;
    boolean authorized;

    public Transaction(String bankIn, int accountIn, double amountIn, boolean authorizedIn)
    {
        bankName = bankIn;
        accountNumber = accountIn;
        amount = amountIn;
        authorized = authorizedIn;
    }
}
