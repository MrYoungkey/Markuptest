class Room {
    private double width;
    private double length;
    private int floor;

    public Room() {
        this.width = 10;
        this.length = 12.5;
        this.floor = 1;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        }
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Room(double length, double width, int floor) {
        setLength(length);
        setWidth(width);
        this.floor = floor;
    }

    @Override
    public String toString() {
        return length + " x " + width + ", floor " + floor;
    }
}

class Classroom extends Room {
    private int numStudents;

    public Classroom(double length, double width, int floor, int numStudents) {
        super(length, width, floor);
        this.numStudents = numStudents;
    }

    @Override
    public String toString() {
        return super.toString() + ", capacity = " + numStudents + " students";
    }
}

public class Q1 {
    public static void main(String[] args) {
        Room room1 = new Room();
        System.out.println("Room 1: " + room1);

        Room room2 = new Room(8.5, 11.5, 2);
        System.out.println("Room 2: " + room2);

        Classroom classroom1 = new Classroom(20, 15, 3, 30);
        System.out.println("Classroom 1: " + classroom1);

        Classroom classroom2 = new Classroom(18, 12, 2, 25);
        System.out.println("Classroom 2: " + classroom2);

        Room[] rooms = {room1, room2, classroom1, classroom2};
        Classroom[] classrooms = filterClassrooms(rooms);

        System.out.println("\nClassrooms:");
        for (Classroom classroom : classrooms) {
            System.out.println(classroom);
        }
    }

    public static Classroom[] filterClassrooms(Room[] rooms) {
        int count = 0;
        for (Room room : rooms) {
            if (room instanceof Classroom) {
                count++;
            }
        }

        Classroom[] classrooms = new Classroom[count];
        int index = 0;
        for (Room room : rooms) {
            if (room instanceof Classroom) {
                classrooms[index++] = (Classroom) room;
            }
        }

        return classrooms;
    }
}

