import java.util.ArrayList;

public class Box <T> {
    private  ArrayList listOfFruits;
    T obj;
    float weight;

    public Box() {
        listOfFruits = new ArrayList<>();
    }

    public void addFruit(T fruit, int quantity) {
        obj = fruit;
        for (int i = 0; i < quantity; i++) {
            listOfFruits.add(fruit);
        }
    }

        public float getWeight() {
            if (listOfFruits.size() == 0) weight = 0;
            else if (obj instanceof Apple) {
                weight = 1.0f * listOfFruits.size();
            } else if (obj instanceof Orange) {
                weight = 1.5f * listOfFruits.size();
            }
            return weight;
        }

        public boolean compare (Box<?> box) {
            return this.equals(box);
        }

        public void moveFruits (Box<T> box) {
        box.addFruit(obj, listOfFruits.size());
        listOfFruits.clear();
        }

    }

