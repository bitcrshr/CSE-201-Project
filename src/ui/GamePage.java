package ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.AuthenticationManager;
import io.GameStorage;
import models.Game;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GamePage extends JFrame {
	private JTextField txtEnterYourThoughts;

	//private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePage frame = new GamePage(new Game());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//public Game game = null;

	/**
	 * Create the frame.
	 */
	public GamePage() {
		this(new Game());
	}
	
	
	public GamePage(Game game) {
		
		//Profile uploader = new Profile("RiotGames","psswrd");
		//String desc = "Wildly popular MOBA with over 130 characters to choose from! Download for free now!";
		//Game game = new Game("League of Legends",uploader,desc,new ArrayList<String>());
		//Game game = new Game();
		
		getContentPane().setBackground(new Color(255, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 268, 388, 0};
		gridBagLayout.rowHeights = new int[]{26, 0, 0, 0, 0, -9, 0, 0, 0, 0, 108, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		ImageIcon icon;
		
		try {
			icon = new ImageIcon(ImageIO.read(new URL(game.getPreviewLink())));
		} catch (Exception e) {
			e.printStackTrace();
			icon = new ImageIcon("League.jpg");
		}
		
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(300,300, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		
		JButton btnBackToSearch = new JButton("Back to search");
		btnBackToSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchandResults s = new SearchandResults();
				s.setVisible(true);
				setVisible(false);
			}
		});
		btnBackToSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnBackToSearch.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_btnBackToSearch = new GridBagConstraints();
		gbc_btnBackToSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnBackToSearch.gridx = 1;
		gbc_btnBackToSearch.gridy = 0;
		getContentPane().add(btnBackToSearch, gbc_btnBackToSearch);
		
		//return (currentUser == null) ? null : new Profile(currentUser);
		
		String name = (game == null) ? "none" : game.getName();
		JLabel lblgameTitle = new JLabel(name);
		GridBagConstraints gbc_lblgameTitle = new GridBagConstraints();
		gbc_lblgameTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblgameTitle.gridx = 1;
		gbc_lblgameTitle.gridy = 1;
		getContentPane().add(lblgameTitle, gbc_lblgameTitle);
		
		JLabel lblRating = new JLabel("Rating");
		GridBagConstraints gbc_lblRating = new GridBagConstraints();
		gbc_lblRating.insets = new Insets(0, 0, 5, 0);
		gbc_lblRating.gridx = 2;
		gbc_lblRating.gridy = 2;
		getContentPane().add(lblRating, gbc_lblRating);
		
		JLabel lblscore = new JLabel("" + game.getRating());
		GridBagConstraints gbc_lblscore = new GridBagConstraints();
		gbc_lblscore.insets = new Insets(0, 0, 5, 0);
		gbc_lblscore.gridx = 2;
		gbc_lblscore.gridy = 3;
		getContentPane().add(lblscore, gbc_lblscore);
		
		JLabel lblPlatform = new JLabel(game.getPlatform().toString());
		GridBagConstraints gbc_lblPlatform = new GridBagConstraints();
		gbc_lblPlatform.insets = new Insets(0, 0, 5, 0);
		gbc_lblPlatform.gridx = 2;
		gbc_lblPlatform.gridy = 4;
		getContentPane().add(lblPlatform, gbc_lblPlatform);
		
		JLabel lblGenre = new JLabel(game.getGenre().toString());
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.insets = new Insets(0, 0, 5, 0);
		gbc_lblGenre.gridx = 2;
		gbc_lblGenre.gridy = 5;
		getContentPane().add(lblGenre, gbc_lblGenre);
		
		
		
		String[] ratings = {"Score 1-5 (1 = worst 5 = best)","1","2","3","4","5"};
		JLabel label = new JLabel(icon);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 5;
		getContentPane().add(label, gbc_label);
		
		String des = (game == null) ? "none" : game.getDescription();
		JLabel lbldescription = new JLabel(des);
		lbldescription.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lbldescription = new GridBagConstraints();
		gbc_lbldescription.gridheight = 5;
		gbc_lbldescription.insets = new Insets(0, 0, 0, 5);
		gbc_lbldescription.gridx = 1;
		gbc_lbldescription.gridy = 6;
		getContentPane().add(lbldescription, gbc_lbldescription);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblComments = new JLabel("Comments");
		GridBagConstraints gbc_lblComments = new GridBagConstraints();
		gbc_lblComments.insets = new Insets(0, 0, 5, 0);
		gbc_lblComments.gridx = 2;
		gbc_lblComments.gridy = 6;
		getContentPane().add(lblComments, gbc_lblComments);
		JComboBox comboBox = new JComboBox(ratings);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 7;
		getContentPane().add(comboBox, gbc_comboBox);
		
		txtEnterYourThoughts = new JTextField();
		txtEnterYourThoughts.setText("Enter Your Thoughts:");
		GridBagConstraints gbc_txtEnterYourThoughts = new GridBagConstraints();
		gbc_txtEnterYourThoughts.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterYourThoughts.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterYourThoughts.gridx = 2;
		gbc_txtEnterYourThoughts.gridy = 8;
		getContentPane().add(txtEnterYourThoughts, gbc_txtEnterYourThoughts);
		txtEnterYourThoughts.setColumns(10);
		
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 0);
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 9;
		getContentPane().add(btnSubmit, gbc_btnSubmit);
		
		if (AuthenticationManager.getInstance().currentUser().getAdmin()) {
			JButton deleteButton = new JButton("Delete");
			deleteButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					GameStorage.getInstance().deleteGame(game.getName());
					setVisible(false);
					(new SearchandResults(GameStorage.getInstance().toArray())).setVisible(true);;
				}
			});
			
			GridBagConstraints gbc_btnDelete = new GridBagConstraints();
			gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
			gbc_btnDelete.gridx = 2;
			gbc_btnDelete.gridy = 10;
			getContentPane().add(deleteButton, gbc_btnDelete);
		}
		
		JLabel lblNewLabel = new JLabel("[Comments]");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 10;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
	}
}
