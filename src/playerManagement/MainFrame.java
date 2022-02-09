package playerManagement;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import SquadDetails.SquadDetailsWindow;
import Staff.MainInt;
import java_project.Schedules;
import java_project.Teams;

public class MainFrame {

	public JFrame frmMainMenu;
	public JTable table;
	public String firstLine = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new MainFrame();
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MainFrame() {
	/**
	 * Initialize the contents of the frame.
	 */
		frmMainMenu = new JFrame();
		frmMainMenu.getContentPane().setBackground(new Color(0, 0, 102));
		frmMainMenu.getContentPane().setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setResizable(false);
		frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS\\Downloads\\FCB.png"));
		frmMainMenu.setBounds(260, 100, 929, 625);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
					
		JButton playerMgt = new JButton("Player Management");
		playerMgt.setBackground(SystemColor.info);
		playerMgt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				new playerMgt();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/SquadDetails/Squad/png-transparent-lionel-messi-kicking-ball-fifa-14-fifa-18-fifa-15-fifa-13-fifa-12-fifa-team-human-video-game.png")));
		lblNewLabel_1.setBounds(0, 397, 915, 181);
		frmMainMenu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(752, 160, 140, 130);
		frmMainMenu.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\fcb-meta-logo.png"));
		playerMgt.setFont(new Font("Tahoma", Font.BOLD, 18));
		playerMgt.setBounds(40, 80, 300, 50);
		frmMainMenu.getContentPane().add(playerMgt);
		
		
		JButton fixtures = new JButton("Fixtures");
		fixtures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				new Schedules();
			}
		});
		fixtures.setBackground(SystemColor.scrollbar);
		fixtures.setFont(new Font("Tahoma", Font.BOLD, 18));
		fixtures.setBounds(400, 80, 300, 50);
		frmMainMenu.getContentPane().add(fixtures);
		
		JButton btnNewButton = new JButton("Squads");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmMainMenu.dispose();
				SquadDetailsWindow window = new SquadDetailsWindow();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(SystemColor.scrollbar);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(40, 160, 300, 50);
		frmMainMenu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Player Ratings");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				new PlayerRatings();
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(40, 240, 300, 50);
		frmMainMenu.getContentPane().add(btnNewButton_1);
		
		JButton playerMgt_1 = new JButton("Injuries and suspensions");
		playerMgt_1.setBackground(SystemColor.scrollbar);
		playerMgt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				new MainInj();
				
			}
		});
		playerMgt_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		playerMgt_1.setBounds(40, 320, 300, 50);
		frmMainMenu.getContentPane().add(playerMgt_1);
		
		JButton playerMgt_2 = new JButton("Standings and Results");
		playerMgt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				new Teams();
			}
		});
		playerMgt_2.setBackground(SystemColor.info);
		playerMgt_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		playerMgt_2.setBounds(400, 160, 300, 50);
		frmMainMenu.getContentPane().add(playerMgt_2);
		
		JButton btnOther = new JButton("Other");
		btnOther.setBackground(SystemColor.info);
		btnOther.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOther.setBounds(400, 320, 300, 50);
		frmMainMenu.getContentPane().add(btnOther);
		
		JButton btnNewButton_3 = new JButton("Staff Management");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				MainInt window = new MainInt();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(SystemColor.scrollbar);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(400, 240, 300, 50);
		frmMainMenu.getContentPane().add(btnNewButton_3);
		
		JLabel lblClub = new JLabel("FC BARCELONA");
		lblClub.setHorizontalAlignment(SwingConstants.LEFT);
		lblClub.setFont(new Font("Bodoni MT Black", Font.BOLD, 45));
		lblClub.setForeground(UIManager.getColor("Button.light"));
		lblClub.setBounds(40, 10, 433, 40);
		frmMainMenu.getContentPane().add(lblClub);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setBounds(820, 0, 95, 588);
		frmMainMenu.getContentPane().add(panel);
		panel.setLayout(null);
		

		frmMainMenu.setVisible(true);
		
	}
}

