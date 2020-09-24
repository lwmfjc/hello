package fife.ly.entity;

public class Bed {
    private String name;
    private Pillow pillow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pillow getPillow() {
        return pillow;
    }

    public void setPillow(Pillow pillow) {
        this.pillow = pillow;
    }

    public void usePillow(){
        if(pillow!=null) {
            System.out.println("I use pillow[" + pillow + "]");
        }else {
            System.out.println("The bed has no pillow!");
        }
    }
}
