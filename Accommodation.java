public class Accommodation extends Renter
{
    //Attributes
    private char accommodationType;
    private int accommodationDuration;
    private String accommodationName;
    private double accommodationPrice;
    
    //Default constructor
    public Accommodation()
    {
        super();
    }
    //Normal constructor
    public Accommodation(String name, String phone, String ic, RentalCompany company, char accommodationType, int accommodationDuration)
    {
        super(name,phone,ic,company);
        this.accommodationType = accommodationType;      
        this.accommodationDuration = accommodationDuration;
    }
    //Mutator method
    public void setAccommodation(char newAccommodationType, int newAccommodationDuration)
    {
        accommodationType = newAccommodationType;
        accommodationDuration = newAccommodationDuration;
    }
    //Accessor method
    public char getAccommodationType(){return accommodationType;}
    public int getAccommodationDuration(){return accommodationDuration;}
    public String getAccommodationName(){return accommodationName;}
    public double getAccommodationPrice(){return accommodationPrice;}
    //Processing method
    public double calcPrice() //Set accommodation name, accommodation price and return total price including 7% tax
    {
        if(super.getCompany().getCompanyName().equals("RoomHive"))
        {
            if(accommodationType == 'A')
            {
                accommodationName = "Single Room";
                accommodationPrice = 120;
            }
            else if(accommodationType == 'B')
            {
                accommodationName = "Double Room";
                accommodationPrice = 240;
            }
            else if(accommodationType == 'C')
            {
                accommodationName = "Deluxe Room";
                accommodationPrice = 330;
            }
        } 
        else if(super.getCompany().getCompanyName().equals("CozyStays"))
        {
            if(accommodationType == 'A')
            {
                accommodationName = "Apartment";
                accommodationPrice = 540;
            }
            else if(accommodationType == 'H')
            {
                accommodationName = "Homestay";
                accommodationPrice = 720;
            }
        }
        
        return (accommodationPrice*accommodationDuration)*1.07;
    }
    //Display method   
    public String displayReceipt()
    {
        return "\n ============================================" +
                "\n        Car Rental And Accommodation         " + 
                "\n             Owned & Operated By :          " +
                "\n                 " + getCompany().getCompanyName() +
                "\n --------------------------------------------" +
                "\n  Renter Name  : " + renterName +
                "\n  Phone Number : " + renterPhoneNo + "\n" +
                
                "\n  Accommodation Type           " + accommodationName +
                "\n  Rental Days                  " + accommodationDuration +
                "\n  Rental Price                 RM" + accommodationPrice +
                "\n                              ---------------" +
                "\n  Total Payment                RM" + String.format("%.2f",calcPrice()) +
                "\n --------------------------------------------" +
                "\n                                             " +
                "\n   * your total payment is included 7% tax   " +
                "\n                ~ Thank you ~                " + 
                "\n ============================================" +
                "\n ";
    }
}
