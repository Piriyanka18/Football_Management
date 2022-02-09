package playerManagement;

import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import SquadDetails.SquadDetailsWindow;
import Staff.MainInt;
import Staff.Registration;
import java_project.Matches;
import java_project.Schedules;

import java.sql.SQLException;


public class ViewersFrame{

	public JFrame frmMainMenu;
	JFrame coachframe;
	JFrame secondframe;
	public JTable table;
	public JTable table_1;
	public String firstLine = null;
	DefaultTableModel model ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new ViewersFrame();

	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ViewersFrame() {
	/**
	 * Initialize the contents of the frame.
	 */
		frmMainMenu = new JFrame();
		frmMainMenu.getContentPane().setBackground(new Color(0, 0, 102));
		frmMainMenu.getContentPane().setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setResizable(false);
		frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewersFrame.class.getResource("/SquadDetails/Squad/FCB.png")));
		frmMainMenu.setBounds(260, 100, 929, 625);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
					
		JButton playerMgt = new JButton("Player Management");
		playerMgt.setBackground(SystemColor.info);
		playerMgt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmMainMenu.dispose();
				JFrame frmPlayerManagement;
				JTable table;
				DefaultTableModel model;
				
				frmPlayerManagement = new JFrame();
//				frmPlayerManagement.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS\\Downloads\\FCB.png"));
				frmPlayerManagement.setIconImage(Toolkit.getDefaultToolkit().getImage(playerMgt.class.getResource("/SquadDetails/Squad/FCB.png")));
				frmPlayerManagement.setTitle("Player Management");
				frmPlayerManagement.setResizable(false);
				frmPlayerManagement.getContentPane().setForeground(Color.RED);
				frmPlayerManagement.getContentPane().setBackground(new Color(0, 0, 102));
				frmPlayerManagement.setBackground(Color.BLACK);
				frmPlayerManagement.setBounds(250, 100, 1000, 620);
				frmPlayerManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmPlayerManagement.getContentPane().setLayout(null);
				
				table = new JTable();
				table.setFont(new Font("Tahoma", Font.PLAIN, 11));
				table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				Object[] columns = {"Player Number","Name", "Age", "Preffered Foot", "Height", "Weight","Salary", "Contracted Till"};
				model = new DefaultTableModel();
				
				model.setColumnIdentifiers(columns);
				table.setModel(model);
				
				table.setBackground(Color.white);
				table.setForeground(Color.black);
				table.setSelectionBackground(Color.red);
				table.setGridColor(Color.BLUE);
				table.setSelectionForeground(Color.white);
				table.setRowHeight(30);
				table.setAutoCreateRowSorter(true);
				
				JScrollPane pane = new JScrollPane(table);
				pane.setForeground(Color.red);
				pane.setBounds(10,56,966,439);
				frmPlayerManagement.getContentPane().add(pane);
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		        
		        JPanel panel = new JPanel();
				panel.setBackground(new Color(102, 0, 0));
				panel.setBounds(0, 0, 986, 508);
				frmPlayerManagement.getContentPane().add(panel);
				panel.setLayout(null);
		        
		        JLabel lblNewLabel = new JLabel("Player Management");
				lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
				lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 32));
				lblNewLabel.setBounds(10, 10, 374, 43);
				panel.add(lblNewLabel);
		        
			//// btnMainMenu ////
				
				JButton btnMainMenu = new JButton("Main Menu");
				btnMainMenu.setForeground(Color.BLACK);
				btnMainMenu.setBackground(SystemColor.info);
				btnMainMenu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ViewersFrame();
						frmPlayerManagement.dispose();
						
					}
				});
				btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnMainMenu.setBounds(360, 525, 230, 30);
				frmPlayerManagement.getContentPane().add(btnMainMenu);
				
				///////////////////////////////////////// Starting With Table ///////////////////////////////////////
				
				
				   Object[] ro = new Object[8];
				   try {  
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						Statement stmt = con.createStatement();
						String sql="SELECT * FROM `player details` WHERE 1";
						ResultSet rs=stmt.executeQuery(sql);
						while (rs.next()) {
							
							ro[0] = rs.getString("Jersey Number");
							ro[1] = rs.getString("Name");
							ro[2] = rs.getString("Age");
							ro[3] = rs.getString("Preffered Foot");
							ro[4] = rs.getString("Height");
							ro[5] = rs.getString("Weight");
							ro[6] = rs.getString("Salary");
							ro[7] = rs.getString("Contracted Till");
							
							model.addRow(ro);
						}
						con.close();
						} 
					catch(Exception e1) {
						System.out.print(e1);
						}
				
				
				/////////////////////////////////////////////////////////////////////////////////////////////////////
				   
				   frmPlayerManagement.setVisible(true);
				   
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ViewersFrame.class.getResource("/SquadDetails/Squad/png-transparent-lionel-messi-kicking-ball-fifa-14-fifa-18-fifa-15-fifa-13-fifa-12-fifa-team-human-video-game.png")));
		lblNewLabel_1.setBounds(0, 397, 915, 181);
		frmMainMenu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(752, 160, 140, 130);
		frmMainMenu.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\fcb-meta-logo.png"));
		playerMgt.setFont(new Font("Tahoma", Font.BOLD, 18));
		playerMgt.setBounds(40, 80, 300, 50);
		frmMainMenu.getContentPane().add(playerMgt);
		
		//.......................................Fixtures..................................................................................................
		
		JButton fixtures = new JButton("Fixtures");
		fixtures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmMainMenu.dispose();
				//................................match schedules....................
				JFrame upcomingframe;
				
				upcomingframe = new JFrame();
				upcomingframe.setResizable(false);
				upcomingframe.setTitle("Match Scheduling");
				upcomingframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Schedules.class.getResource("/SquadDetails/Squad/FCB.png")));
				upcomingframe.getContentPane().setForeground(Color.RED);
				upcomingframe.getContentPane().setBackground(new Color(0,0,51));
				upcomingframe.setBackground(Color.BLACK);
				upcomingframe.setBounds(250, 120, 1000, 620);
				upcomingframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				upcomingframe.getContentPane().setLayout(null);
				
				table = new JTable();
				table.setFont(new Font("Tahoma", Font.PLAIN, 11));
				table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				Object[] columns = {"Match Number","Date","Team 1", "Team 2", "Time", "Venue"};
				model = new DefaultTableModel();
				
				model.setColumnIdentifiers(columns);
				table.setModel(model);
				
				table.setBackground(Color.white);
				table.setForeground(Color.black);
				table.setSelectionBackground(Color.red);
				table.setGridColor(Color.BLUE);
				table.setSelectionForeground(Color.white);
				table.setRowHeight(30);
				table.setAutoCreateRowSorter(true);
				
				JScrollPane pane = new JScrollPane(table);
				pane.setForeground(Color.BLUE);
				pane.setBounds(49,45,889,450);
				upcomingframe.getContentPane().add(pane);
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		        
		        Object[] ro = new Object[6];
				   try {  
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						Statement stmt = con.createStatement();
						//sdf = new SimpleDateFormat("yyyy-MM-dd"); 
						String sql="SELECT * FROM `schedules` WHERE 1";
						ResultSet rs=stmt.executeQuery(sql);
						while (rs.next()) {
							
							ro[0] = rs.getString("Match Number");
							ro[1] = rs.getString("Date");
							ro[2] = rs.getString("Team 1");
							ro[3] = rs.getString("Team 2");
							ro[4] = rs.getString("Time");
							ro[5] = rs.getString("Venue");
							
							
							model.addRow(ro);
						}
						con.close();
						} 
					catch(Exception e1) {
						System.out.print(e1);
						}
				

					
					JPanel panel = new JPanel();
					panel.setBackground(new Color(0, 0, 51));
					panel.setBounds(0, 0, 1006, 600);
					upcomingframe.getContentPane().add(panel);
					panel.setLayout(null);

					JButton match_history = new JButton("Match History");
					match_history.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							//..................match history window opens..............
							
							JFrame fixtureframe;
							
							upcomingframe.dispose();
							
							fixtureframe = new JFrame();
							fixtureframe.setTitle("Match History");
							fixtureframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Matches.class.getResource("/SquadDetails/Squad/FCB.png")));
							fixtureframe.getContentPane().setForeground(Color.RED);
							fixtureframe.getContentPane().setBackground(new Color(0, 0, 139));
							fixtureframe.setBackground(Color.BLACK);
							fixtureframe.setBounds(250, 120, 1000, 650);
							fixtureframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							fixtureframe.getContentPane().setLayout(null);
							
							table = new JTable();
							table.setFont(new Font("Tahoma", Font.PLAIN, 11));
							table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
							Object[] columns = {"Match number","Date","Team 1", "Result team 1", "Goals team 1", "Team 2", "Result team 2", "Goals team 2"};
							model = new DefaultTableModel();
							
							model.setColumnIdentifiers(columns);
							table.setModel(model);
							
							table.setBackground(Color.GRAY);
							table.setFont(new Font("Tahoma", Font.BOLD, 12));
							table.setForeground(Color.black);
							table.setSelectionBackground(Color.red);
							table.setGridColor(Color.BLUE);
							table.setSelectionForeground(Color.white);
							table.setRowHeight(30);
							table.setAutoCreateRowSorter(true);
							
							JScrollPane pane = new JScrollPane(table);
							pane.setForeground(Color.red);
							pane.setBounds(57,45,886,495);
							fixtureframe.getContentPane().add(pane);
							
							DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

					        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
					       
					        //.........................table loading............................
					        
					        Object[] ro = new Object[8];
							   try {  
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
									Statement stmt = con.createStatement();
									String sql="SELECT * FROM `matches` WHERE 1";
									ResultSet rs=stmt.executeQuery(sql);
									while (rs.next()) {
										
										ro[0] = rs.getString("match_num");
										ro[1] = rs.getString("date");
										ro[2] = rs.getString("team_1");
										ro[3] = rs.getString("result_team_1");
										ro[4] = rs.getString("goals_team_1");
										ro[5] = rs.getString("team_2");
										ro[6] = rs.getString("result_team_2");
										ro[7] = rs.getString("goals_team_2");
										
										
										
										model.addRow(ro);
									}
									con.close();
									} 
								catch(Exception ex) {
									 JOptionPane.showMessageDialog(null, ex);  
									}
							

								JPanel panel = new JPanel();
								panel.setBackground(new Color(0, 0, 51));
								panel.setBounds(0, 0, 1004, 652);
								fixtureframe.getContentPane().add(panel);
								panel.setLayout(null);
								

								JButton match_history = new JButton("Match History");
								match_history.setBounds(170, 50, 117, 53);
								fixtureframe.getContentPane().add(match_history);
								
								JButton btnNewButton = new JButton("Back");
								btnNewButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
									upcomingframe.setVisible(true);
										fixtureframe.dispose();
									}
								});
								btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
								btnNewButton.setBounds(400,560 , 200, 30);
								upcomingframe.getContentPane().add(btnNewButton);
								panel.add(btnNewButton);
								

								JTextField txtMatchSchedules = new JTextField();
								txtMatchSchedules.setBackground(new Color(0, 0, 128));
								txtMatchSchedules.setForeground(new Color(245, 255, 250));
								txtMatchSchedules.setFont(new Font("Tahoma", Font.BOLD, 14));
								txtMatchSchedules.setText("   Hey! This is the Match History");
								txtMatchSchedules.setBounds(371, 0, 239, 46);
								panel.add(txtMatchSchedules);
								txtMatchSchedules.setColumns(10);
								
								
							
							fixtureframe.setVisible(true);
							
					
						}
					});
					match_history.setBackground(SystemColor.info);
					match_history.setFont(new Font("Tahoma", Font.BOLD, 16));
					match_history.setBounds(780, 520, 150, 45);
					panel.add(match_history);
					//...............................back button......................
					
					JButton btnNewButton = new JButton("Back");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frmMainMenu.setVisible(true);
							upcomingframe.dispose();
						}
					});
					btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnNewButton.setBounds(370, 525, 230, 30);
					upcomingframe.getContentPane().add(btnNewButton);
					panel.add(btnNewButton);
					
					JTextField txtMatchSchedules = new JTextField();
					txtMatchSchedules.setBackground(new Color(0, 0, 128));
					txtMatchSchedules.setForeground(new Color(245, 255, 250));
					txtMatchSchedules.setFont(new Font("Tahoma", Font.BOLD, 14));
					txtMatchSchedules.setText("    Hey There! This is the Upcoming Match Schedule.");
					txtMatchSchedules.setBounds(323, 0, 373, 46);
					panel.add(txtMatchSchedules);
					txtMatchSchedules.setColumns(10);
				

				upcomingframe.setVisible(true);
				
			}});		
		fixtures.setBackground(SystemColor.scrollbar);
		fixtures.setFont(new Font("Tahoma", Font.BOLD, 18));
		fixtures.setBounds(400, 80, 300, 50);
		frmMainMenu.getContentPane().add(fixtures);
		
		//......................................................squads...............................................................................................
		JButton btnNewButton = new JButton("Squads");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmMainMenu.dispose();
				
				JFrame frame;
				
				frame = new JFrame();
				frame.setTitle("Squads");
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SquadDetailsWindow.class.getResource("/SquadDetails/Squad/FCB.png")));
				frame.setBackground(new Color(255, 255, 255));
				frame.getContentPane().setBackground(new Color(102, 0, 0));
				frame.getContentPane().setForeground(Color.WHITE);
				frame.setBounds(400, 90, 665, 650);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				
			//----------------------------label for upcoming squad------------------------------------------------
				
				JLabel lblNewLabel = new JLabel();
				lblNewLabel.setText("Upcomming Squad");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
				lblNewLabel.setBounds(240, 11, 289, 41);
				frame.getContentPane().add(lblNewLabel);
				
			//---------------------------label for date ------------------------------------------------------------
				
				JLabel lblNewLabel_1 = new JLabel();
				lblNewLabel_1.setText("10.10.2021");
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
				lblNewLabel_1.setBounds(265, 54, 190, 41);
				frame.getContentPane().add(lblNewLabel_1);
				
			//---------------------------------label for logo image--------------------------------------------------
				
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(SquadDetailsWindow.class.getResource("/SquadDetails/Squad/logo1.PNG")));
				lblNewLabel_3.setBounds(141, 11, 89, 86);
				frame.getContentPane().add(lblNewLabel_3);
				
			//---------------------------back to main page button-----------------------------------------------------
				
				JButton btnNewButton_2 = new JButton("BACK TO MAIN PAGE");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						new ViewersFrame();
					}
				});
				btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnNewButton_2.setBounds(141, 531, 369, 49);
				frame.getContentPane().add(btnNewButton_2);
				
			//------------------------------------------squad table-----------------------------------------------------
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(70, 108, 190, 305);
				frame.getContentPane().add(scrollPane);
				
				table_1 = new JTable();
				scrollPane.setViewportView(table_1);
				model = new DefaultTableModel();
				table_1.setModel(model);
				scrollPane.setVisible(true);
				
				
				
			    Object [] columns = {"Position", "Player"};
			    model.setColumnIdentifiers(columns);
			    
				table_1.getColumnModel().getColumn(0).setPreferredWidth(60);
				table_1.getColumnModel().getColumn(0).setMinWidth(60);
				table_1.getColumnModel().getColumn(0).setMaxWidth(64);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(126);
				table_1.getColumnModel().getColumn(1).setMinWidth(110);
				table_1.getColumnModel().getColumn(1).setMaxWidth(126);
				
				table_1.setRowHeight(22);
				
			//----------------------------------loading data from database to table----------------------------------------
				
				Object[] row = new Object[2];
					try { 
					   Class.forName("com.mysql.cj.jdbc.Driver");  
					   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");   
					   Statement statement = con.createStatement();
					   String sql = "SELECT * FROM `squad` WHERE 1";      
					   ResultSet rs= statement.executeQuery(sql);

					   while (rs.next()) {
						  row[0] = rs.getString("Position");
				          row[1] = rs.getString("Player");
						  model.addRow(row);
					   }
					   statement.close();  
					   con.close();  
					} catch (SQLException | ClassNotFoundException e1) {  
						 JOptionPane.showMessageDialog(null, e1);  
					}  
					
			//-----------------------------------Image of positions ----------------------------------------------------
				
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setIcon(new ImageIcon(SquadDetailsWindow.class.getResource("/SquadDetails/Squad/positions.PNG")));
				lblNewLabel_2.setBounds(341, 96, 283, 383);
				frame.getContentPane().add(lblNewLabel_2);
				
		   //--------------------------------labels for previous squad images------------------------------------------
				
				JLabel firstLabel = new JLabel("");
				firstLabel.setIcon(new ImageIcon(SquadDetailsWindow.class.getResource("/SquadDetails/Squad/11.jpg")));
				firstLabel.setBounds(10, 108, 313, 313);
				frame.getContentPane().add(firstLabel);
				
				JLabel secondLabel = new JLabel("");
				secondLabel.setIcon(new ImageIcon(SquadDetailsWindow.class.getResource("/SquadDetails/Squad/22.jpg")));
				secondLabel.setBounds(10, 108, 313, 313);
				frame.getContentPane().add(secondLabel);
				
				JLabel thirdLabel = new JLabel("");
				thirdLabel.setIcon(new ImageIcon(SquadDetailsWindow.class.getResource("/SquadDetails/Squad/33.jpg")));
				thirdLabel.setBounds(10, 108, 313, 313);
				frame.getContentPane().add(thirdLabel);
				
				
			//------------------------button(back button) to view previous squads------------------------------------------
				
				JButton backButton = new JButton("");
				firstLabel.setVisible(false);
				secondLabel.setVisible(false);
				thirdLabel.setVisible(false);
				scrollPane.setVisible(true);
				backButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						//firstLabel.setVisible(true);
						if(firstLabel.isVisible()) {
							lblNewLabel.setText("Previous Squad");
							lblNewLabel_1.setText("07.07.2021");
							scrollPane.setVisible(false);
							firstLabel.setVisible(false);
							secondLabel.setVisible(true);
							thirdLabel.setVisible(false);
						}else if(secondLabel.isVisible()) {
								lblNewLabel.setText("Previous Squad");
								lblNewLabel_1.setText("28.05.2021");
								scrollPane.setVisible(false);
								firstLabel.setVisible(false);
								secondLabel.setVisible(false);
								thirdLabel.setVisible(true);
						}else if(thirdLabel.isVisible()){
								lblNewLabel.setText("Previous Squad");
								lblNewLabel_1.setText("28.05.2021");
								scrollPane.setVisible(false);
								firstLabel.setVisible(false);
								secondLabel.setVisible(false);
								thirdLabel.setVisible(true);
						}else {
							//JLabel lblNewLabel = new JLabel("Previous Squad");
							lblNewLabel.setText("Previous Squad");
							lblNewLabel_1.setText("23.09.2021");
							firstLabel.setVisible(true);
							scrollPane.setVisible(false);
						}

					}
				});
				backButton.setIcon(new ImageIcon(SquadDetailsWindow.class.getResource("/SquadDetails/Squad/back1.png")));
				backButton.setBounds(101, 430, 62, 57);
				frame.getContentPane().add(backButton);
				
			//------------------------button(Next button) to view previous squads------------------------------------------
				
				JButton nextButton = new JButton("\r\n\r\n");
				nextButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(firstLabel.isVisible()) {
							scrollPane.setVisible(true);
							lblNewLabel.setText("Upcomming Squad");
							lblNewLabel_1.setText("10..2021");
							firstLabel.setVisible(false);
							secondLabel.setVisible(false);
							thirdLabel.setVisible(false);
						}else if(secondLabel.isVisible()) {
								scrollPane.setVisible(false);
								lblNewLabel.setText("Previous Squad");
								lblNewLabel_1.setText("23.09.2021");
								firstLabel.setVisible(true);
								secondLabel.setVisible(false);
								thirdLabel.setVisible(false);
						}else if(thirdLabel.isVisible()){
								scrollPane.setVisible(false);
								lblNewLabel.setText("Previous Squad");
								lblNewLabel_1.setText("07.07.2021");
								firstLabel.setVisible(false);
								secondLabel.setVisible(true);
								thirdLabel.setVisible(false);
						}else {
							scrollPane.setVisible(true);
						}
						
					}
				});
				nextButton.setIcon(new ImageIcon(SquadDetailsWindow.class.getResource("/SquadDetails/Squad/next2.png")));
				nextButton.setBounds(168, 430, 62, 57);
				frame.getContentPane().add(nextButton);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(0, 0, 102));
				panel_1.setBounds(0, 424, 649, 187);
				frame.getContentPane().add(panel_1);
							
	
								
				
				frame.setVisible(true);	
				
				
			}
		});
		btnNewButton.setBackground(SystemColor.scrollbar);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(40, 160, 300, 50);
		frmMainMenu.getContentPane().add(btnNewButton);
		
		//..............................................player ratings......................................................................................
		
		JButton btnNewButton_1 = new JButton("Player Ratings");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmMainMenu.dispose();
				JFrame frmPlayerRatings;
				JScrollPane pane;
				JTable table;
				DefaultTableCellRenderer centerRenderer;
				DefaultTableModel model;
				JPanel panel;
				JButton btnMainMenu;
				
				frmPlayerRatings = new JFrame();
				frmPlayerRatings.setIconImage(Toolkit.getDefaultToolkit().getImage(PlayerRatings.class.getResource("/SquadDetails/Squad/FCB.png")));
				frmPlayerRatings.setTitle("Player Ratings");
				frmPlayerRatings.setResizable(false);
				frmPlayerRatings.getContentPane().setForeground(Color.RED);
				frmPlayerRatings.getContentPane().setBackground(new Color(0, 0, 102));
				frmPlayerRatings.setBackground(Color.BLACK);
				frmPlayerRatings.setBounds(250, 100, 1000, 620);
				frmPlayerRatings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmPlayerRatings.getContentPane().setLayout(null);
				
				table = new JTable();
				table.setFont(new Font("Tahoma", Font.PLAIN, 11));
				table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				
				Object[] colRatings = {"Ranking","Player Number","Name", "Matches Played","Goals","Assists","Clean Sheets","Ratings"};
				
				model = new DefaultTableModel();
				model.setColumnIdentifiers(colRatings);
				
				table.setModel(model);
				table.setBackground(Color.white);
				table.setForeground(Color.black);
				table.setSelectionBackground(Color.red);
				table.setGridColor(Color.BLUE);
				table.setSelectionForeground(Color.white);
				table.setRowHeight(30);
				table.setAutoCreateRowSorter(true);
				
				pane = new JScrollPane(table);
				pane.setForeground(Color.red);
				pane.setBounds(10,56,966,439);
				
				frmPlayerRatings.getContentPane().add(pane);
				
				centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		        
		        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		        
		        panel = new JPanel();
				panel.setBackground(new Color(102, 0, 0));
				panel.setBounds(0, 0, 986, 508);
				frmPlayerRatings.getContentPane().add(panel);
				panel.setLayout(null);
		        
		        JLabel lblCaption = new JLabel("Player Ratings");
				lblCaption.setForeground(SystemColor.activeCaptionBorder);
				lblCaption.setFont(new Font("Bodoni MT Black", Font.BOLD, 32));
				lblCaption.setBounds(10, 10, 374, 43);
				panel.add(lblCaption);
				
				
		        
				///////////////////////////////////////// Starting With Table ///////////////////////////////////////
				
				
				   Object[] srow = new Object[8];
				   try {  
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						Statement stmt = con.createStatement();
						String sql="SELECT * FROM `player ratings` WHERE 1";
						ResultSet rs=stmt.executeQuery(sql);
						while (rs.next()) {
							
							srow[0] = rs.getString("Ranking");
							srow[1] = rs.getString("Player Number");
							srow[2] = rs.getString("Name");
							srow[3] = rs.getString("Matches Played");
							srow[4] = rs.getString("Goals");
							srow[5] = rs.getString("Assists");
							srow[6] = rs.getString("Clean Sheets");
							srow[7] = rs.getString("Ratings");
							
							model.addRow(srow);
						}
						con.close();
						} 
					catch(Exception e1) {
						System.out.print(e1);
						}
				
				
				/////////////////////////////////////////////////////////////////////////////////////////////////////
				   
				//// btnMainMenu ////
					
					btnMainMenu = new JButton("Main Menu");
					btnMainMenu.setForeground(Color.BLACK);
					btnMainMenu.setBackground(SystemColor.info);
					btnMainMenu.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							new ViewersFrame();
							frmPlayerRatings.dispose();
							
						}
					});
					btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
					btnMainMenu.setBounds(360, 525, 230, 30);
					frmPlayerRatings.getContentPane().add(btnMainMenu);
				
				   frmPlayerRatings.setVisible(true);
				   
			}
		});
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(40, 240, 300, 50);
		frmMainMenu.getContentPane().add(btnNewButton_1);
		
		//...........................................Injuries and Suspensions.................................................................................
		JButton playerMgt_1 = new JButton("Injuries and suspensions");
		playerMgt_1.setBackground(SystemColor.scrollbar);
		playerMgt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//----------------------Main------------------------------//
				frmMainMenu.dispose();
				JFrame ViewersFrame;
				
				ViewersFrame = new JFrame();
				ViewersFrame.setTitle("Injuries and Suspensions");
				ViewersFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(PlayerRatings.class.getResource("/SquadDetails/Squad/FCB.png")));
				ViewersFrame.getContentPane().setBackground(new Color(0, 0, 102));
				ViewersFrame.getContentPane().setLayout(null);
				
				//-------------------Injuries--------------------------//
				
				JButton btnNewButton = new JButton("Injuries");
				btnNewButton.setForeground(Color.BLACK);
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton.setBackground(SystemColor.info);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						JFrame frmInjury;
						JTable table;
						DefaultTableModel model;
						
						frmInjury = new JFrame();
						frmInjury.setIconImage(Toolkit.getDefaultToolkit().getImage(Injuries_main.class.getResource("/SquadDetails/Squad/FCB.png")));
						frmInjury.setTitle("Injured Players");
						frmInjury.setResizable(false);
						frmInjury.getContentPane().setForeground(Color.RED);
						frmInjury.getContentPane().setBackground(new Color(0, 0, 102));
						frmInjury.setBackground(Color.BLACK);
						frmInjury.setBounds(250, 100, 1000, 620);
						frmInjury.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frmInjury.getContentPane().setLayout(null);
						
						table = new JTable();
						table.setFont(new Font("Tahoma", Font.PLAIN, 11));
						table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						Object[] columns = {"Player Number","Name", "Injury Type ", "Recovery Time"};
						model = new DefaultTableModel();
						
						model.setColumnIdentifiers(columns);
						table.setModel(model);
						
						table.setBackground(Color.white);
						table.setForeground(Color.black);
						table.setSelectionBackground(Color.red);
						table.setGridColor(Color.BLUE);
						table.setSelectionForeground(Color.white);
						table.setRowHeight(30);
						table.setAutoCreateRowSorter(true);
						
						JScrollPane pane = new JScrollPane(table);
						pane.setForeground(Color.red);
						pane.setBounds(10,56,966,439);
						frmInjury.getContentPane().add(pane);
						
						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

				        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				        
				        JPanel panel = new JPanel();
						panel.setBackground(new Color(102, 0, 0));
						panel.setBounds(0, 0, 986, 508);
						frmInjury.getContentPane().add(panel);
						panel.setLayout(null);
				        
				        JLabel lblNewLabel = new JLabel("Injured Players");
						lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
						lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 32));
						lblNewLabel.setBounds(10, 10, 374, 43);
						panel.add(lblNewLabel);
						
						JButton btnMainMenu = new JButton("Main Menu");
						btnMainMenu.setForeground(Color.BLACK);
						btnMainMenu.setBackground(SystemColor.info);
						btnMainMenu.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frmInjury.dispose();
								new ViewersFrame();
	
							}
						});
						btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
						btnMainMenu.setBounds(360, 525, 230, 30);
						frmInjury.getContentPane().add(btnMainMenu);
				        
						///////////////////////////////////////// Starting With Table ///////////////////////////////////////
						
						
						   Object[] ro = new Object[4];
						   try {  
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
								Statement stmt = con.createStatement();
								String sql="SELECT * FROM `injury` WHERE 1";
								ResultSet rs=stmt.executeQuery(sql);
								while (rs.next()) {
									
									ro[0] = rs.getString("Player Number");
									ro[1] = rs.getString("Name");
									ro[2] = rs.getString("Injury Type");
									ro[3] = rs.getString("Recovery Time");
									
									model.addRow(ro);
								}
								con.close();
								} 
							catch(Exception e1) {
								System.out.print(e1);
								}
						
						
						/////////////////////////////////////////////////////////////////////////////////////////////////////
						   
						   frmInjury.setVisible(true);
						   ViewersFrame.dispose();
							
					}
				});
				
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon(MainInj.class.getResource("/SquadDetails/Squad/fcb-meta-logo.png")));
				lblNewLabel.setBounds(266, 84, 142, 147);
				ViewersFrame.getContentPane().add(lblNewLabel);
				
				
				
				
				btnNewButton.setBounds(50, 84, 150, 45);
				ViewersFrame.getContentPane().add(btnNewButton);
				
				//-------------------Suspensions--------------------------//
				
				JButton btnNewButton_1 = new JButton("Suspension");
				btnNewButton_1.setForeground(Color.BLACK);
				btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JFrame frmSuspended;
						JTable table;
						DefaultTableModel model;
						
						frmSuspended = new JFrame();
						frmSuspended.setIconImage(Toolkit.getDefaultToolkit().getImage(Suspended_main.class.getResource("/SquadDetails/Squad/FCB.png")));
						frmSuspended.setTitle("Suspended Players");
						frmSuspended.setResizable(false);
						frmSuspended.getContentPane().setForeground(Color.RED);
						frmSuspended.getContentPane().setBackground(new Color(0, 0, 102));
						frmSuspended.setBackground(Color.BLACK);
						frmSuspended.setBounds(250, 100, 1000, 620);
						frmSuspended.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frmSuspended.getContentPane().setLayout(null);
						
						table = new JTable();
						table.setFont(new Font("Tahoma", Font.PLAIN, 11));
						table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						Object[] columns = {"Player Number","Name", "Yellow Cards ", "Red Cards", "Suspended Matches Count"};
						model = new DefaultTableModel();
						
						model.setColumnIdentifiers(columns);
						table.setModel(model);
						
						table.setBackground(Color.white);
						table.setForeground(Color.black);
						table.setSelectionBackground(Color.red);
						table.setGridColor(Color.BLUE);
						table.setSelectionForeground(Color.white);
						table.setRowHeight(30);
						table.setAutoCreateRowSorter(true);
						
						JScrollPane pane = new JScrollPane(table);
						pane.setForeground(Color.red);
						pane.setBounds(10,56,966,439);
						frmSuspended.getContentPane().add(pane);
						
						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

				        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
				        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
				        
				        JPanel panel = new JPanel();
						panel.setBackground(new Color(102, 0, 0));
						panel.setBounds(0, 0, 986, 508);
						frmSuspended.getContentPane().add(panel);
						panel.setLayout(null);
						
						JLabel lblNewLabel = new JLabel("Suspended Players");
						lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
						lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 32));
						lblNewLabel.setBounds(10, 10, 374, 43);
						panel.add(lblNewLabel);
						
					//// btnMainMenu ////
						
						JButton btnMainMenu = new JButton("Main Menu");
						btnMainMenu.setForeground(Color.BLACK);
						btnMainMenu.setBackground(SystemColor.info);
						btnMainMenu.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frmSuspended.dispose();
								new ViewersFrame();
								
								
							}
						});
						btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
						btnMainMenu.setBounds(360, 525, 230, 30);
						frmSuspended.getContentPane().add(btnMainMenu);
				        
						///////////////////////////////////////// Starting With Table ///////////////////////////////////////
						
						
						   Object[] ro = new Object[5];
						   try {  
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
								Statement stmt = con.createStatement();
								String sql="SELECT * FROM `suspended` WHERE 1";
								ResultSet rs=stmt.executeQuery(sql);
								while (rs.next()) {
									
									ro[0] = rs.getString("Player Number");
									ro[1] = rs.getString("Name");
									ro[2] = rs.getString("Yellow Cards");
									ro[3] = rs.getString("Red Cards");
									ro[4] = rs.getString("Suspended Matches");
									
									model.addRow(ro);
								}
								con.close();
								} 
							catch(Exception e1) {
								System.out.print(e1);
								}
						   
						   frmSuspended.setVisible(true);
						   ViewersFrame.dispose();
						
					}
				});
				btnNewButton_1.setBackground(SystemColor.info);
				btnNewButton_1.setBounds(50, 186, 150, 45);
				ViewersFrame.getContentPane().add(btnNewButton_1);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(102, 0, 0));
				panel.setForeground(Color.WHITE);
				panel.setBounds(333, 0, 142, 326);
				ViewersFrame.getContentPane().add(panel);
				ViewersFrame.setBounds(500, 200, 489, 363);
				ViewersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JButton btnNewButton_3 = new JButton("Back");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ViewersFrame.dispose();
						new ViewersFrame();
					}
			});
				panel.setLayout(null);
				btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_3.setBorderPainted(false);			btnNewButton_3.setBackground(SystemColor.info);
				btnNewButton_3.setBounds(33,278, 75, 27);
				panel.add(btnNewButton_3);
				
				ViewersFrame.setVisible(true);
				frmMainMenu.dispose();
				
				
			}
				
		});
		playerMgt_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		playerMgt_1.setBounds(40, 320, 300, 50);
		frmMainMenu.getContentPane().add(playerMgt_1);
		
		//............................................Standings and Results.............................................................
		
		JButton playerMgt_2 = new JButton("Standings and Results");
		playerMgt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmMainMenu.dispose();
				JFrame standingsframe;
				
				standingsframe = new JFrame();
				standingsframe.setResizable(false);
				standingsframe.setTitle("Team Management");
				standingsframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/SquadDetails/Squad/FCB.png")));
				standingsframe.getContentPane().setForeground(Color.RED);
				standingsframe.getContentPane().setBackground(new Color(25, 25, 112));
				standingsframe.setBackground(Color.BLACK);
				standingsframe.setBounds(250, 100, 1016, 550);
				standingsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				standingsframe.getContentPane().setLayout(null);
				Object[] columns = {"Team ID","Name","Matches", "Goals", "Wins", "Losts", "Draws", "Points"};
				model = new DefaultTableModel();
				
				model.setColumnIdentifiers(columns);
				
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
				
		        JPanel panel = new JPanel();
				panel.setBackground(new Color(0, 0, 139));
				panel.setBounds(0, 0, 1012, 400);
				standingsframe.getContentPane().add(panel);
				panel.setLayout(null);
				
				JTextField txtMatchSchedules = new JTextField();
				txtMatchSchedules.setBackground(new Color(0, 0, 128));
				txtMatchSchedules.setForeground(new Color(245, 255, 250));
				txtMatchSchedules.setFont(new Font("Tahoma", Font.BOLD, 14));
				txtMatchSchedules.setText("   See The Team Performances!   ");
				txtMatchSchedules.setBounds(383, 0, 242, 48);
				panel.add(txtMatchSchedules);
				txtMatchSchedules.setColumns(10);
				
				table = new JTable();
				table.setFont(new Font("Tahoma", Font.PLAIN, 14));
				table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				table.setModel(model);
				
				table.setBackground(Color.white);
				table.setForeground(Color.black);
				table.setSelectionBackground(Color.red);
				table.setGridColor(Color.BLUE);
				table.setSelectionForeground(Color.white);
				table.setRowHeight(30);
				table.setAutoCreateRowSorter(true);
				
				JScrollPane pane = new JScrollPane(table);
				pane.setBounds(10, 48, 981, 650);
				panel.add(pane);
				pane.setForeground(Color.red);
				
				//...........................................connecting table.................................
				Object[] ro = new Object[8];
				   try {  
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						Statement stmt = con.createStatement();
						String sql="SELECT * FROM `teams` WHERE 1";
						ResultSet rs=stmt.executeQuery(sql);
						while (rs.next()) {
							
							ro[0] = rs.getString("Team ID");
							ro[1] = rs.getString("Name");
							ro[2] = rs.getString("Matches");
							ro[3] = rs.getString("Goals");
							ro[4] = rs.getString("Wins");
							ro[5] = rs.getString("Losts");
							ro[6] = rs.getString("Draws");
							ro[7] = rs.getString("Points");
							
							
							
							model.addRow(ro);
						}
						con.close();
						} 
					catch(Exception e1) {
						System.out.print(e1);
						}

					        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
					        table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

					        JButton btnNewButton = new JButton("Back");
							btnNewButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									frmMainMenu.setVisible(true);
									standingsframe.dispose();
									
								}
							});
							btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
							btnNewButton.setBounds(390, 430, 200, 30);
							standingsframe.getContentPane().add(btnNewButton);
							
		        standingsframe.setVisible(true);
				
				
			}
		});
		playerMgt_2.setBackground(SystemColor.info);
		playerMgt_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		playerMgt_2.setBounds(400, 160, 300, 50);
		frmMainMenu.getContentPane().add(playerMgt_2);
		
//..................................................Other.....................................................................................................		
		JButton btnOther = new JButton("Other");
		btnOther.setBackground(SystemColor.info);
		btnOther.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOther.setBounds(400, 320, 300, 50);
		frmMainMenu.getContentPane().add(btnOther);
	//......................................................staff management......................................................................................
		
		JButton btnNewButton_3 = new JButton("Staff Management");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmMainMenu.dispose();
	
				JFrame frame;
				frame = new JFrame();
				frame.setTitle("Staff Management");
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainInt.class.getResource("/SquadDetails/Squad/FCB.png")));
				frame.getContentPane().setBackground(new Color(0, 0, 51));
				frame.setBounds(450, 180, 656, 530);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				
				
				
				JLabel lblNewLabel = new JLabel("STAFF MANAGEMENT");
				lblNewLabel.setBounds(22, 44, 671, 80);
				lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
				lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 46));
				frame.getContentPane().add(lblNewLabel);
				
				
				JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setBounds(428, 203, 146, 165);
				frame.getContentPane().add(lblNewLabel_1);
				lblNewLabel_1  .setIcon(new ImageIcon(MainInt.class.getResource("/SquadDetails/Squad/fcb-meta-logo.png")));
				
				//................medical staff........................
				
				JButton btnNewButton = new JButton("Medical Staff");
				btnNewButton.setBounds(73, 154, 245, 61);
				btnNewButton.setBorderPainted(false);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						
						secondframe = new JFrame();
						secondframe.setTitle("Medical Staff");
						secondframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/SquadDetails/Squad/FCB.png")));
						secondframe.setBounds(220, 100, 1125, 640);
						secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						secondframe.getContentPane().setLayout(null);
						
						JPanel panel = new JPanel();
						panel.setBackground(new Color(0, 0, 51));
						panel.setForeground(Color.BLACK);
						panel.setBounds(0, 0, 1111, 647);
						secondframe.getContentPane().add(panel);
						panel.setLayout(null);
						
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setSize(new Dimension(0, 5));
						scrollPane.setBounds(11, 49, 1090, 416);
						panel.add(scrollPane);
						table = new JTable();
						table.setRowHeight(30);
						
						
						model =new DefaultTableModel();
						table.addMouseListener(new MouseAdapter() {
							
						});;
						table.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"ID", "Name", "Designation", "Address", "Contact No", "Email"
							}
						));
						table.getColumnModel().getColumn(0).setPreferredWidth(55);
						table.getColumnModel().getColumn(3).setPreferredWidth(86);
						table.getColumnModel().getColumn(4).setPreferredWidth(107);
						scrollPane.setViewportView(table);
						
						//...................................loading data from the database.................
						Connection con;
						
						
						Object[] col = new Object[6];
						 try {  
								Class.forName("com.mysql.cj.jdbc.Driver");
								 con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
								Statement stmt = con.createStatement();
								String sql="SELECT * FROM `medical` WHERE 1";
								ResultSet rs=stmt.executeQuery(sql);
								table.setModel(DbUtils.resultSetToTableModel(rs));

								while (rs.next()) {
									
									col [0] = rs.getString("Id");
									col [1] = rs.getString("Name");
									col [2] = rs.getString("Designation");
									col [3] = rs.getString("Address");
									col [4] = rs.getString("Contact No");
									col [5] = rs.getString("Email");
									
									
									
									model.addRow(col);
								}
								con.close();
								
								
						 }
							catch(Exception e1) {
								;
								System.out.print(e1);
							}
							
						
					

							JLabel lblNewLabel = new JLabel("MEDICAL STAFF");
							lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
							lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 29));
							lblNewLabel.setBounds(11, 10, 285, 40);
							panel.add(lblNewLabel);
							
							
							JButton btnNewButton_1_1 = new JButton("<-BACK");
							btnNewButton_1_1.setBounds(435, 500, 200, 40);
							btnNewButton_1_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								frmMainMenu.setVisible(true);
								
								secondframe.dispose();
								}

							});
							btnNewButton_1_1.setForeground(new Color(0, 0, 51));
							btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
							btnNewButton_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panel.add(btnNewButton_1_1);
//						
						 
						secondframe.setVisible(true);
						frame.dispose();;
					}
				});
				btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
				btnNewButton.setBackground(SystemColor.info);
				btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
				frame.getContentPane().add(btnNewButton);
				
				
				//.................................Coach view................................
				
				JButton btnNewButton_1 = new JButton("Coaches");
				btnNewButton_1.setBounds(73, 251, 245, 61);
				btnNewButton_1.setBorderPainted(false);
				btnNewButton_1.setBackground(SystemColor.scrollbar);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						coachframe = new JFrame();
						coachframe.setTitle("Coaches");
						coachframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/SquadDetails/Squad/FCB.png")));
						coachframe.setBounds(250, 75, 1031, 580);
						coachframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						coachframe.getContentPane().setLayout(null);
						

						JPanel panel = new JPanel();
						panel.setBackground(new Color(0, 0, 51));
						panel.setBounds(0, 10, 1017, 420);
						coachframe.getContentPane().add(panel);
						panel.setLayout(null);
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(10, 59, 997, 351);
						panel.add(scrollPane);
						
						JPanel panel_1 = new JPanel();
						panel_1.setBackground(new Color(0, 0, 51));
						panel_1.setBounds(0, 431, 1017, 246);
						coachframe.getContentPane().add(panel_1);
						
						JLabel lblNewLabel = new JLabel("COACH DETAILS");
						lblNewLabel.setBounds(10, -13, 411, 80);
						panel.add(lblNewLabel);
						lblNewLabel.setForeground(new Color(204, 204, 204));
						lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 29));
						
						
						JButton btnNewButton_1 = new JButton("<-BACK");
						btnNewButton_1.setBorderPainted(false);
						btnNewButton_1.setBackground(SystemColor.info);
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							
								frmMainMenu.setVisible(true);
								coachframe.dispose();
							}
						});
						btnNewButton_1.setForeground(new Color(0, 0, 51));
						btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
						btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
						btnNewButton_1.setBounds(400, 30, 200, 40);
						panel_1.add(btnNewButton_1);
						panel_1.setLayout(null);
						
						table = new JTable();
						table.setRowHeight(30);
						table.setModel(new DefaultTableModel(
							new Object[][] {
								{null, null, null, null, null, null},
							},
							new String[] {
								"ID", "Name", "Designation", "Address", "ContactNo", "Email"
							}
							
						
						));
						
						table.getColumnModel().getColumn(0).setPreferredWidth(55);
						table.getColumnModel().getColumn(3).setPreferredWidth(86);
						table.getColumnModel().getColumn(4).setPreferredWidth(107);
						scrollPane.setViewportView(table);
						Connection con;
						
						
						Object[] col = new Object[6];
						 try {  
								Class.forName("com.mysql.cj.jdbc.Driver");
								 con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
								Statement stmt = con.createStatement();
								String sql="SELECT * FROM `coaches` WHERE 1";
								ResultSet rs=stmt.executeQuery(sql);
								table.setModel(DbUtils.resultSetToTableModel(rs));

								while (rs.next()) {
									
									col [0] = rs.getString("Id");
									col [1] = rs.getString("Name");
									col [2] = rs.getString("Designation");
									col [3] = rs.getString("Address");
									col [4] = rs.getString("Contact No");
									col [5] = rs.getString("Email");
								
									
									
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.addRow(col);
								}
								con.close();
								}
								

							catch(Exception e1) {
								;
								System.out.print(e1);
							}
							
						 
							
//						
						
											
						coachframe.setVisible(true);
						frame.dispose();
					}
					
				});
				btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
				btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
				frame.getContentPane().add(btnNewButton_1);
				
				//..............................other staff.......................
				
				
				JButton btnNewButton_2 = new JButton("Other Staff");
				btnNewButton_2.setBounds(73, 359, 245, 67);
				btnNewButton_2.setBackground(SystemColor.info);
				btnNewButton_2.setBorderPainted(false);
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						JFrame otherframe;
						
					otherframe = new JFrame();
					otherframe.setTitle("Other Staff");
					otherframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/SquadDetails/Squad/FCB.png")));
					otherframe.setBounds(250, 50, 1094, 700);
					otherframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					otherframe.getContentPane().setLayout(null);
					

					JPanel panel = new JPanel();
					panel.setBackground(new Color(0, 0, 51));
					panel.setBounds(0, 0, 1080, 699);
					otherframe.getContentPane().add(panel);
					panel.setLayout(null);
						
					//........................back button.........................	
					JButton btnNewButton_1 = new JButton("<-BACK");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frmMainMenu.setVisible(true);
							otherframe.dispose();
							
						}
					});
					btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
					btnNewButton_1.setForeground(new Color(0, 0, 51));
					btnNewButton_1.setBounds(425, 600, 200, 40);
					panel.add(btnNewButton_1);
					
					JLabel lblNewLabel = new JLabel("OTHER STAFF");
					lblNewLabel.setForeground(new Color(192, 192, 192));
					lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 25));
					lblNewLabel.setBounds(10, 5, 424, 48);
					panel.add(lblNewLabel);
					//..................................................................
					
					
					
					table = new JTable();
					table.setRowHeight(30);
					table.setBounds(540, 5, 0, 0);
					panel.add(table);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBackground(new Color(102, 0, 0));
					scrollPane.setBounds(10, 47, 1060, 529);
					panel.add(scrollPane);
					
					table_1 = new JTable();
				
					table_1.setRowHeight(30);
					table_1.setModel(new DefaultTableModel(
						new Object[][] {
							{null, null, null, null, null, null},
						},
						new String[] {
							"ID", "Name", "Designation", "Address", "ContactNo", "Email"
						}
					));
					
					
				//.....................load table.............................
					Connection con;
					
					
					Object[] col = new Object[6];
					 try {  
							Class.forName("com.mysql.cj.jdbc.Driver");
							 con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
							Statement stmt = con.createStatement();
							String sql="SELECT * FROM `otherstaff` WHERE 1";
							ResultSet rs=stmt.executeQuery(sql);
							table_1.setModel(DbUtils.resultSetToTableModel(rs));

							while (rs.next()) {
								
								col [0] = rs.getString("Id");
								col [1] = rs.getString("Name");
								col [2] = rs.getString("Designation");
								col [3] = rs.getString("Address");
								col [4] = rs.getString("Contact No");
								col [5] = rs.getString("Email");
							
								
								
								DefaultTableModel model = (DefaultTableModel) table_1.getModel();
								model.addRow(col);
							}
							con.close();
							}
							

						catch(Exception e1) {
							;
							System.out.print(e1);
						}
						
					scrollPane.setViewportView(table_1);
					
					
					
					
						otherframe.setVisible(true);
						frame.dispose();
					}
				});
				btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
				btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
				frame.getContentPane().add(btnNewButton_2);
				
				
	//...................................................................................................
				
				
				JLabel medic = new JLabel("");
				medic.setBounds(573, 395, 190, 165);
				frame.getContentPane().add(medic);
				
				JPanel panel = new JPanel();
				panel.setBounds(495, 0, 157, 587);
				panel.setBackground(new Color(102, 0, 0));
				frame.getContentPane().add(panel);
				panel.setLayout(null);
				
				JButton btnNewButton_3 = new JButton("Back");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						new ViewersFrame();
						
					}
				});
				btnNewButton_3.setBorderPainted(false);
				btnNewButton_3.setBackground(SystemColor.info);
				btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton_3.setBounds(27, 431, 85, 31);
				panel.add(btnNewButton_3);

				frame.setVisible(true);
				
				
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
	public void load_table() {
		Connection con;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
	Object[] col = new Object[6];
	 try {  
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
			Statement stmt = con.createStatement();
			String sql="SELECT * FROM `medical` WHERE 1";
			ResultSet rs=stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));

			while (rs.next()) {
				
				col [0] = rs.getString("Id");
				col [1] = rs.getString("Name");
				col [2] = rs.getString("Designation");
				col [3] = rs.getString("Address");
				col [4] = rs.getString("Contact No");
				col [5] = rs.getString("Email");
				
				
				
				model.addRow(col);
			}
			con.close();
			
			
	 }
		catch(Exception e1) {
			;
			System.out.print(e1);
		}
		
	 frmMainMenu.setVisible(true);
	
}
	
}


	