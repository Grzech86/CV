package Nobilities.EggDrop.egg1;

public class Building {
    public final Floor[] floors;

    public Building(Floor[] floors) {
        this.floors = floors;
    }

    public int findLastNonCritical(Egg egg, int hop) {
        int possiblyNonCritical = 0;

        for(int i = hop; i < floors.length; i += hop) {
            Floor floor = floors[i];
            floor.drop(egg);

            if (egg.isBroken()) {
                break;
            }

            possiblyNonCritical = i;
        }

        return possiblyNonCritical;
    }

    public int preciselyFindCriticalFloor(Egg egg, int start) {
        for(int i = start; i < floors.length; i++) {
            floors[i].drop(egg);

            if (egg.isBroken()) {
                return i;
            }
        }

        return -1;
    }

    public int findCriticalFloor() {
        Egg egg1 = new Egg();
        Egg egg2 = new Egg();

        int startOfSegment = findLastNonCritical(egg1, 3);
        int criticalFloorIndex = preciselyFindCriticalFloor(egg2, startOfSegment);

        return floors[criticalFloorIndex].getFloorNumber();
    }
}
