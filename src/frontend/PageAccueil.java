package frontend;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PageAccueil extends JFrame {

	private JPanel contentPane;
	private JTextField txtTerminotronNeuronal;


	/**
	 * Create the frame.
	 */
	public PageAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#03a9f4"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setSize(550,400); 
		
		JPanel vide = new JPanel();
		vide.setBackground(Color.decode("#03a9f4"));
		contentPane.add(vide, BorderLayout.NORTH);
		
		JPanel vide_1 = new JPanel();
		vide_1.setBackground(Color.decode("#03a9f4"));
		contentPane.add(vide_1, BorderLayout.SOUTH);
		
		JPanel vide_2 = new JPanel();
		vide_2.setBackground(Color.decode("#03a9f4"));
		contentPane.add(vide_2, BorderLayout.WEST);
		
		JPanel vide_3 = new JPanel();
		vide_3.setBackground(Color.decode("#03a9f4"));
		contentPane.add(vide_3, BorderLayout.EAST);
		
		JPanel panneau = new JPanel();
		contentPane.add(panneau, BorderLayout.CENTER);
		panneau.setLayout(new BorderLayout(0, 0));
		
		JPanel vide_4 = new JPanel();
		vide_4.setBackground(Color.decode("#01579b"));
		panneau.add(vide_4, BorderLayout.NORTH);
		
		JPanel vide_5 = new JPanel();
		vide_5.setBackground(Color.decode("#01579b"));
		panneau.add(vide_5, BorderLayout.SOUTH);
		
		JPanel vide_6 = new JPanel();
		vide_6.setBackground(Color.decode("#01579b"));
		panneau.add(vide_6, BorderLayout.WEST);
		
		JPanel vide_7 = new JPanel();
		vide_7.setBackground(Color.decode("#01579b"));
		panneau.add(vide_7, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panneau.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#01579b"));
		panel_4.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#01579b"));
		panel_4.add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#01579b"));
		panel_4.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#01579b"));
		panel_4.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_4.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		txtTerminotronNeuronal = new JTextField();
		txtTerminotronNeuronal.setEditable(false);
		txtTerminotronNeuronal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtTerminotronNeuronal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTerminotronNeuronal.setBackground(new Color(255, 165, 0));
		txtTerminotronNeuronal.setText("TERMINOTRON ");
		txtTerminotronNeuronal.setColumns(10);
		panel_5.add(txtTerminotronNeuronal, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.decode("#01579b"));
		panel_6.add(panel_8, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PageAccueil.class.getResource("/ressources/imageIntro.jpg")));
		panel_8.add(lblNewLabel);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9, BorderLayout.SOUTH);
		
		JPanel bouton_lancer_logiciel = new JPanel();
		bouton_lancer_logiciel.setBackground(Color.WHITE);
		panel_5.add(bouton_lancer_logiciel, BorderLayout.NORTH);
		bouton_lancer_logiciel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Chercher Sara Conor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		bouton_lancer_logiciel.add(btnNewButton);
		
		
	}

}
