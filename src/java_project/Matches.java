package java_project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;

import playerManagement.MainFrame;
import java.awt.Toolkit;

public class Matches {

	private JFrame frame;
	public JTable table;
	private DefaultTableModel model;
	private JTextField textMatchNum;
	private JTextField textGoals2;
	private JTextField textGoals1;
	private JDateChooser dc_1;
	private JTextField txtMatchSchedules;
	private java.util.Date date;
	
	public static void main(String[] args) {
	
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public Matches() {

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Matches.class.getResource("/SquadDetails/Squad/FCB.png")));
		frame.setTitle("Match History");
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setBackground(new Color(0, 0, 139));
		frame.setBackground(Color.BLACK);
		frame.setBounds(250, 50, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		pane.setBounds(10,45,976,459);
		frame.getContentPane().add(pane);
		
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
       
        
        
///////////////////////////////////////// Starting With Table ///////////////////////////////////////
		
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
			catch(Exception e1) {
				System.out.print(e1);
				}
        
       

///////////////////////////////////////////////Components //////////////////////////////////////////////////////
        
		
		JComboBox<String> Team1Cb = new JComboBox<String>();
		Team1Cb.setFont(new Font("Tahoma", Font.BOLD, 14));
		Team1Cb.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose Name", 
				"Preachers", "Fighting Cardinals", "The Predators", "Razorbacks", "Rebels", 
				"Fighting Crusaders", "Avengers", "Aztecs", "Blackflies", "Blazers", "Red Devils", 
				"Fighting Bees", "Purple Pride", "Buckeyes", "Los Lobos", "Comets", "Commodores",
				"Green Machine", "Continentals", "Bonnies"}));
		Team1Cb.setBounds(83, 585, 137, 33);
		frame.getContentPane().add(Team1Cb);
		
		JComboBox<String> Team2Cb = new JComboBox<String>();
		Team2Cb.setFont(new Font("Tahoma", Font.BOLD, 14));
		Team2Cb.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose Name", "Preachers", "Fighting Cardinals", 
				"The Predators", "Razorbacks", "Rebels", "Fighting Crusaders", "Avengers", "Aztecs", "Blackflies", "Blazers", 
				"Red Devils", "Fighting Bees", "Purple Pride", "Buckeyes", "Los Lobos", "Comets", "Commodores", 
				"Green Machine", "Continentals", "Bonnies"}));
		Team2Cb.setBounds(338, 585, 144, 33);
		frame.getContentPane().add(Team2Cb);
		
		JComboBox<String> Result1Cb = new JComboBox<String>();
		Result1Cb.setFont(new Font("Tahoma", Font.BOLD, 14));
		Result1Cb.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose ", "Won", "Draw ", "Lost"}));
		Result1Cb.setBounds(83, 628, 137, 33);
		frame.getContentPane().add(Result1Cb);
		
		JComboBox<String> Result2Cb = new JComboBox<String>();
		Result2Cb.setFont(new Font("Tahoma", Font.BOLD, 14));
		Result2Cb.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose", "Won", "Draw ", "Lost"}));
		Result2Cb.setBounds(338, 631, 144, 33);
		frame.getContentPane().add(Result2Cb);
		
		textMatchNum = new JTextField();
		textMatchNum.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMatchNum.setBounds(338, 536, 143, 27);
		frame.getContentPane().add(textMatchNum);
		textMatchNum.setColumns(10);
		
		textGoals2 = new JTextField();
		textGoals2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textGoals2.setBounds(338, 674, 144, 27);
		frame.getContentPane().add(textGoals2);
		textGoals2.setColumns(10);
		
		textGoals1 = new JTextField();
		textGoals1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textGoals1.setColumns(10);
		textGoals1.setBounds(83, 674, 137, 27);
		frame.getContentPane().add(textGoals1);
		
		
		//////////////////////////////////////  Add Button //////////////////////////////////////////////////////
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Object[] row = new Object[8];
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int PMatchNum,PGoals1,PGoals2;
				String PResult2Cb,PResult1Cb,PTeam2Cb,PTeam1Cb;
				 java.util.Date Pdate;	  
				

		
		
		 try {
			   
		    	if(  Team1Cb.getSelectedItem() != Team2Cb.getSelectedItem()){
					 
		    		 
					   PMatchNum =  Integer.parseInt(textMatchNum.getText());
				       Pdate =dc_1.getDate();	
					   
					   PGoals1 = Integer.parseInt(textGoals1.getText());
					   PGoals2 = Integer.parseInt(textGoals2.getText());
					   PResult2Cb = (String) Result2Cb.getSelectedItem();
					   PResult1Cb = (String) Result1Cb.getSelectedItem();
					   PTeam2Cb = (String) Team2Cb.getSelectedItem();
					   PTeam1Cb = (String) Team1Cb.getSelectedItem(); 
		    		
		    					   

		       	   Class.forName("com.mysql.cj.jdbc.Driver");
					     Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
					     String query1 = "INSERT INTO `matches`( `match_num`,`date`, `team_1`, `result_team_1`,`goals_team_1`,`team_2`, `result_team_2`, `goals_team_2`) "
					 		               + "VALUES ('"+ PMatchNum+"','"+Pdate+"','"+PTeam1Cb+"','"+ PResult1Cb+"','"+PGoals1+"','"+PTeam2Cb+"','"+PResult2Cb+"','"+PGoals2+"')";
		             Statement ps = con.prepareStatement(query1);
		             ps.executeUpdate(query1);
		             
		                row[0] = textMatchNum.getText();
		                row[1] = dc_1.getDate();
		                row[2] = (String) Team1Cb.getSelectedItem();
						row[3] = (String) Result1Cb.getSelectedItem();
						row[4] = textGoals1.getText();
						row[5] = (String) Team2Cb.getSelectedItem();
						row[6] = (String) Result2Cb.getSelectedItem();
						row[7] = textGoals2.getText();
		             
	
						
						model.addRow(row);
						JOptionPane.showMessageDialog(null, "Match History Details Added!");
		    	}						
						
						else {
					
						JOptionPane.showMessageDialog(null, "Match can not be conducted between one team! Please specify two teams");
					
		           
		       }} catch (Exception ex) {
		           JOptionPane.showMessageDialog(null,  ex.getMessage());
		       }
		   }
	});
		btnAdd.setBounds(659, 560, 96, 33);
		frame.getContentPane().add(btnAdd);
		
		
		////////////////////////////////// Reset Button ////////////////////////////////////////////////////////////////
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

					textMatchNum.setText(null);
					dc_1.setDate(null);
					Team1Cb.setSelectedItem("Choose Name");
					Result1Cb.setSelectedItem("Choose ");
					textGoals1.setText(null);
					textGoals2.setText(null);
					Team2Cb.setSelectedItem("Choose Name");
					Result2Cb.setSelectedItem("Choose");
					
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(822, 560, 96, 33);
		frame.getContentPane().add(btnReset);
		
		
		////////////////////////////////////////////// Update Button ////////////////////////////////////////////////////////////////
		
		JButton btnUP = new JButton("Update");
		btnUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
	         		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
	         		  
	         		 int i = table.getSelectedRow();
	         		  
	         	    if  (textMatchNum.getText().isEmpty() != true && i>=0) {
	         			 
		              if(dc_1.getDate() != null) {
                          java.util.Date Pdate = dc_1.getDate();;
		    	           String query = "UPDATE `matches` SET `date`='"+Pdate+"' WHERE `match_num`="+textMatchNum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt(dc_1.getDate(), i, 1);
		            }
		            if(((String) Team1Cb.getSelectedItem()).isEmpty() != true){
		            	  String PTeam1Cb = (String) Team1Cb.getSelectedItem();
		    	           String query = "UPDATE `matches` SET `team_1`='"+PTeam1Cb+"' WHERE `match_num`="+textMatchNum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String) Team1Cb.getSelectedItem(), i, 2);
		            }
		            if(((String) Result1Cb.getSelectedItem()).isEmpty() != true){
		    	           String PResult1Cb = (String) Result1Cb.getSelectedItem();
		    	           String query = "UPDATE `matches` SET `result_team_1`='"+PResult1Cb+"' WHERE `match_num`="+textMatchNum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String) Result1Cb.getSelectedItem(), i, 3);       
		            }
		            if(((String) textGoals1.getText()).isEmpty() != true){
		            	   String PGoals1 = (String)textGoals1.getText();
		    	           String query = "UPDATE `matches` SET `goals_team_1`='"+PGoals1+"' WHERE `match_num`="+textMatchNum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt(textGoals1.getText(), i, 4);
		            }
		            if(((String) Team2Cb.getSelectedItem()).isEmpty() != true){
     	                   String PTeam2Cb = (String)Team2Cb.getSelectedItem();  
     	                   String query = "UPDATE `matches` SET `team_2`='"+PTeam2Cb+"' WHERE `match_num`="+textMatchNum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String)Team2Cb.getSelectedItem(), i, 5);
		     	           
		            }if(((String) Result2Cb.getSelectedItem()).isEmpty() != true){
  	                   String PResult2Cb = (String)Result2Cb.getSelectedItem();  
  	                   String query = "UPDATE `matches` SET `result_team_2`='"+PResult2Cb+"' WHERE `match_num`="+textMatchNum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String)Result2Cb.getSelectedItem(), i, 6);
		            }
		            if(((String) textGoals2.getText()).isEmpty() != true){
  	                   String PGoals2 = (String)textGoals2.getText();  
  	                   String query = "UPDATE `matches` SET `goals_team_2`='"+PGoals2+"' WHERE `match_num`="+textMatchNum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String)textGoals2.getText(), i, 7);
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
		btnUP.setBounds(822, 609, 96, 34);
		frame.getContentPane().add(btnUP);
		
		
		////////////////////////////////////// Delete Button ///////////////////////////////////////////////////////////
		
		JButton btnDel = new JButton("Delete");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				int i = table.getSelectedRow();
				  
				if(i>=0) {
					
					
			        try {
			        	Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						String delRow = "delete from `matches` where `match_num` ="+table.getValueAt(i,0);
			            Statement ps = con.prepareStatement(delRow);
			            ps.execute(delRow);
			           
			            JOptionPane.showMessageDialog(null, "Match history Deleted!");
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
		
		/////////////////////////////////////////////////////////////////////////
		
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDel.setBounds(659, 609, 96, 28);
		frame.getContentPane().add(btnDel);
		
		JLabel lblNewLabel = new JLabel("Match Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(229, 537, 125, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTeam = new JLabel("Team 2");
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setBounds(257, 564, 66, 21);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResult.setForeground(Color.WHITE);
		lblResult.setBounds(290, 641, 66, 21);
		frame.getContentPane().add(lblResult);
		
		JLabel lblGoals = new JLabel("Goals");
		lblGoals.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGoals.setForeground(Color.WHITE);
		lblGoals.setBounds(290, 676, 45, 27);
		frame.getContentPane().add(lblGoals);
		
		JLabel lblGoals_1 = new JLabel("Goals");
		lblGoals_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGoals_1.setForeground(Color.WHITE);
		lblGoals_1.setBounds(20, 679, 45, 13);
		frame.getContentPane().add(lblGoals_1);
		
		JLabel lblResult_1 = new JLabel("Result");
		lblResult_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResult_1.setForeground(Color.WHITE);
		lblResult_1.setBounds(20, 638, 68, 13);
		frame.getContentPane().add(lblResult_1);
		
		JLabel lblTeam_1 = new JLabel("Team 1");
		lblTeam_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam_1.setForeground(Color.WHITE);
		lblTeam_1.setBounds(10, 568, 68, 13);
		frame.getContentPane().add(lblTeam_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 0, 996, 516);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtMatchSchedules = new JTextField();
		txtMatchSchedules.setBackground(new Color(0, 0, 128));
		txtMatchSchedules.setForeground(new Color(245, 255, 250));
		txtMatchSchedules.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMatchSchedules.setText("    Match History");
		txtMatchSchedules.setBounds(381, 0, 137, 47);
		panel.add(txtMatchSchedules);
		txtMatchSchedules.setColumns(10);
		
		/////////////////////////////////// Exit Button ////////////////////////////////////////////////////////////////
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit");
				  if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Match History Table",JOptionPane.YES_NO_OPTION)
						  == JOptionPane.YES_NO_OPTION)
				System.exit(0);
			}
		});
		
		
		//////////////////////////////////////////////////////////////////////////
		
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(659, 657, 96, 34);
		frame.getContentPane().add(btnExit);
		
		JButton btnMain = new JButton("<< Main Page");
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				frame.dispose();
			}
		});
		btnMain.setBounds(788, 657, 180, 34);
		frame.getContentPane().add(btnMain);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(288, 597, 66, 21);
		frame.getContentPane().add(lblName);
		
		JLabel lblTeam_1_1 = new JLabel("Name");
		lblTeam_1_1.setForeground(Color.WHITE);
		lblTeam_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam_1_1.setBounds(20, 595, 68, 13);
		frame.getContentPane().add(lblTeam_1_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(20, 537, 45, 21);
		frame.getContentPane().add(lblDate);
		
		dc_1 = new JDateChooser();
		dc_1.setDate(date);
		dc_1.setDateFormatString("yyyy-MM-dd");
		dc_1.setBounds(83, 536, 137, 27);
		frame.getContentPane().add(dc_1);
		
		frame.setVisible(true);
	}
}

