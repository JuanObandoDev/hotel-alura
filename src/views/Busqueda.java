package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.GuestController;
import controllers.ReservationController;
import models.Guest;
import models.Reservation;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import utils.MouseEvents;

/**
 * Class Busqueda
 * this class is the search menu of the application
 * 
 * @version 1.0
 * @since 1.0
 * 
 * @extends JFrame
 * 
 * @see controllers.GuestController
 * @see controllers.ReservationController
 * @see models.Guest
 * @see models.Reservation
 * @see utils.MouseEvents
 * 
 * @author genesysaluralatam
 * @author JuanObandoDev
 */
@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new Busqueda().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private final JPanel contentPane;
	private final JPanel header;
	private final JPanel btnAtras;
	private final JPanel btnbuscar;
	private final JPanel btnEditar;
	private final JPanel btnEliminar;
	private final JPanel btnexit;
	private final JTabbedPane panel;
	private final JTextField txtBuscar;
	private final JTable tbHuespedes;
	private final JTable tbReservas;
	private final DefaultTableModel modelo;
	private final DefaultTableModel modeloHuesped;
	private final JLabel labelAtras;
	private final JLabel labelExit;
	private final JLabel lblBuscar;
	private final JLabel lblEditar;
	private final JLabel lblEliminar;
	private final JLabel lblNewLabel_2;
	private final JLabel lblNewLabel_4;
	private final JSeparator separator_1_2;
	private JScrollPane scroll_table;
	private JScrollPane scroll_tableHuespedes;
	private int[] coords = new int[2];
	private int[] location = new int[2];

	/**
	 * Constructor method that init the components of the class
	 */
	public Busqueda() {
		this.contentPane = new JPanel();
		this.header = new JPanel();
		this.btnAtras = new JPanel();
		this.btnexit = new JPanel();
		this.btnbuscar = new JPanel();
		this.btnEditar = new JPanel();
		this.btnEliminar = new JPanel();
		this.txtBuscar = new JTextField();
		this.lblNewLabel_4 = new JLabel("BÚSQUEDA");
		this.lblNewLabel_2 = new JLabel("");
		this.labelAtras = new JLabel("<");
		this.labelExit = new JLabel("X");
		this.lblBuscar = new JLabel("BUSCAR");
		this.lblEditar = new JLabel("EDITAR");
		this.lblEliminar = new JLabel("ELIMINAR");
		this.tbReservas = new JTable();
		this.tbHuespedes = new JTable();
		this.modelo = (DefaultTableModel) this.tbReservas.getModel();
		this.modeloHuesped = (DefaultTableModel) this.tbHuespedes.getModel();
		this.panel = new JTabbedPane(JTabbedPane.TOP);
		this.separator_1_2 = new JSeparator();

		configComponents();
		configComponentEvents();
		addComponents();
	}

	/**
	 * Method that config the components of the class
	 */
	private void configComponents() {
		this.contentPane.setBackground(Color.WHITE);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);

		this.txtBuscar.setBounds(536, 127, 193, 31);
		this.txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.txtBuscar.setColumns(10);

		this.lblNewLabel_4.setForeground(new Color(12, 138, 199));
		this.lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		this.lblNewLabel_4.setBounds(331, 62, 280, 42);

		this.panel.setBackground(new Color(12, 138, 199));
		this.panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.panel.setBounds(20, 169, 865, 328);

		this.tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));

		this.modelo.addColumn("Numero de Reserva");
		this.modelo.addColumn("Fecha Check In");
		this.modelo.addColumn("Fecha Check Out");
		this.modelo.addColumn("Valor");
		this.modelo.addColumn("Forma de Pago");
		this.loadReservationTable();

		this.scroll_table = new JScrollPane(this.tbReservas);
		this.scroll_table.setVisible(true);

		this.tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));

		this.modeloHuesped.addColumn("Número de Huesped");
		this.modeloHuesped.addColumn("Nombre");
		this.modeloHuesped.addColumn("Apellido");
		this.modeloHuesped.addColumn("Fecha de Nacimiento");
		this.modeloHuesped.addColumn("Nacionalidad");
		this.modeloHuesped.addColumn("Telefono");
		this.modeloHuesped.addColumn("Número de Reserva");
		this.loadGuestTable();

		this.scroll_tableHuespedes = new JScrollPane(this.tbHuespedes);
		this.scroll_tableHuespedes.setVisible(true);

		this.lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		this.lblNewLabel_2.setBounds(56, 51, 104, 107);

		this.header.setLayout(null);
		this.header.setBackground(Color.WHITE);
		this.header.setBounds(0, 0, 910, 36);

		this.btnAtras.setLayout(null);
		this.btnAtras.setBackground(Color.WHITE);
		this.btnAtras.setBounds(0, 0, 53, 36);

		this.labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		this.labelAtras.setBounds(0, 0, 53, 36);

		this.btnexit.setLayout(null);
		this.btnexit.setBackground(Color.WHITE);
		this.btnexit.setBounds(857, 0, 53, 36);

		this.labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelExit.setForeground(Color.BLACK);
		this.labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.labelExit.setBounds(0, 0, 53, 36);

		this.separator_1_2.setForeground(new Color(12, 138, 199));
		this.separator_1_2.setBackground(new Color(12, 138, 199));
		this.separator_1_2.setBounds(539, 159, 193, 2);

		this.btnbuscar.setLayout(null);
		this.btnbuscar.setBackground(new Color(12, 138, 199));
		this.btnbuscar.setBounds(748, 125, 122, 35);
		this.btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		this.lblBuscar.setBounds(0, 0, 122, 35);
		this.lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblBuscar.setForeground(Color.WHITE);
		this.lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		this.btnEditar.setLayout(null);
		this.btnEditar.setBackground(new Color(12, 138, 199));
		this.btnEditar.setBounds(635, 508, 122, 35);
		this.btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		this.lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblEditar.setForeground(Color.WHITE);
		this.lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.lblEditar.setBounds(0, 0, 122, 35);

		this.btnEliminar.setLayout(null);
		this.btnEliminar.setBackground(new Color(12, 138, 199));
		this.btnEliminar.setBounds(767, 508, 122, 35);
		this.btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		this.lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblEliminar.setForeground(Color.WHITE);
		this.lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.lblEliminar.setBounds(0, 0, 122, 35);

		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
	}

	/**
	 * Method that config the events of the components
	 */
	private void configComponentEvents() {
		this.header.addMouseMotionListener(new MouseMotionAdapter() {
			/**
			 * Method that move the frame
			 */
			@Override
			public void mouseDragged(MouseEvent e) {
				location = new MouseEvents().headerMouseDragged(e, coords);
				setLocation(location[0], location[1]);
			}
		});
		this.header.addMouseListener(new MouseAdapter() {
			/**
			 * Method that get the coordinates of the frame
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				coords = new MouseEvents().headerMousePressed(e);
			}
		});
		this.btnAtras.addMouseListener(new MouseAdapter() {
			/**
			 * Method that returns to the main menu after login
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuUsuario().setVisible(true);
				dispose();
			}

			/**
			 * Method that change the color of the button when the mouse enter
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			/**
			 * Method that change the color of the button when the mouse is out
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		this.btnexit.addMouseListener(new MouseAdapter() {
			/**
			 * Method that close and returns to the main menu
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuUsuario().setVisible(true);
				dispose();
			}

			/**
			 * Method that change the color of the button when the mouse enter
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			/**
			 * Method that change the color of the button when the mouse is out
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		this.btnbuscar.addMouseListener(new MouseAdapter() {
			/**
			 * Method that search a reservation or guest
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				String search = txtBuscar.getText();
				if (search.isEmpty()) {
					loadReservationTable();
					loadGuestTable();
				} else {
					try {
						modelo.setRowCount(0);
						List<Reservation> reservations = new ReservationController().getReservationsBySearch(search);
						reservations.forEach(reservation -> modelo.addRow(new Object[] {
								reservation.getId(),
								convertToDate(reservation.getStartDate()),
								convertToDate(reservation.getEndDate()),
								reservation.getTotal(),
								reservation.getPaymentMethod()
						}));
						modeloHuesped.setRowCount(0);
						List<Guest> guests = new GuestController().getGuestsBySearch(search);
						guests.forEach(guest -> modeloHuesped.addRow(new Object[] {
								guest.getId(),
								guest.getName(),
								guest.getLastName(),
								convertToDate(guest.getBornDate()),
								guest.getNationality(),
								guest.getPhone(),
								guest.getReservationId()
						}));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Method that add the components to the frame
	 */
	private void addComponents() {
		this.panel.addTab(
				"Reservas",
				new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")),
				this.scroll_table,
				null);
		this.panel.addTab(
				"Huéspedes",
				new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				this.scroll_tableHuespedes,
				null);
		this.contentPane.add(this.panel);
		this.btnAtras.add(this.labelAtras);
		this.header.add(this.btnAtras);
		this.header.add(this.btnexit);
		this.contentPane.add(this.header);
		this.btnexit.add(this.labelExit);
		this.contentPane.add(this.separator_1_2);
		this.btnbuscar.add(this.lblBuscar);
		this.contentPane.add(this.btnbuscar);
		this.btnEditar.add(this.lblEditar);
		this.contentPane.add(this.btnEditar);
		this.btnEliminar.add(this.lblEliminar);
		this.contentPane.add(this.btnEliminar);
		this.contentPane.add(this.lblNewLabel_2);
		this.contentPane.add(this.lblNewLabel_4);
		this.contentPane.add(this.txtBuscar);
		setContentPane(this.contentPane);
	}

	/**
	 * Method that load the reservation table
	 */
	private void loadReservationTable() {
		try {
			List<Reservation> reservations = new ReservationController().getReservations();
			reservations.forEach(reservation -> this.modelo.addRow(new Object[] {
					reservation.getId(),
					convertToDate(reservation.getStartDate()),
					convertToDate(reservation.getEndDate()),
					reservation.getTotal(),
					reservation.getPaymentMethod()
			}));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that load the guest table
	 */
	private void loadGuestTable() {
		try {
			List<Guest> guests = new GuestController().getGuests();
			guests.forEach(guest -> this.modeloHuesped.addRow(new Object[] {
					guest.getId(),
					guest.getName(),
					guest.getLastName(),
					convertToDate(guest.getBornDate()),
					guest.getNationality(),
					guest.getPhone(),
					guest.getReservationId()
			}));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that convert a string date to a date format
	 */
	private String convertToDate(String strDate) {
		HashMap<String, String> months = new HashMap<>();
		months.put("Jan", "01");
		months.put("Feb", "02");
		months.put("Mar", "03");
		months.put("Apr", "04");
		months.put("May", "05");
		months.put("Jun", "06");
		months.put("Jul", "07");
		months.put("Aug", "08");
		months.put("Sep", "09");
		months.put("Oct", "10");
		months.put("Nov", "11");
		months.put("Dec", "12");
		String[] date = strDate.split(" ");
		String[] day = date[2].split(",");
		String month = months.get(date[1]);
		return day[0] + "-" + month + "-" + date[5];
	}
}
