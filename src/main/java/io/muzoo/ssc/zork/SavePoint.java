package io.muzoo.ssc.zork;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SavePoint {

    private Map<String, Save> savePoints;

    public SavePoint() {
        savePoints = new HashMap<>();
    }

    public void savePoint(String savedPointName, Save save) {
        savePoints.put(savedPointName, save);
    }

    public Save loadPoint(String savedPointName) {
        if(savePoints.containsKey(savedPointName)) {
            return savePoints.get(savedPointName);
        }
        return null;
    }
}
