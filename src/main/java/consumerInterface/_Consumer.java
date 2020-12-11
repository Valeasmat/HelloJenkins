package consumerInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        //Imperative
        System.out.println("Imperative style");
        greetCustomer(new Customer("Israel Cabrera","99954837"));
        System.out.println("Declarative style");
        Customer matias=new Customer("Matias Gutierrez","48475767");
        greetCustomerConsumer.accept(matias);
        System.out.println("Declarative Bi style");
        Customer renato=new Customer("Renato Mendiola","394838440");
        greetCustomerBiConsumer.accept(renato,false);
    }
    static BiConsumer<Customer,Boolean> greetCustomerBiConsumer=
            (customer,showPhone)-> System.out.println("Hello "
                    + customer.customerName+" your phone number is "
            +(showPhone ? customer.customerPhoneNumber :"***********"));

    static Consumer<Customer> greetCustomerConsumer=
            customer-> System.out.println("Hello "+customer.customerName+" your phone number is "+customer.customerPhoneNumber);

    static void greetCustomer(Customer customer){
        System.out.println("Hello "+customer.customerName+" your phone number is "+customer.customerPhoneNumber);
    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
