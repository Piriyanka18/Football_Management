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

public class Injuries_main {

	private JFrame frmInjury;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textName;
	private JLabel lblName;
	private JTextField textInjury;
	private JTextField textRecovery;
	private JLabel lblHeight;
	private JLabel lblWeight;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnRemove;
	private JTextField textJNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new Injuries_main();
	
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Injuries_main() {
 
		frmInjury = new JFrame();
		frmInjury.setIconImage(Toolkit.getDefaultToolkit().getImage(Injuries_main.class.getResource("/SquadDetails/Squad/FCB.png")));
		frmInjury.setTitle("Injured Players");
		frmInjury.setResizable(false);
		frmInjury.getContentPane().setForeground(Color.RED);
		frmInjury.getContentPane().setBackground(new Color(0, 0, 102));
		frmInjury.setBackground(Color.BLACK);
		frmInjury.setBounds(250, 50, 1000, 750);
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
		
		// textName
		textName = new JTextField();
		textName.setBounds(225, 560, 275, 40);
		frmInjury.getContentPane().add(textName);
		textName.setColumns(10);
		
		// lblName
		
		lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(225, 538, 100, 20);
		frmInjury.getContentPane().add(lblName);
		
		// textRed
		
		textInjury = new JTextField();
		textInjury.setColumns(10);
		textInjury.setBounds(50, 647, 275, 40);
		frmInjury.getContentPane().add(textInjury);
		
		// textSuspended
		
		textRecovery = new JTextField();
		textRecovery.setColumns(10);
		textRecovery.setBounds(350, 647, 150, 40);
		frmInjury.getContentPane().add(textRecovery);
		
		// lblRed
		
		lblHeight = new JLabel("Injury Type");
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHeight.setBounds(50, 625, 100, 20);
		frmInjury.getContentPane().add(lblHeight);
		
		//lblSuspended
		
		lblWeight = new JLabel("Recovery Time");
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWeight.setBounds(350, 625, 243, 20);
		frmInjury.getContentPane().add(lblWeight);
		
		// btnAdd
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(SystemColor.info);
		
		Object[] row = new Object[4];
		
		// BtnAdd ActionListener
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int PJNum;
				String Pname,PInjury,PRecovery;  
				   
				   try {
					  
					   Pname = textName.getText();
					   PJNum = Integer.parseInt(textJNum.getText());
					   PRecovery = textRecovery.getText();
					   PInjury = textInjury.getText();
					   
			       	   Class.forName("com.mysql.cj.jdbc.Driver");
						     Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						     String query1 = "INSERT INTO `injury`( `Player Number`,`Name`, `Injury Type`, `Recovery Time`) "
						 		               + "VALUES ('"+PJNum+"','"+Pname+"','"+PInjury+"','"+PRecovery+"')";
			             Statement ps = con.prepareStatement(query1);
			             ps.executeUpdate(query1);
			             
			                row[0] = textJNum.getText();
			                row[1] = textName.getText();
							row[2] = textInjury.getText();
							row[3] = textRecovery.getText();
							
							model.addRow(row);
							
							JOptionPane.showMessageDialog(null, "Injury Details Added!");
			           
			       } catch (Exception ex) {
			           JOptionPane.showMessageDialog(null,  ex.getMessage());
			       }
			   }
		});
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(700, 534, 100, 40);
		frmInjury.getContentPane().add(btnAdd);
		
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
			    	           String query = "UPDATE `injury` SET `Name`='"+newName+"' WHERE `Player Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(textName.getText(), i, 1);

			            }
			            if(textInjury.getText().isEmpty() != true){
			    	           String newInjury = textInjury.getText();
			    	           String query = "UPDATE `injury` SET `Injury Type`='"+newInjury+"' WHERE `Player Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(textInjury.getText(), i, 2);

			            }
			            if(textRecovery.getText().isEmpty() != true){
			    	           String newRecovery = textRecovery.getText();
			    	           String query = "UPDATE `injury` SET `Recovery Time`='"+newRecovery+"' WHERE `Player Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(textRecovery.getText(), i, 3);

			            }
			            
			            JOptionPane.showMessageDialog(null, "Details Updated!"); 
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
		frmInjury.getContentPane().add(btnEdit);
		
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
						String delRow = "delete from `injury` where `Jersey Number` ="+table.getValueAt(i,0);
			            Statement ps = con.prepareStatement(delRow);
			            ps.execute(delRow);
			           
			            JOptionPane.showMessageDialog(null, "Record of  " +table.getValueAt(i,1) +" Deleted!");
			            model.removeRow(i);
			        } catch (Exception e1) {
			            JOptionPane.showMessageDialog(null,  e1.getMessage());
			        }
				}
				 else {
					JOptionPane.showMessageDialog(frmInjury,"Please select the player raw you wish to delete!");
				}
				
				}
		});
		
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRemove.setBounds(700, 594, 100, 40);
		frmInjury.getContentPane().add(btnRemove);
		
		// lblId
		
		JLabel lblPnum = new JLabel("Player Num.");
		lblPnum.setForeground(Color.WHITE);
		lblPnum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPnum.setBounds(50, 538, 100, 20);
		frmInjury.getContentPane().add(lblPnum);
		
		/// Red Panel ///
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
		
		///// btnReset
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(SystemColor.info);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textInjury.setText("");
				textRecovery.setText("");;
				textJNum.setText("");
			}
		});
		
		
		btnReset.setBounds(830, 594, 100, 40);
		frmInjury.getContentPane().add(btnReset);
		
		//// btnMainMenu ////
		
		JButton btnMainMenu = new JButton("Back");
		btnMainMenu.setForeground(Color.BLACK);
		btnMainMenu.setBackground(SystemColor.info);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInjury.dispose();
				new MainInj();
				
				
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMainMenu.setBounds(700, 656, 230, 30);
		frmInjury.getContentPane().add(btnMainMenu);
		
		////// textJNum
		
		textJNum = new JTextField();
		textJNum.setBackground(Color.WHITE);
		textJNum.setBounds(50, 560, 150, 40);
		frmInjury.getContentPane().add(textJNum);
		textJNum.setColumns(10);
		

		frmInjury.setVisible(true);
	    
	    
	}
}

