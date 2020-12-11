package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment=incrementByOne(0);
        System.out.println(increment+ " imperative");

        Integer increment2=incrementByOneFunction.apply(10);
        System.out.println(increment2+ " declarative");
        Integer multiply =multiplyBy10Function.apply(increment2);
        System.out.println(multiply+ " declarative next");

        Function<Integer,Integer> chainFunction=incrementByOneFunction.andThen(multiplyBy10Function);
        Integer chainAnswer=chainFunction.apply(10);
        System.out.println(chainAnswer+ " declarative one line function");

        //Bifunction
        Integer incAndMultBiF=incrementByOneAndMultiplyBiFunction.apply(2,4);
        System.out.println(incAndMultBiF+" bifunction answer");
    }
    static Function<Integer,Integer> incrementByOneFunction= number->number+1;
    static Function<Integer,Integer> multiplyBy10Function=number->number*10;

    static BiFunction<Integer,Integer,Integer>incrementByOneAndMultiplyBiFunction=
            (numToIncrem,numToMult)->(numToIncrem+1)*numToMult;

    static int incrementByOne(int number){
        return number+1;
    }

    static int incrementByOneAndMultiply(int number,int numToMultiplyBy){
        return(number+1)*numToMultiplyBy;
    }

}
