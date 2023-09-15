package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import connections.ConnectionFactory;
import dao.GuestDAO;
import models.Guest;

/**
 * Class GuestController
 * this class is used to handle the guest data using the GuestDAO class
 * 
 * @version 1.0
 * @since 1.0
 * 
 * @see GuestDAO
 * @see Guest
 * @see ConnectionFactory
 * 
 * @autor JuanObandoDev
 */
public class GuestController {
    /**
     * Method that updates a guest object into the database
     * 
     * @param id
     * @param name
     * @param last_name
     * @param born_date
     * @param nacionality
     * @param phone
     * @return int resultSet
     * @throws SQLException
     */
    public int update(int id, String name, String last_name, String born_date, String nacionality, String phone)
            throws SQLException {
        final Connection conn = new ConnectionFactory().getConnection();
        final PreparedStatement ps = conn.prepareStatement(
                "UPDATE guests SET name = ?, last_name = ?, born_date = ?, nacionality = ?, phone = ? WHERE id = ?");
        try (conn) {
            try (ps) {
                ps.setString(1, name);
                ps.setString(2, last_name);
                ps.setString(3, born_date);
                ps.setString(4, nacionality);
                ps.setString(5, phone);
                ps.setInt(6, id);
                ps.execute();
            } catch (SQLException e) {
                throw e;
            }
        }
        return ps.getUpdateCount();
    }

    /**
     * Method that deletes a guest object from the database
     * 
     * @param id
     * @return int resultSet
     * @throws SQLException
     */
    public int delete(int id) throws SQLException {
        int result = 0;
        final Connection conn = new ConnectionFactory().getConnection();
        final PreparedStatement ps = conn.prepareStatement("DELETE FROM guests WHERE id = ?");
        try (conn) {
            try (ps) {
                ps.setInt(1, id);
                ps.execute();
                result = ps.getUpdateCount();
            } catch (SQLException e) {
                throw e;
            }
        }
        return result;
    }

    /**
     * Method that returns all guests from the database
     * 
     * @return List<Guest> guests
     * @throws SQLException
     */
    public List<Guest> getGuests() throws SQLException {
        return new GuestDAO(new ConnectionFactory().getConnection()).select();
    }

    /**
     * Method that returns all guests from the database by reservation_id
     * 
     * @param reservation_id
     * @return List<Guest> guests
     * @throws SQLException
     */
    public List<Guest> getGuests(int reservation_id) throws SQLException {
        return new GuestDAO(new ConnectionFactory().getConnection()).select(reservation_id);
    }

    /**
     * Method that returns all guests from the database by search
     * 
     * @param search
     * @return List<Guest> guests
     * @throws SQLException
     */
    public List<Guest> getGuestsBySearch(String search) throws SQLException {
        return new GuestDAO(new ConnectionFactory().getConnection()).getGuestsBySearch(search);
    }

    /**
     * Method that saves a guest object into the database
     * 
     * @param guest
     * @throws SQLException
     */
    public void save(Guest guest) throws SQLException {
        new GuestDAO(new ConnectionFactory().getConnection()).insert(guest);
    }
}
