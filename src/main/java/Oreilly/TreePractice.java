package Oreilly;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TreePractice {
    public static void main(String[] args) {
        new TreePractice().demo();
    }
    public void demo(){
        User u1=new User(2,"Soo-Hyun");
        User u2=new User(8,"Renato");
        User u3=new User(4,"Matias");
        User u4=new User(7,"Lucas");
        User u5=new User(1,"Dua");
        User u6=new User(5,"Shawn");
        User u7=new User(12,"Pink");
        User u8=new User(14,"Harry");
        User u9=new User(13,"James");
        User u10=new User(11,"Sam");
        List<User> list=new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        list.add(u6);
        list.add(u7);
        list.add(u8);
        list.add(u9);
        list.add(u10);
        Map<Integer, User> collect = list.stream().filter(x -> (x.getUserId() % 2 == 0)).collect(Collectors.toMap(User::getUserId, Function.identity()));
        collect.entrySet().stream().forEach(x-> System.out.println("Key: "+x+"Value: "+x.getValue().getName()));

    }
}
class User implements Comparable<User>{
    private Integer userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(User o) {
        return this.userId-o.getUserId();
    }
}