package controllers;

import java.sql.SQLException;
import java.util.List;

import connections.ConnectionFactory;
import dao.ReservationDAO;
import models.Reservation;

public class ReservationController {
    private final ReservationDAO reservationDAO;

    public ReservationController() {
        this.reservationDAO = new ReservationDAO(new ConnectionFactory().getConnection());
    }

    public List<Reservation> getReservations() throws SQLException {
        return this.reservationDAO.getReservations();
    }

    public List<Reservation> getReport() throws SQLException {
        return this.reservationDAO.getReservationsWithGuests();
    }

    public void save(Reservation reservation) throws SQLException {
        this.reservationDAO.insert(reservation);
    }
}
