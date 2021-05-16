package uts.isd.controller;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Briana Margetts
 */
public class PaymentValidator implements Serializable{
    //checks payment type is only letters and spaces
    private String paymentTypePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    // checks ccv is only numbers and is between 2 - 5
    private String ccvPattern = "[0-9]{2,5}";
    // checks account number is only numbers and is at least 5 digits long
    private String accountNumberPattern = "[0-9]{5,}";

    public PaymentValidator() {
    }
    
    // using java.util.regex.Matcher & Pattern to compare pattern with srting imput
     public boolean validate(String pattern, String input) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        return m.matches();
    }
     // validating payment type to make sure it matches pattern
     public boolean validatePaymentType(String paymentType){
         return validate(paymentTypePattern, paymentType);
     }
     // validating ccv to make sure it matches pattern
     public boolean validateCcv(String ccv){
         return validate(ccvPattern, ccv);
     }
     // validating account number to make sure it matches pattern
     public boolean validateAccountNumber(String  accountNumber){
         return validate( accountNumberPattern,  accountNumber);
     }
    // clearing error messages
    public void clear(HttpSession session){
        //session.setAttribute("customerID","");
    }
    
    
}
