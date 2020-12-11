package combinatorPattern;




import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice", "alice@email.com", "+51999663888", LocalDate.of(1998, 9, 3));
        CustomerValidatorService vs = new CustomerValidatorService();
        System.out.println(vs.isValid(customer));

        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator.isEmailValid().and(CustomerRegistrationValidator.isAdult()).and(CustomerRegistrationValidator.isPhoneValid()).apply(customer);
        System.out.println(result);
        if (result != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

        Duration d = Duration.ofMinutes(25);
        Duration d0 = Duration.ofMinutes(35);
        Duration d1 = Duration.ofMinutes(55);
        Duration d2= Duration.ofMinutes(27);
        Duration d3= Duration.ofMinutes(29);
        List<Duration> ld=new ArrayList<>();
        ld.add(d);
        ld.add(d0);
        ld.add(d1);
        ld.add(d2);
        ld.add(d3);
        Optional<Duration> total= ld.stream().reduce(Duration::plus);
        total.ifPresent(du-> System.out.println(du.getSeconds()));
    }

}
