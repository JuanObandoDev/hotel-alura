package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	/**
	 * Launch the application.
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
	private JPanel header;
	private JPanel btnAtras;
	private JPanel btnbuscar;
	private JPanel btnEditar;
	private JPanel btnEliminar;
	private JPanel btnexit;
	private JTabbedPane panel;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	private JLabel lblBuscar;
	private JLabel lblEditar;
	private JLabel lblEliminar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JSeparator separator_1_2;
	private JScrollPane scroll_table;
	private JScrollPane scroll_tableHuespedes;
	private int xMouse;
	private int yMouse;

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.WHITE);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);

		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		setContentPane(this.contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);

		this.txtBuscar = new JTextField();
		this.txtBuscar.setBounds(536, 127, 193, 31);
		this.txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.txtBuscar.setColumns(10);
		this.contentPane.add(this.txtBuscar);

		this.lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		this.lblNewLabel_4.setForeground(new Color(12, 138, 199));
		this.lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		this.lblNewLabel_4.setBounds(331, 62, 280, 42);
		this.contentPane.add(this.lblNewLabel_4);

		this.panel = new JTabbedPane(JTabbedPane.TOP);
		this.panel.setBackground(new Color(12, 138, 199));
		this.panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.panel.setBounds(20, 169, 865, 328);
		this.contentPane.add(this.panel);

		this.tbReservas = new JTable();
		this.tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));

		this.modelo = (DefaultTableModel) this.tbReservas.getModel();
		this.modelo.addColumn("Numero de Reserva");
		this.modelo.addColumn("Fecha Check In");
		this.modelo.addColumn("Fecha Check Out");
		this.modelo.addColumn("Valor");
		this.modelo.addColumn("Forma de Pago");

		this.scroll_table = new JScrollPane(this.tbReservas);
		this.scroll_table.setVisible(true);

		this.panel.addTab(
				"Reservas",
				new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")),
				this.scroll_table,
				null);

		this.tbHuespedes = new JTable();
		this.tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));

		this.modeloHuesped = (DefaultTableModel) this.tbHuespedes.getModel();
		this.modeloHuesped.addColumn("Número de Huesped");
		this.modeloHuesped.addColumn("Nombre");
		this.modeloHuesped.addColumn("Apellido");
		this.modeloHuesped.addColumn("Fecha de Nacimiento");
		this.modeloHuesped.addColumn("Nacionalidad");
		this.modeloHuesped.addColumn("Telefono");
		this.modeloHuesped.addColumn("Número de Reserva");

		this.scroll_tableHuespedes = new JScrollPane(this.tbHuespedes);
		this.scroll_tableHuespedes.setVisible(true);
		this.panel.addTab(
				"Huéspedes",
				new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				this.scroll_tableHuespedes,
				null);

		this.lblNewLabel_2 = new JLabel("");
		this.lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		this.lblNewLabel_2.setBounds(56, 51, 104, 107);
		this.contentPane.add(this.lblNewLabel_2);

		this.header = new JPanel();
		this.header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		this.header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		this.header.setLayout(null);
		this.header.setBackground(Color.WHITE);
		this.header.setBounds(0, 0, 910, 36);
		this.contentPane.add(this.header);

		this.btnAtras = new JPanel();
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
		this.btnAtras.setLayout(null);
		this.btnAtras.setBackground(Color.WHITE);
		this.btnAtras.setBounds(0, 0, 53, 36);
		this.header.add(this.btnAtras);

		this.labelAtras = new JLabel("<");
		this.labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		this.labelAtras.setBounds(0, 0, 53, 36);
		this.btnAtras.add(this.labelAtras);

		this.btnexit = new JPanel();
		this.btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuUsuario().setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		this.btnexit.setLayout(null);
		this.btnexit.setBackground(Color.WHITE);
		this.btnexit.setBounds(857, 0, 53, 36);
		this.header.add(this.btnexit);

		this.labelExit = new JLabel("X");
		this.labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelExit.setForeground(Color.BLACK);
		this.labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.labelExit.setBounds(0, 0, 53, 36);
		this.btnexit.add(this.labelExit);

		this.separator_1_2 = new JSeparator();
		this.separator_1_2.setForeground(new Color(12, 138, 199));
		this.separator_1_2.setBackground(new Color(12, 138, 199));
		this.separator_1_2.setBounds(539, 159, 193, 2);
		this.contentPane.add(this.separator_1_2);

		this.btnbuscar = new JPanel();
		this.btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// search method
			}
		});
		this.btnbuscar.setLayout(null);
		this.btnbuscar.setBackground(new Color(12, 138, 199));
		this.btnbuscar.setBounds(748, 125, 122, 35);
		this.btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(this.btnbuscar);

		this.lblBuscar = new JLabel("BUSCAR");
		this.lblBuscar.setBounds(0, 0, 122, 35);
		this.lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblBuscar.setForeground(Color.WHITE);
		this.lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.btnbuscar.add(this.lblBuscar);

		this.btnEditar = new JPanel();
		this.btnEditar.setLayout(null);
		this.btnEditar.setBackground(new Color(12, 138, 199));
		this.btnEditar.setBounds(635, 508, 122, 35);
		this.btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.contentPane.add(this.btnEditar);

		this.lblEditar = new JLabel("EDITAR");
		this.lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblEditar.setForeground(Color.WHITE);
		this.lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.lblEditar.setBounds(0, 0, 122, 35);
		this.btnEditar.add(this.lblEditar);

		this.btnEliminar = new JPanel();
		this.btnEliminar.setLayout(null);
		this.btnEliminar.setBackground(new Color(12, 138, 199));
		this.btnEliminar.setBounds(767, 508, 122, 35);
		this.btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.contentPane.add(this.btnEliminar);

		this.lblEliminar = new JLabel("ELIMINAR");
		this.lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblEliminar.setForeground(Color.WHITE);
		this.lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.lblEliminar.setBounds(0, 0, 122, 35);
		this.btnEliminar.add(this.lblEliminar);
	}

	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		this.xMouse = evt.getX();
		this.yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - this.xMouse, y - this.yMouse);
	}
}
