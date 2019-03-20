package com.example.demo.common.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houlei
 * @DESC:Zoo类
 * @create 2019-02-22 13:42
 */
public class Zoo {
    //用来存储所有的动物
    private List<Animal> animals = new ArrayList<>();
    //用来储存动物增加的额监听器
    private List<AnimalAddedListener> animalAddedListeners = new ArrayList<>();
    public void addAnimal(Animal animal){
        animals.add(animal);
        notifyAnimalAddedListeners(animal);
    }
    public void registerAddedAnimalListener(AnimalAddedListener animalAddedListener){
        animalAddedListeners.add(animalAddedListener);
    }
    public void removeAnimalListener(AnimalAddedListener animalAddedListener){
        animalAddedListeners.remove(animalAddedListener);
    }
    public void notifyAnimalAddedListeners(Animal animal){
        this.animalAddedListeners.forEach(listener->listener.updateAnimalAdded(animal));
    }
}
