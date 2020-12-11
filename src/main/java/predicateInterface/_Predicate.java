package predicateInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println(isPhoneNumberValid("03000000000"));
        System.out.println(isPhoneNumberValid("09800000000"));

        System.out.println("Declarative approach");
        System.out.println(isPhoneNumberValidPredicate.test("03785698563"));

        System.out.println(isPhoneNumberValidPredicate.and(containsNumber5).test("03555555555"));


    }

    static Predicate<String> isPhoneNumberValidPredicate=phone->phone.startsWith("03")&&phone.length()==11;

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("03")&&phoneNumber.length()==11;
    }

    static Predicate<String> containsNumber5=x->x.contains("5");
}
