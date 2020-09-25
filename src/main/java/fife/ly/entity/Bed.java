package fife.ly.entity;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class Bed implements InitializingBean {
    private String name;
    private Pillow pillow;

    public String getName() {
        return name;
    }

    /**注意看context.xml文件,由于使用了注解,需要声明context:annotation-config
     *
     */
    /**
     * 该方法在bea类被投入使用之前及bean实际初始化之前调用
     */
    @PostConstruct
    public void init1(){
        System.out.println("init1");
    }

    public void init2(){
        System.out.println("init2");
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

    /**
     * 在注入依赖项后立即执行
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init3");
    }
}
