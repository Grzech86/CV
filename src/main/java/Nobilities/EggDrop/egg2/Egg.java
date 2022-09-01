package Nobilities.EggDrop.egg2;

public class Egg {
    private boolean broken = false;

    public void brake() {
        broken = true;
    }

    public boolean isBroken() {
        return broken;
    }

    public boolean isNotBroken() {
        return !broken;
    }
}
