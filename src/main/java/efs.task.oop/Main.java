package efs.task.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Villager> villagersList = new ArrayList<>();
        villagersList.add(new Villager("Kashya", 30));
        villagersList.add(new Villager("Gheed", 50));
        villagersList.add(new Villager("Warriv", 35));
        villagersList.add(new Villager("Flawia", 25));
        villagersList.add(new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER));
        villagersList.add(new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY ));

        for(Villager villager: villagersList){
            villager.sayHello();
        }

        Object objectDeckardCain = villagersList.get(5);
        Object objectAkara = villagersList.get(4);
        // Nie możemy bezpośrednio wywołać metod klasy ExtraordinaryVillager na zmiennych typu Object
        // objectDeckardCain.sayHello(); // Błąd kompilacji

        int counter = 0;
        while(Monsters.monstersHealth > 0){
            if(villagersList.get(counter).getHealth() > 0) {
                System.out.println(
                        "\nPotwory posiadaja jeszcze " + Monsters.monstersHealth + " punkty zycia\n" +
                                "Aktualnie walczacy osadnik to " + villagersList.get(counter)
                );
                performAnAction(villagersList.get(counter), Monsters.andariel);
                performAnAction(villagersList.get(counter), Monsters.blacksmith);
            }
            if(++counter == 6){
                counter = 0;
            }
        }

        villagersList.set(5, (ExtraordinaryVillager) objectDeckardCain);
        villagersList.set(4, (ExtraordinaryVillager) objectAkara);

        System.out.println("\nObozowisko ocalone!");
    }
    static void performAnAction(Villager villager, Monster monster){

        if(villager.getHealth() > 0){
            villager.attack(monster);

            if(monster.getHealth() > 0){
                monster.attack(villager);
            }
        }
    }
}
