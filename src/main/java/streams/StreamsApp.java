package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsApp {
    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name,Gender gender) {
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

        Set<Gender> collect1 = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        boolean b = people.stream().allMatch(p -> Gender.FEMALE.equals(p.gender));
        System.out.println("all Matcher female? "+b);
        boolean b1= people.stream().anyMatch(p->Gender.FEMALE.equals(p.gender));
        System.out.println("any matches female? "+b1);

        Optional.ofNullable("angie").ifPresent(x-> System.out.println("sending to "+x));
    }
}
