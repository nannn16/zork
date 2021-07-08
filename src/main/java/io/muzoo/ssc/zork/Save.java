package io.muzoo.ssc.zork;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Save {

    private Map<String, List<String>> savePoints;

    public Save() {
        savePoints = new HashMap<>();
    }

    public void savePoint(String savedPointName, List<String> cmds) {
        savePoints.put(savedPointName, cmds);
    }

    public List<String> loadPoint(String savedPointName) {
        if(savePoints.containsKey(savedPointName)) {
            return savePoints.get(savedPointName);
        }
        return null;
    }
}
