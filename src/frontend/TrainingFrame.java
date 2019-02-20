package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;

public class TrainingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtFentreRglages;
	private JPanel panneau_actions;
	private JPanel panel;
	private JButton retoursMain;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JTextField caracteristiques;
	private JRadioButton car1;
	private JRadioButton car2;
	private JRadioButton car3;
	private JPanel panel_6;
	private JTextField parametres;
	private JRadioButton rdbtnParametre;
	private JRadioButton rdbtnParametre_1;
	private JRadioButton rdbtnParametre_2;
	private JPanel panel_7;
	private JTextField sauvegarde;
	private JPanel panel_8;
	private JTextField charger;
	private JEditorPane editorPane;
	private JTextField txtEntrezLeNom;
	private JPanel panel_9;
	private JTextField valider;
	private JButton btnNewButton;
	private JPanel panel_10;



	/**
	 * Create the frame.
	 */
	public TrainingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.pack();
		this.setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		
		
		JPanel panneau_titre = new JPanel();
		panneau_titre.setBackground(Color.BLUE);
		contentPane.add(panneau_titre, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setText("Nom Application");
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setBackground(Color.BLUE);
		panneau_titre.add(textField);
		
		txtFentreRglages = new JTextField();
		txtFentreRglages.setText("Fen\u00EAtre R\u00E9glages");
		txtFentreRglages.setHorizontalAlignment(SwingConstants.CENTER);
		txtFentreRglages.setColumns(20);
		txtFentreRglages.setBackground(Color.CYAN);
		panneau_titre.add(txtFentreRglages);
		
		retoursMain = new JButton("Retour fen\u00EAtre principale");
		retoursMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		panneau_titre.add(retoursMain);
		
		panneau_actions = new JPanel();
		contentPane.add(panneau_actions, BorderLayout.CENTER);
		panneau_actions.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panneau_actions.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		
		panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(10, 0, 0, 0));
		
		caracteristiques = new JTextField();
		caracteristiques.setBackground(Color.LIGHT_GRAY);
		caracteristiques.setText("Caracteristiques");
		panel_5.add(caracteristiques);
		caracteristiques.setColumns(10);
		
		car1 = new JRadioButton("caracteristique 1");
		panel_5.add(car1);
		
		car2 = new JRadioButton("caracteristique 2");
		panel_5.add(car2);
		
		car3 = new JRadioButton("caracteristique 3");
		panel_5.add(car3);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		
		panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(10, 0, 0, 0));
		
		parametres = new JTextField();
		parametres.setBackground(Color.LIGHT_GRAY);
		parametres.setText("Parametres");
		parametres.setColumns(10);
		panel_6.add(parametres);
		
		rdbtnParametre = new JRadioButton("parametre 1");
		panel_6.add(rdbtnParametre);
		
		rdbtnParametre_1 = new JRadioButton("parametre 2");
		panel_6.add(rdbtnParametre_1);
		
		rdbtnParametre_2 = new JRadioButton("parametre 3");
		panel_6.add(rdbtnParametre_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3);
		
		panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(10, 1, 0, 0));
		
		sauvegarde = new JTextField();
		sauvegarde.setBackground(Color.LIGHT_GRAY);
		sauvegarde.setText("Sauvegarder");
		panel_7.add(sauvegarde);
		sauvegarde.setColumns(10);
		
		txtEntrezLeNom = new JTextField();
		txtEntrezLeNom.setText("Entrez le nom :");
		panel_7.add(txtEntrezLeNom);
		txtEntrezLeNom.setColumns(10);
		
		editorPane = new JEditorPane();
		panel_7.add(editorPane);
		
		panel_9 = new JPanel();
		panel_7.add(panel_9);
		
		panel_10 = new JPanel();
		panel_7.add(panel_10);
		
		valider = new JTextField();
		valider.setBackground(Color.LIGHT_GRAY);
		valider.setText("Accepter modifications :");
		panel_7.add(valider);
		valider.setColumns(10);
		
		btnNewButton = new JButton("valider");
		panel_7.add(btnNewButton);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4);
		
		panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new GridLayout(10, 1, 0, 0));
		
		charger = new JTextField();
		charger.setBackground(Color.LIGHT_GRAY);
		charger.setText("Charger");
		charger.setColumns(10);
		panel_8.add(charger);
	}

}
