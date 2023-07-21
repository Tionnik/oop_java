package oop_java;

public  abstract class Actor implements ActorBehavoir{
    
    private String name;
    private boolean made_order;
    private boolean took_order;

    public Actor(String name1, boolean made_order1, boolean took_order1){
        this.name = name1;
        this.made_order = made_order1;
        this.took_order = took_order1;
    }

    public String getName() {
        return name;
    }

    
}
