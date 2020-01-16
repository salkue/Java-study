import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class CountMapImp<T> implements CountMap<T> {
    private Map<T, Integer> map;

    public CountMapImp<T>

    {
        this.map = new HashMap<T, Integer>();

    }
}


    @Override
    public void add(T o) {
        if (!map.containsKey(o))
            map.put(o, 1);
        else
            map.put(o, map.get(o) + 1);

    }
