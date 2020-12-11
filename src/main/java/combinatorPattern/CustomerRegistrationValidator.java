package combinatorPattern;

import streams.StreamsApp;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@")? ValidationResult.SUCCESS: ValidationResult.EMAIL_NOT_VALID;
    }
    static CustomerRegistrationValidator isPhoneValid(){
        return customer -> customer.getPhone().startsWith("+51")? ValidationResult.SUCCESS: ValidationResult.PHONE_NUM_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears()>18?ValidationResult.SUCCESS:ValidationResult.NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other){
        return customer-> {
            ValidationResult result= this.apply(customer);
            return result.equals(ValidationResult.SUCCESS)?other.apply(customer):result;
        };
    }

    enum ValidationResult{
        SUCCESS,
        PHONE_NUM_NOT_VALID,
        EMAIL_NOT_VALID,
        NOT_AN_ADULT,
    }



}
