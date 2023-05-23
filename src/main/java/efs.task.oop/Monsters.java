package efs.task.oop;

public abstract class Monsters {

    public static final Monster andariel = new Monster(10, 70) {
        @Override
        public String toString() {
            return "Andariel";
        }
    };

    public static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public String toString() {
            return "Blacksmith";
        }
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.damage + 5);
        }
        @Override
        public void takeHit(int damage) {
            super.takeHit(damage + 5);
        }
    };
    static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();
}

