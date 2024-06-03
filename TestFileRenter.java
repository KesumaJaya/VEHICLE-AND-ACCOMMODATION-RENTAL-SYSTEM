import java.io.*; //To use classes in io package
import java.util.*; //To use classes in util package

public class TestFileRenter
{
    public static void main(String[] args) throws IOException
    {
        try{
        //Create array of object
        Renter[] renter = new Renter[30];
        //Initialization
        double incomeA = 0, incomeB = 0, incomeC = 0, incomeD = 0, incomeE = 0;
        //Read contents from renter.txt
        File file = new File("renter.txt");
        Scanner scanfile = new Scanner(file);
        //Create a new file named receiptList and report.txt to store outputs
        PrintWriter list = new PrintWriter("receiptList.txt");
        PrintWriter report = new PrintWriter("report.txt");
               
        //Start loop
        int i = 0;
        while( scanfile.hasNext() )
        {
            //Initialization (Reset the value for each different renter)
            String licenseExp = null, bankName = null, bankID = null;
            char company, vehicleType=' ', vehicleModel=' ', rentalType=' ',accoType=' ';
            double distance, price = 0.0;
            int duration = 0;
            //create object of class RentalCompany to call display method (line 42)
            //if create outside loop, logic error occured on IO file
            RentalCompany rCompany = new RentalCompany();
            //Read input from file and store it in indata variable
            String indata = scanfile.nextLine();
            //Break a string into tokens based on a ";" delimiter
            StringTokenizer st = new StringTokenizer(indata,";");
            //Read tokenized input from file
            String name = st.nextToken(); 
            String phone = st.nextToken();
            String ic = st.nextToken();
            //rCompany.displayCompanyList();    // Display company list table
            company = st.nextToken().charAt(0);// Renter choose company to rent from
            
            if(company == 'A')
            {
                rCompany.setRentalCompany("SwiftDrive","Johor","074136928"); //Create object of class RentalCompany based on selection
                licenseExp = st.nextToken(); //License exipiration date is required for car and van rental
                //rCompany.displayOption();  //Display option table
                vehicleType = st.nextToken().charAt(0);
                vehicleModel = st.nextToken().charAt(0);
                rentalType = st.nextToken().charAt(0);//Car and van rental have the option between rental by hours or days
                duration = Integer.parseInt(st.nextToken());
            }
            else if(company == 'B')
            {
                rCompany.setRentalCompany("CarrierGo","Melaka","069546743"); //Create object of class RentalCompany based on selection
                licenseExp = st.nextToken(); //License exipiration date is required for car and van rental
                //rCompany.displayOption();  //Display option table
                vehicleType = st.nextToken().charAt(0);
                vehicleModel = st.nextToken().charAt(0);
                rentalType = st.nextToken().charAt(0);//Car and van rental have the option between rental by hours or days
                duration = Integer.parseInt(st.nextToken());
            }
            else if(company == 'C')
            {
                rCompany.setRentalCompany("BigWheels","Perak","053245678"); //Create object of class RentalCompany based on selection
                //rCompany.displayOption();  //Display option table
                vehicleModel = st.nextToken().charAt(0);
                rentalType = 'D'; //Lorry rental only have rental by days only
                duration = Integer.parseInt(st.nextToken());
            }
            else if(company == 'D')
            {
                rCompany.setRentalCompany("RoomHive","Pahang","093658773"); //Create object of class RentalCompany based on selection
                //rCompany.displayOption();  //Display option table
                accoType = st.nextToken().charAt(0);
                duration = Integer.parseInt(st.nextToken());
            }
            else if(company == 'E')
            {
                rCompany.setRentalCompany("CozyStays","Selangor","036298834"); //Create object of class RentalCompany based on selection
                //rCompany.displayOption();  //Display option table
                accoType = st.nextToken().charAt(0);
                duration = Integer.parseInt(st.nextToken());
            }
            
            //Object creation
            if(company == 'A' || company == 'B' || company == 'C')
            {
                renter[i] = new Vehicle(name,phone,ic,rCompany,licenseExp,rentalType,vehicleType,vehicleModel,duration);
            }   
            else if(company == 'D' || company == 'E')
            {
                renter[i] = new Accommodation(name,phone,ic,rCompany,accoType,duration);
            }
            
            //System.out.println(" Your total would be RM" + renter[i].calcPrice());
            //System.out.println(" Please provide your bank details to continue the payment);
            bankName = st.nextToken();
            renter[i].setBankName(bankName);
            bankID = st.nextToken();
            renter[i].setBankID(bankID);
            //renter[i].displayReceipt();    // display renter receipt for successful payment
            i++;
        }
        scanfile.close(); //Stop reading input and close the file
        
        //Searching rental type by entering IC number and display personal information if IC number is found.
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");      
        System.out.print("Search by renter ic number : ");
        String search = scan.next();
        
        boolean found = false;
        int iFound = 0;
        i = 0; 
        while(!found && i < renter.length)
        {
            if(renter[i].getRenterIcNo().equalsIgnoreCase(search))
            {
                iFound = i;
                found = true;
            }
            i++;
        }
        
        if(found)
        {
            if(renter[iFound] instanceof Vehicle) //Test whether renter[iFound] object is an instance of class Vehicle
            {
                System.out.println("\nService Type : VEHICLE" + renter[iFound].toString());
            }
            else if(renter[iFound] instanceof Accommodation) //Test whether renter[iFound] object is an instance of class Accommodation
            {
                System.out.println("\nService Type : ACCOMMODATION" + renter[iFound].toString());
            }
            //Type casting is not implemented because no method from subclass is being used
            System.out.println("\nSearch found !!");
        }
        else
        {
            System.out.println("\nSearch not found !!");
        }
        System.out.println("\n\n");  
        
        //Update renter phone number if necessary
        if(found)
        {
            System.out.print("Change " + renter[iFound].getRenterName() + " phone number [YES / NO] : "); 
            String update = scan.next();
            if(update.equalsIgnoreCase("YES"))
            {
                System.out.print("Please enter new phone number : "); 
                String newPhone = scan.next();
                renter[iFound].setPhoneNo(newPhone);
                System.out.println("\nUpdate successful !!");             
            }
            else
            {
                System.out.println("\nNo data update !!");               
            }
        }
        
        ////////////////////////////////////////////////////////////////////////////
        
        //Calculate total income for each company
        for(i=0; i<renter.length; i++)
        {
            if(renter[i].getCompany().getCompanyName().equals("SwiftDrive"))
            {
                incomeA += renter[i].calcPrice();
            }
            else if(renter[i].getCompany().getCompanyName().equals("CarrierGo"))
            {
                incomeB += renter[i].calcPrice();
            }
            else if(renter[i].getCompany().getCompanyName().equals("BigWheels"))
            {
                incomeC += renter[i].calcPrice();
            }
            else if(renter[i].getCompany().getCompanyName().equals("RoomHive"))
            {
                incomeD += renter[i].calcPrice();
            }
            else if(renter[i].getCompany().getCompanyName().equals("CozyStays"))
            {
                incomeE += renter[i].calcPrice();
            }
        }
        
        //Store customers' receipt information in receiptList.txt file
        list.println("======================================================");
        list.println("Customers' Receipt");
        list.println("======================================================");
        for(int j=0; j<renter.length; j++)
        {
            list.println("Company      : " + renter[j].getCompany().toString());
            list.println(" ");
            list.println("Renter Name  : " + renter[j].renterName);
            list.println("Phone Number : " + renter[j].renterPhoneNo);
            list.println("IC Number    : " + renter[j].renterIcNo);
            
            if(renter[j] instanceof Vehicle) //Test whether renter[j] object is an instance of class Vehicle
            {
                Vehicle temp = (Vehicle) renter[j]; //Cast renter[j] object into class Vehicle and store it in temp object (Type casting)
                
                String type = "";
                if(temp.getRentalType() == 'H'){type = " Hour";}
                else if(temp.getRentalType() == 'D'){type = " Day";}
                
                list.println("Vehicle      : " + temp.getVehicleName());
                list.println("Duration     : " + temp.getVehicleDuration() + type);
                list.println("Rental Price : RM" + String.format("%.2f",temp.calcPrice()));
            }
            else if(renter[j] instanceof Accommodation) //Test whether renter[j] object is an instance of class Accommodation
            {
                Accommodation temp = (Accommodation) renter[j]; //Cast renter[j] object into class Accommodation and store it in temp object (Type casting)
                
                list.println("Rental Choose: " + temp.getAccommodationName());
                list.println("Duration     : " + temp.getAccommodationDuration() + " Day");
                list.println("Rental Price : RM" + String.format("%.2f",temp.calcPrice()));
            }
                        
            list.println("Bank Name    : " + renter[j].bankName);
            list.println("Bank ID      : " + renter[j].bankID);
            list.println("--------------------------------------------------");
        }
        list.close(); //Stop storing output and close the file
        
        //Store companies report information in report.txt file
        report.println(" =============================================================");
        report.println(" REPORT");
        report.println(" =============================================================");
        report.println("\n RENTING CHARGES LIST");
        
        report.println(" =============================================================");
        report.println(" CUSTOMER IC NUMBER\tRENTED MODEL\t\tTOTAL PAYMENT ");
        report.println(" =============================================================");
        for(int j=0; j<renter.length; j++)
        {
            if(renter[j] instanceof Vehicle) //Test whether renter[j] object is an instance of class Vehicle
            {
                Vehicle temp = (Vehicle) renter[j]; //Cast renter[j] object into class Vehicle and store it in temp object (Type casting)
                //To call getVehicleName() method from class Vehicle
                report.println("  " + temp.getRenterIcNo() + " \t" + temp.getVehicleName() + "\t\t RM " + String.format("%.2f",temp.calcPrice()));
            }
            else if(renter[j] instanceof Accommodation) //Test whether renter[j] object is an instance of class Accomodation
            {
                Accommodation temp = (Accommodation) renter[j]; //Cast renter[j] object into class Accomodation and store it in temp object (Type casting)
                //To call getAccommodationName() method from class Accomodation
                report.println("  " + temp.getRenterIcNo() + " \t" + temp.getAccommodationName() + "\t\t RM " + String.format("%.2f",temp.calcPrice()));
            }
        }
        report.println(" =============================================================");
        
        //Calculate average, maximum, and minimum of rental charge
        report.println("\n RENTAL CHARGES SUMMARY");
        //Initialization
        double average, totalPrice = 0, max = 0, min = 99999;
        for(int j = 0; j < renter.length; j++)
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
        average = totalPrice/renter.length;
        report.println(" Average renting charge : RM" + String.format("%.2f",average));
        report.println(" Highest renting charge : RM" + String.format("%.2f",max));
        report.println(" Lowest renting charge  : RM" + String.format("%.2f",min));  
        report.println("\n\n");
        
        //Sorting from most to least profitable company
        //Declare array of companyIncome
        String[] companyIncome = new String[5];
        //Initialize array of companyIncome
        companyIncome[0] = " SwiftDrive : RM" + String.format("%.2f",incomeA);
        companyIncome[1] = " CarrierGo  : RM" + String.format("%.2f",incomeB);
        companyIncome[2] = " BigWheels  : RM" + String.format("%.2f",incomeC);
        companyIncome[3] = " RoomHive   : RM" + String.format("%.2f",incomeD);
        companyIncome[4] = " CozyStays  : RM" + String.format("%.2f",incomeE);
        
        String tempIncome;
        for(i = 0; i < companyIncome.length; i++)
        {
            for(int j = i+1; j < companyIncome.length; j++)
            {
                if(Double.parseDouble(companyIncome[j].substring(16)) > Double.parseDouble(companyIncome[i].substring(16)))
                {
                    tempIncome = companyIncome[i];
                    companyIncome[i] = companyIncome[j];
                    companyIncome[j] = tempIncome;
                }
            }
        }
        
        report.println(" TOTAL INCOME FOR EACH COMPANY FROM HIGHEST TO LOWEST \n");
        for(i = 0; i < companyIncome.length; i++)
        {
            report.println(companyIncome[i]);
        }
        report.close(); //Stop storing output and close the file
        
    }
    catch (FileNotFoundException fnfe){System.out.println("File not found!");} //If file needed is not available in the system, error message will be displayed
    catch (IOException ioe){System.out.println("Input/output file problem!");} //If input/output failed to be interpreted, error message will be displayed
    catch (Exception e){System.out.println("Something went wrong.");} //If the normal flow of the program is disterupted, error messafe will be displayed
}
}