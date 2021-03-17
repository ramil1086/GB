

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

    }
}
