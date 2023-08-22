package model;

public class Design implements File {
    public String name;
    public String briefing;
    public String spec;
    public String tests;
    public String iface;
    public String code;
    public Object stats;
    public boolean completed;
    public boolean custom;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString(boolean last) {
        return "Design{" +
                "name='" + name + '\'' +
                ", briefing='" + briefing + '\'' +
                ", spec='" + spec + '\'' +
                ", tests='" + tests + '\'' +
                ", iface='" + iface + '\'' +
                ", code='" + code + '\'' +
                ", stats=" + stats +
                ", completed=" + completed +
                ", custom=" + custom +
                '}';
    }
}
