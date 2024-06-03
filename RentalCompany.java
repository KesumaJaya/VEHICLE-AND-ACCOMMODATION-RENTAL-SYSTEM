public class RentalCompany
{
    //Attributes
    private String companyName;
    private String companyLocation;
    private String companyPhoneNo;
    
    //Default constructor
    public RentalCompany()
    {
        companyName = null;
        companyLocation = null;
        companyPhoneNo = null;
    }
    //Normal constructor
    public RentalCompany(String companyName, String companyLocation, String companyPhoneNo)
    {
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.companyPhoneNo = companyPhoneNo;
    }
    //Mutator method
    public void setRentalCompany(String newCompanyName, String newCompanyLocation, String newCompanyPhoneNo)
    {
        companyName = newCompanyName;
        companyLocation = newCompanyLocation;
        companyPhoneNo = newCompanyPhoneNo;
    }
    //Accessor method
    public String getCompanyName(){return companyName;}
    public String getCommpanyLocation(){return companyLocation;}
    public String getCompanyPhoneNo(){return companyPhoneNo;}
    //Display method
    public String toString()
    {
        return companyName + "," + companyLocation + "," + companyPhoneNo;
    }
    
    public void displayCompanyList()
    {
        System.out.println(" +------------------------------------------------+ ");
        System.out.println(" | CODE |  COMPANY NAME  |  SERVICE PROVIDE       | ");
        System.out.println(" |------------------------------------------------| ");
        System.out.println(" |  A   |  SwiftDrive    |  Car rental            | ");
        System.out.println(" |  B   |  CarrierGo     |  MPV and Van rental    | ");
        System.out.println(" |  C   |  BigWheels     |  Lorry rental          | ");
        System.out.println(" |  D   |  RoomHive      |  Hotel Reservation     | ");
        System.out.println(" |  E   |  CozyStays     |  Homestay & Apartment  | ");
        System.out.println(" +------------------------------------------------+ ");
        System.out.println(" * kindly only enter code given       ");
    }
    
    public void displayOption()
    {
        if(getCompanyName().equals("SwiftDrive"))
        {
            System.out.println("\n +----------------------------------------------------------------------------------------+");
            System.out.println(" |  VEHICLE TYPE      |  VEHICLE CATEGORY  |  VEHICLE MODEL  |  PRICE/HOUR  |  PRICE/DAY  | ");
            System.out.println(" |----------------------------------------------------------------------------------------| ");
            System.out.println(" |  [C] COMPACT CAR   |  [S] STANDARD      |  PERODUA AXIA   |     RM7      |    RM90     | ");
            System.out.println(" |                    |  [P] PREMIUM       |  HONDA JAZZ     |     RM10     |    RM110    | ");
            System.out.println(" |-----------------------------------------|-----------------|--------------|-------------| ");
            System.out.println(" |  [S] SEDAN CAR     |  [S] STANDARD      |  PERODUA BEZZA  |     RM12     |    RM130    | ");
            System.out.println(" |                    |  [P] PREMIUM       |  HONDA CITY     |     RM15     |    RM150    | ");
            System.out.println(" +----------------------------------------------------------------------------------------+ ");
        }
        else if(getCompanyName().equals("CarrierGo"))
        {
            System.out.println("\n +------------------------------------------------------------------------------------+");
            System.out.println(" |  VEHICLE TYPE  |  VEHICLE CATEGORY  |  VEHICLE MODEL  |  PRICE/HOUR  |  PRICE/DAY  | ");
            System.out.println(" |------------------------------------------------------------------------------------| ");
            System.out.println(" |  [M] MPV CAR   |  [S] STANDARD      |  PERODUA ALZA   |     RM25     |    RM280    | ");
            System.out.println(" |                |  [P] PREMIUM       |  HONDA ODYSSEY  |     RM28     |    RM300    | ");
            System.out.println(" |-------------------------------------|-----------------|--------------|-------------| ");
            System.out.println(" |  [V] VAN       |  [C] CARGO         |  NISSAN NV200   |     RM27     |    RM280    | ");
            System.out.println(" |                |  [P] PASSENGER     |  NISSAN NV200   |     RM30     |    RM320    | ");
            System.out.println(" +------------------------------------------------------------------------------------+ ");
        }
        else if(getCompanyName().equals("BigWheels"))
        {
            System.out.println("\n +-----------------------------------------------------------------------+");
            System.out.println(" |  VEHICLE TYPE  |  VEHICLE CATEGORY  |   VEHICLE MODEL   |  PRICE/DAY  | ");
            System.out.println(" |-----------------------------------------------------------------------| ");
            System.out.println(" |     LORRY      |  [F] 5 TONNE       |  HINO 300 SERIES  |    RM480    | ");
            System.out.println(" |                |  [T] 10 TONNE      |  HINO 500 SERIES  |    RM820    | ");
            System.out.println(" +-----------------------------------------------------------------------+ ");
        }
        else if(getCompanyName().equals("RoomHive"))
        {
            System.out.println("\n +--------------------------------------------+ ");
            System.out.println(" |   ACCOMMODATION TYPE   |   PRICE PER DAY   | ");
            System.out.println(" |--------------------------------------------| ");
            System.out.println(" |    [A] Single Room     |      RM 120       | ");
            System.out.println(" |    [B] Double Room     |      RM 240       | ");
            System.out.println(" |    [C] Deluxe Room     |      RM 330       | ");
            System.out.println(" +--------------------------------------------+ ");
        }
        else if(getCompanyName().equals("CozyStays"))
        {
            System.out.println("\n +--------------------------------------------+ ");
            System.out.println(" |   ACCOMMODATION TYPE   |   PRICE PER DAY   | ");
            System.out.println(" |--------------------------------------------| ");
            System.out.println(" |    [A] Apartment       |       RM 540      | ");
            System.out.println(" |    [H] Homestay        |       RM 720      | ");
            System.out.println(" +--------------------------------------------+ ");
        }
    }
}
