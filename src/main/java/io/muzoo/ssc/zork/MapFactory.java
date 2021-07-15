package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.map.UniversityMap;
import io.muzoo.ssc.zork.map.TownMap;
import io.muzoo.ssc.zork.map.ZorkMap;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class MapFactory {

    private static final List<Class<? extends ZorkMap>> REGISTERED_MAPS = Arrays.asList(TownMap.class, UniversityMap.class);

    private static final Map<String, ZorkMap> ZORKMAP_MAP = new HashMap<>();

    static {
        {
            for (Class<? extends ZorkMap> mapClass : REGISTERED_MAPS) {
                try {
                    ZorkMap map = mapClass.getDeclaredConstructor().newInstance();
                    ZORKMAP_MAP.put(map.getMapName(), map);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ZorkMap get(String command) {
        return ZORKMAP_MAP.get(command);
    }

    public static List<String> getAllMapName() {
        return new ArrayList<>(ZORKMAP_MAP.keySet());
    }
}
