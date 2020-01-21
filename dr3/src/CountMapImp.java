import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CountMapImp<T> implements CountMap<T> {
    private Map<T, Integer> map;

    public CountMapImp() {
        this.map = new HashMap<>();
    }


    @Override
    public void add(T o) {
        if (!map.containsKey(o)) {
            map.put(o, 1);
        } else {
            map.put(o, map.get(o) + 1);
        }
    }

    @Override
    public int getCount(T o) {
        return map.get(o);
    }

    @Override
    public int remove(T o) {
        return map.remove(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        Iterator<T> iterator = source.toMap().keySet().iterator();
        while (iterator.hasNext()) {
            T key = iterator.next();
            if (!map.containsKey(key)) {
                map.put(key, source.getCount(key));
            } else {
                map.put(key, map.get(key) + source.getCount(key));
            }
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T,Integer> destination) {
        destination.putAll(map);
    }

    @Override
    public String toString() {
        String string = "";
        for (Map.Entry<T, Integer> elem : map.entrySet())
            string += "" + elem.getKey() + "----" + elem.getValue() + "\n";
        return string;
    }

    public static void main(String[] args) {
        CountMap<Integer> myCountMap = new CountMapImp<>();
        myCountMap.add(1);
        myCountMap.add(2);
        myCountMap.add(2);
        myCountMap.add(2);
        myCountMap.add(3);
        myCountMap.add(3);
        myCountMap.add(3);
        myCountMap.add(3);
        myCountMap.add(4);
        myCountMap.add(4);
        System.out.println(myCountMap);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какого элемента вывести количество?");
        System.out.println(myCountMap.getCount(scanner.nextInt()));
        System.out.println("Какой элемент удалить?");
        System.out.println(myCountMap.remove(scanner.nextInt()));
        System.out.println(myCountMap);
        System.out.println(myCountMap.size());

        CountMap<Integer> myCountMap2 = new CountMapImp<>();
        myCountMap2.add(1);
        myCountMap2.add(2);
        myCountMap2.add(2);
        myCountMap2.add(3);
        myCountMap2.add(6);
        myCountMap2.add(7);
        myCountMap2.add(7);
        myCountMap2.add(3);
        myCountMap2.add(4);
        myCountMap2.add(4);
        System.out.println(myCountMap2);

        myCountMap.addAll(myCountMap2);
        System.out.println(myCountMap);

        Map <Integer,Integer> myDestination = new HashMap<>();
        myCountMap.toMap(myDestination);
        System.out.println(myDestination);
    }
}
