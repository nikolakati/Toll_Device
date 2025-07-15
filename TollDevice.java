package tolldevice_main;

public class TollDevice 
{
    private String deviceID;
    private double balance;
    
    public TollDevice(String deviceID)
    {
        this.deviceID = deviceID;
        this.balance = 0.0;
    }
    
    public void TopUpBalance(double amount) 
    {
        balance += amount;
    }
    
    public boolean PassToll(int vehicle) 
    {
        switch(vehicle)
        {
            case 1 -> 
            {
                if(balance >= 1.80)
                {
                    balance -= 1.80;
                    return true;
                }
                else
                    return false;
            }
            case 2 ->             
            {
                if(balance >= 2.40)
                {
                    balance -= 2.40;
                    return true;
                }
                else
                    return false;
            }
            default -> 
            {
                if(balance >= 5.50)
                {
                    balance -= 5.50;
                    return true;
                }
                else
                    return false;
            }
        }
    }
    
    public double GetBalance()
    {
        return balance;
    }
}