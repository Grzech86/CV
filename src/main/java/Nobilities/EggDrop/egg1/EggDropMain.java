package Nobilities.EggDrop.egg1;

public class EggDropMain {
    public static void main(String[] args) {
        Floor[] floors = {
                new Floor(1, false),
                new Floor(2, false),
                new Floor(3, false),
                new Floor(4, false),
                new Floor(5, false),
                new Floor(6, false),
                new Floor(7, false),
                new Floor(8, true),
        };

        Building building = new Building(floors);
        int floorNumber = building.findCriticalFloor();

        System.out.println("egg drop problem solved: " + floorNumber);
    }
}
