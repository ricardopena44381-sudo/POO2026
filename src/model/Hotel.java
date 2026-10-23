package model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String id;
    private String name;
    private String address;
    private List<Room> rooms = new ArrayList<>();

    public Hotel(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public List<Room> getRooms() { return rooms; }
}
