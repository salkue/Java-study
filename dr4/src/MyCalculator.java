import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MyCalculator {
    public interface Calculator {
        @Cash
        int sum(int a, int b);
    }

    public static class CalculatorImp implements Calculator {

        @Override
        public int sum(int a, int b) {
            return a + b;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Cash {
    }

    public static class Handler implements InvocationHandler {
        private final Calculator myCalculator;
        private Map<Map<Integer, Integer>, Integer> cash = new HashMap<>();

        public Handler(CalculatorImp myCalculator) {
            this.myCalculator = myCalculator;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Map<Integer, Integer> terms = new HashMap<>();
            terms.put((Integer) args[0], (Integer) args[1]);
            if (method.isAnnotationPresent(Cash.class)) {
                if (cash.containsKey(terms)) {
                    System.out.println("Из кэша");
                    return cash.get(terms);
                } else {
                    System.out.println("Считаем");
                    int sum = (Integer) method.invoke(myCalculator, args);
                    cash.put(terms, sum);
                    return sum;
                }
            }
            return method.invoke(myCalculator,args);
        }

    }

    public static void main(String[] args) {
        CalculatorImp testCalc = new CalculatorImp();
        Handler handler = new Handler(testCalc);
        Calculator calc = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(), new Class[]{Calculator.class}, handler);
        System.out.println(calc.sum(1, 2));
        System.out.println(calc.sum(1, 2));
        System.out.println(calc.sum(1, 3));
        System.out.println(calc.sum(1, 6));

    }

}