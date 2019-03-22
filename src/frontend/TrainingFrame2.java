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
import javax.swing.ButtonGroup;

import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JRadioButtonMenuItem;

public class TrainingFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtFentreRglages;
	private JPanel panneau_actions;
	private JButton retoursMain;
	private JPanel organisationPanneauTitre;
	private JPanel panel_11;
	private JPanel bord1;
	private JPanel bord2;
	private JPanel principal;
	private JPanel bord3;
	private JPanel panneau_choix;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JRadioButton perceptron;
	private JRadioButton neuronnes;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;



	/**
	 * Create the frame.
	 */
	public TrainingFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#01579b"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.pack();
		this.setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		
		organisationPanneauTitre = new JPanel();
		contentPane.add(organisationPanneauTitre, BorderLayout.NORTH);
		organisationPanneauTitre.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panneau_titre = new JPanel();
		organisationPanneauTitre.add(panneau_titre, BorderLayout.NORTH);
		panneau_titre.setBackground(Color.decode("#01579b"));
		
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
		txtFentreRglages.setBackground(Color.decode("#b3e5fc"));
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
		
		panel_11 = new JPanel();
		panel_11.setBackground(Color.decode("#03a9f4"));
		organisationPanneauTitre.add(panel_11, BorderLayout.SOUTH);
		
		panneau_actions = new JPanel();
		panneau_actions.setBackground(Color.decode("#03a9f4"));
		contentPane.add(panneau_actions, BorderLayout.CENTER);
		panneau_actions.setLayout(new BorderLayout(0, 0));
		
		bord1 = new JPanel();
		bord1.setBackground(Color.decode("#03a9f4"));
		panneau_actions.add(bord1, BorderLayout.WEST);
		
		bord2 = new JPanel();
		bord2.setBackground(Color.decode("#03a9f4"));
		panneau_actions.add(bord2, BorderLayout.EAST);
		
		bord3 = new JPanel();
		bord3.setBackground(Color.decode("#03a9f4"));
		panneau_actions.add(bord3, BorderLayout.SOUTH);
		
		principal = new JPanel();
		panneau_actions.add(principal, BorderLayout.CENTER);
		principal.setLayout(new GridLayout(1, 0, 0, 0));
		
		panneau_choix = new JPanel();
		principal.add(panneau_choix);
		panneau_choix.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#03a9f4"));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		panneau_choix.add(panel_4, BorderLayout.NORTH);
		
		panel = new JPanel();
		panneau_choix.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.EAST);
		
		perceptron = new JRadioButton("Choisir le perceptron");
		panel_6.add(perceptron);
		perceptron.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(perceptron);
		
		panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.WEST);
		
		neuronnes = new JRadioButton("Choisir le r\u00E9seau de neuronnes");
		panel_7.add(neuronnes);
		neuronnes.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(neuronnes);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.decode("#03a9f4"));
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		panneau_choix.add(panel_5, BorderLayout.SOUTH);
		
	
		panel_1 = new JPanel();
		principal.add(panel_1);
		
		panel_2 = new JPanel();
		principal.add(panel_2);
		
		panel_3 = new JPanel();
		principal.add(panel_3);
	}

}
