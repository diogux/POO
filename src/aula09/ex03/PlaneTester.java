package aula09.ex03;

import utils.*;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager planeManager = new PlaneManager();
        int choice;

        do {
            System.out.println("\nPlane Fleet Menu:");
            System.out.println("1. Add a plane to the fleet");
            System.out.println("2. Remove a plane from the fleet");
            System.out.println("3. Search for a plane");
            System.out.println("4. Print summary of all planes in the fleet");
            System.out.println("5. Print list of all commercial planes in the fleet");
            System.out.println("6. Print list of all military planes in the fleet");
            System.out.println("7. Print the fastest plane in the fleet");
            System.out.println("0. Exit");

            choice = UserInput.newInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addPlane(planeManager);
                    break;
                case 2:
                    removePlane(planeManager);
                    break;
                case 3:
                    searchPlane(planeManager);
                    break;
                case 4:
                    printAllPlanes(planeManager);
                    break;
                case 5:
                    printCommercialPlanes(planeManager);
                    break;
                case 6:
                    printMilitaryPlanes(planeManager);
                    break;
                case 7:
                    printFastestPlane(planeManager);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

    }

    private static void addPlane(PlaneManager planeManager) {
        String id = UserInput.newString("Enter the plane's id: ");
        String model = UserInput.newString("Enter the plane's model: ");
        String manufacturer = UserInput.newString("Enter the plane's manufacturer: ");
        int maxSpeed = UserInput.newInt("Enter the plane's MaxSpeed: ");
        int year = UserInput.intInRange("Enter the plane's year: ", 1903, 2023);
        int maxPassengers = UserInput.newInt("Enter the maximum number of passengers: ");
        int choice = UserInput.intInRange("Enter 1 for a commercial plane or 2 for a military plane: ", 1, 2);
        if (choice == 1) {
            int numCrew = UserInput.newInt("Enter the number of crew: ");
            planeManager.addPlane(new CommercialPlane(id, model, manufacturer, maxSpeed, year, maxPassengers, numCrew));
        } else {
            int numWeapons = UserInput.newInt("Enter the number of weapons: ");
            planeManager
                    .addPlane(new MilitaryPlane(id, manufacturer, model, year, maxPassengers, maxSpeed, numWeapons));
        }
    }

    private static void removePlane(PlaneManager planeManager) {
        String id = UserInput.newString("Enter the plane's id: ");
        try {
            planeManager.removePlane(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchPlane(PlaneManager planeManager) {
        String id = UserInput.newString("Enter the plane's id: ");
        Plane plane = planeManager.searchPlane(id);
        if (plane == null) {
            System.out.println("Plane not found");
        } else {
            System.out.println(plane);
        }
    }

    private static void printAllPlanes(PlaneManager planeManager) {
        planeManager.printAllPlanes();
    }

    private static void printCommercialPlanes(PlaneManager planeManager) {
        for (Plane plane : planeManager.getCommercialPlanes()) {
            System.out.println(plane);
        }
    }

    private static void printMilitaryPlanes(PlaneManager planeManager) {
        for (Plane plane : planeManager.getMilitaryPlanes()) {
            System.out.println(plane);
        }
    }

    private static void printFastestPlane(PlaneManager planeManager) {
        System.out.println("Fastest plane:\n " + planeManager.getFastestPlane());
    }
}
