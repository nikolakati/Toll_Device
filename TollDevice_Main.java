package tolldevice_main;

import java.util.Scanner;

public class TollDevice_Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String deviceID;
        boolean flag;
        int vehicle;
        
        System.out.print("Enter your cards ID (8 digits): ");
        deviceID = input.nextLine();
            
        do
        {    
            System.out.println();
            
            flag = ValidID(deviceID);
            if(!flag)
            {
                System.out.println("Wrong ID! Your ID must have 8 digits.");
                System.out.print("Enter your cards ID (8 digits): ");
                deviceID = input.nextLine();
            }
        }while(!flag);
        
        TollDevice device = new TollDevice(deviceID);
        
        do
        {
            System.out.println();
            System.out.println("Chooce your vehicle you are driving:");
            System.out.println("1.Motorcycle");
            System.out.println("2.Car");
            System.out.println("3.Truck");
            System.out.print("Enter your vehicle (enter number 1-3): ");
            vehicle = input.nextInt();
        }while((vehicle < 1) || (vehicle > 3));
        
        System.out.println();
        
        double amount, extraamount;
        String response;
        
        while(true)
        {
            System.out.print("Enter an amount you want to deposit or 0 to exit: ");
            amount = input.nextDouble();
        
            while(amount < 0)
            {
                System.out.println();
                System.out.print("Deposit positive amount: ");
                amount = input.nextDouble();
            }
            
            if(amount == 0)
            {
                System.out.println();
                System.out.println("Thank you for our services, bye  bye!");
                break;
            }
            
            System.out.println();
            System.out.println("You deposit " + amount + " euro.");
            System.out.println();
            device.TopUpBalance(amount);
            
            if(device.PassToll(vehicle))
                System.out.println("Successful toll passing! New balance " + device.GetBalance() + " euro.");
            else
            {
                System.out.println("Unsuccessful toll passing! Remaining amount of money insufficient."); 
                System.out.print("Do you want to credit another amount? (Yes/No): ");
                input.nextLine();
                response = input.nextLine();
                System.out.println();
                
                if(response.equalsIgnoreCase("No"))
                {
                    System.out.println("Thank you for our services, bye  bye!");
                    break;
                }
            }
        }
    }
    
    public static boolean ValidID(String deviceID) //function for the id check 
    {
        String cleanID = deviceID.replaceAll("\\s", "");
        return cleanID.length() == 8;
    }
}