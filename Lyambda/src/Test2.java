
interface Executable2 {
    int execute(int x, int y);
}

class Runner2 {
    public void run(Executable2 e) {

        int a = e.execute(10,15);
        System.out.println(a);
    }
}

public class Test2 {
    public static void main(String[] args) {
        Runner2 runner = new Runner2();

        runner.run(new Executable2() {
            @Override
            public int execute(int x,int y) {
                System.out.println("Hello");
                return x + y;
            }
        });

        runner.run((x,y) -> x + y);
    }
}
