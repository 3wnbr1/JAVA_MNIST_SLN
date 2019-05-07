package frontend;

import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import java.io.File;

import backend.InferenceEngine;
import backend.dataset.Image;
import backend.models.SLN;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.swing.JProgressBar;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nom_fenetre;
	private JTextField txtAnalyseNonLancee;
	private JTextField txtLeRsultatEst;
	private JTextField texte_e2;
	private JTextField txtEtape;
	private JTextField nom_application;
	private InferenceEngine inference = new InferenceEngine();
	private double[] resultTab;
	private int resultatAnalyse;
	private String resultatAffiche = "Analyse non lancee";
	private double[] tablResult;
	private File selectedFile;

	private String selectedName;
	private static String selectedPath;
	private String fullName;
	private int verifCode = 0;
	private URL url;
	private JTextField nb1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public String getChosenImageName() {
		return selectedName;
	}

	public static String getChosenImagePath() {
		return selectedPath;
	}

	public String getChosenImageFullName() {
		return fullName;
	}

	public void setVerifCode(int code) {
		this.verifCode = code;
	}

	public int getVerifCode() {
		return verifCode;
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

		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);

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

		ImageInserter PaintButton = new ImageInserter(panneau_image);

		JPanel panneau_commande = new JPanel();
		panneau_interactions.add(panneau_commande);
		panneau_commande.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panneau_boutons = new JPanel();
		panneau_commande.add(panneau_boutons);
		panneau_boutons.setLayout(new GridLayout(4, 0, 0, 0));

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

		txtAnalyseNonLancee = new JTextField("Analyse non lanc\u00E9e");
		txtAnalyseNonLancee.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalyseNonLancee.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_15.add(txtAnalyseNonLancee);
		txtAnalyseNonLancee.setColumns(10);

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

		JPanel barGraph = new JPanel();
		panneau_boutons.add(barGraph);
		barGraph.setLayout(new BorderLayout(0, 0));

		JPanel panel_29 = new JPanel();
		panel_29.setBackground(new Color(3, 169, 244));
		barGraph.add(panel_29, BorderLayout.NORTH);

		JPanel panel_30 = new JPanel();
		panel_30.setBackground(new Color(3, 169, 244));
		barGraph.add(panel_30, BorderLayout.SOUTH);

		JPanel panel_31 = new JPanel();
		panel_31.setBackground(new Color(3, 169, 244));
		barGraph.add(panel_31, BorderLayout.EAST);

		JPanel panel_32 = new JPanel();
		panel_32.setBackground(new Color(3, 169, 244));
		barGraph.add(panel_32, BorderLayout.WEST);

		JPanel panneauGraphs = new JPanel();
		panneauGraphs.setBackground(new Color(3, 169, 244));
		barGraph.add(panneauGraphs, BorderLayout.CENTER);
		panneauGraphs.setLayout(new GridLayout(5, 2, 0, 0));

		JPanel panel_33 = new JPanel();
		panneauGraphs.add(panel_33);
		panel_33.setLayout(new GridLayout(0, 2, 0, 0));

		nb1 = new JTextField();
		nb1.setBackground(Color.LIGHT_GRAY);
		nb1.setHorizontalAlignment(SwingConstants.CENTER);
		nb1.setText("0");
		nb1.setEditable(false);
		panel_33.add(nb1);
		nb1.setColumns(10);

		JProgressBar progressBarProba0 = new JProgressBar();
		progressBarProba0.setStringPainted(true);
		progressBarProba0.setForeground(Color.GREEN);
		progressBarProba0.setBackground(new Color(3, 169, 244));
		panel_33.add(progressBarProba0);

		JPanel panel_35 = new JPanel();
		panneauGraphs.add(panel_35);
		panel_35.setLayout(new GridLayout(0, 2, 0, 0));

		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setText("1");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		panel_35.add(textField_2);

		JProgressBar progressBarProba1 = new JProgressBar();
		progressBarProba1.setStringPainted(true);
		progressBarProba1.setForeground(Color.GREEN);
		progressBarProba1.setBackground(new Color(3, 169, 244));
		panel_35.add(progressBarProba1);

		JPanel panel_34 = new JPanel();
		panneauGraphs.add(panel_34);
		panel_34.setLayout(new GridLayout(0, 2, 0, 0));

		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setText("2");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel_34.add(textField_1);

		JProgressBar progressBarProba2 = new JProgressBar();
		progressBarProba2.setForeground(Color.GREEN);
		progressBarProba2.setStringPainted(true);
		panel_34.add(progressBarProba2);
		progressBarProba2.setBackground(new Color(3, 169, 244));
		panel_34.add(progressBarProba2);

		JPanel panel_36 = new JPanel();
		panneauGraphs.add(panel_36);
		panel_36.setLayout(new GridLayout(1, 0, 0, 0));

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setText("3");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_36.add(textField_3);
		textField_3.setColumns(10);

		JProgressBar progressBarProba3 = new JProgressBar();
		progressBarProba3.setStringPainted(true);
		panel_36.add(progressBarProba3);
		progressBarProba3.setForeground(Color.GREEN);
		progressBarProba3.setBackground(new Color(3, 169, 244));
		panel_36.add(progressBarProba3);

		JPanel panel_37 = new JPanel();
		panneauGraphs.add(panel_37);
		panel_37.setLayout(new GridLayout(1, 0, 0, 0));

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("4");
		panel_37.add(textField);
		textField.setColumns(10);

		JProgressBar progressBarProba4 = new JProgressBar();
		progressBarProba4.setStringPainted(true);
		progressBarProba4.setForeground(Color.GREEN);
		progressBarProba4.setBackground(new Color(3, 169, 244));
		panel_37.add(progressBarProba4);

		JPanel panel_38 = new JPanel();
		panneauGraphs.add(panel_38);
		panel_38.setLayout(new GridLayout(0, 2, 0, 0));

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("5");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBackground(Color.LIGHT_GRAY);
		panel_38.add(textField_4);
		textField_4.setColumns(10);

		JProgressBar progressBarProba5 = new JProgressBar();
		progressBarProba5.setStringPainted(true);
		progressBarProba5.setForeground(Color.GREEN);
		progressBarProba5.setBackground(new Color(3, 169, 244));
		panel_38.add(progressBarProba5);

		JPanel panel_39 = new JPanel();
		panneauGraphs.add(panel_39);
		panel_39.setLayout(new GridLayout(1, 0, 0, 0));

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("6");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBackground(Color.LIGHT_GRAY);
		panel_39.add(textField_5);
		textField_5.setColumns(10);

		JProgressBar progressBarProba6 = new JProgressBar();
		progressBarProba6.setStringPainted(true);
		progressBarProba6.setForeground(Color.GREEN);
		progressBarProba6.setBackground(new Color(3, 169, 244));
		panel_39.add(progressBarProba6);

		JPanel panel_40 = new JPanel();
		panneauGraphs.add(panel_40);
		panel_40.setLayout(new GridLayout(0, 2, 0, 0));

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText("7");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBackground(Color.LIGHT_GRAY);
		panel_40.add(textField_6);
		textField_6.setColumns(10);

		JProgressBar progressBarProba7 = new JProgressBar();
		progressBarProba7.setStringPainted(true);
		progressBarProba7.setForeground(Color.GREEN);
		progressBarProba7.setBackground(new Color(3, 169, 244));
		panel_40.add(progressBarProba7);

		JPanel panel_41 = new JPanel();
		panneauGraphs.add(panel_41);
		panel_41.setLayout(new GridLayout(0, 2, 0, 0));

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("8");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setBackground(Color.LIGHT_GRAY);
		panel_41.add(textField_7);
		textField_7.setColumns(10);

		JProgressBar progressBarProba8 = new JProgressBar();
		progressBarProba8.setStringPainted(true);
		progressBarProba8.setForeground(Color.GREEN);
		progressBarProba8.setBackground(new Color(3, 169, 244));
		panel_41.add(progressBarProba8);

		JPanel panel_42 = new JPanel();
		panneauGraphs.add(panel_42);
		panel_42.setLayout(new GridLayout(1, 0, 0, 0));

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setText("9");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setBackground(Color.LIGHT_GRAY);
		panel_42.add(textField_8);
		textField_8.setColumns(10);

		JProgressBar progressBarProba9 = new JProgressBar();
		progressBarProba9.setStringPainted(true);
		progressBarProba9.setForeground(Color.GREEN);
		progressBarProba9.setBackground(new Color(3, 169, 244));
		panel_42.add(progressBarProba9);

		JPanel panel_7 = new JPanel();
		panneau_boutons.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panneau_erreur = new JPanel();
		panel_7.add(panneau_erreur);
		panneau_erreur.setLayout(new BorderLayout(0, 0));

		JButton bouton_erreur = new JButton("Signaler erreur");
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

		ModalProgressBar modalBar = new ModalProgressBar();

		bouton_lance_analyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedFile == null) { // si aucune image chargee, bloquer l'analyse et ouvrir WarningFrame1
					WarningFrame1 frameW = new WarningFrame1();
					frameW.setVisible(true);
				} else { // lancer l'analyse sinon
					inference.loadModel("sln.model");
					resultTab = inference.runInference(new Image(selectedPath, 28, 28));
					resultatAnalyse = SLN.maxDetection(resultTab);
					resultatAffiche = Integer.toString(resultatAnalyse);
					txtAnalyseNonLancee.setText(resultatAffiche);
					tablResult = inference.runInference(new Image(selectedPath, 28, 28));
					progressBarProba0.setValue((int) (tablResult[0] * 100));
					progressBarProba1.setValue((int) (tablResult[1] * 100));
					progressBarProba2.setValue((int) (tablResult[2] * 100));
					progressBarProba3.setValue((int) (tablResult[3] * 100));
					progressBarProba4.setValue((int) (tablResult[4] * 100));
					progressBarProba5.setValue((int) (tablResult[5] * 100));
					progressBarProba6.setValue((int) (tablResult[6] * 100));
					progressBarProba7.setValue((int) (tablResult[7] * 100));
					progressBarProba8.setValue((int) (tablResult[8] * 100));
					progressBarProba9.setValue((int) (tablResult[9] * 100));
				}
			}
		});

		choix_image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// rajout d'un fileChoser
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // initial dir
				int result = fileChooser.showOpenDialog(choix_image);
				if (result == JFileChooser.APPROVE_OPTION) { // user selects a file
					selectedFile = fileChooser.getSelectedFile();
					selectedName = fileChooser.getSelectedFile().getName();
					selectedPath = fileChooser.getSelectedFile().getPath();
					fullName = selectedFile.getAbsolutePath();
					PaintButton.rescale(selectedPath);
					verifCode = 1; // permet de verifier qu'une image a ete chargee
					panel_5.add(PaintButton.getJLabel());
					choix_image.setOpaque(false);
					choix_image.setContentAreaFilled(false);
					choix_image.setBorderPainted(false);
				}

			}
		});

		bouton_acces_reglages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Ouvrir nouvelle fenetre
				modalBar.setVisible(true);
				modalBar.revalidate();
				modalBar.repaint();
				TrainingFrame2 frame = new TrainingFrame2();
				frame.setVisible(true);
				modalBar.setVisible(false);
			}
		});

		bouton_erreur.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					url = getClass().getResource("/ressources/176.wav");
					AudioClip ac = Applet.newAudioClip(url);
					ac.play();
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println(url);
			}
		});

	}

}
