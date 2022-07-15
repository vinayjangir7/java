package main.java.com.github.vinayjangir7.scratch;

import java.util.HashMap;
import java.util.Map;

final class ImmutableClass {

    private final String property1;
    private final int property2;
    private final Map<String, Integer> property3;

    public ImmutableClass(String property1, int propert2, Map<String, Integer> property3) {
        this.property1 = property1;
        this.property2 = propert2;
        Map<String, Integer> tempMap = new HashMap<>();
        property3.forEach(tempMap::put);
        this.property3 = tempMap;
    }

    public String getProperty1() {
        return property1;
    }

    public int getProperty2() {
        return property2;
    }

    public Map<String, Integer> getProperty3() {
        // Creating Map with HashMap reference
        Map<String, Integer> tempMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry :
                this.property3.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}
