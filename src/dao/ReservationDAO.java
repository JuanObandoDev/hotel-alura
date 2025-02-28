package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Guest;
import models.Reservation;

/**
 * Class ReservationDAO
 * this class is used to handle the reservation data
 * 
 * @version 1.0
 * @since 1.0
 * 
 * @see models.Reservation
 * @see models.Guest
 * 
 * @author JuanObandoDev
 */
public class ReservationDAO {
    private final Connection conn;

    /**
     * Constructor method that receives a connection as param and sets it to the
     * class attribute
     * 
     * @param conn
     */
    public ReservationDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Method that returns a reservation object by id
     * 
     * @param id
     * @return int id
     * @throws SQLException
     */
    public int getReservation(String id) throws SQLException {
        final PreparedStatement ps = this.conn.prepareStatement(
                "SELECT id FROM reservations WHERE id = ?");
        try (ps) {
            ps.setString(1, id);
            final ResultSet rs = ps.executeQuery();
            try (rs) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    /**
     * Method that returns all reservations
     * 
     * @return List<Reservation> reservations
     * @throws SQLException
     */
    public List<Reservation> getReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        final PreparedStatement ps = this.conn.prepareStatement(
                "SELECT * FROM reservations");
        try (ps) {
            final ResultSet rs = ps.executeQuery();
            try (rs) {
                while (rs.next()) {
                    reservations.add(new Reservation(
                            rs.getInt("id"),
                            rs.getString("start_date"),
                            rs.getString("end_date"),
                            rs.getInt("total"),
                            rs.getString("payment_method")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservations;
    }

    /**
     * Method that returns all reservations with guests
     * 
     * @return List<Reservation> reservations
     * @throws SQLException
     */
    public List<Reservation> getReservationsWithGuests() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        final PreparedStatement ps = this.conn.prepareStatement(
                "SELECT R.id, R.start_date, R.end_date, R.total, R.payment_method, G.id, G.name, G.last_name, G.born_date, G.nacionality, G.phone FROM reservations AS R INNER JOIN guests AS G ON R.id = G.reservation_id");
        try (ps) {
            final ResultSet rs = ps.executeQuery();
            try (rs) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String start_date = rs.getString("start_date");
                    Reservation reservation = reservations.stream().filter(rsrv -> {
                        return rsrv.getId() == id;
                    }).findAny().orElseGet(() -> {
                        Reservation rsrv = null;
                        try {
                            rsrv = new Reservation(
                                    id,
                                    start_date,
                                    rs.getString("end_date"),
                                    rs.getInt("total"),
                                    rs.getString("payment_method"));
                            reservations.add(rsrv);
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        return rsrv;
                    });
                    reservation.addGuest(new Guest(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("last_name"),
                            rs.getString("born_date"),
                            rs.getString("nacionality"),
                            rs.getString("phone")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservations;
    }

    /**
     * Method that returns all reservations by search
     * 
     * @param search
     * @return List<Reservation> reservations
     * @throws SQLException
     */
    public List<Reservation> getReservationsBySearch(String search) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        final PreparedStatement ps = this.conn.prepareStatement(
                "SELECT * FROM reservations WHERE id LIKE ? OR start_date LIKE ? OR end_date LIKE ? OR total LIKE ? OR payment_method LIKE ?");
        try (ps) {
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");
            ps.setString(4, "%" + search + "%");
            ps.setString(5, "%" + search + "%");
            final ResultSet rs = ps.executeQuery();
            try (rs) {
                while (rs.next()) {
                    reservations.add(new Reservation(
                            rs.getInt("id"),
                            rs.getString("start_date"),
                            rs.getString("end_date"),
                            rs.getInt("total"),
                            rs.getString("payment_method")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservations;
    }

    /**
     * Method that returns the last reservation id added
     * 
     * @return int id
     * @throws SQLException
     */
    public int getLastReservationId() throws SQLException {
        final PreparedStatement ps = this.conn.prepareStatement(
                "SELECT id FROM reservations ORDER BY id DESC LIMIT 1");
        try (ps) {
            final ResultSet rs = ps.executeQuery();
            try (rs) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    /**
     * Method that delete a reservation by id
     * 
     * @param id
     * @throws SQLException
     */
    public void delete(int id) throws SQLException {
        final PreparedStatement ps = this.conn.prepareStatement(
                "DELETE FROM reservations WHERE id = ?");
        try (ps) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method that insert a reservation
     * 
     * @param reservation
     * @throws SQLException
     */
    public void insert(Reservation reservation) throws SQLException {
        final PreparedStatement ps = this.conn.prepareStatement(
                "INSERT INTO reservations (start_date, end_date, total, payment_method) VALUES (?, ?, ?, ?)");
        try (ps) {
            ps.setString(1, reservation.getStartDate());
            ps.setString(2, reservation.getEndDate());
            ps.setInt(3, reservation.getTotal());
            ps.setString(4, reservation.getPaymentMethod());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
