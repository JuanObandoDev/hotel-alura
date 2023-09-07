package models;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int id;
    private String start_date;
    private String end_date;
    private int total;
    private String payment_method;
    private List<Guest> reservations;

    public Reservation(int id, String start_date, String end_date, int total, String payment_method) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total = total;
        this.payment_method = payment_method;
        this.reservations = null;
    }

    public int getId() {
        return this.id;
    }

    public void addGuest(Guest guest) {
        if (this.reservations == null) {
            this.reservations = new ArrayList<>();
        }
        this.reservations.add(guest);
    }

    public List<Guest> getReservations() {
        return this.reservations;
    }

    public String getStartDate() {
        return this.start_date;
    }

    public String getEndDate() {
        return this.end_date;
    }

    public int getTotal() {
        return this.total;
    }

    public String getPaymentMethod() {
        return this.payment_method;
    }
}
