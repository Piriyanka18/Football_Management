package SquadDetails;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import playerManagement.MainFrame;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class SquadDetailsWindow {  

	public JFrame frame;
	public JTable table;
	public JTable table_1;
	public JTextField textField;
	public JTextField textField_1;
	public Button backButton;
	public Button nextButton;
	public DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SquadDetailsWindow window = new SquadDetailsWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//---------------------- Create the application.-------------------------------------
	 
	public SquadDetailsWindow() {
		initialize();
		
	}

	//-------------------Initialize the contents of the frame.-----------------------------
	public void initialize() {
		 viewScodeDetails();

   //--------------------------------textField for position---------------------------------
		 
		    textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField.setForeground(new Color(0, 0, 0));
			textField.setBounds(123, 510, 152, 36);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			textField_1.setBounds(123, 554, 152, 34);
			frame.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
		 
	//---------------------------------Add button---------------------------------------
		
		Object[] row = new Object[2];
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (ae.getSource()== btnNewButton) {
							
						    try {  
						        Class.forName("com.mysql.cj.jdbc.Driver");  
						        // establish connection  
						        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");   
						        Statement statement = con.createStatement();
						       statement.executeUpdate("INSERT INTO `squad` (`Position`,`Player`) " + "VALUES ('" + textField.getText() + "','" + textField_1.getText()  +"')"); 
						       
						       // Inserting data to JTable
						       
						       row[0] = textField.getText();
				               row[1] = textField_1.getText();
				               
				               model.addRow(row);	
						       JOptionPane.showMessageDialog(null, "Record inserted...");  
						       statement.close();  
						       con.close();  
						     
						    } catch (SQLException | ClassNotFoundException e) {  
						        JOptionPane.showMessageDialog(null, e);  
						    }  
						}
						}
					});		
				btnNewButton.setBounds(312, 511, 97, 37);
				frame.getContentPane().add(btnNewButton);
					
	//---------------------------------Remove button---------------------------------------	
				
				JButton btnNewButton_1 = new JButton("Remove");
				btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (ae.getSource()== btnNewButton_1) {
							
							int getSelectedRow = table_1.getSelectedRow();
							
							if(getSelectedRow != -1) {
		
								
								try {
									
									int column = 1;
									int rowData = table_1.getSelectedRow();
									String valueSelected = table_1.getModel().getValueAt(rowData, column).toString();
									
							        Class.forName("com.mysql.cj.jdbc.Driver");  
							        // establish connection  
							        
							        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");  
							        String sql = "DELETE FROM squad WHERE Player = ?";
							        PreparedStatement ps = con.prepareStatement(sql);
							        ps.setString(1, valueSelected);
							        ps.executeUpdate();
							        
							        model.removeRow(getSelectedRow);
							        JOptionPane.showMessageDialog(null, "Record deleted...");
							        ps.close(); 
							        con.close();  
							       
							        
							       
							        
							    } catch (SQLException | ClassNotFoundException e) {  
							        JOptionPane.showMessageDialog(null, e);  
							    }
							}else {
								JOptionPane.showMessageDialog(null, "Please Select a Row to Delete");
							}
							
							
						}
					}
								
				});
		btnNewButton_1.setBounds(312, 554, 97, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Position:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(24, 512, 89, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Player:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(24, 553, 75, 35);
		frame.getContentPane().add(lblNewLabel_5);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(0, 424, 649, 187);
		frame.getContentPane().add(panel_1);
		

}	
	//-----------------------------------------viewScodeDetails method------------------------------------
	
	public void viewScodeDetails() {
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
				new MainFrame();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(442, 531, 182, 49);
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
			} catch (SQLException | ClassNotFoundException e) {  
				 JOptionPane.showMessageDialog(null, e);  
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
		
		
		
	}
}