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

public class Suspended_main {

	private JFrame frmSuspended;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textName;
	private JLabel lblName;
	private JTextField textYellow;
	private JTextField textRed;
	private JTextField textSuspended;
	private JLabel lblAge;
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
		
		new Suspended_main();
	
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Suspended_main() {
 
		frmSuspended = new JFrame();
		frmSuspended.setIconImage(Toolkit.getDefaultToolkit().getImage(Suspended_main.class.getResource("/SquadDetails/Squad/FCB.png")));
		frmSuspended.setTitle("Suspended Players");
		frmSuspended.setResizable(false);
		frmSuspended.getContentPane().setForeground(Color.RED);
		frmSuspended.getContentPane().setBackground(new Color(0, 0, 102));
		frmSuspended.setBackground(Color.BLACK);
		frmSuspended.setBounds(250, 50, 1000, 750);
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
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// textName
		textName = new JTextField();
		textName.setBounds(225, 560, 150, 40);
		frmSuspended.getContentPane().add(textName);
		textName.setColumns(10);
		
		// lblName
		
		lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(225, 538, 100, 20);
		frmSuspended.getContentPane().add(lblName);
		
		// textYellow
		
		textYellow = new JTextField();
		textYellow.setColumns(10);
		textYellow.setBounds(400, 560, 150, 40);
		frmSuspended.getContentPane().add(textYellow);
		
		// textRed
		
		textRed = new JTextField();
		textRed.setColumns(10);
		textRed.setBounds(50, 647, 150, 40);
		frmSuspended.getContentPane().add(textRed);
		
		// textSuspended
		
		textSuspended = new JTextField();
		textSuspended.setColumns(10);
		textSuspended.setBounds(225, 647, 275, 40);
		frmSuspended.getContentPane().add(textSuspended);
		
		// lblYellow
		
		lblAge = new JLabel("Yellow Cards");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(400, 538, 125, 20);
		frmSuspended.getContentPane().add(lblAge);
		
		// lblRed
		
		lblHeight = new JLabel("Red Cards");
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHeight.setBounds(50, 625, 100, 20);
		frmSuspended.getContentPane().add(lblHeight);
		
		//lblSuspended
		
		lblWeight = new JLabel("Suspended Matches Count");
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWeight.setBounds(225, 625, 243, 20);
		frmSuspended.getContentPane().add(lblWeight);
		
		// btnAdd
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(SystemColor.info);
		
		Object[] row = new Object[5];
		
		// BtnAdd ActionListener
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int PYellow,PJNum,PRed,PSuspended;
				String Pname;  
				   
				   try {
					  
					   Pname = textName.getText();
					   PYellow = Integer.parseInt(textYellow.getText());
					   PJNum = Integer.parseInt(textJNum.getText());
					   PSuspended = Integer.parseInt(textSuspended.getText());
					   PRed = Integer.parseInt(textRed.getText());
					   
			       	   Class.forName("com.mysql.cj.jdbc.Driver");
						     Connection con= DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
						     String query1 = "INSERT INTO `suspended`( `Player Number`,`Name`, `Yellow Cards`, `Red Cards`,`Suspended Matches`) "
						 		               + "VALUES ('"+PJNum+"','"+Pname+"','"+PYellow+"','"+PRed+"','"+PSuspended+"')";
			             Statement ps = con.prepareStatement(query1);
			             ps.executeUpdate(query1);
			             
			                row[0] = textJNum.getText();
			                row[1] = textName.getText();
							row[2] = textYellow.getText();
							row[3] = textRed.getText();
							row[4] = textSuspended.getText();
							
							model.addRow(row);
							
							JOptionPane.showMessageDialog(null, "Suspended Details Added!");
			           
			       } catch (Exception ex) {
			           JOptionPane.showMessageDialog(null,  ex.getMessage());
			       }
			   }
		});
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(700, 534, 100, 40);
		frmSuspended.getContentPane().add(btnAdd);
		
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
			    	           String query = "UPDATE `suspended` SET `Name`='"+newName+"' WHERE `Player Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(textName.getText(), i, 1);

			            }
			            if(textYellow.getText().isEmpty() != true){
			    	           int newYellow = Integer.parseInt(textYellow.getText());
			    	           String query = "UPDATE `suspended` SET `Yellow Cards`='"+newYellow+"' WHERE `Player Number`="+textJNum.getText();
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textYellow.getText()), i, 2);
			     	           
			            }
			            if(textRed.getText().isEmpty() != true){
			    	           double newRed = Integer.parseInt(textRed.getText());
			    	           String query = "UPDATE `suspended` SET `Red Cards`='"+newRed+"' WHERE `Player Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textRed.getText()), i, 3);

			            }
			            if(textSuspended.getText().isEmpty() != true){
			    	           double newSuspended = Integer.parseInt(textSuspended.getText());
			    	           String query = "UPDATE `suspended` SET `Suspended Matches`='"+newSuspended+"' WHERE `Player Number`="+textJNum.getText();;
			    	           Statement ps = con.prepareStatement(query);
			     	           ps.executeUpdate(query);
			     	           table.setValueAt(Integer.parseInt(textSuspended.getText()), i, 4);

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
		frmSuspended.getContentPane().add(btnEdit);
		
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
						String delRow = "delete from `suspended` where `Jersey Number` ="+table.getValueAt(i,0);
			            Statement ps = con.prepareStatement(delRow);
			            ps.execute(delRow);
			           
			            JOptionPane.showMessageDialog(null, "Record of  " +table.getValueAt(i,1) +" Deleted!");
			            model.removeRow(i);
			        } catch (Exception e1) {
			            JOptionPane.showMessageDialog(null,  e1.getMessage());
			        }
				}
				 else {
					JOptionPane.showMessageDialog(frmSuspended,"Please select the player raw you wish to delete!");
				}
				
				}
		});
		
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRemove.setBounds(700, 594, 100, 40);
		frmSuspended.getContentPane().add(btnRemove);
		
		// lblId
		
		JLabel lblPnum = new JLabel("Player Num.");
		lblPnum.setForeground(Color.WHITE);
		lblPnum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPnum.setBounds(50, 538, 100, 20);
		frmSuspended.getContentPane().add(lblPnum);
		
		/// Red Panel ///
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
		
		///// btnReset
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(SystemColor.info);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textYellow.setText("");
				textRed.setText("");
				textSuspended.setText("");;
				textJNum.setText("");
			}
		});
		
		
		btnReset.setBounds(830, 594, 100, 40);
		frmSuspended.getContentPane().add(btnReset);
		
		//// btnMainMenu ////
		
		JButton btnMainMenu = new JButton("Back");
		btnMainMenu.setForeground(Color.BLACK);
		btnMainMenu.setBackground(SystemColor.info);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSuspended.dispose();
				new MainInj();
				
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMainMenu.setBounds(700, 656, 230, 30);
		frmSuspended.getContentPane().add(btnMainMenu);
		
		////// textJNum
		
		textJNum = new JTextField();
		textJNum.setBackground(Color.WHITE);
		textJNum.setBounds(50, 560, 150, 40);
		frmSuspended.getContentPane().add(textJNum);
		textJNum.setColumns(10);
		

		frmSuspended.setVisible(true);
	    
	    
	}
}

