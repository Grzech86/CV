package Nobilities.ex1.EggDrop.egg2;

public class EggDropMainV2 {
    public static void main(String[] args) {
        Floor[] floors = {
                new Floor(1, false),
                new Floor(2, false),
                new Floor(3, false),
                new Floor(4, true),
                new Floor(5, true),
                new Floor(6, true)
        };

        Building building = new Building(floors);
        int floorNumber = building.findCriticalFloor();

        System.out.println("egg drop problem solved: " + floorNumber);
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
}
