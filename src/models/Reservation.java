package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Reservation
 * this class is used to modelate the reservation object
 * 
 * @version 1.0
 * @since 1.0
 * 
 * @see Guest
 * 
 * @author JuanObandoDev
 */
public class Reservation {
    private int id;
    private String start_date;
    private String end_date;
    private int total;
    private String payment_method;
    private List<Guest> reservations;

    /**
     * Constructor method that creates a new reservation object
     * 
     * @param id
     * @param start_date
     * @param end_date
     * @param total
     * @param payment_method
     */
    public Reservation(int id, String start_date, String end_date, int total, String payment_method) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total = total;
        this.payment_method = payment_method;
        this.reservations = null;
    }

    /**
     * Method that returns the id of the reservation
     * 
     * @return int id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Method that adds a guest to the reservation List
     * 
     * @param guest
     */
    public void addGuest(Guest guest) {
        if (this.reservations == null) {
            this.reservations = new ArrayList<>();
        }
        this.reservations.add(guest);
    }

    /**
     * Method that returns the reservation List
     * 
     * @return List<Guest> reservations
     */
    public List<Guest> getReservations() {
        return this.reservations;
    }

    /**
     * Method that returns the start date of the reservation
     * 
     * @return String start_date
     */
    public String getStartDate() {
        return this.start_date;
    }

    /**
     * Method that returns the end date of the reservation
     * 
     * @return String end_date
     */
    public String getEndDate() {
        return this.end_date;
    }

    /**
     * Method that returns the total of the reservation
     * 
     * @return int total
     */
    public int getTotal() {
        return this.total;
    }

    /**
     * Method that returns the payment method of the reservation
     * 
     * @return String payment_method
     */
    public String getPaymentMethod() {
        return this.payment_method;
    }
}
