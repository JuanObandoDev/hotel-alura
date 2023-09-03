package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import utils.MouseEvents;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new RegistroHuesped().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private final JPanel contentPane;
	private final JPanel header;
	private final JPanel btnAtras;
	private final JPanel btnguardar;
	private final JPanel btnexit;
	private final JPanel panel;
	private final JLabel imagenFondo;
	private final JLabel logo;
	private final JLabel labelGuardar;
	private final JLabel lblTitulo;
	private final JLabel lblNombre;
	private final JLabel lblApellido;
	private final JLabel lblFechaN;
	private final JLabel lblNacionalidad;
	private final JLabel lblTelefono;
	private final JLabel lblNumeroReserva;
	private final JLabel labelExit;
	private final JLabel labelAtras;
	private final JSeparator separator_1_2;
	private final JSeparator separator_1_2_1;
	private final JSeparator separator_1_2_2;
	private final JSeparator separator_1_2_3;
	private final JSeparator separator_1_2_4;
	private final JSeparator separator_1_2_5;
	private final JTextField txtNombre;
	private final JTextField txtApellido;
	private final JTextField txtTelefono;
	private final JTextField txtNreserva;
	private final JDateChooser txtFechaN;
	private final JComboBox<Format> txtNacionalidad;
	private int[] coords = new int[2];
	private int[] location = new int[2];

	/**
	 * Create the frame.
	 */
	public RegistroHuesped() {
		this.contentPane = new JPanel();
		this.header = new JPanel();
		this.btnAtras = new JPanel();
		this.btnguardar = new JPanel();
		this.panel = new JPanel();
		this.btnexit = new JPanel();
		this.labelAtras = new JLabel("<");
		this.lblNombre = new JLabel("NOMBRE");
		this.lblApellido = new JLabel("APELLIDO");
		this.lblFechaN = new JLabel("FECHA DE NACIMIENTO");
		this.lblNacionalidad = new JLabel("NACIONALIDAD");
		this.lblTelefono = new JLabel("TELÉFONO");
		this.lblTitulo = new JLabel("REGISTRO HUÉSPED");
		this.lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
		this.labelGuardar = new JLabel("GUARDAR");
		this.imagenFondo = new JLabel("");
		this.logo = new JLabel("");
		this.labelExit = new JLabel("X");
		this.txtNombre = new JTextField();
		this.txtApellido = new JTextField();
		this.txtTelefono = new JTextField();
		this.txtNreserva = new JTextField();
		this.txtFechaN = new JDateChooser();
		this.txtNacionalidad = new JComboBox<>();
		this.separator_1_2 = new JSeparator();
		this.separator_1_2_1 = new JSeparator();
		this.separator_1_2_2 = new JSeparator();
		this.separator_1_2_3 = new JSeparator();
		this.separator_1_2_4 = new JSeparator();
		this.separator_1_2_5 = new JSeparator();

		configComponents();
		configComponentEvents();
		addComponents();
	}

	private void configComponents() {
		this.contentPane.setBackground(SystemColor.text);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);

		this.header.setBounds(0, 0, 910, 36);
		this.header.setLayout(null);
		this.header.setBackground(SystemColor.text);
		this.header.setOpaque(false);
		this.header.setBounds(0, 0, 910, 36);

		this.btnAtras.setLayout(null);
		this.btnAtras.setBackground(new Color(12, 138, 199));
		this.btnAtras.setBounds(0, 0, 53, 36);

		this.labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelAtras.setForeground(Color.WHITE);
		this.labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		this.labelAtras.setBounds(0, 0, 53, 36);

		this.txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.txtNombre.setBounds(560, 135, 285, 33);
		this.txtNombre.setBackground(Color.WHITE);
		this.txtNombre.setColumns(10);
		this.txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		this.txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.txtApellido.setBounds(560, 204, 285, 33);
		this.txtApellido.setColumns(10);
		this.txtApellido.setBackground(Color.WHITE);
		this.txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		this.txtFechaN.setBounds(560, 278, 285, 36);
		this.txtFechaN.getCalendarButton()
				.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/icon-reservas.png")));
		this.txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
		this.txtFechaN.setDateFormatString("yyyy-MM-dd");

		this.txtNacionalidad.setBounds(560, 350, 289, 36);
		this.txtNacionalidad.setBackground(SystemColor.text);
		this.txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] { "afgano-afgana", "alemán-alemana",
				"árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana",
				"brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china",
				"colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana",
				"danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña",
				"escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia",
				"etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa",
				"griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa",
				"hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní",
				"irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana",
				"laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí",
				"mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa",
				"panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa",
				"puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca",
				"suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana",
				"uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita" }));

		this.lblNombre.setBounds(562, 119, 253, 14);
		this.lblNombre.setForeground(SystemColor.textInactiveText);
		this.lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.lblApellido.setBounds(560, 189, 255, 14);
		this.lblApellido.setForeground(SystemColor.textInactiveText);
		this.lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.lblFechaN.setBounds(560, 256, 255, 14);
		this.lblFechaN.setForeground(SystemColor.textInactiveText);
		this.lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.lblNacionalidad.setBounds(560, 326, 255, 14);
		this.lblNacionalidad.setForeground(SystemColor.textInactiveText);
		this.lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.lblTelefono.setBounds(562, 406, 253, 14);
		this.lblTelefono.setForeground(SystemColor.textInactiveText);
		this.lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.txtTelefono.setBounds(560, 424, 285, 33);
		this.txtTelefono.setColumns(10);
		this.txtTelefono.setBackground(Color.WHITE);
		this.txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		this.lblTitulo.setBounds(606, 55, 234, 42);
		this.lblTitulo.setForeground(new Color(12, 138, 199));
		this.lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 20));

		this.lblNumeroReserva.setBounds(560, 474, 253, 14);
		this.lblNumeroReserva.setForeground(SystemColor.textInactiveText);
		this.lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		this.txtNreserva.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.txtNreserva.setBounds(560, 495, 285, 33);
		this.txtNreserva.setColumns(10);
		this.txtNreserva.setBackground(Color.WHITE);
		this.txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		this.separator_1_2.setBounds(560, 170, 289, 2);
		this.separator_1_2.setForeground(new Color(12, 138, 199));
		this.separator_1_2.setBackground(new Color(12, 138, 199));

		this.separator_1_2_1.setBounds(560, 240, 289, 2);
		this.separator_1_2_1.setForeground(new Color(12, 138, 199));
		this.separator_1_2_1.setBackground(new Color(12, 138, 199));

		this.separator_1_2_2.setBounds(560, 314, 289, 2);
		this.separator_1_2_2.setForeground(new Color(12, 138, 199));
		this.separator_1_2_2.setBackground(new Color(12, 138, 199));

		this.separator_1_2_3.setBounds(560, 386, 289, 2);
		this.separator_1_2_3.setForeground(new Color(12, 138, 199));
		this.separator_1_2_3.setBackground(new Color(12, 138, 199));

		this.separator_1_2_4.setBounds(560, 457, 289, 2);
		this.separator_1_2_4.setForeground(new Color(12, 138, 199));
		this.separator_1_2_4.setBackground(new Color(12, 138, 199));

		this.separator_1_2_5.setBounds(560, 529, 289, 2);
		this.separator_1_2_5.setForeground(new Color(12, 138, 199));
		this.separator_1_2_5.setBackground(new Color(12, 138, 199));

		this.btnguardar.setBounds(723, 560, 122, 35);
		this.btnguardar.setLayout(null);
		this.btnguardar.setBackground(new Color(12, 138, 199));
		this.btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		this.labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelGuardar.setForeground(Color.WHITE);
		this.labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.labelGuardar.setBounds(0, 0, 122, 35);

		this.panel.setBounds(0, 0, 489, 634);
		this.panel.setBackground(new Color(12, 138, 199));
		this.panel.setLayout(null);

		this.imagenFondo.setBounds(0, 121, 479, 502);
		this.imagenFondo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/registro.png")));

		this.logo.setBounds(194, 39, 104, 107);
		this.logo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/Ha-100px.png")));

		this.btnexit.setBounds(857, 0, 53, 36);
		this.btnexit.setLayout(null);
		this.btnexit.setBackground(Color.WHITE);

		this.labelExit.setBounds(0, 0, 53, 36);
		this.labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelExit.setForeground(SystemColor.black);
		this.labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}

	private void configComponentEvents() {
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
				new ReservasView().setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}
		});
		this.btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// save huesped
			}
		});
		this.btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuPrincipal().setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.RED);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
	}

	private void addComponents() {
		this.contentPane.add(this.header);
		this.header.add(this.btnAtras);
		this.btnAtras.add(this.labelAtras);
		this.contentPane.add(this.txtNombre);
		this.contentPane.add(this.txtApellido);
		this.contentPane.add(this.txtFechaN);
		this.contentPane.add(this.txtNacionalidad);
		this.contentPane.add(this.lblNombre);
		this.contentPane.add(this.lblApellido);
		this.contentPane.add(this.lblFechaN);
		this.contentPane.add(this.lblNacionalidad);
		this.contentPane.add(this.lblTelefono);
		this.contentPane.add(this.txtTelefono);
		this.contentPane.add(this.lblTitulo);
		this.contentPane.add(this.lblNumeroReserva);
		this.contentPane.add(this.txtNreserva);
		this.contentPane.add(this.separator_1_2);
		this.contentPane.add(this.separator_1_2_1);
		this.contentPane.add(this.separator_1_2_2);
		this.contentPane.add(this.separator_1_2_3);
		this.contentPane.add(this.separator_1_2_4);
		this.contentPane.add(this.separator_1_2_5);
		this.contentPane.add(this.btnguardar);
		this.btnguardar.add(this.labelGuardar);
		this.contentPane.add(this.panel);
		this.panel.add(this.imagenFondo);
		this.panel.add(this.logo);
		this.header.add(this.btnexit);
		this.btnexit.add(this.labelExit);
		setContentPane(this.contentPane);
	}
}
