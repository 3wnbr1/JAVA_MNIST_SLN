package frontend;

import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

import backend.Resultats;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;

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
import javax.swing.ImageIcon;
import java.awt.Font;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nom_fenetre;
	private JTextField textField;
	private JTextField txtLeRsultatEst;
	private JTextField texte_e2;
	private JTextField txtEtape;
	private JTextField nom_application;

	public String selectedName;
	public static String selectedPath;
	public String fullName;

	public String getChosenImageName() {
		return selectedName;
	}

	public static String getChosenImagePath() {
		return selectedPath;
	}

	public String getChosenImageFullName() {
		return fullName;
	}


	/**
	 * Create the frame.
	 */
	public MainFrame() {
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

		JPanel panneau_interactions = new JPanel();
		contentPane.add(panneau_interactions, BorderLayout.CENTER);
		panneau_interactions.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panneau_image = new JPanel();
		panneau_image.setBackground(new Color(255, 255, 255));
		panneau_interactions.add(panneau_image);
		panneau_image.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panneau_image.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JButton choix_image = new JButton("Choisir une image");
		panel_5.add(choix_image);
		choix_image.setBackground(new Color(255, 255, 255));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.decode("#03a9f4"));
		panel_5.add(panel_6, BorderLayout.WEST);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.decode("#03a9f4"));
		panel_5.add(panel_8, BorderLayout.SOUTH);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.decode("#03a9f4"));
		panel_5.add(panel_9, BorderLayout.EAST);

		JPanel panel_24 = new JPanel();
		panel_24.setBackground(Color.decode("#03a9f4"));
		panel_5.add(panel_24, BorderLayout.NORTH);

		JPanel panel_25 = new JPanel();
		panneau_image.add(panel_25, BorderLayout.NORTH);
		panel_25.setLayout(new BorderLayout(0, 0));

		txtEtape = new JTextField();
		txtEtape.setEditable(false);
		panel_25.add(txtEtape);
		txtEtape.setBackground(Color.decode("#b3e5fc"));
		txtEtape.setText("ETAPE 1 : choix de l'image");
		txtEtape.setColumns(10);

		JPanel panel_26 = new JPanel();
		panel_26.setBackground(Color.decode("#03a9f4"));
		panel_25.add(panel_26, BorderLayout.EAST);

		JPanel panel_27 = new JPanel();
		panel_27.setBackground(Color.decode("#03a9f4"));
		panel_25.add(panel_27, BorderLayout.WEST);
		choix_image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//rajout d'un fileChoser
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //initial dir
				int result = fileChooser.showOpenDialog(choix_image);
				if (result == JFileChooser.APPROVE_OPTION) { // user selects a file
					File selectedFile = fileChooser.getSelectedFile();
					selectedName = fileChooser.getSelectedFile().getName();
					selectedPath = fileChooser.getSelectedFile().getPath();
					fullName = selectedFile.getAbsolutePath();
					ImageInserter PaintButton = new ImageInserter(selectedPath, panneau_image);
					PaintButton.rescale();
					panel_5.add(PaintButton.getlabel());
					choix_image.setVisible(false); //supprime le bouton
					boolean isChosen = true;

					//TODO rajouter un bouton pour changer d'image charg�e
				}

			}
			}
		);

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

		texte_e2 = new JTextField();
		texte_e2.setEditable(false);
		texte_e2.setBackground(Color.decode("#b3e5fc"));
		texte_e2.setText("ETAPE 2 ");
		panneau_lancer_analyse.add(texte_e2, BorderLayout.NORTH);
		texte_e2.setColumns(10);

		JPanel panel_10 = new JPanel();
		panneau_lancer_analyse.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));

		JButton bouton_lance_analyse = new JButton("Lancer analyse");
		panel_10.add(bouton_lance_analyse);
		bouton_lance_analyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //TODO
				InferenceEngine.lancement(1);
			}
		});
		bouton_lance_analyse.setBackground(Color.decode("#00c853"));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.decode("#03a9f4"));
		panel_10.add(panel_11, BorderLayout.NORTH);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.decode("#03a9f4"));
		panel_10.add(panel_12, BorderLayout.SOUTH);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.decode("#03a9f4"));
		panel_10.add(panel_13, BorderLayout.WEST);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.decode("#03a9f4"));
		panel_10.add(panel_14, BorderLayout.EAST);

		JPanel panneau_resultats = new JPanel();
		panneau_boutons.add(panneau_resultats);
		panneau_resultats.setLayout(new BorderLayout(0, 0));

		txtLeRsultatEst = new JTextField();
		txtLeRsultatEst.setEditable(false);
		txtLeRsultatEst.setBackground(Color.decode("#b3e5fc"));
		txtLeRsultatEst.setText("Le r\u00E9sultat est :");
		panneau_resultats.add(txtLeRsultatEst, BorderLayout.NORTH);
		txtLeRsultatEst.setColumns(10);

		JPanel panel_15 = new JPanel();
		panneau_resultats.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new BorderLayout(0, 0));

		textField = new JTextField(Integer.toString(Resultats.resultatTest()));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_15.add(textField);
		textField.setColumns(10);

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.decode("#03a9f4"));
		panel_15.add(panel_16, BorderLayout.NORTH);

		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.decode("#03a9f4"));
		panel_15.add(panel_17, BorderLayout.SOUTH);

		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.decode("#03a9f4"));
		panel_15.add(panel_18, BorderLayout.WEST);

		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.decode("#03a9f4"));
		panel_15.add(panel_19, BorderLayout.EAST);

		JPanel panel_7 = new JPanel();
		panneau_boutons.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panneau_erreur = new JPanel();
		panel_7.add(panneau_erreur);
		panneau_erreur.setLayout(new BorderLayout(0, 0));

		JButton bouton_erreur = new JButton("Signaler erreur");
		bouton_erreur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   //                      A FAIRE
			}
		});
		bouton_erreur.setBackground(Color.decode("#d50000"));
		panneau_erreur.add(bouton_erreur);

		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.decode("#03a9f4"));
		panel_7.add(panel_20, BorderLayout.NORTH);

		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.decode("#03a9f4"));
		panel_7.add(panel_21, BorderLayout.SOUTH);

		JPanel panel_22 = new JPanel();
		panel_22.setBackground(Color.decode("#03a9f4"));
		panel_7.add(panel_22, BorderLayout.WEST);

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.decode("#03a9f4"));
		panel_7.add(panel_23, BorderLayout.EAST);

		JPanel panneau_acce_reglages = new JPanel();
		panneau_acce_reglages.setBackground(new Color(255, 165, 0));
		panneau_commande.add(panneau_acce_reglages);
		panneau_acce_reglages.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panneau_acce_reglages.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JButton bouton_acces_reglages = new JButton("Acceder r\u00E9glages");
		panel.add(bouton_acces_reglages, BorderLayout.CENTER);
		bouton_acces_reglages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //  Ouvrir nouvelle fen�tre
				dispose();
				TrainingFrame2 frame = new TrainingFrame2();
				frame.setVisible(true);
			}
		});
		bouton_acces_reglages.setBackground(Color.decode("#f57f17"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#03a9f4"));
		panel.add(panel_1, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#03a9f4"));
		panel.add(panel_2, BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#03a9f4"));
		panel.add(panel_3, BorderLayout.WEST);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#03a9f4"));
		panel.add(panel_4, BorderLayout.EAST);

		JPanel organisationPanneauTitre = new JPanel();
		contentPane.add(organisationPanneauTitre, BorderLayout.NORTH);
		organisationPanneauTitre.setLayout(new BorderLayout(0, 0));


		JPanel paneau_titre = new JPanel();
		organisationPanneauTitre.add(paneau_titre, BorderLayout.CENTER);
		paneau_titre.setBackground(Color.decode("#01579b"));
		FlowLayout flowLayout = (FlowLayout) paneau_titre.getLayout();
		flowLayout.setVgap(10);

		nom_application = new JTextField();
		nom_application.setEditable(false);
		nom_application.setForeground(new Color(255, 255, 255));
		nom_application.setBackground(new Color(0, 0, 255));
		nom_application.setText("TERMINOTRON");
		paneau_titre.add(nom_application);
		nom_application.setColumns(10);

		nom_fenetre = new JTextField();
		nom_fenetre.setEditable(false);
		nom_fenetre.setBackground(Color.decode("#b3e5fc"));
		nom_fenetre.setHorizontalAlignment(SwingConstants.CENTER);
		nom_fenetre.setText("Fen\u00EAtre Principale");
		paneau_titre.add(nom_fenetre);
		nom_fenetre.setColumns(20);

		JPanel panel_28 = new JPanel();
		panel_28.setBackground(Color.decode("#03a9f4"));
		organisationPanneauTitre.add(panel_28, BorderLayout.SOUTH);
	}


}
