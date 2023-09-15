package models;

/**
 * Class Guest
 * this class is used to modelate the guest object
 * 
 * @version 1.0
 * @since 1.0
 * 
 * @author JuanObandoDev
 */
public class Guest {
    private int id;
    private String name;
    private String last_name;
    private String born_date;
    private String nationality;
    private String phone;
    private int reservation_id;

    /**
     * Constructor method with all params that creates a new guest object
     * 
     * @param id
     * @param name
     * @param last_name
     * @param born_date
     * @param nationality
     * @param phone
     * @param reservation_id
     */
    public Guest(int id, String name, String last_name, String born_date, String nationality, String phone,
            int reservation_id) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.born_date = born_date;
        this.nationality = nationality;
        this.phone = phone;
        this.reservation_id = reservation_id;
    }

    /**
     * Constructor method without reservation_id param that creates a new guest
     * object
     * 
     * @param id
     * @param name
     * @param last_name
     * @param born_date
     * @param nationality
     * @param phone
     */
    public Guest(int id, String name, String last_name, String born_date, String nationality, String phone) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.born_date = born_date;
        this.nationality = nationality;
        this.phone = phone;
    }

    /**
     * Method that returns the id of the guest
     * 
     * @return int id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Method that returns the name of the guest
     * 
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method that returns the last name of the guest
     * 
     * @return String last_name
     */
    public String getLastName() {
        return this.last_name;
    }

    /**
     * Method that returns the born date of the guest
     * 
     * @return String born_date
     */
    public String getBornDate() {
        return this.born_date;
    }

    /**
     * Method that returns the nationality of the guest
     * 
     * @return String nationality
     */
    public String getNationality() {
        return this.nationality;
    }

    /**
     * Method that returns the phone of the guest
     * 
     * @return String phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Method that returns the reservation id of the guest
     * 
     * @return int reservation_id
     */
    public int getReservationId() {
        return this.reservation_id;
    }

    /**
     * Method that sets the id of the guest
     * 
     * @param reservation_id
     */
    public void setReservationId(int reservation_id) {
        this.reservation_id = reservation_id;
    }
}
