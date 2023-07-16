package mp2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class ObjectPlus implements Serializable {
    public static final String FILENAME = "data.txt";
    private static Map<Class, List> extent = new HashMap<>();
    public ObjectPlus() {
        addToExtent();
    }

    public void addToExtent() {
        List list = extent.get(this.getClass());
        if(list == null) {
            list = new ArrayList();
            extent.put(this.getClass(), list);
        }
        list.add(this);
    }

    protected void removeFromExtent() {
        List list = extent.get(this.getClass());
        if (list == null) {
            return;
        }
        list.remove(this);
    }

    public static Map<Class, List> getExtent() {
       // return Collections.unmodifiableMap(extent);
        return extent;
    }

    public static List getExtent(Class klass) {
        List list = extent.get(klass);
        if(list == null) {
            list = new ArrayList();
        }
        return Collections.unmodifiableList(list);
    }

    public static void saveExtent(ObjectOutputStream oos) throws IOException {
        oos.writeObject(extent);
    }

    public static void loadExtent(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        extent = (Map<Class, List>) ois.readObject();
    }


}
