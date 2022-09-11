package Nobilities.ex1.EggDrop;

public class EggDrop {
    public static void main(String[] args) {


        Building building = new Building(40);
        Bucket bucket = new Bucket(new Egg(), new Egg());
        Egg egg = new Egg();
        Floor floor = new Floor(building.floor(100).isTooHigh());


    }
}


class Floor {
    private boolean tooHigh;

    public Floor(boolean b) {
        tooHigh = b;
    }

    public boolean isTooHigh() {
        return tooHigh;
    }

}

class Building {
    private final int criticalFloor;
    private Floor low = new Floor(false);
    private Floor high = new Floor(true);

    Building(int criticalFloor) {
        this.criticalFloor = criticalFloor;
    }

    Floor floor(int n) {
        return (n < criticalFloor) ? low : high;
    }

    public void drop(Egg egg, int n) {
        if (floor(n).isTooHigh()) {
            egg.brake();

        }
    }

}


class Egg {
    private boolean broken;

    public boolean isBroken() {
        return broken;
    }

    public void brake() {
        broken = true;
    }

}

class Bucket {
    public Bucket(Egg egg, Egg egg1) {

    }

    public Egg getNext() {
        return null;
    }
}

