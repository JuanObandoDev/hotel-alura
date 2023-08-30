package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new MenuUsuario().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private final JPanel contentPane;
	private JPanel header;
	private JPanel panelMenu;
	private JPanel btnRegistro;
	private JPanel btnBusqueda;
	private JPanel btnexit;
	private JPanel panelFecha;
	private JLabel labelExit;
	private JLabel lblBusquedaDeReservas;
	private JLabel lblNewLabel_2;
	private JLabel labelRegistro;
	private JLabel lblNewLabel_1;
	private JLabel labelFecha;
	private JLabel lblNewLabel;
	private JLabel labelDescripcion;
	private JLabel labelDescripcion_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
	private JSeparator separator;
	private int xMouse;
	private int yMouse;

	/**
	 * Create the frame.
	 */
	public MenuUsuario() {
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.WHITE);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);

		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		setContentPane(this.contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

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

		this.panelMenu = new JPanel();
		this.panelMenu.setBackground(new Color(12, 138, 199));
		this.panelMenu.setBounds(0, 0, 257, 609);
		this.panelMenu.setLayout(null);
		this.contentPane.add(this.panelMenu);

		this.lblNewLabel_2 = new JLabel("");
		this.lblNewLabel_2.setBounds(50, 58, 150, 150);
		this.lblNewLabel_2.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-150px.png")));
		this.panelMenu.add(this.lblNewLabel_2);

		this.btnRegistro = new JPanel();
		this.btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(118, 187, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(12, 138, 199));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new ReservasView().setVisible(true);
				dispose();
			}
		});
		this.btnRegistro.setBounds(0, 255, 257, 56);
		this.btnRegistro.setBackground(new Color(12, 138, 199));
		this.btnRegistro.setLayout(null);
		this.panelMenu.add(btnRegistro);

		this.labelRegistro = new JLabel("Registro de reservas");
		this.labelRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
		this.labelRegistro.setForeground(SystemColor.text);
		this.labelRegistro.setBounds(25, 11, 205, 34);
		this.labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		this.btnRegistro.add(this.labelRegistro);

		this.btnBusqueda = new JPanel();
		this.btnBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusqueda.setBackground(new Color(118, 187, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBusqueda.setBackground(new Color(12, 138, 199));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new Busqueda().setVisible(true);
				dispose();
			}
		});
		this.btnBusqueda.setBounds(0, 312, 257, 56);
		this.btnBusqueda.setBackground(new Color(12, 138, 199));
		this.btnBusqueda.setLayout(null);
		this.panelMenu.add(this.btnBusqueda);

		this.lblBusquedaDeReservas = new JLabel("Búsqueda");
		this.lblBusquedaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
		this.lblBusquedaDeReservas.setBounds(27, 11, 200, 34);
		this.lblBusquedaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		this.lblBusquedaDeReservas.setForeground(Color.WHITE);
		this.lblBusquedaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.btnBusqueda.add(this.lblBusquedaDeReservas);

		this.separator = new JSeparator();
		this.separator.setBounds(26, 219, 201, 2);
		this.panelMenu.add(this.separator);

		this.header.setLayout(null);
		this.header.setBackground(Color.WHITE);
		this.header.setBounds(0, 0, 944, 36);
		this.contentPane.add(this.header);

		this.btnexit = new JPanel();
		this.labelExit = new JLabel("X");
		this.labelExit.setBounds(0, 0, 53, 36);
		this.labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.btnexit.add(this.labelExit);
		this.btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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
		this.btnexit.setBounds(891, 0, 53, 36);
		this.header.add(this.btnexit);

		this.panelFecha = new JPanel();
		this.panelFecha.setBackground(new Color(118, 187, 223));
		this.panelFecha.setBounds(256, 84, 688, 121);
		this.panelFecha.setLayout(null);
		this.contentPane.add(this.panelFecha);

		this.lblNewLabel_1 = new JLabel("Sistema de reservas Hotel Alura");
		this.lblNewLabel_1.setBounds(180, 11, 356, 42);
		this.lblNewLabel_1.setForeground(Color.WHITE);
		this.lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 24));
		this.panelFecha.add(this.lblNewLabel_1);

		this.labelFecha = new JLabel("New label");
		this.labelFecha.setBounds(35, 64, 294, 36);
		this.labelFecha.setForeground(Color.WHITE);
		this.labelFecha.setFont(new Font("Roboto", Font.PLAIN, 33));
		this.labelFecha.setText("Hoy es " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		this.panelFecha.add(this.labelFecha);

		this.lblNewLabel = new JLabel("Bienvenido");
		this.lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 24));
		this.lblNewLabel.setBounds(302, 234, 147, 46);
		this.contentPane.add(this.lblNewLabel);

		this.labelDescripcion = new JLabel(
				"<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huespédes del hotel   </body></html>");
		this.labelDescripcion.setFont(new Font("Roboto", Font.PLAIN, 17));
		this.labelDescripcion.setBounds(312, 291, 598, 66);
		this.contentPane.add(this.labelDescripcion);

		this.labelDescripcion_1 = new JLabel(
				"<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>");
		this.labelDescripcion_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		this.labelDescripcion_1.setBounds(311, 345, 569, 88);
		this.contentPane.add(this.labelDescripcion_1);

		this.lblNewLabel_3 = new JLabel("- Registro de Reservas y Huéspedes");
		this.lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 17));
		this.lblNewLabel_3.setBounds(312, 444, 295, 27);
		this.contentPane.add(this.lblNewLabel_3);

		this.lblNewLabel_3_1 = new JLabel("- Edición de Reservas y Huéspedes existentes");
		this.lblNewLabel_3_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		this.lblNewLabel_3_1.setBounds(312, 482, 355, 27);
		this.contentPane.add(this.lblNewLabel_3_1);

		this.lblNewLabel_3_2 = new JLabel("- Eliminar todo tipo de registros");
		this.lblNewLabel_3_2.setFont(new Font("Roboto", Font.PLAIN, 17));
		this.lblNewLabel_3_2.setBounds(312, 520, 295, 27);
		this.contentPane.add(this.lblNewLabel_3_2);
	}

	private void headerMousePressed(MouseEvent evt) {
		this.xMouse = evt.getX();
		this.yMouse = evt.getY();
	}

	private void headerMouseDragged(MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - this.xMouse, y - this.yMouse);
	}
}
