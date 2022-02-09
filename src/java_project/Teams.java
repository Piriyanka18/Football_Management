package java_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import playerManagement.MainFrame;

import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;

public class Teams {

	private JFrame frame;
	public JTable table;
	private DefaultTableModel model;
	private JTextField tfpoints;
	private JTextField tfgoals;
	private JTextField txtMatchSchedules;
	private JTextField tfid;
	
	public static void main(String[] args) {
		new Teams();
	}

	public Teams() {

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Teams.class.getResource("/SquadDetails/Squad/FCB.png")));
		frame.setResizable(false);
		frame.setTitle("Team Management");
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setBackground(new Color(0, 0, 139));
		frame.setBackground(Color.BLACK);
		frame.setBounds(250, 50, 1016, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Object[] columns = {"Team ID","Name","Matches", "Goals", "Wins", "Losts", "Draws", "Points"};
		model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columns);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		
		//////////////////////////////////// Table Connecting ////////////////////////////////////////////
		
		
		
		Object[] ro = new Object[8];
		   try {  
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football1", "root", "");
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
		
		
		//////////////////////////////////////////////Components ///////////////////////////////////////////////////////////////
		
		
		
		
		
		JComboBox<String> cbname = new JComboBox<String>();
		cbname.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbname.setModel(new DefaultComboBoxModel<String>(new String[] 
				{"Choose Name", "", "Preachers", "Fighting Cardinals", "The Predators", "Razorbacks", "Rebels",
						"Fighting Crusaders", "Avengers", "Aztecs", "Blackflies", "Blazers", "Red Devils",
						"Fighting Bees", "Purple Pride", "Buckeyes", "Los Lobos", "Comets", "Commodores", "Green Machine", "Continentals", "Bonnies"}));
		cbname.setBounds(83, 585, 137, 33);
		frame.getContentPane().add(cbname);
		
		JComboBox<String> cblost = new JComboBox<String>();
		cblost.setFont(new Font("Tahoma", Font.BOLD, 14));
		cblost.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose ", "", "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		cblost.setBounds(325, 585, 157, 33);
		frame.getContentPane().add(cblost);
		
		JComboBox<String> Cbmatches = new JComboBox<String>();
		Cbmatches.setFont(new Font("Tahoma", Font.BOLD, 14));
		Cbmatches.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose ", "", "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		Cbmatches.setBounds(83, 628, 137, 33);
		frame.getContentPane().add(Cbmatches);
		
		JComboBox<String> cbdraws = new JComboBox<String>();
		cbdraws.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbdraws.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose", "", "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		cbdraws.setBounds(325, 631, 157, 33);
		frame.getContentPane().add(cbdraws);
		
		JComboBox<String> cbwins = new JComboBox<String>();
		cbwins.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose ", "", "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		cbwins.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbwins.setBounds(325, 542, 157, 33);
		frame.getContentPane().add(cbwins);
		
		tfpoints = new JTextField();
		tfpoints.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfpoints.setBounds(325, 674, 157, 27);
		frame.getContentPane().add(tfpoints);
		tfpoints.setColumns(10);
		
		tfgoals = new JTextField();
		tfgoals.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfgoals.setColumns(10);
		tfgoals.setBounds(83, 674, 137, 27);
		frame.getContentPane().add(tfgoals);
		
		/////////////////////////////// Add Button //////////////////////////////////////////////////////////////
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Object[] row = new Object[8];
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int PPoints,PGoals;
				String Pid,Pname,Pmatches,PWins,PLosts,PDraws;
				   
			  try {
				  
				  if((Integer.parseInt( (String) cbwins.getSelectedItem()) + Integer.parseInt( (String) cblost.getSelectedItem()) + Integer.parseInt( (String) cbdraws.getSelectedItem())
				  ==Integer.parseInt( (String) Cbmatches.getSelectedItem())))
						  
					{ 
					  
  				       Pid = tfid.getText();
					   Pname =  (String) cbname.getSelectedItem();
					   Pmatches =(String) Cbmatches.getSelectedItem();
					   PGoals = Integer.parseInt(tfgoals.getText());
					   PWins = (String) cbwins.getSelectedItem();
					   PLosts = (String) cblost.getSelectedItem();
					   PDraws = (String) cbdraws.getSelectedItem();
					   PPoints = Integer.parseInt(tfpoints.getText());
					   
			       	   Class.forName("com.mysql.cj.jdbc.Driver");
						     Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football1", "root", "");
						     String query1 = "INSERT INTO `teams`"
						     		+ "( `Team ID`,`Name`, `Matches`, `Goals`,`Wins`,`Losts`, `Draws`, `Points`) "
						 		               + "VALUES ('"+ Pid+"','"+Pname+"','"+Pmatches+"','"+ PGoals+"','"+ PWins+"','"+ PLosts+"','"+ PDraws+"','"+ PPoints+"')";
			             Statement ps = con.prepareStatement(query1);
			             ps.executeUpdate(query1);
			             
			               // row[0] = dateChooser.getText();
			                row[0] = tfid.getText();
			                row[1] = (String) cbname.getSelectedItem();
							row[2] = (String) Cbmatches.getSelectedItem();
							row[3] = tfgoals.getText();
							row[4] =(String) cbwins.getSelectedItem();
							row[5] = (String) cblost.getSelectedItem();
							row[6] = (String) cbdraws.getSelectedItem();
							row[7] = tfpoints.getText();
							
							model.addRow(row);
							
							JOptionPane.showMessageDialog(null, "Team Performances Added!");
							
			  }   else {
					
					JOptionPane.showMessageDialog(null, "Please Enter Details Accurately");
			           
			       } } catch (Exception ex) {
			           JOptionPane.showMessageDialog(null,  ex.getMessage());
			       }
			   }
		});   
				
				
		btnAdd.setBounds(711, 542, 96, 33);
		frame.getContentPane().add(btnAdd);
		
		
		///////////////////////////////////////// Reset Button ///////////////////////////////////////////////////
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  tfid.setText(null);
				  tfgoals.setText(null);
				  tfpoints.setText(null);
	              cbname.setSelectedItem("Choose Name");
	              Cbmatches.setSelectedItem("Choose ");
	              cbwins.setSelectedItem("Choose ");
	              cblost.setSelectedItem("Choose ");
	              cbdraws.setSelectedItem("Choose");
				
				
			}
		});   
				
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(835, 585, 96, 33);
		frame.getContentPane().add(btnReset);
		
		
		//////////////////////////////////// Update Button ////////////////////////////////////////////////////////////
		
		JButton btnUP = new JButton("Update");
		btnUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
	         		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football1", "root", "");
	         		  
	         		 int i = table.getSelectedRow();
	         		  
	         	    if  ( tfid.getText().isEmpty() != true && i>=0) {
	         			 
		              if(cbname.getSelectedItem() != null) {
		            	  String Pname1 = (String) cbname.getSelectedItem();
		    	           String query = "UPDATE `teams` SET `Name`='"+Pname1+"' WHERE `Team ID`="+tfid.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt(cbname.getSelectedItem(), i, 1);
		            }
		            if(((String) Cbmatches.getSelectedItem()).isEmpty() != true){
		            	  String PTeam1Cb = (String) Cbmatches.getSelectedItem();
		    	           String query = "UPDATE `teams` SET `Matches`='"+PTeam1Cb+"' WHERE `Team ID`="+tfid.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String) Cbmatches.getSelectedItem(), i, 2);
		            }
		            if( tfgoals.getText().isEmpty() != true){
		    	           String Pgoal = ((String) tfgoals.getText());
		    	           String query = "UPDATE `teams` SET `Goals`='"+Pgoal+"' WHERE `Team ID`="+tfid.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String) tfgoals.getText(), i, 3);       
		            }
		            if(((String) cbwins.getSelectedItem()).isEmpty() != true){
		            	   String Pwin = (String)cbwins.getSelectedItem();
		    	           String query = "UPDATE `teams` SET `Wins`='"+Pwin+"' WHERE `Team ID`="+tfid.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt(cbwins.getSelectedItem(), i, 4);
		            }
		            if(((String) cblost.getSelectedItem()).isEmpty() != true){
    	                   String Plost = (String) cblost.getSelectedItem();  
    	                   String query = "UPDATE `teams` SET `Losts`='"+Plost+"' WHERE `Team ID`="+tfid.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String) cblost.getSelectedItem(), i, 5);
		     	           
		            }if(((String) cbdraws.getSelectedItem()).isEmpty() != true){
 	                   String Pdraw = (String)cbdraws.getSelectedItem();  
 	                   String query = "UPDATE `teams` SET `Draws`='"+Pdraw+"' WHERE `Team ID`="+tfid.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String)cbdraws.getSelectedItem(), i, 6);
		            }
		            if(tfpoints.getText().isEmpty() != true){
 	                   String Ppo = (String)tfpoints.getText();  
 	                   String query = "UPDATE `teams` SET `Points`='"+Ppo+"' WHERE `Team ID`="+tfid.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt(tfpoints.getText(), i, 7);
		            }
		           
		           
		            
		            JOptionPane.showMessageDialog(null, "Details Updated!"); 
	           }
	         	else {
	         		JOptionPane.showMessageDialog(null, "Fill Match Number and select the row before editing!");
	         	}

		       }
		    	  catch(Exception e2) {
			            JOptionPane.showMessageDialog(null,"Can't update!");
			        }
				
			
				
			}
		});
		btnUP.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUP.setBounds(835, 541, 96, 34);
		frame.getContentPane().add(btnUP);
		
		///////////////////////////////////////Delete Button ///////////////////////////////////////////////////////
		
		JButton btnDel = new JButton("Delete");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int i = table.getSelectedRow();
				  
				if(i>=0) {
					
					
			        try {
			        	Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football1", "root", "");
						String delRow = "delete from `teams` where `Team ID` ="+table.getValueAt(i,0);
			            Statement ps = con.prepareStatement(delRow);
			            ps.execute(delRow);
			           
			            JOptionPane.showMessageDialog(null, "Team Record Deleted!");
			            model.removeRow(i);
			        } catch (Exception e1) {
			            JOptionPane.showMessageDialog(null,  e1.getMessage());
			        }
				}
				else {
					JOptionPane.showConfirmDialog(frame,"Please select the record what you want to delete!");
				}
			}
		});
		
		
		//////////////////////////////////// Components //////////////////////////////////////////////
		
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDel.setBounds(711, 587, 96, 28);
		frame.getContentPane().add(btnDel);
		
		JLabel lblTeam = new JLabel("Wins ");
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setBounds(249, 542, 66, 21);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblResult = new JLabel("Draws");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResult.setForeground(Color.WHITE);
		lblResult.setBounds(249, 634, 66, 21);
		frame.getContentPane().add(lblResult);
		
		JLabel lblGoals = new JLabel("Points");
		lblGoals.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGoals.setForeground(Color.WHITE);
		lblGoals.setBounds(249, 672, 45, 27);
		frame.getContentPane().add(lblGoals);
		
		JLabel lblGoals_1 = new JLabel("Goals");
		lblGoals_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGoals_1.setForeground(Color.WHITE);
		lblGoals_1.setBounds(20, 679, 45, 13);
		frame.getContentPane().add(lblGoals_1);
		
		JLabel lblResult_1 = new JLabel("Matches");
		lblResult_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResult_1.setForeground(Color.WHITE);
		lblResult_1.setBounds(20, 638, 68, 13);
		frame.getContentPane().add(lblResult_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 0, 1012, 516);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtMatchSchedules = new JTextField();
		txtMatchSchedules.setBackground(new Color(0, 0, 128));
		txtMatchSchedules.setForeground(new Color(245, 255, 250));
		txtMatchSchedules.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMatchSchedules.setText("    Team Performances");
		txtMatchSchedules.setBounds(394, 0, 180, 49);
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
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setBounds(10, 48, 981, 459);
		panel.add(pane);
		pane.setForeground(Color.red);
		
		        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		        table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit");
				  if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Team Performance Table",JOptionPane.YES_NO_OPTION)
						  == JOptionPane.YES_NO_OPTION)
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(771, 627, 96, 34);
		frame.getContentPane().add(btnExit);
		
		JButton btnMain = new JButton("<< Main Page");
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				frame.dispose();
			}
		});
		btnMain.setBounds(729, 670, 202, 34);
		frame.getContentPane().add(btnMain);
		
		JLabel lblName = new JLabel("Losts");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(249, 591, 66, 21);
		frame.getContentPane().add(lblName);
		
		JLabel lblTeam_1_1 = new JLabel("Name");
		lblTeam_1_1.setForeground(Color.WHITE);
		lblTeam_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam_1_1.setBounds(20, 595, 68, 13);
		frame.getContentPane().add(lblTeam_1_1);
		
		JLabel lblDate = new JLabel("Number");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(10, 548, 68, 21);
		frame.getContentPane().add(lblDate);
		
		tfid = new JTextField();
		tfid.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfid.setColumns(10);
		tfid.setBounds(83, 540, 137, 27);
		frame.getContentPane().add(tfid);
		
		JLabel lblTeam_1_2 = new JLabel("Team ");
		lblTeam_1_2.setForeground(Color.WHITE);
		lblTeam_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam_1_2.setBounds(10, 526, 68, 13);
		frame.getContentPane().add(lblTeam_1_2);
		
	
		
		frame.setVisible(true);
	}
}

