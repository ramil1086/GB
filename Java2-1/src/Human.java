public class Human implements Creatures {

    private String name;
    private int jumpLimit;
    private int runLimit;
    private boolean participant = true;

    public boolean isParticipant() {
        return participant;
    }

    public Human(String name, int jumpLimit, int runLimit) {

        this.name = name;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    public String getName() {
        return name;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    public void setParticipant(boolean participant) {
        this.participant = participant;
    }

    @Override
    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public void jump() {
        System.out.println(name + " прыгает...");
    }

    @Override
    public void run() {
        System.out.println(name + " бежит...");
    }
}
