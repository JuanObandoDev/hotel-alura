package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import utils.MouseEvents;

public class Login extends JFrame {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new Login().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private final JPanel contentPane;
	private final JPanel panel;
	private final JPanel panel_1;
	private final JPanel btnexit;
	private final JPanel btnLogin;
	private final JPanel header;
	private final JLabel imgHotel;
	private final JLabel labelExit;
	private final JLabel labelTitulo;
	private final JLabel LabelUsuario;
	private final JLabel lblContrasea;
	private final JLabel lblNewLabel;
	private final JLabel lblNewLabel_1;
	private final JTextField txtUsuario;
	private final JPasswordField txtContrasena;
	private final JSeparator separator;
	private final JSeparator separator_1;
	private int[] coords = new int[2];
	private int[] location = new int[2];

	/**
	 * Create the frame.
	 */
	public Login() {
		this.contentPane = new JPanel();
		this.panel = new JPanel();
		this.panel_1 = new JPanel();
		this.btnexit = new JPanel();
		this.btnLogin = new JPanel();
		this.header = new JPanel();
		this.imgHotel = new JLabel("");
		this.labelExit = new JLabel("X");
		this.labelTitulo = new JLabel("INICIAR SESIÓN");
		this.LabelUsuario = new JLabel("USUARIO");
		this.lblContrasea = new JLabel("CONTRASEÑA");
		this.lblNewLabel_1 = new JLabel("");
		this.lblNewLabel = new JLabel("ENTRAR");
		this.txtUsuario = new JTextField();
		this.txtContrasena = new JPasswordField();
		this.separator = new JSeparator();
		this.separator_1 = new JSeparator();

		configComponents();
		addComponents();
		configComponentEvents();
	}

	private void validateLogin(String user, String password) {
		String Usuario = "admin";
		String Contraseña = "admin";
		if (user.equals(Usuario) && password.equals(Contraseña)) {
			new MenuUsuario().setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Usuario o Contraseña no válidos");
		}
	}

	private void configComponentEvents() {
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
				btnexit.setBackground(new Color(12, 138, 199));
				labelExit.setForeground(Color.white);
			}
		});
		this.txtContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtContrasena.getPassword()).equals("********")) {
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.black);
				}
				if (txtUsuario.getText().isEmpty()) {
					txtUsuario.setText("Ingrese su nombre de usuario");
					txtUsuario.setForeground(Color.gray);
				}
			}
		});
		this.txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.black);
				}
				if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
					txtContrasena.setText("********");
					txtContrasena.setForeground(Color.gray);
				}
			}
		});
		this.btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				validateLogin(txtUsuario.getText(), String.valueOf(txtContrasena.getPassword()));
			}
		});
		this.header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				location = new MouseEvents().headerMouseDragged(e, new int[] { coords[0], coords[1] });
				setLocation(location[0], location[1]);
			}
		});
		this.header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				coords = new MouseEvents().headerMousePressed(e);
			}
		});
	}

	private void configComponents() {
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);

		this.panel.setBounds(0, 0, 788, 527);
		this.panel.setBackground(Color.WHITE);
		this.panel.setLayout(null);

		this.panel_1.setBackground(new Color(12, 138, 199));
		this.panel_1.setBounds(484, 0, 304, 527);
		this.panel_1.setLayout(null);

		this.imgHotel.setBounds(0, 0, 304, 538);
		this.imgHotel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/img-hotel-login-.png")));

		this.labelExit.setBounds(0, 0, 53, 36);
		this.labelExit.setForeground(SystemColor.text);
		this.labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		this.labelExit.setHorizontalAlignment(SwingConstants.CENTER);

		this.btnexit.setBounds(251, 0, 53, 36);
		this.btnexit.setBackground(new Color(12, 138, 199));
		this.btnexit.setLayout(null);
		this.btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		this.txtContrasena.setText("********");
		this.txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		this.txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.txtContrasena.setBounds(65, 353, 324, 32);

		this.txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.txtUsuario.setText("Ingrese su nombre de usuario");
		this.txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		this.txtUsuario.setBounds(65, 256, 324, 32);
		this.txtUsuario.setColumns(10);

		this.separator.setBackground(new Color(0, 120, 215));
		this.separator.setBounds(65, 292, 324, 2);

		this.labelTitulo.setForeground(SystemColor.textHighlight);
		this.labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		this.labelTitulo.setBounds(65, 149, 202, 26);

		this.separator_1.setBackground(SystemColor.textHighlight);
		this.separator_1.setBounds(65, 393, 324, 2);

		this.LabelUsuario.setForeground(SystemColor.textInactiveText);
		this.LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		this.LabelUsuario.setBounds(65, 219, 107, 26);

		this.lblContrasea.setForeground(SystemColor.textInactiveText);
		this.lblContrasea.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		this.lblContrasea.setBounds(65, 316, 140, 26);

		this.btnLogin.setBackground(SystemColor.textHighlight);
		this.btnLogin.setBounds(65, 431, 122, 44);
		this.btnLogin.setLayout(null);
		this.btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		this.lblNewLabel.setBounds(0, 0, 122, 44);
		this.lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		this.lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imagenes/lOGO-50PX.png")));
		this.lblNewLabel_1.setBounds(65, 65, 48, 59);

		this.header.setBackground(SystemColor.window);
		this.header.setBounds(0, 0, 784, 36);
		this.header.setLayout(null);

		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		setLocationRelativeTo(null);
	}

	private void addComponents() {
		this.btnexit.add(this.labelExit);
		this.panel_1.add(this.btnexit);
		this.panel_1.add(this.imgHotel);
		this.panel.add(this.panel_1);
		this.panel.add(this.header);
		this.btnLogin.add(this.lblNewLabel);
		this.panel.add(this.btnLogin);
		this.panel.add(this.lblNewLabel_1);
		this.panel.add(this.separator);
		this.panel.add(this.labelTitulo);
		this.panel.add(this.lblContrasea);
		this.panel.add(this.txtContrasena);
		this.panel.add(this.LabelUsuario);
		this.panel.add(this.txtUsuario);
		this.panel.add(this.separator_1);
		this.contentPane.add(this.panel);
		setContentPane(this.contentPane);
	}
}
