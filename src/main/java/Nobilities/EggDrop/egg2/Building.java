package Nobilities.EggDrop.egg2;

public class Building {
    public final Floor[] floors;

    public Building(Floor[] floors) {
        this.floors = floors;
    }


    public int findCriticalFloor() {
        Egg egg1 = new Egg();
//        Egg egg2 = new Egg();

        for(Floor floor : floors) {
            floor.drop(egg1);
            if (egg1.isBroken()) {
                return floor.getFloorNumber();
            }
         }

        return -1;
    }
}
