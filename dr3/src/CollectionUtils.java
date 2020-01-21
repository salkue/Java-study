import java.util.*;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    //создать новый List
    public static <T> List<? extends T> newArrayList() {
        List<? extends T> list = new ArrayList<>();
        return list;
    }

    //поиск заданного элемента
    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o) + 1;
    }

    //обрезает кусок заданного размера
    public static <T> List<? extends T> limit(List<? extends T> source, int size) {
        if (source.size() > size)
            return source.subList(0, size);
        else
            return source;
    }

    //добавляет элемент в коллекцию
    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }


    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }


    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T c2element : c2) {
            if (c1.contains(c2element))
                return true;
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (t.compareTo(min) >= 0 && t.compareTo(max) <= 0) {
                result.add(t);
            }
        }
        Collections.sort(result);
        return result;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (t.compareTo(min) >= 0 && t.compareTo(max) <= 0) {
                result.add(t);
            }
        }
        Collections.sort(result, comparator);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>(Arrays.asList(1, 324, 5, 7, 3, 10, 11, 112, 10, 111));
        CollectionUtils.add(testList, 1);
        System.out.println("testList1:");
        for (int i : testList) {
            System.out.println(i);
        }

        List<Integer> testList2 = (List<Integer>) CollectionUtils.newArrayList();
        CollectionUtils.addAll(testList, testList2);
        System.out.println("\naddAll test");
        System.out.println("\ntestList2:");
        for (int i : testList2) {
            System.out.println(i);
        }

        System.out.println("\nindexOf test " + CollectionUtils.indexOf(testList, 111));

        System.out.println("\nlimit test:");
        List<Integer> testList3 = (List<Integer>) CollectionUtils.limit(testList, 4);
        for (int i : testList3) {
            System.out.println(i);
        }

        System.out.println("\nremoveAll test:");
        CollectionUtils.removeAll(testList, Arrays.asList(5, 7, 3));
        System.out.println("testList1:");
        for (int i : testList) {
            System.out.println(i);
        }

        System.out.println("\ncontainsAll test:" + CollectionUtils.containsAll(testList, Arrays.asList(10, 11)));

        System.out.println("\ncontainsAny test:" + CollectionUtils.containsAny(testList, Arrays.asList(10000, 1120)));

        System.out.println("\nrange test:");
        List<Integer> testList4 = CollectionUtils.range(testList, 0, 15);
        for (int i : testList4) {
            System.out.println(i);
        }

        System.out.println("\nrange2 test:");
        Comparator <Integer> myComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        List<Integer> testList5 = CollectionUtils.range(testList, 0, 15,myComparator);
        for (int i : testList5) {
            System.out.println(i);
        }
    }
}