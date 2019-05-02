package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Aide extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtAide;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aide frame = new Aide();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aide() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		setSize(800, 600);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); // permet d'�viter la fermeture du programme si
																// l'utilisateur clique sur la croix de fermeture de la
																// fen�tre d'aide

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 87, 155));
		panel.add(panel_1, BorderLayout.NORTH);

		textField = new JTextField();
		textField.setText("TERMINOTRON");
		textField.setForeground(Color.WHITE);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.BLUE);
		panel_1.add(textField);

		txtAide = new JTextField();
		txtAide.setText("Aide");
		txtAide.setHorizontalAlignment(SwingConstants.CENTER);
		txtAide.setEditable(false);
		txtAide.setColumns(20);
		txtAide.setBackground(new Color(179, 229, 252));
		panel_1.add(txtAide);

		JButton bouton_fermeture = new JButton("Fermer l'aide");
		bouton_fermeture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(bouton_fermeture);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(3, 169, 244));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JButton imageAide = new JButton("");
		imageAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		imageAide.setIcon(new ImageIcon(Aide.class.getResource("/ressources/imageAide3.jpg")));
		panel_2.add(imageAide);
	}

}
