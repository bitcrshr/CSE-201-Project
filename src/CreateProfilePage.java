import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateProfilePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	Profile p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateProfilePage frame = new CreateProfilePage(true);
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
	public CreateProfilePage(boolean newProfile) {
		
		getContentPane().setFont(new Font("Monaco", Font.PLAIN, 13));
		getContentPane().setBackground(new Color(51, 255, 204));
		setBounds(100, 100,  700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 185, 688, 296);
		panel.setBackground(new Color(255, 255, 204));
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 121, 0, 276, 289, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 25, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCreateAProfile = new JLabel("Create A Profile");
		lblCreateAProfile.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCreateAProfile = new GridBagConstraints();
		gbc_lblCreateAProfile.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateAProfile.gridx = 3;
		gbc_lblCreateAProfile.gridy = 1;
		panel.add(lblCreateAProfile, gbc_lblCreateAProfile);
		
		JLabel lblUserName = new JLabel("User name:");
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.anchor = GridBagConstraints.EAST;
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.gridx = 2;
		gbc_lblUserName.gridy = 2;
		panel.add(lblUserName, gbc_lblUserName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 4;
		panel.add(lblPassword, gbc_lblPassword);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 4;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		if (newProfile){
			JLabel lblConfirmPassowrd = new JLabel("Confirm Password:");
			GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
			gbc_lblConfirmPassword.anchor = GridBagConstraints.EAST;
			gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblConfirmPassword.gridx = 2;
			gbc_lblConfirmPassword.gridy = 6;
			panel.add(lblConfirmPassowrd, gbc_lblConfirmPassword);
		
			textField_2 = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 5);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 3;
			gbc_textField_2.gridy = 6;
			panel.add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);
		}
		
		String buttonLabel = (newProfile) ? "Create Profile" : "Login";
		JButton btnCreateProfile = new JButton(buttonLabel);
		btnCreateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = textField_1.getText();
				if(newProfile) {
					if(AuthenticationManager.getInstance().signUp(username, password)) {
						SearchandResults s = new SearchandResults();
						s.setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null,
							    "Sign up failed. Please try again.",
							    "Inane warning",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					//sign in
					if(AuthenticationManager.getInstance().signIn(username, password)) {
						SearchandResults s = new SearchandResults();
						s.setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null,
							    "Login failed. Please try again.",
							    "Inane warning",
							    JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		GridBagConstraints gbc_btnCreateProfile = new GridBagConstraints();
		gbc_btnCreateProfile.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreateProfile.gridx = 3;
		gbc_btnCreateProfile.gridy = 8;
		panel.add(btnCreateProfile, gbc_btnCreateProfile);
		
	}
	
	public Profile createProfile(String username,String password){
		p = new Profile(username,password);
		return p;
	}
	
	public Profile getProfile(){
		return p;
	}
}
