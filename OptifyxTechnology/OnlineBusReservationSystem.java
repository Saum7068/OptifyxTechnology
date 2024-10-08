import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bus {
    private int busNumber;
    private String destination;
    private int totalSeats;
    private int bookedSeats;

    public Bus(int busNumber, String destination, int totalSeats) {
        this.busNumber = busNumber;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public int getBusNumber() { return busNumber; }
    public String getDestination() { return destination; }
    public int getTotalSeats() { return totalSeats; }
    public int getBookedSeats() { return bookedSeats; }
    public void bookSeat() { bookedSeats++; }
    public void cancelSeat() { bookedSeats--; }

    @Override
    public String toString() {
        return "Bus{" +
                "busNumber=" + busNumber +
                ", destination='" + destination + '\'' +
                ", totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                '}';
    }
}

class ReservationSystem {
    private List<Bus> buses = new ArrayList<>();

    public void addBus(Bus bus) {
        buses.add(bus);
        System.out.println("Bus added successfully!");
    }

    public void viewBuses() {
        if (buses.isEmpty()) {
            System.out.println("No buses available.");
        } else {
            for (Bus bus : buses) {
                System.out.println(bus);
            }
        }
    }

    public void bookSeat(int busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNumber() == busNumber) {
                if (bus.getBookedSeats() < bus.getTotalSeats()) {
                    bus.bookSeat();
                    System.out.println("Seat booked successfully!");
                } else {
                    System.out.println("No seats available!");
                }
                return;
            }
        }
        System.out.println("Bus not found!");
    }

    public void cancelSeat(int busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNumber() == busNumber) {
                if (bus.getBookedSeats() > 0) {
                    bus.cancelSeat();
                    System.out.println("Seat cancelled successfully!");
                } else {
                    System.out.println("No seats to cancel!");
                }
                return;
            }
        }
        System.out.println("Bus not found!");
    }
}

public class OnlineBusReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        while (true) {
            System.out.println("\nOnline Bus Reservation System");
            System.out.println("1. Add Bus");
            System.out.println("2. View Buses");
            System.out.println("3. Book Seat");
            System.out.println("4. Cancel Seat");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter bus number: ");
                    int busNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter total seats: ");
                    int totalSeats = scanner.nextInt();
                    reservationSystem.addBus(new Bus(busNumber, destination, totalSeats));
                    break;
                case 2:
                    reservationSystem.viewBuses();
                    break;
                case 3:
                    System.out.print("Enter bus number to book seat: ");
                    busNumber = scanner.nextInt();
                    reservationSystem.bookSeat(busNumber);
                    break;
                case 4:
                    System.out.print("Enter bus number to cancel seat: ");
                    busNumber = scanner.nextInt();
                    reservationSystem.cancelSeat(busNumber);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
