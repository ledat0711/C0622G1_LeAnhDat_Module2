package animal_edible.controller;

import animal_edible.model.animal.Animal;
import animal_edible.model.animal.Chicken;
import animal_edible.model.animal.Tiger;
import animal_edible.model.edible.Edible;
import animal_edible.model.fruit.Apple;
import animal_edible.model.fruit.Fruit;
import animal_edible.model.fruit.Orange;

public class MainController {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken){
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits){
            System.out.println(fruit.howToEat());
        }
    }
}
