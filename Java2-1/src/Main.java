public class Main {
    public static void main(String[] args) {
        Creatures[] creatures = {new Human("Человек", 3, 400), new Cat("Кот", 5, 1000), new Robot("Робот", 1, 100)};
        Courses[] courses = {new Wall(3), new Treadmill(500)};
        for (Creatures cr : creatures) {
         for (Courses co : courses) {
            if (cr.isParticipant()) System.out.println(co.getResult(cr));
         }
         if (cr.isParticipant()) System.out.println(cr.getName() + " достиг финиша!\n************\n");
        }
    }
}
