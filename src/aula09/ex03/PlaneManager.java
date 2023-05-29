package aula09.ex03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaneManager {
    private static Map<String, Plane> planes;

    public PlaneManager() {
        planes = new HashMap<>();
    }

    public void addPlane(Plane plane) {
        planes.put(plane.getId(), plane);
    }

    public void removePlane(String id) {
        if (!planes.containsKey(id))
            throw new IllegalArgumentException("Plane not found");
        planes.remove(id);
    }

    public Plane searchPlane(String id) {
        if (!planes.containsKey(id))
            return null;
        return planes.get(id);
    }

    public List<Plane> getCommercialPlanes() {
        if (planes.isEmpty()) {
            return null;
        } else {
            List<Plane> commercialPlanes = new ArrayList<>();
            for (Plane plane : planes.values()) {
                if (plane instanceof CommercialPlane) {
                    commercialPlanes.add(plane);
                }
            }
            return commercialPlanes;
        }
    }

    public List<Plane> getMilitaryPlanes() {
        if (planes.isEmpty()) {
            return null;
        } else {
            List<Plane> militaryPlanes = new ArrayList<>();
            for (Plane plane : planes.values()) {
                if (plane instanceof MilitaryPlane) {
                    militaryPlanes.add(plane);
                }
            }
            return militaryPlanes;
        }
    }

    public void printAllPlanes() {
        if (planes.isEmpty()) {
            System.out.println("No planes in the fleet");
        } else {
            for (Plane plane : planes.values()) {
                System.out.println(plane);
            }
        }
    }

    public List<Plane> getAllPlanes(){
        List<Plane> planesList = new ArrayList<>();
        if (planes.isEmpty())
            return null;
        else {
            for (Plane plane : planes.values()) {
                planesList.add(plane);
            }
            return planesList;
        }
    }

    public Plane getFastestPlane() {
        if (planes.isEmpty()) {
            return null;
        } else {
            Plane fastestPlane = null;
            for (Plane plane : planes.values()) {
                if (fastestPlane == null || plane.getMaxSpeed() > fastestPlane.getMaxSpeed()) {
                    fastestPlane = plane;
                }
            }
            return fastestPlane;
        }
    }
}
