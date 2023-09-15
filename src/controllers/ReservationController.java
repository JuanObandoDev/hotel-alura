package controllers;

import java.sql.SQLException;
import java.util.List;

import connections.ConnectionFactory;
import dao.ReservationDAO;
import models.Reservation;

/**
 * Class ReservationController
 * this class is used to handle the reservation data using the ReservationDAO
 * class
 * 
 * @version 1.0
 * @since 1.0
 * 
 * @see ReservationDAO
 * @see Reservation
 * @see ConnectionFactory
 * 
 * @autor JuanObandoDev
 */
public class ReservationController {
    private final ReservationDAO reservationDAO;

    /**
     * Constructor method that creates a new dao object and sets it to the class
     * attribute
     */
    public ReservationController() {
        this.reservationDAO = new ReservationDAO(new ConnectionFactory().getConnection());
    }

    /**
     * Method that returns all reservations from the database
     * 
     * @return List<Reservation> reservations
     * @throws SQLException
     */
    public List<Reservation> getReservations() throws SQLException {
        return this.reservationDAO.getReservations();
    }

    /**
     * Method that returns a list of reservations by search
     * 
     * @param search
     * @return List<Reservation> reservations
     * @throws SQLException
     */
    public List<Reservation> getReservationsBySearch(String search) throws SQLException {
        return this.reservationDAO.getReservationsBySearch(search);
    }

    /**
     * Method that returns a list of reservations with guests
     * 
     * @return List<Reservation> reservations
     * @throws SQLException
     */
    public List<Reservation> getReport() throws SQLException {
        return this.reservationDAO.getReservationsWithGuests();
    }

    /**
     * Method that returns the last reservation id added to the database
     * 
     * @return int id
     * @throws SQLException
     */
    public int getReservationId() throws SQLException {
        return this.reservationDAO.getLastReservationId();
    }

    /**
     * Method that remove a reservation from the database by id
     * 
     * @param id
     * @throws SQLException
     */
    public void deleteReservation(int id) throws SQLException {
        this.reservationDAO.delete(id);
    }

    /**
     * Method that save a reservation to the database
     * 
     * @param reservation
     * @throws SQLException
     */
    public void save(Reservation reservation) throws SQLException {
        this.reservationDAO.insert(reservation);
    }
}
