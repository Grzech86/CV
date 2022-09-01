package Nobilities.EggDrop.egg1;

public class Floor {
    private final int n;
    private final boolean critical;

    public Floor(int n, boolean critical) {
        this.n = n;
        this.critical = critical;
    }

    public void drop(Egg egg) {
        if (critical) {
            egg.brake();
        }
    }


    public int getFloorNumber() {
        return n;
    }
}
