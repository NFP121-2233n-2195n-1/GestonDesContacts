package Models;
import java.util.Date;
import java.io.Serializable;


/**
 * Write a description of class PhoneNumber here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhoneNumber implements Serializable
{
    private static int next = 0;
    private int phoneNumberID;
    private String regionCode;
    private String phoneNumber;
    
    public PhoneNumber(String regionCode, String phoneNumber){
        this.regionCode = regionCode;
        this.phoneNumber = phoneNumber;
        phoneNumberID = (int) (new Date().getTime()/1000)+next;
        next++;
    }
    
    public int getPhoneNumberID(){return this.phoneNumberID;}
    public String getRegionCode(){return this.regionCode;}
    public String getPhoneNumber(){return this.phoneNumber;}
    
    public void setRegionCode(String regionCode){this.regionCode = regionCode;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}

}
