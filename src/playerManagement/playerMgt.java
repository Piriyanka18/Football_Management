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

public class playerMgt {

	private JFrame frmPlayerManagement;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textName;
	private JLabel lblName;
	private JTextField textAge;
	private JTextField textPrefFoot;
	private JTextField textHeight;
	private JTextField textWeight;
	private JTextField textContract;
	private JLabel lblAge;
	private JLabel lblPrefFoot;
	private JLabel lblHeight;
	private JLabel lblWeight;
	private JLabel lblContract;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnRemove;
	private JTextField textSalary;
	private JTextField textJNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new playerMgt();
	
	}

	/**
	 * Create the application.
	 */
	public playerMgt() {
 
		frmPlayerManagement = new JFrame();
		frmPlayerManagement.setIconImage(Toolkit.getDefaultToolkit().getImage(playerMgt.class.getResource("/SquadDetails/Squad/FCB.png")));
		frmPlayerManagement.setTitle("Player Management");
		frmPlayerManagement.setResizable(false);
		frmPlayerManagement.getContentPane().setForeground(Color.RED);
		frmPlayerManagement.getContentPane().setBackground(new Color(0, 0, 102));
		frmPlayerManagement.setBackground(Color.BLACK);
		frmPlayerManagement.setBounds(250, 50, 1000, 750);
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
		
		// textName
		textName = new JTextField();
		textName.setBounds(150, 560, 150, 40);
		frmPlayerManagement.getContentPane().add(textName);
		textName.setColumns(10);
		
		// lblName
		
		lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(150, 538, 100, 20);
		frmPlayerManagement.getContentPane().add(lblName);
		
		// textAge
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(325, 560, 125, 40);
		frmPlayerManagement.getContentPane().add(textAge);
		
		// TextPrefFoot
		
		textPrefFoot = new JTextField();
		textPrefFoot.setColumns(10);
		textPrefFoot.setBounds(475, 560, 125, 40);
		frmPlayerManagement.getContentPane().add(textPrefFoot);
		
		// textHeight
		
		textHeight = new JTextField();
		textHeight.setColumns(10);
		textHeight.setBounds(25, 647, 125, 40);
		frmPlayerManagement.getContentPane().add(textHeight);
		
		// textWeight
		
		textWeight = new JTextField();
		textWeight.setColumns(10);
		textWeight.setBounds(175, 647, 125, 40);
		frmPlayerManagement.getContentPane().add(textWeight);
		
		// textContract
		
		textContract = new JTextField();
		textContract.setColumns(10);
		textContract.setBounds(475, 647, 125, 40);
		frmPlayerManagement.getContentPane().add(textContract);
		
		// lblAge
		
		lblAge = new JLabel("Age");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(325, 538, 100, 20);
		frmPlayerManagement.getContentPane().add(lblAge);
		
		// lblPrefFoot
		
		lblPrefFoot = new JLabel("Preffered Foot");
		lblPrefFoot.setForeground(Color.WHITE);
		lblPrefFoot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrefFoot.setBounds(475, 538, 120, 20);
		frmPlayerManagement.getContentPane().add(lblPrefFoot);
		
		// lblHeight
		
		lblHeight = new JLabel("Height");
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHeight.setBounds(25, 625, 100, 20);
		frmPlayerManagement.getContentPane().add(lblHeight);
		
		//lblWeight
		
		lblWeight = new JLabel("Weight");
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWeight.setBounds(175, 625, 100, 20);
		frmPlayerManagement.getContentPane().add(lblWeight);
		
		// lblContract
		
		lblContract = new JLabel("Contracted Till");
		lblContract.setForeground(Color.WHITE);
		lblContract.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContract.setBounds(475, 625, 120, 20);
		frmPlayerManagement.getContentPane().add(lblContract);
		
		// btnAdd
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(SystemColor.info);
		
		Object[] row = new Object[8];
		
		// BtnAdd ActionListener
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Page,Pcontract,PJNum,Psalary;
				String Pname,Pfoot;
				double Pweight,Pheight;   
				   
				   try {
					  
					   Pname = textName.getText();
					   Page = Integer.parseInt(textAge.getText());
					   Pfoot = textPrefFoot.getText();
					   PJNum = Integer.parseInt(textJNum.getText());
					   Pweight = Double.parseDouble(textWeight.getText());
					   Pheight = Double.parseDouble(textHeight.getText());
					   Psalary = Integer.parseInt(textSalary.getText());
					   Pcontract = Integer.parseInt(textContract.getText());
					   PJNum = Integer.parseInt(textJNum.getText());
					   
			       	   Class.forName("com.mysql.cj.jdbc.Driver");
						     Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						     String query1 = "INSERT INTO `Player Details`( `Jersey Number`,`Name`, `Age`, `Preffered Foot`,`Height`, `Weight`,`Salary`, `Contracted Till`) "
						 		               + "VALUES ('"+PJNum+"','"+Pname+"','"+Page+"','"+Pfoot+"','"+Pheight+"','"+Pweight+"','"+Psalary+"','"+Pcontract+"')";
			             Statement ps = con.prepareStatement(query1);
			             ps.executeUpdate(query1);
			             
			                row[0] = textJNum.getText();
			                row[1] = textName.getText();
							row[2] = textAge.getText();
							row[3] = textPrefFoot.getText();
							row[4] = textHeight.getText();
							row[5] = textWeight.getText();
							row[6] = textSalary.getText();
							row[7] = textContract.getText();
							
							model.addRow(row);
							
							JOptionPane.showMessageDialog(null, "Player Details Added!");
			           
			       } catch (Exception ex) {
			           JOptionPane.showMessageDialog(null,  ex.getMessage());
			       }
			   }
		});
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(700, 534, 100, 40);
		frmPlayerManagement.getContentPane().add(btnAdd);
		
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
			    	           String query = "UPDATE `player details` SET `Name`='"+newName+"' WHERE `Jersey Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(textName.getText(), i, 1);

			            }
			            if(textAge.getText().isEmpty() != true){
			    	           int newAge = Integer.parseInt(textAge.getText());
			    	           String query = "UPDATE `player details` SET `Age`='"+newAge+"' WHERE `Jersey Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textAge.getText()), i, 2);

			            }
			            if(textPrefFoot.getText().isEmpty() != true){
			    	           String newPrefFoot = textPrefFoot.getText();
			    	           String query = "UPDATE `player details` SET `Preffered Foot`='"+newPrefFoot+"' WHERE `Jersey Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(textPrefFoot.getText(), i, 3);
       
			            }
			            if(textSalary.getText().isEmpty() != true) {
                               int newSalary = Integer.parseInt(textSalary.getText());
			    	           String query = "UPDATE `player details` SET `Salary`='"+newSalary+"' WHERE `Jersey Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textSalary.getText()), i, 6);

			            }
			            if(textHeight.getText().isEmpty() != true){
			    	           double newHeight = Double.parseDouble(textHeight.getText());
			    	           String query = "UPDATE `player details` SET `Height`='"+newHeight+"' WHERE `Jersey Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Double.parseDouble(textHeight.getText()), i, 4);

			            }
			            if(textWeight.getText().isEmpty() != true){
			    	           double newWeight = Double.parseDouble(textWeight.getText());
			    	           String query = "UPDATE `player details` SET `Weight`='"+newWeight+"' WHERE `Jersey Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Double.parseDouble(textWeight.getText()), i, 5);

			            }
			            if(textContract.getText().isEmpty() != true){
			    	           int newContract = Integer.parseInt(textContract.getText());
			    	           String query = "UPDATE `player details` SET `Contracted Till`='"+newContract+"'WHERE `Jersey Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textContract.getText()), i, 7);

			     	           
			            }
			            
			            JOptionPane.showMessageDialog(null, "Details Updated!"); 
		           }
		         	else {
		         		JOptionPane.showMessageDialog(null, "Fill Player ID and select the row before editing!");
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
		frmPlayerManagement.getContentPane().add(btnEdit);
		
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
						String delRow = "delete from `player details` where `Jersey Number` ="+table.getValueAt(i,0);
			            Statement ps = con.prepareStatement(delRow);
			            ps.execute(delRow);
			           
			            JOptionPane.showMessageDialog(null, "Player " +table.getValueAt(i,1) +" Deleted!");
			            model.removeRow(i);
			        } catch (Exception e1) {
			            JOptionPane.showMessageDialog(null,  e1.getMessage());
			        }
				}
				 else {
					JOptionPane.showMessageDialog(frmPlayerManagement,"Please select the player raw you wish to delete!");
				}
				
				}
		});
		
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRemove.setBounds(700, 594, 100, 40);
		frmPlayerManagement.getContentPane().add(btnRemove);
		
		// textSalary
		
		textSalary = new JTextField();
		textSalary.setColumns(10);
		textSalary.setBounds(325, 647, 125, 40);
		frmPlayerManagement.getContentPane().add(textSalary);
		
		// lblId
		
		JLabel lblPnum = new JLabel("Player Num.");
		lblPnum.setForeground(Color.WHITE);
		lblPnum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPnum.setBounds(25, 538, 100, 20);
		frmPlayerManagement.getContentPane().add(lblPnum);
		
		/// Red Panel ///
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
		
		///// btnReset
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(SystemColor.info);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textAge.setText("");
				textPrefFoot.setText("");
				textHeight.setText("");
				textWeight.setText("");
				textContract.setText("");
				textJNum.setText("");
				textSalary.setText("");
			}
		});
		
		
		btnReset.setBounds(830, 594, 100, 40);
		frmPlayerManagement.getContentPane().add(btnReset);
		
		//// btnMainMenu ////
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setForeground(Color.BLACK);
		btnMainMenu.setBackground(SystemColor.info);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				frmPlayerManagement.dispose();
				
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMainMenu.setBounds(700, 656, 230, 30);
		frmPlayerManagement.getContentPane().add(btnMainMenu);
		
		////// textJNum
		
		textJNum = new JTextField();
		textJNum.setBackground(Color.WHITE);
		textJNum.setBounds(25, 560, 100, 40);
		frmPlayerManagement.getContentPane().add(textJNum);
		textJNum.setColumns(10);
		
		///// lblPNum
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalary.setForeground(Color.WHITE);
		lblSalary.setBounds(325, 625, 100, 20);
		frmPlayerManagement.getContentPane().add(lblSalary);
		

		frmPlayerManagement.setVisible(true);
	    
	    
	}
}

