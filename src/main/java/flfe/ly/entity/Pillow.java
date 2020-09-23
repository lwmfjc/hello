package flfe.ly.entity;

public class Pillow {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "plw["+name+"]";
    }
}
