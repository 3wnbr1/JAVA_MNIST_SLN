package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nom_fenetre;
	private JTextField textField;
	private JTextField txtLeRsultatEst;
	private JTextField texte_e2;
	private JTextField txtEtape;
	private JTextField nom_application;

	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.pack();
		this.setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		
		
		JPanel paneau_titre = new JPanel();
		paneau_titre.setBackground(new Color(0, 0, 255));
		FlowLayout flowLayout = (FlowLayout) paneau_titre.getLayout();
		flowLayout.setVgap(10);
		contentPane.add(paneau_titre, BorderLayout.NORTH);
		
		nom_application = new JTextField();
		nom_application.setForeground(new Color(255, 255, 255));
		nom_application.setBackground(new Color(0, 0, 255));
		nom_application.setText("Nom Application");
		paneau_titre.add(nom_application);
		nom_application.setColumns(10);
		
		nom_fenetre = new JTextField();
		nom_fenetre.setBackground(new Color(0, 255, 255));
		nom_fenetre.setHorizontalAlignment(SwingConstants.CENTER);
		nom_fenetre.setText("Fen\u00EAtre Principale");
		paneau_titre.add(nom_fenetre);
		nom_fenetre.setColumns(20);
		
		JPanel panneau_interactions = new JPanel();
		contentPane.add(panneau_interactions, BorderLayout.CENTER);
		panneau_interactions.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panneau_image = new JPanel();
		panneau_image.setBackground(new Color(255, 255, 255));
		panneau_interactions.add(panneau_image);
		panneau_image.setLayout(new BorderLayout(0, 0));
		
		JButton choix_image = new JButton("Choisir une image");
		choix_image.setBackground(new Color(255, 255, 255));
		choix_image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   //TODO
			}
		});
		panneau_image.add(choix_image, BorderLayout.CENTER);
		
		txtEtape = new JTextField();
		txtEtape.setBackground(new Color(0, 255, 255));
		txtEtape.setText("ETAPE 1 : choix de l'image");
		panneau_image.add(txtEtape, BorderLayout.NORTH);
		txtEtape.setColumns(10);
		
		JPanel panneau_commande = new JPanel();
		panneau_interactions.add(panneau_commande);
		panneau_commande.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panneau_boutons = new JPanel();
		panneau_commande.add(panneau_boutons);
		panneau_boutons.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panneau_lancer_analyse = new JPanel();
		panneau_lancer_analyse.setBackground(new Color(34, 139, 34));
		panneau_boutons.add(panneau_lancer_analyse);
		panneau_lancer_analyse.setLayout(new BorderLayout(0, 0));
		
		JButton bouton_lance_analyse = new JButton("Lancer analyse");
		bouton_lance_analyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //TODO
			}
		});
		bouton_lance_analyse.setBackground(new Color(50, 205, 50));
		panneau_lancer_analyse.add(bouton_lance_analyse);
		
		texte_e2 = new JTextField();
		texte_e2.setBackground(new Color(0, 255, 255));
		texte_e2.setText("ETAPE 2 ");
		panneau_lancer_analyse.add(texte_e2, BorderLayout.NORTH);
		texte_e2.setColumns(10);
		
		JPanel panneau_resultats = new JPanel();
		panneau_boutons.add(panneau_resultats);
		panneau_resultats.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //TODO
			}
		});
		panneau_resultats.add(textField);
		textField.setColumns(10);
		
		txtLeRsultatEst = new JTextField();
		txtLeRsultatEst.setBackground(new Color(0, 255, 255));
		txtLeRsultatEst.setText("Le r\u00E9sultat est :");
		panneau_resultats.add(txtLeRsultatEst, BorderLayout.NORTH);
		txtLeRsultatEst.setColumns(10);
		
		JPanel panneau_erreur = new JPanel();
		panneau_boutons.add(panneau_erreur);
		panneau_erreur.setLayout(new BorderLayout(0, 0));
		
		JButton bouton_erreur = new JButton("Signaler erreur");
		bouton_erreur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   //                      A FAIRE
			}
		});
		bouton_erreur.setBackground(new Color(255, 0, 0));
		panneau_erreur.add(bouton_erreur);
		
		JPanel panneau_acce_reglages = new JPanel();
		panneau_acce_reglages.setBackground(new Color(255, 165, 0));
		panneau_commande.add(panneau_acce_reglages);
		panneau_acce_reglages.setLayout(new BorderLayout(0, 0));
		
		JButton bouton_acces_reglages = new JButton("Acceder r\u00E9glages");
		bouton_acces_reglages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //  Ouvrir nouvelle fenêtre 
				dispose();
				TrainingFrame frame = new TrainingFrame();
				frame.setVisible(true);
			}
		});
		bouton_acces_reglages.setBackground(new Color(255, 165, 0));
		panneau_acce_reglages.add(bouton_acces_reglages);
	}

}
