package Oreilly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class LambdasPractice {

    private void demo(int i1,int i2) {
        BinaryIntOp mult = (x, y) -> x * y;
        BinaryIntOp composed = (x, y) -> mult.compute(mult.compute(x, x), mult.compute(y, y));
        int rpta = highApply((x, y) -> (x + 59) * (y + 6), i1, i2);
        System.out.println("Default: " + BinaryIntOp.operate(i1, i2));
        System.out.println(("Multiplica: " + mult.compute(i1, i2)));
        System.out.println("Multiplica composed: " + composed.compute(i1, i2));
        System.out.println("High order: " + rpta);

        BinaryInt bi = new BinaryInt() {
            @Override
            public int compute(BinaryIntOp op, int i1, int i2) {
                int rpta = op.compute(i1,i2);
                return rpta;
            }
        };
        List<Usuario> list = new ArrayList<>();
        Usuario u1=new Usuario("Vale","12345");
        Usuario u2=new Usuario("Juan","1jjhds");
        Usuario u3=new Usuario("Cecilia","12345");
        Usuario u4=new Usuario("Angie","cp45");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        System.out.println(list);
        list.sort(Usuario::compareTo);
        System.out.println(list);


    }
    public int highApply(BinaryIntOp op,int i1, int i2){
        return op.compute(i1,i2);
    }

    public static void main(String[] args) {
        LambdasPractice lp=new LambdasPractice();
        lp.demo(5,4);

    }
}
@FunctionalInterface
interface BinaryIntOp{
    int compute(int i1,int i2);
    static int operate(int i1,int i2){
        return i1+i2;
    }
}
@FunctionalInterface
interface BinaryInt{
    int compute(BinaryIntOp op, int i1, int i2);
    static int operate(int i1,int i2){
        return i1+i2;
    }
}
class Usuario implements Comparable<Usuario>{
    private String name;
    private String password;

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(Usuario o) {
        return o.getName().compareTo(this.name);
    }
}
