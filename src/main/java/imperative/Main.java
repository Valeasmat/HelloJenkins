package imperative;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("name='").append(name).append('\'');
            sb.append(", gender='").append(gender).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
    enum Gender{
        MALE,FEMALE
    }
    public static void main(String[] args) {
        List<Person> people= Arrays.asList(
                new Person("Valeria",Gender.FEMALE),
                new Person("Angie",Gender.FEMALE),
                new Person("Cecilia",Gender.FEMALE),
                new Person("Matias",Gender.MALE),
                new Person("Renato",Gender.MALE),
                new Person("Lucas",Gender.MALE)
        );

        //Imperative
        List<Person> female=new ArrayList<>();
        for(Person p:people){
            if(Gender.FEMALE.equals(p.gender)){
                female.add(p);
            }
        }
        for(Person p:female){
            System.out.println(p);
        }
        // end imperative
        System.out.println("------------");

        //Declarative
        people.stream()
                .filter(x -> Gender.FEMALE.equals(x.gender))
                .forEach(System.out::println);
        // end declarative
        System.out.println("------------");

    }
}
