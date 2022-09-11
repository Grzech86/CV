package Nobilities.ex1.EggDrop.egg1;

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

    public static class Floor {
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

    public static class Egg {
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

    public static class Building {
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
}
