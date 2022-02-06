package Models;


/**
 * Write a description of class PhoneNumber here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhoneNumber
{
    private static int next = 0;
    private int phoneNumberID;
    private String regionCode;
    private String phoneNumber;
    
    PhoneNumber(String regionCode, String phoneNumber){
        this.regionCode = regionCode;
        this.phoneNumber = phoneNumber;
    }
    
    public int getPhoneNumberID(){return this.phoneNumberID;}
    public String getRegionCode(){return this.regionCode;}
    public String getPhoneNumber(){return this.phoneNumber;}
    
    public void setRegionCode(String regionCode){this.regionCode = regionCode;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}

}
