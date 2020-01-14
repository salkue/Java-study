import java.util.*;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private String str;
    private String[] WordArray;

    public Solution(String str) {
        this.str = str;
        this.WordArray = str.split("\\s+");
    }

    public class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length())
                return o1.length() - o2.length();
            else return o1.compareTo(o2);
        }
    }

    public class ReverseInterator implements Iterator<String> {
        private List<String> StringList;
        private int counter;

        public ReverseInterator(List StringList) {
            this.StringList = StringList;
            counter = StringList.size();
        }

        @Override
        public boolean hasNext() {
            return counter > 0;
        }

        @Override
        public String next() {
            counter--;
            return StringList.get(counter);
        }
    }

    //Задание 1: Подсчитайте количество различных слов в файле.
    public int uniqWordCount() {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(WordArray));
        return set.size();
    }

    //Задание 2: Выведите на экран список различных слов файла,
    // отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
    public void uniqSortWords() {
        MyComparator myComparator = new MyComparator();
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(WordArray));
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, myComparator);
        for (String s : list)
            System.out.println(s);
    }

    //Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле

    public void wordCounter() {
        Map<String, Integer> map = new HashMap<>();
        for (String s : WordArray) {
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }
        System.out.println("Количество повторений слов:" + map);
    }

    //Задание 4: Выведите на экран все строки в обратном порядке.
    public void reversePrint() {
        List<String> list = new ArrayList<>(Arrays.asList(str.split("\n")));
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    //Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
    public void revIterator() {
        List<String> list = new ArrayList<>(Arrays.asList(str.split("\n")));
        Iterator<String> MyIterator = new ReverseInterator(list);
        while (MyIterator.hasNext()) {
            System.out.println(MyIterator.next());
        }
    }

    //Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
    public void inputNumber() {
        List<String> list = new ArrayList<>(Arrays.asList(str.split("\n")));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер строки! (1-" + list.size() + ")");
            try {
                System.out.println(list.get(scanner.nextInt() - 1));
            } catch (IndexOutOfBoundsException e) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        String text = "я узнал что у меня\nесть огромная семья\nи тропинка и лужок\nв поле каждый колосок\nэто родина моя\nвсех люблю на свете я";
        Solution sol = new Solution(text);
        System.out.println("Задание 1.");
        System.out.println("Количество различных слов - " + sol.uniqWordCount());

        System.out.println("Задание 2.");
        sol.uniqSortWords();

        System.out.println("Задание 3.");
        sol.wordCounter();

        System.out.println("Задание 4.");
        sol.reversePrint();

        System.out.println("Задание 5.");
        sol.revIterator();

        System.out.println("Задание 6.");
        sol.inputNumber();
    }
}