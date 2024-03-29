package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.AuthenticationManager;
import io.GameStorage;
import models.Game;
import models.Profile;
import models.genre;
import models.platform;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SearchandResults extends JFrame{
	private JComboBox<platform> comboBoxPlatform;
	private JComboBox<genre> comboBoxGenre;
	private JComboBox<String> comboBoxTime;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_2;
	private JButton btnLogin;
	
	private JLabel lblUserName;
	private Profile profile;
	private JButton btnNewButton_3;
	private JTextField txtWord;
	
	private static Game[] games = {	new Game("League of Legends",
										"",
										genre.MOBA,
										platform.WINDOWS),
								new Game("Valorant",
										"",
										genre.FPS,
										platform.WINDOWS),
								new Game("Super Mario Bros",
										"",
										genre.PLATFORMER,
										platform.ALL),
								new Game("World of Warcraft",
										"",
										genre.MMO,
										platform.ALL)};
	
	private Game blank = new Game();
	private static GameStorage gs = GameStorage.getInstance();
	private static boolean added = gs.storeGame(new Game("League of Legends",
										"",
										genre.MOBA,
										platform.WINDOWS));
	private static boolean added1 = gs.storeGame(new Game("Valorant",
			"",
			genre.FPS,
			platform.WINDOWS));
	private static boolean added2 = gs.storeGame(new Game("Super Mario Bros",
			"",
			genre.PLATFORMER,
			platform.ALL));
	private static boolean added3 = gs.storeGame(new Game("World of Warcraft",
			"",
			genre.MMO,
			platform.ALL));
	private static Game[]  allGames = gs.toArray();
	private Game[] searchGames = gs.toArray();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchandResults window = new SearchandResults();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchandResults() {
		this(allGames);
	}
	
	public SearchandResults(Game[] searchGames) {
		profile = AuthenticationManager.getInstance().currentUser();
		lblUserName = (profile == null) ? new JLabel("Username: none") : new JLabel("Username: " + profile.getUserName());
		this.searchGames = searchGames;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 204));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 50, 670, 87);
		panel.setBackground(new Color(204, 255, 255));
		panel.setForeground(new Color(255, 51, 255));
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{79, 92, 74, 90, 132, 0};
		gbl_panel.rowHeights = new int[]{25, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		String s0[] = { "-------","this week", "this month", "this year", "all time"};
		
		lblNewLabel_1 = new JLabel("Platform");
		lblNewLabel_1.setForeground(new Color(255, 51, 204));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Genre");
		lblNewLabel_2.setForeground(new Color(255, 51, 255));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Advanced Search");
		lblNewLabel.setForeground(new Color(255, 0, 153));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		comboBoxGenre = new JComboBox(genre.values());
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 1;
		panel.add(comboBoxGenre, gbc_comboBox_1);
		comboBoxPlatform = new JComboBox(platform.values());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		panel.add(comboBoxPlatform, gbc_comboBox);
		
		txtWord = new JTextField();
		txtWord.setText("");
		GridBagConstraints gbc_txtThisIsA = new GridBagConstraints();
		gbc_txtThisIsA.insets = new Insets(0, 0, 5, 0);
		gbc_txtThisIsA.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtThisIsA.gridx = 3;
		gbc_txtThisIsA.gridy = 1;
		panel.add(txtWord, gbc_txtThisIsA);
		txtWord.setColumns(10);
		
		//When button is pressed search based on tags and substring
		btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genre gen = (genre) comboBoxGenre.getSelectedItem();
				platform plat = (platform) comboBoxPlatform.getSelectedItem();
				String substring = txtWord.getText().toLowerCase();
				Game[] searches = new Game[allGames.length];
				int count = 0;
				for(Game g : allGames){
					if(g.getGenre().equals(gen) || gen.equals(genre.ALL)){ 
						if(g.getPlatform().equals(plat) || plat.equals(platform.ALL)){
							if(g.getName().toLowerCase().contains(substring)){
								searches[count] = g;
								count++;
							}
						}
					}
				}
				Game[] retGame = new Game[count];
				for(int i = 0 ;i<retGame.length;i++) {
					retGame[i] = searches[i];
				}
				SearchandResults sr = new SearchandResults(retGame);
				sr.setVisible(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 2;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 255));
		panel_1.setBounds(0, 149, 670, 414);
		getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 151, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		int count = 0;
		int yOffset = 0;
		for(int i = 0; i < ((searchGames.length >= 6) ? 6 : searchGames.length); i++){
			Game g = searchGames[i];
			
			JLabel gameLabel = new JLabel(g.getName());
			GridBagConstraints gbc_gameLabel = new GridBagConstraints();
			gbc_gameLabel.insets = new Insets(0,0,5,5);
			gbc_gameLabel.gridx = count;
			gbc_gameLabel.gridy = yOffset;
			panel_1.add(gameLabel,gbc_gameLabel);
			
			ImageIcon icon;
			try {
				icon = new ImageIcon(ImageIO.read(new URL(g.getPreviewLink())));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				icon = new ImageIcon("League.jpg");
			}
			Image image = icon.getImage();
			Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			JLabel picture = new JLabel(icon);
			GridBagConstraints gbc_picture = new GridBagConstraints();
			gbc_picture.insets = new Insets(0,0,5,5);
			gbc_picture.gridx = count;
			gbc_picture.gridy = yOffset + 1;
			panel_1.add(picture,gbc_picture);
			
			JLabel desc = new JLabel(g.getDescription());
			desc.setForeground(new Color(255,51,255));
			GridBagConstraints gbc_desc = new GridBagConstraints();
			gbc_desc.insets = new Insets(0,0,5,5);
			gbc_desc.gridx = count;
			gbc_desc.gridy = yOffset + 2;
			panel_1.add(desc,gbc_desc);
			
			JButton game = new JButton("Visit this game");
			game.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					GamePage gp = new GamePage(g);
					gp.setVisible(true);
					setVisible(false);
				}
			});
			GridBagConstraints gbc_Game = new GridBagConstraints();
			gbc_Game.insets = new Insets(0,0,5,5);
			gbc_Game.gridx = count;
			gbc_Game.gridy = yOffset + 3;
			panel_1.add(game,gbc_Game);
			
			count++;
			if(count == 3){
				yOffset += 5;
				count = 0;
 			}
		}
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 255));
		panel_2.setBounds(0, 6, 670, 36);
		getContentPane().add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{12, 0, 0, 79, 0, 170, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		
		lblUserName.setForeground(new Color(255, 51, 255));
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.insets = new Insets(0, 0, 0, 5);
		gbc_lblUserName.gridx = 1;
		gbc_lblUserName.gridy = 0;
		panel_2.add(lblUserName, gbc_lblUserName);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfilePage profilePage = new ProfilePage();
				profilePage.setVisible(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnProfile = new GridBagConstraints();
		gbc_btnProfile.insets = new Insets(0, 0, 0, 5);
		gbc_btnProfile.gridx = 2;
		gbc_btnProfile.gridy = 0;
		panel_2.add(btnProfile, gbc_btnProfile);
		
		JLabel lblBugFreeGames = new JLabel("Bug Free Games");
		lblBugFreeGames.setForeground(new Color(255, 51, 255));
		lblBugFreeGames.setBackground(Color.GREEN);
		lblBugFreeGames.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		GridBagConstraints gbc_lblBugFreeGames = new GridBagConstraints();
		gbc_lblBugFreeGames.insets = new Insets(0, 0, 0, 5);
		gbc_lblBugFreeGames.gridx = 4;
		gbc_lblBugFreeGames.gridy = 0;
		panel_2.add(lblBugFreeGames, gbc_lblBugFreeGames);
		
		if (AuthenticationManager.getInstance().currentUser() == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginPage l = new LoginPage();
					l.setVisible(true);
					setVisible(false);
				}
			});
		} else {
			btnLogin = new JButton("Sign Out");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AuthenticationManager.getInstance().signOut();
					SearchandResults s = new SearchandResults();
					s.setVisible(true);
					setVisible(false);
				}
			});
			
			repaint();
		}
		
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.gridx = 6;
		gbc_btnLogin.gridy = 0;
		panel_2.add(btnLogin, gbc_btnLogin);
	}
}
