package mp4.ordered;

import mp1.Methods;

public class Drug implements Methods {
    private String name;
    private String manufacturer;
    private String Group;

    public Drug(String name, String manufacturer, String group) throws Exception {
        checkString(name);
        checkString(manufacturer);
        checkString(group);

        this.name = name;
        this.manufacturer = manufacturer;
        Group = group;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getGroup() {
        return Group;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", Group='" + Group + '\'' +
                '}';
    }
}
