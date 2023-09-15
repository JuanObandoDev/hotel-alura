package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

/**
 * Class Exito
 * this class is the success message of the application
 * 
 * @version 1.0
 * @since 1.0
 * 
 * @extends JDialog
 * 
 * @author genesysaluralatam
 * @author JuanObandoDev
 */
@SuppressWarnings("serial")
public class Exito extends JDialog {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new Exito().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private final JPanel contentPanel;
	private final JPanel buttonPane;
	private final JButton okButton;
	private final JButton cancelButton;
	private final JLabel lblNewLabel;
	private final JLabel lblNewLabel_1;

	/**
	 * Create the dialog.
	 */
	public Exito() {
		this.contentPanel = new JPanel();
		this.buttonPane = new JPanel();
		this.lblNewLabel = new JLabel("");
		this.lblNewLabel_1 = new JLabel("Datos guardados satisfactoriamente");
		this.okButton = new JButton("OK");
		this.cancelButton = new JButton("Cancel");

		configComponents();
		addComponents();
		configComponentEvents();
	}

	/**
	 * Method that configures the events of the components
	 */
	private void configComponentEvents() {
		/**
		 * Event that closes the dialog and opens the main menu
		 */
		this.okButton.addActionListener((ActionEvent e) -> {
			new MenuUsuario().setVisible(true);
			dispose();
		});
		/**
		 * Event that closes the dialog and opens the main menu
		 */
		this.cancelButton.addActionListener((ActionEvent e) -> {
			new MenuUsuario().setVisible(true);
			dispose();
		});
	}

	/**
	 * Method that configures the components of the view
	 */
	private void configComponents() {
		this.contentPanel.setBackground(SystemColor.control);
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPanel.setLayout(null);

		this.lblNewLabel.setIcon(new ImageIcon(Exito.class.getResource("/imagenes/Ha-100px.png")));
		this.lblNewLabel.setBounds(123, 11, 100, 100);

		this.lblNewLabel_1.setForeground(new Color(12, 138, 199));
		this.lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		this.lblNewLabel_1.setBounds(27, 122, 322, 21);

		this.buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

		this.okButton.setActionCommand("OK");

		this.cancelButton.setActionCommand("Cancel");

		setIconImage(Toolkit.getDefaultToolkit().getImage(Exito.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 394, 226);
		getContentPane().setLayout(new BorderLayout());
		getRootPane().setDefaultButton(this.okButton);
		setLocationRelativeTo(null);
	}

	/**
	 * Method that adds the components to the view
	 */
	private void addComponents() {
		this.contentPanel.add(this.lblNewLabel);
		this.contentPanel.add(this.lblNewLabel_1);
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		this.buttonPane.add(this.cancelButton);
		this.buttonPane.add(this.okButton);
		getContentPane().add(this.buttonPane, BorderLayout.SOUTH);
	}
}
