package frontend;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.InferenceEngine;
import backend.TrainingEngine;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class TrainingFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtTerminotron;
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
	private JPanel panneau_parametres;
	private JPanel panel_2;
	private JPanel panel_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JMenuBar menuPerceptron;
	private JMenu mnNewMenu;
	private JCheckBox reg1;
	private JCheckBox reg2;
	private JCheckBox reg3;
	private JRadioButton perceptron;
	private JRadioButton neuronne;
	private JTextField parametres;
	private JPanel panel_1;
	private JPanel panel_8;
	private JPanel panel_10;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel general;
	private JPanel panel_9;
	private JPanel panel_14;
	private JPanel panel_15;
	private JTextField choix_type;
	private JPanel panel_16;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_17;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_25;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	private JTextField epoc;
	private JTextField batch_size;
	private JTextField training_step;
	private JPanel panel_31;
	private JPanel panel_32;
	private JTextField nb_de_passes;
	private JTextField valeur_nb_images;
	private JTextField nb_incrementations;
	private JButton bouton_validation;
	private JPanel panel_33;
	private JPanel panel_35;
	private JPanel panel_36;
	private JButton bouton_sauvegarder_modele;
	private JPanel panel_37;
	private JPanel panel_34;
	private JPanel panel_38;
	private JTextField choix_nom;
	private JTextField textField_1;
	private JPanel panel_39;
	private JPanel panel_40;
	private JPanel panel_41;
	private JPanel panel_42;
	private JButton bouton_chargement;
	private JButton bouton_validation_chargement;
	private JButton bouton_valider_sauvegarde;
	private JButton bouton_lancer_apprentissage;
	private JProgressBar progressBar;
	private JButton button;

	/**
	 * Static permet de reccuperer les valeurs en memoire sans les get et sans
	 * instancier la classe
	 */
<<<<<<< HEAD
=======
	
	static TrainingEngine trainer = new TrainingEngine();
	private InferenceEngine inferer = new InferenceEngine();
	
	public static double trainingStep; // = incrementation 
	public static int batchSize;  // = nb d'images par passe
	public static int nombreEpoch;  // = nb de passes
	private int modelnumber = 0;
	
	
	String modelToLoadName;
	String modelToLoadPath;
	String modelToLoadfullName;
	String saveDir;
	String savePath = "user.home"; //by default
	String saveName;
	String defaultPath = "user.home";
	
	
>>>>>>> Igot/integrtraining

	public static double trainingStep; // = incrementation
	public static long batchSize; // = nb d'images par passe
	public static long nombreEpoch; // = nb de passes
	TrainingEngine TrainMe = new TrainingEngine();

	/**
	 * Create the frame.
	 * @return 
	 */
<<<<<<< HEAD

=======
	
	
	private void saveModel(String name) {
		trainer.saveModel(savePath);
		System.out.println("Saved on "+savePath);
	}
	
	
	private void loadModel() {
		inferer.loadModel(modelToLoadPath);
		System.out.println("model loaded from "+ modelToLoadPath);	
	}
	
	
	public String getSavePath() {
		return savePath;
	}	
	
	
	public String getLoadPath() {
		return modelToLoadPath;
	}
	
	private void trainModel() {
		/**
		 * 1=perceptron
		 * 2=SLN
		 * 3=perceptron2?
		 */
		if (modelnumber==1) {
			//choisir modele perceptron
			trainer.trainPerceptron(batchSize, trainingStep, nombreEpoch);
			System.out.println("perceptron entrainé");
		} else {
			if (modelnumber==2) {
				//choisir SLN
				trainer.trainSLN(batchSize, trainingStep, nombreEpoch);
				System.out.println("SLN entrainé");
			} else {
				if (modelnumber ==3 ) {
					//choisir perceptron 2
				} else { System.out.println("type de modele non selectionné");
				}
				
			}
		}
	}

	
>>>>>>> Igot/integrtraining
	public TrainingFrame2() {

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

		organisationPanneauTitre = new JPanel();
		contentPane.add(organisationPanneauTitre, BorderLayout.NORTH);
		organisationPanneauTitre.setLayout(new BorderLayout(0, 0));

		JPanel panneau_titre = new JPanel();
		organisationPanneauTitre.add(panneau_titre, BorderLayout.NORTH);
		panneau_titre.setBackground(Color.decode("#01579b"));

		txtTerminotron = new JTextField();
		txtTerminotron.setEditable(false);
		txtTerminotron.setText("TERMINOTRON");
		txtTerminotron.setForeground(Color.WHITE);
		txtTerminotron.setColumns(10);
		txtTerminotron.setBackground(Color.BLUE);
		panneau_titre.add(txtTerminotron);

		txtFentreRglages = new JTextField();
		txtFentreRglages.setEditable(false);
		txtFentreRglages.setText("Fen\u00EAtre R\u00E9glages");
		txtFentreRglages.setHorizontalAlignment(SwingConstants.CENTER);
		txtFentreRglages.setColumns(20);
		txtFentreRglages.setBackground(Color.decode("#b3e5fc"));
		panneau_titre.add(txtFentreRglages);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); // permet d'ï¿½viter la fermeture du programme si
																// l'utilisateur clique sur la croix de fermeture de la
																// fenï¿½tre d'aide

		retoursMain = new JButton("Retour fen\u00EAtre principale");
		retoursMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
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

		general = new JPanel();
		panneau_choix.add(general);
		general.setLayout(new GridLayout(0, 1, 0, 0));

		panel_4 = new JPanel();
		general.add(panel_4);
		panel_4.setBackground(Color.decode("#03a9f4"));
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));

		choix_type = new JTextField();
		choix_type.setBackground(Color.decode("#ffb74d"));
		choix_type.setHorizontalAlignment(SwingConstants.CENTER);
		choix_type.setText("Choix du type de mod\u00E8le :");
		choix_type.setEditable(false);
		panel_4.add(choix_type);
		choix_type.setColumns(10);

		panel_16 = new JPanel();
		panel_16.setBackground(Color.decode("#03a9f4"));
		general.add(panel_16);

		panel = new JPanel();
		general.add(panel);
		panel.setBackground(Color.decode("#03a9f4"));
		panel.setLayout(new BorderLayout(0, 0));

		panel_6 = new JPanel();
		panel_6.setBackground(Color.decode("#03a9f4"));
		panel.add(panel_6, BorderLayout.NORTH);

		neuronne = new JRadioButton("Choisir le r\u00E9seau de neuronnes");
		neuronne.setBackground(Color.decode("#b3e5fc"));
		buttonGroup.add(neuronne);
		neuronne.addActionListener(new ActionListener() {
<<<<<<< HEAD
			public void actionPerformed(ActionEvent e) { // TODO
			}
		});
		panel_6.add(neuronne);

=======
			public void actionPerformed(ActionEvent e) {  
				modelnumber=2;
			}
		});
		panel_6.add(neuronne);
		
	
		
>>>>>>> Igot/integrtraining
		panel_7 = new JPanel();
		panel_7.setBackground(Color.decode("#03a9f4"));
		panel.add(panel_7, BorderLayout.CENTER);

		perceptron = new JRadioButton("Choisir le Perceptron");
		perceptron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelnumber=1;
				System.out.println("perceptron choisi");
			}
		});
		perceptron.setBackground(Color.decode("#b3e5fc"));
		buttonGroup.add(perceptron);
		panel_7.add(perceptron);

		panel_5 = new JPanel();
		general.add(panel_5);
		panel_5.setBackground(new Color(3, 169, 244));
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();

		menuPerceptron = new JMenuBar();
		panel_5.add(menuPerceptron);

		mnNewMenu = new JMenu("R\u00E9glages Perceptron");
		mnNewMenu.setBackground(Color.decode("#b3e5fc"));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuPerceptron.add(mnNewMenu);

		reg1 = new JCheckBox("Reglage1");
		reg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // TODO
			}
		});
		mnNewMenu.add(reg1);

		reg2 = new JCheckBox("Reglage2");
		reg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // TODO
			}
		});
		mnNewMenu.add(reg2);

		reg3 = new JCheckBox("Reglage3");
		reg3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // TODO
			}
		});
		mnNewMenu.add(reg3);

		panel_35 = new JPanel();
		panel_35.setBackground(new Color(3, 169, 244));
		general.add(panel_35);

		panel_9 = new JPanel();
		panel_9.setBackground(Color.decode("#01579b"));
		panneau_choix.add(panel_9, BorderLayout.NORTH);

		panel_14 = new JPanel();
		panel_14.setBackground(Color.decode("#01579b"));
		panneau_choix.add(panel_14, BorderLayout.SOUTH);

		panel_15 = new JPanel();
		panel_15.setBackground(Color.decode("#01579b"));
		panneau_choix.add(panel_15, BorderLayout.WEST);

		panneau_parametres = new JPanel();
		panneau_parametres.setBackground(Color.decode("#03a9f4"));
		principal.add(panneau_parametres);
		panneau_parametres.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panneau_parametres.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		parametres = new JTextField();
		parametres.setEditable(false);
		parametres.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(parametres);
		parametres.setBackground(Color.decode("#ffb74d"));
		parametres.setText("R\u00E9glage des param\u00E8tres :");
		parametres.setColumns(10);

		panel_31 = new JPanel();
		panel_1.add(panel_31);
		panel_31.setLayout(new GridLayout(3, 2, 0, 0));

		epoc = new JTextField();
		epoc.setBackground(Color.decode("#03a9f4"));
		epoc.setHorizontalAlignment(SwingConstants.CENTER);
		epoc.setEditable(false);
		panel_31.add(epoc);
		epoc.setText("nombre de passes");
		epoc.setColumns(10);

		nb_de_passes = new JTextField();
		nb_de_passes.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(nb_de_passes);
		nb_de_passes.setColumns(10);

		batch_size = new JTextField();
		batch_size.setBackground(Color.decode("#03a9f4"));
		batch_size.setHorizontalAlignment(SwingConstants.CENTER);
		batch_size.setEditable(false);
		panel_31.add(batch_size);
		batch_size.setText("nombre d'images par passe");
		batch_size.setColumns(10);

		valeur_nb_images = new JTextField();
		valeur_nb_images.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // TODO
			}
		});
		valeur_nb_images.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(valeur_nb_images);
		valeur_nb_images.setColumns(10);

		training_step = new JTextField();
		training_step.setBackground(Color.decode("#03a9f4"));
		training_step.setHorizontalAlignment(SwingConstants.CENTER);
		training_step.setEditable(false);
		panel_31.add(training_step);
		training_step.setText("incr\u00E9mentation");
		training_step.setColumns(10);

		nb_incrementations = new JTextField();
		nb_incrementations.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(nb_incrementations);
		nb_incrementations.setColumns(10);

		panel_32 = new JPanel();
		panel_1.add(panel_32);
		panel_32.setLayout(new GridLayout(0, 1, 0, 0));

		bouton_validation = new JButton("VALIDER MODIFICATION");
		bouton_validation.addActionListener(new ActionListener() {
<<<<<<< HEAD
			public void actionPerformed(ActionEvent e) {
				nombreEpoch = Long.parseLong(nb_de_passes.getText());
				batchSize = Long.parseLong(valeur_nb_images.getText());
				trainingStep = Double.parseDouble(nb_incrementations.getText());
=======
			public void actionPerformed(ActionEvent e) { 
				nombreEpoch = Integer.parseInt(nb_de_passes.getText());
				batchSize = Integer.parseInt(valeur_nb_images.getText());
				trainingStep = Double.parseDouble(nb_incrementations.getText());				
>>>>>>> Igot/integrtraining
			}

		});
		bouton_validation.setBackground(new Color(0, 255, 127));
		panel_32.add(bouton_validation);

		panel_33 = new JPanel();
		panel_33.setBackground(Color.decode("#03a9f4"));
		panel_1.add(panel_33);
		panel_33.setLayout(new BorderLayout(0, 0));

		bouton_lancer_apprentissage = new JButton("Lancer l'apprentissage avec les valeurs rentrï¿½es plus haut");
		bouton_lancer_apprentissage.addActionListener(new ActionListener() {
<<<<<<< HEAD
			public void actionPerformed(ActionEvent e) {
				nombreEpoch = Long.parseLong(nb_de_passes.getText());
				batchSize = Long.parseLong(valeur_nb_images.getText());
				trainingStep = Double.parseDouble(nb_incrementations.getText());
				TrainMe.train(batchSize, trainingStep, nombreEpoch); // lancement d'entrainement
=======
			public void actionPerformed(ActionEvent e) {	
				//try {
					nombreEpoch =Integer.parseInt(nb_de_passes.getText());
					batchSize = Integer.parseInt(valeur_nb_images.getText());
					trainingStep = Double.parseDouble(nb_incrementations.getText());                
					trainModel();
				//} catch (Exception a) {
				//	System.out.println("ERREUR");
				//}
				
					
>>>>>>> Igot/integrtraining
			}
			
		});
		bouton_lancer_apprentissage.setBackground(new Color(0, 255, 127));
		panel_33.add(bouton_lancer_apprentissage);

		panel_36 = new JPanel();
		panel_36.setBackground(new Color(3, 169, 244));
		panel_1.add(panel_36);
		panel_36.setLayout(new BorderLayout(0, 0));

		progressBar = new JProgressBar(); // Affiche l'ï¿½volution du stade d'apprentissage
		panel_36.add(progressBar);
		progressBar.setToolTipText("Avancement");
<<<<<<< HEAD
=======
		progressBar.setValue(trainer.getProgressionStatus());
>>>>>>> Igot/integrtraining
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setForeground(new Color(124, 252, 0));
		progressBar.setBackground(new Color(220, 20, 60));

		panel_8 = new JPanel();
		panel_8.setBackground(Color.decode("#01579b"));
		panneau_parametres.add(panel_8, BorderLayout.SOUTH);

		panel_10 = new JPanel();
		panel_10.setBackground(Color.decode("#01579b"));
		panneau_parametres.add(panel_10, BorderLayout.NORTH);

		panel_13 = new JPanel();
		panel_13.setBackground(Color.decode("#01579b"));
		panneau_parametres.add(panel_13, BorderLayout.WEST);

		panel_12 = new JPanel();
		panel_12.setBackground(Color.decode("#01579b"));
		panneau_parametres.add(panel_12, BorderLayout.EAST);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#03a9f4"));
		principal.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_18 = new JPanel();
		panel_18.setBackground(new Color(1, 87, 155));
		panel_2.add(panel_18, BorderLayout.SOUTH);

		panel_19 = new JPanel();
		panel_19.setBackground(new Color(1, 87, 155));
		panel_2.add(panel_19, BorderLayout.NORTH);

		panel_17 = new JPanel();
		panel_2.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new GridLayout(0, 1, 0, 0));

		panel_20 = new JPanel();
		panel_17.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));

		panel_25 = new JPanel();
		panel_25.setBackground(Color.decode("#03a9f4"));
		panel_20.add(panel_25, BorderLayout.CENTER);
		panel_25.setLayout(new GridLayout(0, 1, 0, 0));
<<<<<<< HEAD

		bouton_sauvegarder_modele = new JTextField();
=======
		
		bouton_sauvegarder_modele = new JButton();
		bouton_sauvegarder_modele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
>>>>>>> Igot/integrtraining
		bouton_sauvegarder_modele.setText("Sauvegarder sous");
		bouton_sauvegarder_modele.setHorizontalAlignment(SwingConstants.CENTER);
		//bouton_sauvegarder_modele.setEditable(false);
		//bouton_sauvegarder_modele.setColumns(10);
		bouton_sauvegarder_modele.setBackground(new Color(255, 183, 77));
		panel_25.add(bouton_sauvegarder_modele);
<<<<<<< HEAD

=======
		bouton_sauvegarder_modele.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {		
					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File(System.getProperty(defaultPath)));
					chooser.setDialogTitle("dir sauvegarder modele");
				    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				    chooser.setAcceptAllFileFilterUsed(false);
				    if (chooser.showOpenDialog(bouton_sauvegarder_modele) == JFileChooser.APPROVE_OPTION) { 				    	
				    	saveDir = chooser.getCurrentDirectory().toString() + "\\" + chooser.getSelectedFile().getName(); //ne donne pass le nom
				        }				    
				    System.out.println(saveName);				    
				       }				    
				}
			);
		
>>>>>>> Igot/integrtraining
		panel_37 = new JPanel();
		panel_25.add(panel_37);
		panel_37.setLayout(new GridLayout(0, 2, 0, 0));

		panel_34 = new JPanel();
		panel_34.setBackground(Color.decode("#03a9f4"));
		panel_37.add(panel_34);

		choix_nom = new JTextField();
		choix_nom.setBackground(Color.decode("#b3e5fc"));
		choix_nom.setEditable(false);
		choix_nom.setText("Choisir le nom :");
		choix_nom.setHorizontalAlignment(SwingConstants.CENTER);
		panel_34.add(choix_nom);
		choix_nom.setColumns(10);

		panel_38 = new JPanel();
		panel_38.setBackground(Color.decode("#03a9f4"));
		panel_37.add(panel_38);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.decode("#b3e5fc"));
		panel_38.add(textField_1);
		textField_1.setColumns(10);

		bouton_valider_sauvegarde = new JButton("Valider la sauvegarde");
		bouton_valider_sauvegarde.addActionListener(new ActionListener() {
<<<<<<< HEAD
			public void actionPerformed(ActionEvent e) { // TODO
=======
			
			public void actionPerformed(ActionEvent e) {
				saveName = textField_1.getText();
				
				savePath = saveDir  +"\\"+ saveName;
				
				saveModel(saveName);
				
				
>>>>>>> Igot/integrtraining
			}
		});
		bouton_valider_sauvegarde.setBackground(new Color(0, 255, 127));
		panel_25.add(bouton_valider_sauvegarde);

		panel_26 = new JPanel();
		panel_26.setBackground(Color.decode("#01579b"));
		panel_20.add(panel_26, BorderLayout.SOUTH);

		panel_21 = new JPanel();
		panel_21.setBackground(Color.decode("#03a9f4"));
		panel_17.add(panel_21);
		panel_21.setLayout(new BorderLayout(0, 0));

		button = new JButton("Aide");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aide frame = new Aide();
				frame.setVisible(true);
			}
		});
		button.setBackground(Color.decode("#03a9f4"));
		button.setIcon(new ImageIcon(TrainingFrame2.class.getResource("/ressources/Sans titre.jpg")));
		panel_21.add(button, BorderLayout.CENTER);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#03a9f4"));
		principal.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		panel_22 = new JPanel();
		panel_22.setBackground(new Color(1, 87, 155));
		panel_3.add(panel_22, BorderLayout.SOUTH);

		panel_23 = new JPanel();
		panel_23.setBackground(new Color(1, 87, 155));
		panel_3.add(panel_23, BorderLayout.NORTH);

		panel_24 = new JPanel();
		panel_24.setBackground(new Color(1, 87, 155));
		panel_3.add(panel_24, BorderLayout.EAST);

		panel_27 = new JPanel();
		panel_3.add(panel_27, BorderLayout.CENTER);
		panel_27.setLayout(new GridLayout(0, 1, 0, 0));

		panel_28 = new JPanel();
		panel_28.setBackground(Color.decode("#03a9f4"));
		panel_27.add(panel_28);
		panel_28.setLayout(new BorderLayout(0, 0));

		panel_30 = new JPanel();
		panel_30.setBackground(Color.decode("#01579b"));
		panel_28.add(panel_30, BorderLayout.SOUTH);

		panel_39 = new JPanel();
		panel_39.setBackground(Color.decode("#01579b"));
		panel_28.add(panel_39, BorderLayout.WEST);

		panel_40 = new JPanel();
		panel_28.add(panel_40, BorderLayout.CENTER);
		panel_40.setLayout(new GridLayout(0, 1, 0, 0));

		panel_41 = new JPanel();
		panel_40.add(panel_41);
		panel_41.setLayout(new GridLayout(0, 1, 0, 0));

		bouton_chargement = new JButton("Charger");
		bouton_chargement.addActionListener(new ActionListener() {
<<<<<<< HEAD
			public void actionPerformed(ActionEvent e) { // TODO
=======
			public void actionPerformed(ActionEvent e) {
				//rajout d'un fileChoser
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //initial dir
				int result = fileChooser.showOpenDialog(bouton_chargement);
				if (result == JFileChooser.APPROVE_OPTION) { // user selects a file
					File selectedFile = fileChooser.getSelectedFile();
					modelToLoadName = fileChooser.getSelectedFile().getName();
					modelToLoadPath = fileChooser.getSelectedFile().getPath();
					modelToLoadfullName = selectedFile.getAbsolutePath();
					bouton_chargement.setText("Modèle choisi :  " + modelToLoadPath);
					

				}

>>>>>>> Igot/integrtraining
			}
			}
		);
		bouton_chargement.setBackground(new Color(255, 183, 77));
		panel_41.add(bouton_chargement);

		panel_42 = new JPanel();
		panel_42.setBackground(new Color(3, 169, 244));
		panel_41.add(panel_42);
		panel_42.setLayout(new BorderLayout(0, 0));

		bouton_validation_chargement = new JButton("Valider le chargement");
		bouton_validation_chargement.addActionListener(new ActionListener() {
<<<<<<< HEAD
			public void actionPerformed(ActionEvent e) { // TODO
=======
			public void actionPerformed(ActionEvent e) { 
				loadModel();
>>>>>>> Igot/integrtraining
			}
		});
		bouton_validation_chargement.setBackground(new Color(0, 255, 127));
		panel_42.add(bouton_validation_chargement, BorderLayout.CENTER);

		panel_29 = new JPanel();
		panel_29.setBackground(Color.decode("#03a9f4"));
		panel_27.add(panel_29);
	}
	
	
	

}
