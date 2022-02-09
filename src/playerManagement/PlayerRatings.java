package playerManagement;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class PlayerRatings {

	private JFrame frmPlayerRatings;
	private JScrollPane pane;
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableCellRenderer centerRenderer;
	private JTextField textName;
	private JTextField textMatches;
	private JTextField textGoals;
	private JTextField textRanking;
	private JTextField textAssist;
	private JTextField textCleanSheet;
	private JTextField textRating;
	private JTextField textJNum;
	private JLabel lblMatches;
	private JLabel lblGoals;
	private JLabel lblRanking;
	private JLabel lblAssists;
	private JLabel lblCleanSheets;
	private JLabel lblName;
	private JLabel lblRating;
	private JLabel lblPnum;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnRemove;
	private JButton btnReset;
	private JButton btnMainMenu;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new PlayerRatings();
	
	}

	/**
	 * Create the application.
	 */
	public PlayerRatings() {
 
		frmPlayerRatings = new JFrame();
		frmPlayerRatings.setIconImage(Toolkit.getDefaultToolkit().getImage(PlayerRatings.class.getResource("/SquadDetails/Squad/FCB.png")));
		frmPlayerRatings.setTitle("Player Ratings");
		frmPlayerRatings.setResizable(false);
		frmPlayerRatings.getContentPane().setForeground(Color.RED);
		frmPlayerRatings.getContentPane().setBackground(new Color(0, 0, 102));
		frmPlayerRatings.setBackground(Color.BLACK);
		frmPlayerRatings.setBounds(250, 50, 1000, 750);
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
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// textName
		textName = new JTextField();
		textName.setBounds(300, 560, 150, 40);
		frmPlayerRatings.getContentPane().add(textName);
		textName.setColumns(10);
		
		// lblName
		
		lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(300, 538, 100, 20);
		frmPlayerRatings.getContentPane().add(lblName);
		
		// textMatches
		
		textMatches = new JTextField();
		textMatches.setColumns(10);
		textMatches.setBounds(475, 560, 125, 40);
		frmPlayerRatings.getContentPane().add(textMatches);
		
		// textGoals
		
		textGoals = new JTextField();
		textGoals.setColumns(10);
		textGoals.setBounds(25, 647, 125, 40);
		frmPlayerRatings.getContentPane().add(textGoals);
		
		// textRanking
		
		textRanking = new JTextField();
		textRanking.setColumns(10);
		textRanking.setBounds(25, 560, 125, 40);
		frmPlayerRatings.getContentPane().add(textRanking);
		
		// textAssist
		
		textAssist = new JTextField();
		textAssist.setColumns(10);
		textAssist.setBounds(175, 647, 125, 40);
		frmPlayerRatings.getContentPane().add(textAssist);
		
		// textCleanSheet
		
		textCleanSheet = new JTextField();
		textCleanSheet.setColumns(10);
		textCleanSheet.setBounds(325, 647, 125, 40);
		frmPlayerRatings.getContentPane().add(textCleanSheet);
		
		// lblMatches
		
		lblMatches = new JLabel("Matches");
		lblMatches.setForeground(Color.WHITE);
		lblMatches.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatches.setBounds(475, 538, 78, 20);
		frmPlayerRatings.getContentPane().add(lblMatches);
		
		// lblGoals
		
		lblGoals = new JLabel("Goals");
		lblGoals.setForeground(Color.WHITE);
		lblGoals.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGoals.setBounds(25, 625, 120, 20);
		frmPlayerRatings.getContentPane().add(lblGoals);
		
		// lblRanking
		
		lblRanking = new JLabel("Ranking");
		lblRanking.setForeground(Color.WHITE);
		lblRanking.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRanking.setBounds(25, 538, 100, 20);
		frmPlayerRatings.getContentPane().add(lblRanking);
		
		//lblAssists
		
		lblAssists = new JLabel("Assists");
		lblAssists.setForeground(Color.WHITE);
		lblAssists.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAssists.setBounds(175, 625, 100, 20);
		frmPlayerRatings.getContentPane().add(lblAssists);
		
		// lblCleanSheets
		
		lblCleanSheets = new JLabel("Clean Sheets");
		lblCleanSheets.setForeground(Color.WHITE);
		lblCleanSheets.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCleanSheets.setBounds(325, 625, 120, 20);
		frmPlayerRatings.getContentPane().add(lblCleanSheets);
		
		// btnAdd
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(SystemColor.info);
		
		Object[] erow = new Object[8];
		
		// BtnAdd ActionListener
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Pmatches,Pcleansheet,PJNum,Pgoals,Passist,Prankings;
				String Pname;
				double Pratings;   
				   
				   try {
					  
					   Pname = textName.getText();
					   Pmatches = Integer.parseInt(textMatches.getText());
					   Pgoals = Integer.parseInt(textGoals.getText());
					   PJNum = Integer.parseInt(textJNum.getText());
					   Passist = Integer.parseInt(textAssist.getText());
					   Prankings = Integer.parseInt(textRanking.getText());
					   Pratings = Double.parseDouble(textRating.getText());
					   Pcleansheet = Integer.parseInt(textCleanSheet.getText());
					   
			       	   Class.forName("com.mysql.cj.jdbc.Driver");
						     Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						     String query1 = "INSERT INTO `player ratings`( `Ranking`,`Player Number`,`Name`, `Matches Played`, `Goals`,`Assists`, `Clean Sheets`,`Ratings`) "
						 		               + "VALUES ('"+Prankings+"','"+PJNum+"','"+Pname+"','"+Pmatches+"','"+Pgoals+"','"+Passist+"','"+Pcleansheet+"','"+Pratings+"')";
			             Statement ps = con.prepareStatement(query1);
			             ps.executeUpdate(query1);
			             
			               erow[0] = textRanking.getText();
			               erow[1] = textJNum.getText();
			               erow[2] = textName.getText();
			               erow[3] = textMatches.getText();
			               erow[4] = textGoals.getText();
			               erow[5] = textAssist.getText();
			               erow[6] = textCleanSheet.getText();
			               erow[7] = textRating.getText();
							
							model.addRow(erow);
							
							JOptionPane.showMessageDialog(null, "Ranking Details Added!");
			           
			       } catch (Exception ex) {
			           JOptionPane.showMessageDialog(null,  ex.getMessage());
			       }
			   }
		});
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(700, 534, 100, 40);
		frmPlayerRatings.getContentPane().add(btnAdd);
		
		// btnEdit
		
		btnEdit = new JButton("Edit");
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setBackground(SystemColor.info);
		
		// btnEdit Action Listener
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    
			     try {
                          Class.forName("com.mysql.cj.jdbc.Driver");
		         		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
		         		  
		         		 int i = table.getSelectedRow();
	  
		         	if(textJNum.getText().isEmpty() != true && i>=0) {
		         		
			             if(textName.getText().isEmpty() != true) {
                               String newName = textName.getText();
			    	           String query = "UPDATE `player ratings` SET `Name`='"+newName+"' WHERE `Player Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(textName.getText(), i, 2);

			            }
			            if(textMatches.getText().isEmpty() != true){
			    	           int newMatches = Integer.parseInt(textMatches.getText());
			    	           String query = "UPDATE `player ratings` SET `Matches Played`='"+newMatches+"' WHERE `Player Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textMatches.getText()), i, 3);

			            }
			            if(textGoals.getText().isEmpty() != true){
			    	           int newGoals = Integer.parseInt(textGoals.getText());
			    	           String query = "UPDATE `player ratings` SET `Goals`='"+newGoals+"' WHERE `Player Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textGoals.getText()), i, 4);
       
			            }
			            if(textRating.getText().isEmpty() != true) {
                               double newRating = Double.parseDouble(textRating.getText());
			    	           String query = "UPDATE `player ratings` SET `Ratings`='"+newRating+"' WHERE `Player Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Double.parseDouble(textRating.getText()), i, 7);

			            }
			            if(textRanking.getText().isEmpty() != true){
			    	           int newRanking = Integer.parseInt(textRanking.getText());
			    	           String query = "UPDATE `player ratings` SET `Ranking`='"+newRanking+"' WHERE `Player Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textRanking.getText()), i, 0);

			            }
			            if(textAssist.getText().isEmpty() != true){
			    	           int newAssist = Integer.parseInt(textAssist.getText());
			    	           String query = "UPDATE `player ratings` SET `Assists`='"+newAssist+"' WHERE `Player Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textAssist.getText()), i, 5);

			            }
			            if(textCleanSheet.getText().isEmpty() != true){
			    	           int newCleanSheet = Integer.parseInt(textCleanSheet.getText());
			    	           String query = "UPDATE `player ratings` SET `Clean Sheets`='"+newCleanSheet+"'WHERE `Player Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textCleanSheet.getText()), i, 6);

			     	           
			            }
			            
			            JOptionPane.showMessageDialog(null, "Ratings Updated!"); 
		           }
		         	else {
		         		JOptionPane.showMessageDialog(null, "Fill Player Number and select the row before editing!");
		         	}
 
			       }
			    	  catch(Exception e2) {
				            JOptionPane.showMessageDialog(null,"Can't update!");
				        }
			      }
			
			}
		);
		
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBounds(830, 534, 100, 40);
		frmPlayerRatings.getContentPane().add(btnEdit);
		
		// btnRemove
		
		btnRemove = new JButton("Remove");
		btnRemove.setForeground(Color.BLACK);
		btnRemove.setBackground(SystemColor.info);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				int i = table.getSelectedRow();
				  
				if(i>=0) {
					
					
			        try {
			        	Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						String delRow = "delete from `player ratings` where `Player Number` ="+table.getValueAt(i,1);
			            Statement ps = con.prepareStatement(delRow);
			            ps.execute(delRow);
			           
			            JOptionPane.showMessageDialog(null, "Player " +table.getValueAt(i,2) +" Deleted!");
			            model.removeRow(i);
			        } catch (Exception e1) {
			            JOptionPane.showMessageDialog(null,  e1.getMessage());
			        }
				}
				 else {
					JOptionPane.showMessageDialog(frmPlayerRatings,"Please select the player raw you wish to delete!");
				}
				
				}
		});
		
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRemove.setBounds(700, 594, 100, 40);
		frmPlayerRatings.getContentPane().add(btnRemove);
		
		// textRating
		
		textRating = new JTextField();
		textRating.setColumns(10);
		textRating.setBounds(475, 646, 125, 40);
		frmPlayerRatings.getContentPane().add(textRating);
		
		// lblId
		
		lblPnum = new JLabel("Player Num.");
		lblPnum.setForeground(Color.WHITE);
		lblPnum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPnum.setBounds(175, 538, 100, 20);
		frmPlayerRatings.getContentPane().add(lblPnum);
		
		/// Red Panel ///
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setBounds(0, 0, 986, 508);
		frmPlayerRatings.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCaption = new JLabel("Player Ratings");
		lblCaption.setForeground(SystemColor.activeCaptionBorder);
		lblCaption.setFont(new Font("Bodoni MT Black", Font.BOLD, 32));
		lblCaption.setBounds(10, 10, 374, 43);
		panel.add(lblCaption);
		
		///// btnReset
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(SystemColor.info);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textMatches.setText("");
				textGoals.setText("");
				textRanking.setText("");
				textAssist.setText("");
				textCleanSheet.setText("");
				textJNum.setText("");
				textRating.setText("");
			}
		});
		
		
		btnReset.setBounds(830, 594, 100, 40);
		frmPlayerRatings.getContentPane().add(btnReset);
		
		//// btnMainMenu ////
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setForeground(Color.BLACK);
		btnMainMenu.setBackground(SystemColor.info);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				frmPlayerRatings.dispose();
				
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMainMenu.setBounds(700, 656, 230, 30);
		frmPlayerRatings.getContentPane().add(btnMainMenu);
		
		////// textJNum
		
		textJNum = new JTextField();
		textJNum.setBackground(Color.WHITE);
		textJNum.setBounds(175, 560, 100, 40);
		frmPlayerRatings.getContentPane().add(textJNum);
		textJNum.setColumns(10);
		
		///// lblPNum
		
		lblRating = new JLabel("Rating");
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRating.setForeground(Color.WHITE);
		lblRating.setBounds(475, 625, 100, 20);
		frmPlayerRatings.getContentPane().add(lblRating);
		

		frmPlayerRatings.setVisible(true);
	    
	    
	}
}

