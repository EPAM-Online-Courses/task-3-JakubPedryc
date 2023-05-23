abstract class Monster implements Fighter {
    protected int health;
    protected int damage;

    Monster(int health, int damage){
        this.health = health;
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }
    public int getDamage(){
        return damage;
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        if(health - damage >= 0){
            health -= damage;
            Monsters.monstersHealth -= damage;
        }
        else{
            Monsters.monstersHealth -= health;
            health = 0;
        }
    }
}
