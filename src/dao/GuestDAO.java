package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Guest;

public class GuestDAO {
    private final Connection conn;

    public GuestDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Guest guest) throws SQLException {
        try (this.conn) {
            final PreparedStatement ps = this.conn.prepareStatement(
                    "INSERT INTO guests (name, last_name, born_date, nacionality, phone, reservation_id) VALUES (?, ?, ?, ?, ?, ?)");
            try (ps) {
                ps.setString(1, guest.getName());
                ps.setString(2, guest.getLastName());
                ps.setString(3, guest.getBornDate());
                ps.setString(4, guest.getNacionality());
                ps.setString(5, guest.getPhone());
                ps.setInt(6, guest.getReservationId());
                ps.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Guest> select() throws SQLException {
        List<Guest> guests = new ArrayList<>();
        try (this.conn) {
            final PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM guests");
            try (ps) {
                ps.execute();
                final ResultSet rs = ps.getResultSet();
                try (rs) {
                    while (rs.next()) {
                        guests.add(new Guest(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("last_name"),
                                rs.getString("born_date"),
                                rs.getString("nacionality"),
                                rs.getString("phone"),
                                rs.getInt("reservation_id")));
                    }
                }
            }
        }
        return guests;
    }

    public List<Guest> select(int reservation_id) throws SQLException {
        List<Guest> guests = new ArrayList<>();
        try (this.conn) {
            final PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM guests WHERE reservation_id = ?");
            try (ps) {
                ps.setInt(1, reservation_id);
                ps.execute();
                final ResultSet rs = ps.getResultSet();
                try (rs) {
                    if (rs.next()) {
                        guests.add(new Guest(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("last_name"),
                                rs.getString("born_date"),
                                rs.getString("nacionality"),
                                rs.getString("phone"),
                                rs.getInt("reservation_id")));
                    }
                }
            }
        }
        return guests;
    }
}
