import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class TestRenter
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        
        Renter[] renter = new Renter[30];
        RentalCompany rCompany = new RentalCompany();
        double incomeA = 0, incomeB = 0, incomeC = 0, incomeD = 0, incomeE = 0;
        String next;
        
        //////////////////////////////////START LOOP////////////////////////////////////////////////
        int i = 0;
        do
        {
            String licenseExp = null, bankName = null, bankID = null;
            char company, vType=' ', vModel=' ', rType=' ',aType=' ';
            double distance , price = 0.0;
            int duration = 0;
            
            System.out.println("\n Welcome to Vehicle and Accommodation Rental Service System\n");
            
            System.out.print(" Enter renter name : "); 
            String name = scan.next(); 
            
            System.out.print(" Enter Phone no    : ");
            String phone = scan.next();
            
            System.out.print(" Enter ic no       : ");
            String ic = scan.next();
            
            // diplay list of rental company 
            rCompany.displayCompanyList();
            
            System.out.print("\n Choose company to rent : ");
            company = scan.next().charAt(0);
            company = Character.toUpperCase(company);
        
            if(company=='A' || company=='B')
            {
                System.out.print(" Enter your license expiry date [dd/mm/yyyy] : ");
                licenseExp = scan.next();
            }
                  
            System.out.print("\n\n\n");
            
            if(company=='A')
            {
                rCompany = new RentalCompany("SwiftDrive","Johor","074136928");
                
                System.out.println("\n Thank You For Choosing Our Company " + rCompany.getCompanyName());
                System.out.println(" Here is what our company can provide : ");
                rCompany.displayOption();
                
                System.out.print("\n Please choose vehicle types    [C/S] : ");
                vType = scan.next().charAt(0);
                vType = Character.toUpperCase(vType);
                
                System.out.print(" Please choose vehicle category [S/P] : ");
                vModel = scan.next().charAt(0);
                vModel = Character.toUpperCase(vModel);
            }
            else if(company=='B')
            {
                rCompany = new RentalCompany("CarrierGo","Melaka","069546743");
                
                System.out.println("\n Thank You For Choosing Our Company " + rCompany.getCompanyName());
                System.out.println(" Here is what our company can provide : ");
                rCompany.displayOption();
                                
                System.out.print("\n Please choose vehicle types    [M/V] : ");
                vType = scan.next().charAt(0);
                vType = Character.toUpperCase(vType);
                
                if(vType == 'M')
                {
                    System.out.print(" Please choose vehicle category [S/P] : ");
                }
                else if(vType == 'V')
                {
                    System.out.print(" Please choose vehicle category [C/P] : ");
                }
                
                vModel = scan.next().charAt(0);
                vModel = Character.toUpperCase(vModel);
            }
            else if(company=='C')
            {
                rCompany = new RentalCompany("BigWheels","Perak","053245678");
                
                System.out.println("\n Thank You For Choosing Our Company " + rCompany.getCompanyName());
                System.out.println(" Here is what our company can provide : ");
                rCompany.displayOption();
                                
                System.out.print("\n Please enter your option [F/T] : ");
                vModel = scan.next().charAt(0);
                vModel = Character.toUpperCase(vModel);
                rType = 'D';
            }
            else if(company == 'D')
            {
                rCompany = new RentalCompany("RoomHive","Pahang","093658773");
                    
                System.out.println("\n Thank You For Choosing Our Company " + rCompany.getCompanyName());
                System.out.println(" Here is what our company can offer : ");
                rCompany.displayOption();
                
                System.out.print("\n Please choose accommodation types [A/B/C] : ");
                aType = scan.next().charAt(0);
                aType = Character.toUpperCase(aType);
                
                System.out.print(" Book for how many days    : ");
                duration = scan.nextInt();
            }
            else if(company == 'E')
            {
                rCompany = new RentalCompany("CozyStays","Selangor","036298834");
                    
                System.out.println("\n Thank You For Choosing Our Company " + rCompany.getCompanyName());
                System.out.println(" Here is what our company can offer : ");
                rCompany.displayOption();
                
                System.out.print("\n Please choose accommodation types [A/H] : ");
                aType = scan.next().charAt(0);
                aType = Character.toUpperCase(aType);
                
                System.out.print(" Book for how many days    : ");
                duration = scan.nextInt();
            }
            
            if(company=='A' || company=='B' || company=='C')
            {                
                if(company == 'A' || company == 'B')
                {
                    System.out.println("\n +----------------------+ ");
                    System.out.println(" |   [H] rent by hour   | ");
                    System.out.println(" |   [D] rent by day    | " );
                    System.out.println(" +----------------------+ ");
                    
                    System.out.print("\n Please choose rental type   : ");
                    rType = scan.next().charAt(0);
                    rType = Character.toUpperCase(rType);
                }
                
                if(rType == 'H')
                {
                        System.out.print(" Enter how many hour to rent : ");
                        duration = scan.nextInt();
                }
                else if(rType == 'D') 
                {
                        System.out.print(" Enter how many days to rent : ");
                        duration = scan.nextInt();
                }
            }
        
            //////////////////////////////  CREATING OBJECT  ////////////////////////////////////////////////
            
            if(company == 'A' || company == 'B' || company == 'C')
            {
                renter[i] = new Vehicle(name,phone,ic,rCompany,licenseExp,rType,vType,vModel,duration);
            }   
            else if(company == 'D' || company == 'E')
            {
                renter[i] = new Accommodation(name,phone,ic,rCompany,aType,duration);
            }
            
            //////////////////////////////  PAYMENT METHODE  ////////////////////////////////////////////
            
            System.out.print("\n\n\n");
            
            System.out.println(" Your total would be RM" + String.format("%.2f",renter[i].calcPrice()));
            System.out.println(" Please provide your bank details to continue the payment  \n");
            
            System.out.print(" Enter bank name : ");
            bankName = scan.next();
            renter[i].setBankName(bankName);
            
            System.out.print(" Enter bank id   : ");
            bankID = scan.next();
            renter[i].setBankID(bankID);
            
            // display receipt
            System.out.println("\n\n\n");
            System.out.println(renter[i].displayReceipt());
                        
            //////////////////////////////////////////////////////////////////////////////////////////////
            
            System.out.print("\n Press enter to continue or \"END\" to exit : ");
            next = scan.next();
            
            System.out.println(" ");
            System.out.println(" ");
            
            //////////////////////////////////////////////////////////////////////////////////////////////
            
            //calculate total income for each company  
            if(rCompany.getCompanyName().equals("SwiftDrive"))
            {
                incomeA += renter[i].calcPrice();
            }
            else if(rCompany.getCompanyName().equals("CarrierGo"))
            {
                incomeB += renter[i].calcPrice();
            }
            else if(rCompany.getCompanyName().equals("BigWheels"))
            {
                incomeC += renter[i].calcPrice();
            }
            else if(rCompany.getCompanyName().equals("RoomHive"))
            {
                incomeD += renter[i].calcPrice();
            }
            else if(rCompany.getCompanyName().equals("CozyStays"))
            {
                incomeE += renter[i].calcPrice();
            }
            
            i++;
        }
        while(!(next.equals("END")));
        
        ////////////////////////// DISPLAY RENTER LIST //////////////////////////////////
        
        System.out.println("\n\n\n\n");  
        
        
        System.out.println(" REPORT");
        System.out.println(" =============================================================");
        
        System.out.println(" RENTER IC NO\t\tRENTED MODEL\t\tTOTAL PAYMENT ");
        System.out.println(" ============================================================");
        for(int j=0; j<i; j++)
        {
            if(renter[j] instanceof Vehicle)
            {
                Vehicle temp = (Vehicle) renter[j];
                System.out.println(" " + renter[j].getRenterIcNo() + " \t\t" + temp.getVehicleName() + "\t\tRM" + String.format("%.2f",temp.calcPrice()));
            }
            else if(renter[j] instanceof Accommodation)
            {
                Accommodation temp = (Accommodation) renter[j];
                System.out.println(" " + renter[j].getRenterIcNo() + " \t\t" + temp.getAccommodationName() + "\t\tRM" + String.format("%.2f",temp.calcPrice()));
            }
        }System.out.println(" =============================================================");
        
        ////////////////////// CALCULATE AVERAGE, MAXIMUM VALUE, MINIMUM VALUE //////////////////////////////////
        
        System.out.println("\n\n"); 
        
        double average, totalPrice = 0, max = renter[0].calcPrice(), min = renter[0].calcPrice();
        for(int j=0; j<i; j++)
        {
            totalPrice += renter[j].calcPrice();
            if(renter[j].calcPrice() > max)
            {
                max = renter[j].calcPrice();
            }
            if(renter[j].calcPrice() < min)
            {
                min = renter[j].calcPrice();
            }
        }
        average = totalPrice/i;
        System.out.println(" Average renting charge : RM" + String.format("%.2f",average));
        System.out.println(" Highest renting charge : RM" + String.format("%.2f",max));
        System.out.println(" Lowest renting charge  : RM" + String.format("%.2f",min));     
        
        ///////////////////////// SORTING COMPANY INCOME FROM HIGHEST TO LOWEST ///////////////////////////////
        
        System.out.println("\n\n");  
        
        String[] companyIncome = new String[5];
        
        companyIncome[0] = " SwiftDrive : RM" + String.format("%.2f",incomeA);
        companyIncome[1] = " CarrierGo  : RM" + String.format("%.2f",incomeB);
        companyIncome[2] = " BigWheels  : RM" + String.format("%.2f",incomeC);
        companyIncome[3] = " RoomHive   : RM" + String.format("%.2f",incomeD);
        companyIncome[4] = " CozyStays  : RM" + String.format("%.2f",incomeE);
        
        String tempIncome;
        for(int a=0; a<companyIncome.length; a++)
        {
            for(int b=a+1; b<companyIncome.length; b++)
            {
                if(Double.parseDouble(companyIncome[b].substring(16)) > Double.parseDouble(companyIncome[a].substring(16)))
                {
                    tempIncome = companyIncome[a];
                    companyIncome[a] = companyIncome[b];
                    companyIncome[b] = tempIncome;
                }
            }
        }
        
        System.out.println(" TOTAL INCOME FOR EACH COMPANY \n");
        for(int a=0; a<companyIncome.length; a++)
        {
            System.out.println(companyIncome[a]);
        }
        
        ////////////////////////////////////// SEARCHING //////////////////////////////////////////
        
        System.out.println("\n\n"); 
        
        System.out.print("Search by renter ic number : ");
        String search = scan.next();
        
        boolean found = false;
        int index=0, iFound=0;
            
        try{
            while(!found && index<renter.length)
            {
                if(renter[index].getRenterIcNo().equalsIgnoreCase(search))
                {
                    iFound = index;
                    found = true;
                }
                index++;
            }
        }catch (Exception e){System.out.println("\nSearch not found !!");}
        
        if(found)
        {
            if(renter[iFound] instanceof Vehicle)
            {
                System.out.println("\nService Type : VEHICLE" + renter[iFound].toString());
            }
            else if(renter[iFound] instanceof Accommodation)
            {
                System.out.println("\nService Type : ACCOMMODATION" + renter[iFound].toString());
            }
            System.out.println("\nSearch found !!");
        }
    }
}