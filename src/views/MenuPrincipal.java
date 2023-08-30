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

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	/**
	 * Launch the application.
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
	private Panel panel;
	private JPanel panel_1;
	private JPanel header;
	private JPanel btnexit;
	private JPanel btnLogin;
	private JLabel imagenFondo;
	private JLabel logo;
	private JLabel lblCopyR;
	private JLabel labelExit;
	private JLabel imagenLogin;
	private JLabel lblTitulo;
	private int xMouse;
	private int yMouse;

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);

		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 537);
		setContentPane(this.contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		this.panel = new Panel();
		this.panel.setBackground(SystemColor.window);
		this.panel.setBounds(0, 0, 910, 537);
		this.panel.setLayout(null);
		this.contentPane.add(this.panel);

		this.imagenFondo = new JLabel("");
		this.imagenFondo.setBounds(-50, 0, 732, 501);
		this.imagenFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/menu-img.png")));
		this.panel.add(this.imagenFondo);

		this.logo = new JLabel("");
		this.logo.setBounds(722, 80, 150, 156);
		this.logo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/aH-150px.png")));
		this.panel.add(this.logo);

		this.panel_1 = new JPanel();
		this.panel_1.setBounds(0, 500, 910, 37);
		this.panel_1.setBackground(new Color(12, 138, 199));
		this.panel_1.setLayout(null);
		this.panel.add(this.panel_1);

		this.lblCopyR = new JLabel("Development by JuanObando © 2023");
		this.lblCopyR.setBounds(315, 11, 284, 19);
		this.lblCopyR.setForeground(new Color(240, 248, 255));
		this.lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));
		this.panel_1.add(this.lblCopyR);

		this.header = new JPanel();
		this.header.setBounds(0, 0, 910, 36);
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
		this.panel.add(this.header);

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
		this.btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.btnexit.setBackground(Color.WHITE);
		this.btnexit.setBounds(857, 0, 53, 36);
		this.header.add(this.btnexit);

		this.btnLogin = new JPanel();
		this.btnLogin.setBounds(754, 300, 83, 70);
		this.btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		this.btnLogin.setLayout(null);
		this.btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.btnLogin.setBackground(SystemColor.window);
		this.panel.add(this.btnLogin);

		this.imagenLogin = new JLabel("");
		this.imagenLogin.setBounds(0, 0, 80, 70);
		this.imagenLogin.setHorizontalAlignment(SwingConstants.CENTER);
		this.imagenLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/login.png")));
		this.btnLogin.add(this.imagenLogin);

		this.lblTitulo = new JLabel("LOGIN");
		this.lblTitulo.setBounds(754, 265, 83, 24);
		this.lblTitulo.setBackground(SystemColor.window);
		this.lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblTitulo.setForeground(SystemColor.textHighlight);
		this.lblTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));
		this.panel.add(this.lblTitulo);
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
