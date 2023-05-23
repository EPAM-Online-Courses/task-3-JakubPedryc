public class Villager implements Fighter {
    protected String name;
    protected int age;
    protected int health;
    protected int damage;
    public Villager(String name, int age){
        this.name = name;
        this.age = age;
        this.health = 100;
        this.damage = (int)((100 - age * 0.5) / 10);
    }

    public int getHealth(){
        return health;
    }
    public int getDamage(){
        return damage;
    }
    public void sayHello(){
        System.out.println("Greetings traveler... I'm " + name + "and I'm " + age + " years old");
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        if(health - damage >= 0){
            health -= damage;
        }
        else{
            health = 0;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
