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


public class Schedules {

	private JFrame frame;
	public JTable table;
	private DefaultTableModel model;
	private JTextField tfmatchnum;
	private JTextField txtMatchSchedules;
	//private java.util.Date date;
	Statement ps;
	private JDateChooser dc_1;
	
	
	public static void main(String[] args) {
		new Schedules();
	}

	public Schedules() {

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Schedules.class.getResource("/SquadDetails/Squad/FCB.png")));
		frame.setResizable(false);
		frame.setTitle("Match Scheduling");
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setBackground(new Color(0, 0, 139));
		frame.setBackground(Color.BLACK);
		frame.setBounds(250, 50, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		pane.setForeground(Color.red);
		pane.setBounds(10,45,964,459);
		frame.getContentPane().add(pane);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        
        
///////////////////////////////////////// Starting With Table ///////////////////////////////////////
		
          Object[] ro = new Object[6];
		   try {  
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
				Statement stmt = con.createStatement(); 
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
        
       

/////////////////////////////////////////////Components ////////////////////////////////////////////////////////
        
		JComboBox<String> cb1 = new JComboBox<String>();
		cb1.setFont(new Font("Tahoma", Font.BOLD, 14));
		cb1.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose Name", 
				"Preachers", "Fighting Cardinals", "The Predators", "Razorbacks", "Rebels", 
				"Fighting Crusaders", "Avengers", "Aztecs", "Blackflies", "Blazers", "Red Devils", 
				"Fighting Bees", "Purple Pride", "Buckeyes", "Los Lobos", "Comets", "Commodores",
				"Green Machine", "Continentals", "Bonnies"}));
		cb1.setBounds(83, 604, 137, 33);
		frame.getContentPane().add(cb1);
		
		JComboBox<String> cb2 = new JComboBox<String>();
		cb2.setFont(new Font("Tahoma", Font.BOLD, 14));
		cb2.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose Name", "Preachers", "Fighting Cardinals", 
				"The Predators", "Razorbacks", "Rebels", "Fighting Crusaders", "Avengers", "Aztecs", "Blackflies", "Blazers", 
				"Red Devils", "Fighting Bees", "Purple Pride", "Buckeyes", "Los Lobos", "Comets", "Commodores", 
				"Green Machine", "Continentals", "Bonnies"}));
		cb2.setBounds(338, 604, 144, 33);
		frame.getContentPane().add(cb2);
		
		JComboBox<String> cbtime = new JComboBox<String>();
		cbtime.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbtime.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose ", "9.00 a.m. onwards", "3.00 p.m. onwards"}));
		cbtime.setBounds(83, 658, 137, 33);
		frame.getContentPane().add(cbtime);
		
		JComboBox<String> cbvenue = new JComboBox<String>();
		cbvenue.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbvenue.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose", "St. James Park", 
				"Old Trafford", "Wembley Stadium", "Oakwell Stadium"}));
		cbvenue.setBounds(338, 658, 144, 33);
		frame.getContentPane().add(cbvenue);
		
		tfmatchnum = new JTextField();
		tfmatchnum.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfmatchnum.setBounds(338, 548, 144, 27);
		frame.getContentPane().add(tfmatchnum);
		tfmatchnum.setColumns(10);
		
		
//////////////////////////////////////Add Button //////////////////////////////////////////
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Object[] row = new Object[6];
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int PMatchNum;
				String Pvenue,Ptime,P1,P2;
				 java.util.Date Pnewdate;	  
		
		
		
			    
				 try {
					   
				    	if( cb1.getSelectedItem() != cb2.getSelectedItem()){
	  				       
						   PMatchNum =  Integer.parseInt(tfmatchnum.getText());
						   Pnewdate =  dc_1.getDate();				   
						   P1 = (String) cb1.getSelectedItem();
						   P2 = (String) cb2.getSelectedItem();
						   Ptime = (String) cbtime.getSelectedItem();
						   Pvenue = (String) cbvenue.getSelectedItem();
						   
				       	   Class.forName("com.mysql.cj.jdbc.Driver");
							     Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
							     String query1 = "INSERT INTO `schedules`( `Match Number`,`Date`, `Team 1`, `Team 2`,`Time`,`Venue`) "
							 		               + "VALUES ('"+PMatchNum+"','"+Pnewdate+"','"+P1+"','"+ P2+"','"+Ptime+"','"+Pvenue+"')";
				             Statement ps = con.prepareStatement(query1);
				             ps.executeUpdate(query1);
				             
				                row[0] = tfmatchnum.getText();
				                row[1]=  dc_1.getDate();
				                row[2] = (String) cb1.getSelectedItem();
								row[3] = (String) cb2.getSelectedItem();
								row[4] = (String) cbtime.getSelectedItem();
								row[5] = (String) cbvenue.getSelectedItem();	
								
								model.addRow(row);
								JOptionPane.showMessageDialog(null, "Match Details Added!");
				    	}						
														
							
								else {
					
								JOptionPane.showMessageDialog(null, "Match can not be conducted between one team! Please specify two teams");
				       }} catch (Exception ex) {
				           JOptionPane.showMessageDialog(null,  ex.getMessage());
				       }
				   }
			});
		
		
		btnAdd.setBounds(659, 526, 96, 33);
		frame.getContentPane().add(btnAdd);
		
		/////////////////////////////////// Reset Button //////////////////////////////////////
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  tfmatchnum.setText(null);
				  dc_1.setDate(null);
	              cb1.setSelectedItem("Choose Name");
			      cb2.setSelectedItem("Choose Name");
				  cbtime.setSelectedItem("Choose ");
				  cbvenue.setSelectedItem("Choose");
					
				
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(822, 526, 96, 33);
		frame.getContentPane().add(btnReset);
		
		
		
		////////////////////////////////// Update Button /////////////////////////////////////
		
		JButton btnUP = new JButton("Update");
		btnUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
	         		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
	         		  
	         		 int i = table.getSelectedRow();
	         		  
	         	    if  (tfmatchnum.getText().isEmpty() != true && i>=0) {
	         			 
		              if(dc_1.getDate() != null) {
                          java.util.Date newdate = dc_1.getDate();;
		    	           String query = "UPDATE `schedules` SET `Date`='"+newdate+"' WHERE `Match Number`="+tfmatchnum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt(dc_1.getDate(), i, 1);
		            }
		            if(((String) cb1.getSelectedItem()).isEmpty() != true){
		            	  String newteam1 = (String) cb1.getSelectedItem();
		    	           String query = "UPDATE `schedules` SET `Team 1`='"+newteam1+"' WHERE `Match Number`="+tfmatchnum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String) cb1.getSelectedItem(), i, 2);
		            }
		            if(((String) cb2.getSelectedItem()).isEmpty() != true){
		    	           String newteam2 = (String) cb2.getSelectedItem();
		    	           String query = "UPDATE `schedules` SET `Team 2`='"+newteam2+"' WHERE `Match Number`="+tfmatchnum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String) cb2.getSelectedItem(), i, 3);       
		            }
		            if(((String) cbtime.getSelectedItem()).isEmpty() != true){
		            	   String newTime = (String)cbtime.getSelectedItem();
		    	           String query = "UPDATE `schedules` SET `Time`='"+newTime+"' WHERE `Match Number`="+tfmatchnum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String)cbtime.getSelectedItem(), i, 4);
		            }
		            if(((String) cbvenue.getSelectedItem()).isEmpty() != true){
     	                   String newVenue = (String)cbvenue.getSelectedItem();  
     	                   String query = "UPDATE `schedules` SET `Venue`='"+newVenue+"' WHERE `Match Number`="+tfmatchnum.getText();
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		     	           table.setValueAt((String)cbvenue.getSelectedItem(), i, 5);
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
		btnUP.setBounds(822, 569, 96, 34);
		frame.getContentPane().add(btnUP);
		
		
		////////////////////////////// Delete Button ////////////////////////////////////////////////////////
		
		JButton btnDel = new JButton("Delete");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				int i = table.getSelectedRow();
				  
				if(i>=0) {
					
					
			        try {
			        	Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						String delRow = "delete from `schedules` where `Match Number` ="+table.getValueAt(i,0);
			            Statement ps = con.prepareStatement(delRow);
			            ps.execute(delRow);
			           
			            JOptionPane.showMessageDialog(null, "Schedule Record Deleted!");
			            model.removeRow(i);
			        } catch (Exception e1) {
			            JOptionPane.showMessageDialog(null,  e1.getMessage());
			        }
				}
				else {
					JOptionPane.showConfirmDialog(frame,"Please select the record what you want to delete!");
				}
				
				}
			}
		);
		
		//////////////////////////////////////Components ////////////////////////////
		
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDel.setBounds(659, 569, 96, 33);
		frame.getContentPane().add(btnDel);
		
		JLabel lblNewLabel = new JLabel("Match Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(230, 551, 125, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTeam = new JLabel("Team 2");
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setBounds(250, 604, 66, 21);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblResult = new JLabel("Venue");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResult.setForeground(Color.WHITE);
		lblResult.setBounds(250, 664, 66, 21);
		frame.getContentPane().add(lblResult);
		
		JLabel lblResult_1 = new JLabel("Time");
		lblResult_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResult_1.setForeground(Color.WHITE);
		lblResult_1.setBounds(20, 668, 68, 13);
		frame.getContentPane().add(lblResult_1);
		
		JLabel lblTeam_1 = new JLabel("Team 1");
		lblTeam_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam_1.setForeground(Color.WHITE);
		lblTeam_1.setBounds(20, 604, 68, 13);
		frame.getContentPane().add(lblTeam_1);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 0, 1006, 516);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtMatchSchedules = new JTextField();
		txtMatchSchedules.setBackground(new Color(0, 0, 128));
		txtMatchSchedules.setForeground(new Color(245, 255, 250));
		txtMatchSchedules.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMatchSchedules.setText("    Match Schedules");
		txtMatchSchedules.setBounds(401, 0, 146, 46);
		panel.add(txtMatchSchedules);
		txtMatchSchedules.setColumns(10);
		
		
		////////////////////////////// Exit Button //////////////////////////////
		
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
		btnExit.setBounds(733, 613, 96, 34);
		frame.getContentPane().add(btnExit);
		
		JButton btnMain = new JButton("<< Main Page");
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MainFrame();
				frame.dispose();
			}
		});
		btnMain.setBounds(806, 664, 168, 34);
		frame.getContentPane().add(btnMain);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(250, 624, 66, 13);
		frame.getContentPane().add(lblName);
		
		JLabel lblTeam_1_1 = new JLabel("Name");
		lblTeam_1_1.setForeground(Color.WHITE);
		lblTeam_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam_1_1.setBounds(20, 624, 68, 13);
		frame.getContentPane().add(lblTeam_1_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(20, 554, 45, 21);
		frame.getContentPane().add(lblDate);
		
		
		dc_1 = new JDateChooser();
		dc_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dc_1.setBounds(80, 548, 140, 27);
		frame.getContentPane().add(dc_1);
		
		JButton btnMain_1 = new JButton("<< Match History");
		btnMain_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       new Matches();
			       frame.dispose();
			}
		});
		btnMain_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMain_1.setBounds(601, 666, 168, 34);
		frame.getContentPane().add(btnMain_1);
		
		
		frame.setVisible(true);}
		
		
	

	public String getDcDateFormatString() {
		return dc_1.getDateFormatString();
	}
	public void setDcDateFormatString(String dateFormatString) {
		dc_1.setDateFormatString(dateFormatString);
	}
}

