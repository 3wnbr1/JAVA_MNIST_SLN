package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WarningFrame1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtAttention;
	private JTextField txtVeuillezChargerUen;
	private JTextField txtIlSembleQue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarningFrame1 frame = new WarningFrame1();
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
	public WarningFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
		setSize(400,200);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);   // permet d'éviter la fermeture du programme si l'utilisateur clique sur la croix de fermeture de la fenêtre d'aide
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(255, 165, 0));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 165, 0));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		txtAttention = new JTextField();
		txtAttention.setBackground(Color.RED);
		txtAttention.setText("Attention");
		txtAttention.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(txtAttention, BorderLayout.NORTH);
		txtAttention.setColumns(10);
		
		txtIlSembleQue = new JTextField();
		txtIlSembleQue.setBackground(Color.RED);
		txtIlSembleQue.setHorizontalAlignment(SwingConstants.CENTER);
		txtIlSembleQue.setText("Il me semble que vous n'avez pas charg\u00E9 d'image");
		panel_1.add(txtIlSembleQue, BorderLayout.CENTER);
		txtIlSembleQue.setColumns(10);
		
		txtVeuillezChargerUen = new JTextField();
		txtVeuillezChargerUen.setBackground(Color.RED);
		txtVeuillezChargerUen.setHorizontalAlignment(SwingConstants.CENTER);
		txtVeuillezChargerUen.setText("Veuillez en charger une et recommencer");
		panel_1.add(txtVeuillezChargerUen, BorderLayout.SOUTH);
		txtVeuillezChargerUen.setColumns(10);
		
	}

}
