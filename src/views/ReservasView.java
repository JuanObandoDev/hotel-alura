package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controllers.ReservationController;
import models.Reservation;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.sql.SQLException;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import utils.MouseEvents;

@SuppressWarnings("serial")
public class ReservasView extends JFrame {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new ReservasView().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private final JPanel contentPane;
	private final JPanel panel;
	private final JPanel panel_1;
	private final JPanel btnexit;
	private final JPanel btnsiguiente;
	private final JPanel header;
	private final JPanel btnAtras;
	private final JLabel logo;
	private final JLabel imagenFondo;
	private final JLabel lblTitulo;
	private final JLabel lblCheckIn;
	private final JLabel lblCheckOut;
	private final JLabel lblFormaPago;
	private final JLabel lblValor;
	private final JLabel lblSiguiente;
	private final JLabel labelExit;
	private final JLabel labelAtras;
	private final JTextField txtValor;
	private final JComboBox<String> txtFormaPago;
	private final JSeparator separator_1_2;
	private final JSeparator separator_1_3;
	private final JSeparator separator_1_1;
	private final JSeparator separator_1;
	private static JDateChooser txtFechaEntrada;
	private static JDateChooser txtFechaSalida;
	private int[] coords = new int[2];
	private int[] location = new int[2];

	/**
	 * Create the frame.
	 */
	public ReservasView() {
		super("Reserva");
		this.contentPane = new JPanel();
		this.panel = new JPanel();
		this.panel_1 = new JPanel();
		this.btnexit = new JPanel();
		this.header = new JPanel();
		this.btnAtras = new JPanel();
		this.btnsiguiente = new JPanel();
		this.separator_1_2 = new JSeparator();
		this.separator_1_3 = new JSeparator();
		this.separator_1_1 = new JSeparator();
		this.separator_1 = new JSeparator();
		this.lblCheckIn = new JLabel("CHECK IN");
		this.lblCheckOut = new JLabel("CHECK OUT");
		this.lblFormaPago = new JLabel("FORMA DE PAGO");
		this.lblTitulo = new JLabel("RESERVAS");
		this.logo = new JLabel("");
		this.imagenFondo = new JLabel("");
		this.lblValor = new JLabel("VALOR");
		this.labelExit = new JLabel("X");
		this.labelAtras = new JLabel("<");
		this.lblSiguiente = new JLabel("SIGUIENTE");
		ReservasView.txtFechaEntrada = new JDateChooser();
		ReservasView.txtFechaSalida = new JDateChooser();
		this.txtValor = new JTextField();
		this.txtFormaPago = new JComboBox<>();

		configComponents();
		addComponents();
		configComponentEvents();
	}

	private void configComponents() {
		this.contentPane.setBackground(SystemColor.control);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);

		this.panel.setBorder(null);
		this.panel.setBackground(Color.WHITE);
		this.panel.setBounds(0, 0, 910, 560);
		this.panel.setLayout(null);

		this.separator_1_2.setForeground(SystemColor.textHighlight);
		this.separator_1_2.setBounds(68, 195, 289, 2);
		this.separator_1_2.setBackground(SystemColor.textHighlight);

		this.separator_1_3.setForeground(SystemColor.textHighlight);
		this.separator_1_3.setBackground(SystemColor.textHighlight);
		this.separator_1_3.setBounds(68, 453, 289, 2);

		this.separator_1_1.setForeground(SystemColor.textHighlight);
		this.separator_1_1.setBounds(68, 281, 289, 11);
		this.separator_1_1.setBackground(SystemColor.textHighlight);

		this.lblCheckIn.setForeground(SystemColor.textInactiveText);
		this.lblCheckIn.setBounds(68, 136, 169, 14);
		this.lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.lblCheckOut.setForeground(SystemColor.textInactiveText);
		this.lblCheckOut.setBounds(68, 221, 187, 14);
		this.lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.lblFormaPago.setForeground(SystemColor.textInactiveText);
		this.lblFormaPago.setBounds(68, 382, 187, 24);
		this.lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.lblTitulo.setBounds(109, 60, 219, 42);
		this.lblTitulo.setForeground(new Color(12, 138, 199));
		this.lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));

		this.panel_1.setBounds(428, 0, 482, 560);
		this.panel_1.setBackground(new Color(12, 138, 199));
		this.panel_1.setLayout(null);

		this.logo.setBounds(197, 68, 104, 107);
		this.logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));

		this.imagenFondo.setBounds(0, 140, 500, 409);
		this.imagenFondo.setBackground(Color.WHITE);
		this.imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));

		this.lblValor.setForeground(SystemColor.textInactiveText);
		this.lblValor.setBounds(72, 303, 196, 14);
		this.lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.separator_1.setForeground(SystemColor.textHighlight);
		this.separator_1.setBounds(68, 362, 289, 2);
		this.separator_1.setBackground(SystemColor.textHighlight);

		this.btnexit.setLayout(null);
		this.btnexit.setBackground(new Color(12, 138, 199));
		this.btnexit.setBounds(429, 0, 53, 36);

		this.labelExit.setForeground(Color.WHITE);
		this.labelExit.setBounds(0, 0, 53, 36);
		this.labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

		this.header.setBounds(0, 0, 910, 36);
		this.header.setLayout(null);
		this.header.setBackground(Color.WHITE);

		this.btnAtras.setLayout(null);
		this.btnAtras.setBackground(Color.WHITE);
		this.btnAtras.setBounds(0, 0, 53, 36);

		this.labelAtras.setBounds(0, 0, 53, 36);
		this.labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));

		this.lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblSiguiente.setForeground(Color.WHITE);
		this.lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.lblSiguiente.setBounds(0, 0, 122, 35);

		this.txtValor.setBackground(SystemColor.text);
		this.txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtValor.setForeground(Color.BLACK);
		this.txtValor.setBounds(78, 328, 63, 33);
		this.txtValor.setEditable(false);
		this.txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		this.txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.txtValor.setColumns(10);

		ReservasView.txtFechaSalida.getCalendarButton()
				.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		ReservasView.txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		ReservasView.txtFechaSalida.setBounds(68, 246, 289, 35);
		ReservasView.txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		ReservasView.txtFechaSalida.setBackground(Color.WHITE);
		ReservasView.txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		ReservasView.txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		ReservasView.txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		ReservasView.txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));

		ReservasView.txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		ReservasView.txtFechaEntrada.getCalendarButton()
				.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		ReservasView.txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		ReservasView.txtFechaEntrada.setBounds(68, 161, 289, 35);
		ReservasView.txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		ReservasView.txtFechaEntrada.setBackground(Color.WHITE);
		ReservasView.txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		ReservasView.txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		ReservasView.txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));

		this.txtFormaPago.setBounds(68, 417, 289, 38);
		this.txtFormaPago.setBackground(SystemColor.text);
		this.txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		this.txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.txtFormaPago.setModel(new DefaultComboBoxModel(
				new String[] { "Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo" }));

		this.btnsiguiente.setLayout(null);
		this.btnsiguiente.setBackground(SystemColor.textHighlight);
		this.btnsiguiente.setBounds(238, 493, 122, 35);
		this.btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}

	private void addComponents() {
		this.btnexit.add(this.labelExit);
		this.panel_1.add(this.btnexit);
		this.panel_1.add(this.imagenFondo);
		this.panel_1.add(this.logo);
		this.btnsiguiente.add(this.lblSiguiente);
		this.panel.add(this.btnsiguiente);
		this.panel.add(this.panel_1);
		this.btnAtras.add(this.labelAtras);
		this.header.add(this.btnAtras);
		this.panel.add(this.header);
		this.panel.add(ReservasView.txtFechaSalida);
		this.panel.add(ReservasView.txtFechaEntrada);
		this.panel.add(this.txtFormaPago);
		this.panel.add(this.txtValor);
		this.panel.add(this.separator_1);
		this.panel.add(this.lblValor);
		this.panel.add(this.lblTitulo);
		this.panel.add(this.lblFormaPago);
		this.panel.add(this.lblCheckOut);
		this.panel.add(this.lblCheckIn);
		this.panel.add(this.separator_1_1);
		this.panel.add(this.separator_1_3);
		this.panel.add(this.separator_1_2);
		this.contentPane.add(this.panel);
		setContentPane(this.contentPane);
	}

	private void configComponentEvents() {
		this.btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuPrincipal().setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(new Color(12, 138, 199));
				labelExit.setForeground(Color.white);
			}
		});
		this.header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				location = new MouseEvents().headerMouseDragged(e, coords);
				setLocation(location[0], location[1]);
			}
		});
		this.header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				coords = new MouseEvents().headerMousePressed(e);
			}
		});
		this.btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuUsuario().setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		ReservasView.txtFechaSalida.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			if (txtFechaEntrada.getDate() != null && txtFechaSalida.getDate() != null) {
				long diferencia = txtFechaSalida.getDate().getTime() - txtFechaEntrada.getDate().getTime();
				long dias = diferencia / (1000 * 60 * 60 * 24);
				txtValor.setText("$" + String.valueOf(dias * 1000));
			}
		});
		this.btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int value;
				if (ReservasView.txtFechaEntrada.getDate() == null || ReservasView.txtFechaSalida.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
					return;
				}
				try {
					value = Integer.valueOf(txtValor.getText().replace("$", ""));
				} catch (NumberFormatException ex) {
					return;
				}
				Reservation reservation = new Reservation(
						1,
						txtFechaEntrada.getDate().toString(),
						txtFechaSalida.getDate().toString(),
						value,
						txtFormaPago.getSelectedItem().toString());
				try {
					new ReservationController().save(reservation);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				new RegistroHuesped().setVisible(true);
				dispose();
			}
		});
	}
}
