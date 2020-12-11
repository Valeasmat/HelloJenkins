package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPhoneValid(String phone){
        return phone.startsWith("+51");
    }
    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears()>18;
    }

    public boolean isValid(Customer customer){
        return isAdult(customer.getDob())&&isEmailValid(customer.getEmail())&&isPhoneValid(customer.getPhone());

    }


}
