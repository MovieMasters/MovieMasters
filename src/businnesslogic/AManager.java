package businnesslogic;

import java.util.HashMap;

public abstract class AManager {
    /**
     * managersMap holds the enum Manager and the abstract object AManager
     */
    private static HashMap<Manager, AManager> managersMap;

    public static HashMap<Manager, AManager> getManagersMap() {
        return managersMap;
    }

    public static void setManagersMap(HashMap<Manager, AManager> managersMap) {
        AManager.managersMap = managersMap;
    }
}
