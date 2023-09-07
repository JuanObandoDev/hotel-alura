package models;

public class Guest {
    private int id;
    private String name;
    private String last_name;
    private String born_date;
    private String nacionality;
    private String phone;
    private int reservation_id;

    public Guest(int id, String name, String last_name, String born_date, String nacionality, String phone,
            int reservation_id) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.born_date = born_date;
        this.nacionality = nacionality;
        this.phone = phone;
        this.reservation_id = reservation_id;
    }

    public Guest(int id, String name, String last_name, String born_date, String nacionality, String phone) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.born_date = born_date;
        this.nacionality = nacionality;
        this.phone = phone;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public String getBornDate() {
        return this.born_date;
    }

    public String getNacionality() {
        return this.nacionality;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getReservationId() {
        return this.reservation_id;
    }

    public void setReservationId(int reservation_id) {
        this.reservation_id = reservation_id;
    }
}
