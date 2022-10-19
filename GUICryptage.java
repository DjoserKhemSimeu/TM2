package tm2Pak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class GUICryptage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int choix;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICryptage window = new GUICryptage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUICryptage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JRadioButton rdbtnDecryptage = new JRadioButton("decryptage");
		buttonGroup.add(rdbtnDecryptage);
		panel.add(rdbtnDecryptage);
		
		JRadioButton rdbtnCryptage = new JRadioButton("cryptage");
		rdbtnCryptage.setSelected(true);
		buttonGroup.add(rdbtnCryptage);
		rdbtnCryptage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
			}
		});
		panel.add(rdbtnCryptage);
		
	
		
		JButton btnDecalage = new JButton("Decalage");
		btnDecalage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Decalage event= new Decalage (textField_2.getText());
				if(rdbtnCryptage.isSelected()) {
					textField.setText(event.cryptage(textField_1.getText()));
				}else {
					textField_1.setText(event.deCryptage(textField.getText()));
				}
			}
		});
		panel.add(btnDecalage);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Cl\u00E9 de cryptage");
		panel_2.add(lblNewLabel);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTexte = new JLabel("Texte Propre");
		panel_2.add(lblTexte);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblResultat = new JLabel("Texte Crypt\u00E9");
		panel_2.add(lblResultat);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		JButton btnPlayfair = new JButton("Playfair");
		btnPlayfair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Playfair event= new Playfair (textField_2.getText());
				if(rdbtnCryptage.isSelected()) {
					textField.setText(event.cryptage(textField_1.getText()));
				}else {
					textField_1.setText(event.deCryptage(textField.getText()));
				}
			}
		});
		panel.add(btnPlayfair);
	}

}
