package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import connections.ConnectionFactory;
import dao.GuestDAO;
import models.Guest;

public class GuestController {
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

    public List<Guest> getGuests() throws SQLException {
        return new GuestDAO(new ConnectionFactory().getConnection()).select();
    }

    public List<Guest> getGuests(int reservation_id) throws SQLException {
        return new GuestDAO(new ConnectionFactory().getConnection()).select(reservation_id);
    }

    public List<Guest> getGuestsBySearch(String search) throws SQLException {
        return new GuestDAO(new ConnectionFactory().getConnection()).getGuestsBySearch(search);
    }

    public void save(Guest guest) throws SQLException {
        new GuestDAO(new ConnectionFactory().getConnection()).insert(guest);
    }
}
