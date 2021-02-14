public class Treadmill implements Courses{
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }




    public String getResult (Creatures object) {
        if (isSuccess(object)) return object.getName() + " успешно пробежал.";
        return object.getName() + " не смог пробежать, выбывает из соревания.\n************\n";

    }

    public boolean isSuccess (Creatures object) {
        object.run();
        if (object.getRunLimit() >= length) return true;
        else {
            object.setParticipant(false);
            return false;
        }
    }
}
