import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();

        orangeBox.addFruit(new Orange(), 4);
        appleBox.addFruit(new Apple(), 7);

        System.out.println("Вес коробки апельсинов " + orangeBox.getWeight());
        System.out.println("Вес коробки яблок " + appleBox.getWeight());

        appleBox.addFruit(new Apple(), 1);
//        appleBox.addFruit(new Orange(),1);

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(appleBox));

        Box<Orange> emptyOrangeBox = new Box<>();
        orangeBox.moveFruits(emptyOrangeBox);
        System.out.println(orangeBox.getWeight());
        System.out.println(emptyOrangeBox.getWeight());


        Object[] array = {1,2,3,4,5};
        changeTwoArrayElements (array, 1,3);
        for (Object o : array) {
            System.out.println(o);
        }

        ArrayList list = arrayToArrayList (array);
        System.out.println(list);
    }

    public static void changeTwoArrayElements (Object[] array, int firstElement, int secondElement ) {
        Object temp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = temp;
    }
    public static ArrayList arrayToArrayList (Object[] array) {
        ArrayList list = new ArrayList();
        for (Object o : array) {
            list.add(o);
        }
        return list;
    }
    }

