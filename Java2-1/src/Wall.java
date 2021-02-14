public class Wall implements Courses{
    private int height;

    public Wall(int height) {
        this.height = height;
    }



    public String getResult (Creatures object) {
        if (isSuccess(object)) return object.getName() + " успешно перепрыгнул.";
        return object.getName() + " не смог перепрыгнуть, выбывает из соревнования.\n************\n";

    }

    public boolean isSuccess (Creatures object) {
        object.jump();
        if (object.getJumpLimit() >=height) return true;
        else {
            object.setParticipant(false);
            return false;
        }
    }
}
