package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import utils.MouseEvents;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new MenuPrincipal().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private final JPanel contentPane;
	private final Panel panel;
	private final JPanel panel_1;
	private final JPanel header;
	private final JPanel btnexit;
	private final JPanel btnLogin;
	private final JLabel imagenFondo;
	private final JLabel logo;
	private final JLabel lblCopyR;
	private final JLabel labelExit;
	private final JLabel imagenLogin;
	private final JLabel lblTitulo;
	private int[] coords = new int[2];
	private int[] location = new int[2];

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		this.contentPane = new JPanel();
		this.panel = new Panel();
		this.panel_1 = new JPanel();
		this.header = new JPanel();
		this.btnexit = new JPanel();
		this.btnLogin = new JPanel();
		this.imagenFondo = new JLabel("");
		this.logo = new JLabel("");
		this.lblCopyR = new JLabel("Development by JuanObando © 2023");
		this.labelExit = new JLabel("X");
		this.imagenLogin = new JLabel("");
		this.lblTitulo = new JLabel("LOGIN");

		configComponents();
		addComponents();
		configComponentEvents();
	}

	private void configComponentEvents() {
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
		this.btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
	}

	private void configComponents() {
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);

		this.panel.setBackground(SystemColor.window);
		this.panel.setBounds(0, 0, 910, 537);
		this.panel.setLayout(null);

		this.panel_1.setBounds(0, 500, 910, 37);
		this.panel_1.setBackground(new Color(12, 138, 199));
		this.panel_1.setLayout(null);

		this.imagenFondo.setBounds(-50, 0, 732, 501);
		this.imagenFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/menu-img.png")));

		this.logo.setBounds(722, 80, 150, 156);
		this.logo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/aH-150px.png")));

		this.lblCopyR.setBounds(315, 11, 284, 19);
		this.lblCopyR.setForeground(new Color(240, 248, 255));
		this.lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));

		this.header.setBounds(0, 0, 910, 36);
		this.header.setLayout(null);
		this.header.setBackground(Color.WHITE);

		this.btnexit.setLayout(null);
		this.btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.btnexit.setBackground(Color.WHITE);
		this.btnexit.setBounds(857, 0, 53, 36);

		this.labelExit.setBounds(0, 0, 53, 36);
		this.labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

		this.btnLogin.setBounds(754, 300, 83, 70);
		this.btnLogin.setLayout(null);
		this.btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.btnLogin.setBackground(SystemColor.window);

		this.imagenLogin.setBounds(0, 0, 80, 70);
		this.imagenLogin.setHorizontalAlignment(SwingConstants.CENTER);
		this.imagenLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/login.png")));

		this.lblTitulo.setBounds(754, 265, 83, 24);
		this.lblTitulo.setBackground(SystemColor.window);
		this.lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblTitulo.setForeground(SystemColor.textHighlight);
		this.lblTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));

		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 537);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}

	private void addComponents() {
		this.panel.add(this.imagenFondo);
		this.panel.add(this.logo);
		this.panel_1.add(this.lblCopyR);
		this.panel.add(this.panel_1);
		this.btnexit.add(this.labelExit);
		this.header.add(this.btnexit);
		this.panel.add(this.header);
		this.panel.add(this.lblTitulo);
		this.btnLogin.add(this.imagenLogin);
		this.panel.add(this.btnLogin);
		this.contentPane.add(this.panel);
		setContentPane(this.contentPane);
	}
}
