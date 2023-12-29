package AddressBookSystemGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;



public class UpdateEntry {
	static JPanel panel = new JPanel();
	static Object[][] data = {
            
            
 	};
 	 
	static String[] columns = {"ID","Name","Age","Sex","Birthday","Address","Civil Status","Telephone","Email","Occupation"
 			,"Company"};
	static DefaultTableModel model = new DefaultTableModel(data,columns);;
	
	static JButton searchBtn;
	 JTable table;
	
	public void updateEntry() {
		
		//make label for enter if to delete
		JLabel introLabel = new JLabel("Search by name : ");
		introLabel.setBounds(50,15,200,50);
		introLabel.setFont(new Font("Verdana",Font.PLAIN,17));
		introLabel.setForeground(new Color(112,112,112));
		panel.add(introLabel);
		//make text Field to Update
		JTextField searchBar = new JTextField();
		 
		
		searchBar.setBounds(220,21,250,40);
		searchBar.setMargin(new Insets(5,10,10,10));
		searchBar.setFont(new Font("Verdana",Font.PLAIN,16));
		panel.add(searchBar);
		//if the panel is not visible then clear the text
		
		
		//make search action
		
		    searchBtn = new JButton("Search");
			searchBtn.setBounds(490,21,150,40);
			searchBtn.setBackground(new Color(112,112,112));
			searchBtn.setForeground(Color.white);
			searchBtn.setMargin(new Insets(8,10,10,10));
			searchBtn.setFocusable(false);
			searchBtn.setFont(new Font("Verdana",Font.PLAIN,18));
			panel.add(searchBtn);
			
			
			
			
			//make a update btn
			JButton UpdateBtn;
			UpdateBtn = new JButton("Update row");
			UpdateBtn.setBackground(Color.DARK_GRAY);
		 	UpdateBtn.setForeground(Color.white);
		 	UpdateBtn.setFocusable(false);
		 	UpdateBtn.setFont(new Font("Verdana",Font.PLAIN,15));
		 	UpdateBtn.setBounds(1030,50,140,40);
		 	UpdateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 	panel.add(UpdateBtn);
		 		
		 	/*
		 	 * ACTION FOR UPDATE ROW BTN IS CLICKED
		 	 */
		 	UpdateBtn.addActionListener((e) -> {
		 		
		 		int selectedRow = selectedRow();
		 	
		 		
		 		if(selectedRow != -1) {
		 			String getName = (String) table.getValueAt(selectedRow, 1);
		 			String getAge = (String)table.getValueAt(selectedRow, 2);
		 			String getSex = (String)table.getValueAt(selectedRow, 3);
		 			String getBday = (String)table.getValueAt(selectedRow, 4);
		 			String getAddress = (String)table.getValueAt(selectedRow, 5);
		 			String getCivil = (String)table.getValueAt(selectedRow, 6);
		 			String getTel = (String)table.getValueAt(selectedRow, 7);
		 			String getEmail = (String)table.getValueAt(selectedRow, 8);
		 			String getOccu = (String)table.getValueAt(selectedRow, 9);
		 			String getCompany = (String)table.getValueAt(selectedRow, 10);
		 			
		 			/*
		 			 * 
		 			 * 
		 			 * 
		 			 * 
		 			 * 
		 			 * DIALOG FOR UPDATE ENTRY 
		 			 * 
		 			 * 
		 			 * 
		 			 * 
		 			 * 
		 			 * 
		 			 */

		 			JDialog dialog = new JDialog(Home.frame, "Update window");
		 			JPanel panel = new JPanel();
		 		  
		 			/*
		 			 * MAKE BUTTON FOR CLEAR FIELDS
		 			 * 
		 			 */
		 			
		 			
		 			
		 			    JButton clearBtn = new JButton("Clear fields");
		 				clearBtn.setBounds(0,40,150,40);
		 				clearBtn.setBackground(new Color(112,112,112));
		 				clearBtn.setForeground(Color.white);
		 				clearBtn.setMargin(new Insets(8,10,10,10));
		 				clearBtn.setFocusable(false);
		 				clearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 				clearBtn.setFont(new Font("Verdana",Font.PLAIN,18));
		 				panel.add(clearBtn);
		 			
		 			 //font for the text
		 		    Font txtFont = new Font("Verdana",Font.PLAIN,15);
		 		    //font for fields
		 		    Font fieldFont = new Font("Verdana",Font.PLAIN,16);
		 		    
		 		    int marginLeftLabel = 70;
		 		    int marginLeftField = 250;
		 			int idNum = (int) table.getValueAt(selectedRow, 0);
		 		    //MAKE LABEL TITLE 
		 		    Label title = new Label("You are updating Entry no. " + idNum);
		 		    title.setBounds(180,0,450,30);
		 		    title.setBackground(new Color(255,207,51));
		 		    title.setForeground(Color.darkGray);
		 		    title.setFont(new Font("Verdana",Font.BOLD,17));
		 		    panel.add(title);
		 		    
		 		   Label bgTitle =  new Label();
		 		    bgTitle.setBounds(0,0,600,30);
		 		    bgTitle.setBackground(new Color(255,207,51));
		 		    panel.add(bgTitle);
		 		    
		 		    //name label
		 		    JLabel nameLabel = new JLabel("Edit Full name :");
		 		    nameLabel.setBounds(marginLeftLabel, 100, 150, 50);
		 		    nameLabel.setFont(txtFont);
		 		    nameLabel.setForeground(new Color(112,112,112));
		 		    panel.add(nameLabel);
		 		    
		 		    //name input 
		 		    JTextField nameField = new JTextField(getName);
		 		    nameField.setBounds(marginLeftField , 100, 250, 50);
		 		    nameField.setMargin(new Insets(10,10,10,10));
		 		    nameField.setFont(fieldFont);
		 		    panel.add(nameField);
		 		    
		 		    //age label
		 		    JLabel ageLabel = new JLabel("Edit Age :");
		 		    ageLabel.setBounds(marginLeftLabel, 180, 100, 50);
		 		    ageLabel.setFont(txtFont);
		 		    ageLabel.setForeground(new Color(112,112,112));
		 		    panel.add(ageLabel);
		 		    
		 		    //age input 
		 		    JTextField ageField = new JTextField(getAge);
		 		    ageField.setBounds(marginLeftField , 180, 100, 50);
		 		    ageField.setMargin(new Insets(10,10,10,10));
		 		    ageField.setFont(fieldFont);
		 		    panel.add(ageField);
		 			
		 		    //sex label
		 		    JLabel sexLabel = new JLabel("Edit Sex :");
		 		    sexLabel.setBounds(marginLeftLabel, 260, 120, 50);
		 		    sexLabel.setFont(txtFont);
		 		    sexLabel.setForeground(new Color(112,112,112));
		 		    panel.add(sexLabel);
		 		    
		 		    //sex input 
		 		    JTextField sexField = new JTextField(getSex);
		 		    sexField .setBounds(marginLeftField , 260, 160, 50);
		 		    sexField .setMargin(new Insets(10,10,10,10));
		 		    sexField .setFont(fieldFont);
		 		    panel.add(sexField );
		 		    
		 		    //bday label
		 		    JLabel bdayLabel = new JLabel("Edit Birthday :");
		 		    bdayLabel.setBounds(marginLeftLabel, 340, 160, 50);
		 		    bdayLabel.setFont(txtFont);
		 		    bdayLabel.setForeground(new Color(112,112,112));
		 		    panel.add(bdayLabel);
		 		    
		 		    //bdayinput 
		 		    JTextField bdayField = new JTextField(getBday);
		 		    bdayField.setBounds(marginLeftField , 340, 190, 50);
		 		    bdayField.setMargin(new Insets(10,10,10,10));
		 		    bdayField.setFont(fieldFont);
		 		    panel.add(bdayField);
		 		    
		 		    //addfress label
		 		    JLabel addrLabel = new JLabel("Edit Address :");
		 		    addrLabel.setBounds(marginLeftLabel, 420, 160, 50);
		 		    addrLabel.setFont(txtFont);
		 		    addrLabel.setForeground(new Color(112,112,112));
		 		    panel.add(addrLabel);
		 		    
		 		    //addr input 
		 		    JTextField addrField = new JTextField(getAddress);
		 		    addrField.setBounds(marginLeftField , 420, 190, 50);
		 		    addrField.setMargin(new Insets(10,10,10,10));
		 		    addrField.setFont(fieldFont);
		 		    panel.add(addrField);
		 		    
		 		    //civilss label
		 		    JLabel civilLabel = new JLabel("Edit Civil Status :");
		 		    civilLabel.setBounds(marginLeftLabel, 500, 160, 50);
		 		    civilLabel.setFont(txtFont);
		 		    civilLabel.setForeground(new Color(112,112,112));
		 		    panel.add(civilLabel);
		 		    
		 		    //civil input 
		 		    JTextField civilField = new JTextField(getCivil);
		 		    civilField.setBounds(marginLeftField , 500, 190, 50);
		 		    civilField.setMargin(new Insets(10,10,10,10));
		 		    civilField.setFont(fieldFont);
		 		    panel.add(civilField);
		 		    
		 		    
		 		    //teelpon label
		 		    JLabel telLabel = new JLabel("Edit Telephone :");
		 		    telLabel.setBounds(marginLeftLabel, 580, 160, 50);
		 		    telLabel.setFont(txtFont);
		 		    telLabel.setForeground(new Color(112,112,112));
		 		    panel.add(telLabel);
		 		    //tel input 
		 		    JTextField telField = new JTextField(getTel);
		 		    telField.setBounds(marginLeftField , 580, 190, 50);
		 		    telField.setMargin(new Insets(10,10,10,10));
		 		    telField.setFont(fieldFont);
		 		    panel.add(telField);
		 		    
		 		    //emssil label
		 		    JLabel emailLabel = new JLabel("Edit Email :");
		 		    emailLabel.setBounds(marginLeftLabel, 660, 160, 50);
		 		    emailLabel.setFont(txtFont);
		 		    emailLabel.setForeground(new Color(112,112,112));
		 		    panel.add(emailLabel);
		 		    
		 		    //email input 
		 		    JTextField emailField = new JTextField(getEmail);
		 		    emailField.setBounds(marginLeftField , 660, 190, 50);
		 		    emailField.setMargin(new Insets(10,10,10,10));
		 		    emailField.setFont(fieldFont);
		 		    panel.add(emailField);
		 		    
		 		    //occu label
		 		    JLabel occuLabel = new JLabel("Edit Occupation :");
		 		    occuLabel.setBounds(marginLeftLabel, 740, 160, 50);
		 		    occuLabel.setFont(txtFont);
		 		    occuLabel.setForeground(new Color(112,112,112));
		 		    panel.add(occuLabel);
		 		    
		 		    //occu input 
		 		    JTextField occuField = new JTextField(getOccu);
		 		    occuField.setBounds(marginLeftField , 740, 190, 50);
		 		    occuField.setMargin(new Insets(10,10,10,10));
		 		    occuField.setFont(fieldFont);
		 		    panel.add(occuField);
		 		    
		 		    //company label
		 		    JLabel companyLabel = new JLabel("Edit Company :");
		 		    companyLabel.setBounds(marginLeftLabel, 820, 160, 50);
		 		    companyLabel.setFont(txtFont);
		 		    companyLabel.setForeground(new Color(112,112,112));
		 		    panel.add(companyLabel);
		 		    
		 		    //occu input 
		 		    JTextField companyField = new JTextField(getCompany);
		 		    companyField.setBounds(marginLeftField , 820, 190, 50);
		 		    companyField.setMargin(new Insets(10,10,10,10));
		 		    companyField.setFont(fieldFont);
		 		    panel.add(companyField);
		 		    
		 		    //make submit btn
		 		    

		 		    JButton submitBtn = new JButton("Update");
		 			submitBtn.setBounds(160,910,250,40);
		 			submitBtn.setBackground(new Color(32, 33, 25));
		 			submitBtn.setForeground(Color.white);
		 			submitBtn.setMargin(new Insets(8,10,10,10));
		 			submitBtn.setFocusable(false);
		 			submitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 			submitBtn.setFont(new Font("Verdana",Font.PLAIN,18));
		 			panel.add(submitBtn);
		 		    
		 			
		 			
		 			
		 			
		 			/*
		 			 * ACTION LISTENER FOR CLEAR FIELDS
		 			 */
		 			clearBtn.addActionListener(new ActionListener() {
		 				
		 				public void actionPerformed(ActionEvent e) {
		 				//clear the fields
		 				nameField.setText("");
		 				ageField.setText("");
		 				sexField.setText("");
		 				bdayField.setText("");
		 				addrField.setText("");
		 				telField.setText("");
		 				emailField.setText("");
		 				occuField.setText("");
		 				companyField.setText("");
		 				civilField.setText("");
		 				}
		 			});
		 			
		 			/*
		 			 * ACTION LISTENER FOR SUBMIT BUTTONNNNNNNNNNNNNN
		 			 */
		 			submitBtn.addActionListener(new ActionListener() {
		 				
		 				public void actionPerformed(ActionEvent e) {
		 					submitBtn.setEnabled(false);
		 					//get data
		 		        	String getName = nameField.getText();
		 		        	//get age
		 		        	String getAge = ageField.getText();
		 		        	//get sex
		 		        	
		 		        	String getSex = sexField.getText();
		 		        	//get bday
		 		        	
		 		        	String getBday = bdayField.getText();
		 		        	//get Address
		 		        	
		 		        	String getAddress = addrField.getText();
		 		        	
		 		        	//get civil
		 		        	String getCivil = civilField.getText();
		 		        	
		 		        	//get telephone
		 		        	String getTelephone = telField.getText();
		 		        	
		 		        	//get emails
		 		        	String getEmail = emailField.getText();
		 		        	
		 		        	//get occcupation
		 		        	String getOccupation = occuField.getText();
		 		        	
		 		        	//get company
		 		        	String getCompany = companyField.getText();
		 		        	
		 		        	
		 		        	
		 		        	//check if the input fields are empty 
		 		        	
		 		      	if(!(getName.isEmpty() || getAge.isEmpty() || getBday.isEmpty() ||  getAddress.isEmpty() || getSex.isEmpty() ||
		 		         getCivil.isEmpty() || getTelephone.isEmpty() || getEmail.isEmpty() || getOccupation.isEmpty() || getCompany.isEmpty())) {
		 		        		//IF THE FIELDS ARE NOT EMPTY then proceed updating
		 		      	     Database person = new Database(getName, getAge, getSex, getBday, getAddress, getCivil, getTelephone, getEmail, getOccupation, getCompany);
		        		    person.updateData(getName, getAge, getSex, getBday, getAddress, getCivil, getTelephone, getEmail, getOccupation, getCompany,(idNum - 1));
		        		    updateTable();
		        		    dialog.setVisible(false);
		        		    /*
		        		     * 
		        		     * 
		        		     * 
		        		     * 
		        		     * MAKE SUCCESS WINDOW MEANING THAT SUCCESS UDPATE
		        		     * 
		        		     * 
		        		     * 
		        		     * 
		        		     * 
		        		     * 
		        		     * 
		        		     */
		        		    
		        		    //make window
       		    		 JWindow successWindow = new JWindow();
       		    		 //make panel
       		    		 JPanel successPanel = new JPanel();
       		    		 successPanel.setSize(320,170);
       		    		 successPanel.setLayout(null);
       		    		 successPanel.setVisible(true);
       		    		 successPanel.setBorder(BorderFactory.createMatteBorder(8,1,1,1, new Color(170, 255, 0)));
       		    		 
       		    		 //create an image
       		    		
       		    		 ImageIcon check = new ImageIcon("checked.png");
       		    		 Image image = check.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
       		    		 
       		    		 
       		    		 JLabel setIcon = new JLabel(new ImageIcon(image));
       		    		 successPanel.add(setIcon);
       		    		 setIcon.setBounds(5,15,90,90);
       		    		 
       		    		 JLabel successLabel = new JLabel("Entry updated successfully!");
       		    		 successLabel.setFont(new Font("Verdana",Font.PLAIN,14));
       		    		 successLabel.setBounds(110,36,250,50);
       		    		 successLabel.setForeground(new Color(112,112,112));
       		    		 successPanel.add(successLabel);
       		    		 
       		    		 
       		    		 //make ok btn 
       		    		 
       		    		 JButton ok = new JButton("Ok");
       		    		 ok.setBounds(90,120,150,35);
       		    		 ok.setFocusable(false);
       		    		 ok.setBackground(new Color(112,112,112));
       		    		 ok.setForeground(Color.white);
       		    		 ok.setFont(new Font("Verdana",Font.PLAIN,16));
       		    		 successPanel.add(ok);
       		    		 
       		    		 ok.addActionListener(new ActionListener() {

							
								public void actionPerformed(ActionEvent e) {
									successWindow.setVisible(false);
									submitBtn.setEnabled(true);
									
	
									
									updateTable();
									
								}
       		    			 
       		    		 });
       		    		 
       		    		 successWindow.add(successPanel);
       		    		 
       		    		 successWindow.setBackground(Color.LIGHT_GRAY);
       		    		 successWindow.setAlwaysOnTop(true);
       		    		 successWindow.setSize(320,170);
       		    		 successWindow.setLayout(null);
       		    		 successWindow.setLocationRelativeTo(Home.frame);
       		    		 successWindow.setVisible(true);
		        		    
		 		      	} else {
		 		      	//make a error window
		 	        		JWindow window = new JWindow();
		 	        		
		 	        		//make panel
		 	        		JPanel ePanel = new JPanel();
		 	        		ePanel.setBorder(BorderFactory.createMatteBorder(9, 1, 1, 1, Color.red));
		 	        		JLabel errorLabel = new JLabel("Please fill out all the fields!");
		 	        		errorLabel.setFont(new Font("Verdana",Font.PLAIN,15));
		 	        		errorLabel .setBounds(125,45,250,50);
		 	        		
		 	        		
		 	        		ImageIcon check = new ImageIcon("exclamation.png");
		 		    		 Image image = check.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		 		    		 
		 		    		 
		 		    		 JLabel setIcon = new JLabel(new ImageIcon(image));
		 		    		 ePanel.add(setIcon);
		 		    		 setIcon.setBounds(10,25,90,90);
		 		    		 
		 	        		//make exit btn 
		 	        		JButton exitBtn = new JButton("Ok");
		 	        		exitBtn.setBackground(new Color(112,112,112));
		 	        		exitBtn.setForeground(Color.white);
		 	        		exitBtn.setFont(new Font("Verdana",Font.PLAIN,15));
		 	        		exitBtn.setBounds(110,140,140,40);
		 	        		ePanel.add(exitBtn);
		 	        		
		 	        		exitBtn.addActionListener(new ActionListener() {
		 	        			
		 	        		

		 						@Override
		 						public void actionPerformed(ActionEvent e) {
		 							window.setVisible(false);
		 							 submitBtn.setEnabled(true);
		 						}
		 	        			
		 	        		});
		 	        		
		 	        		ePanel.add(errorLabel );	
		 	        		ePanel.setSize(350,200);
		 	        		ePanel.setLayout(null);
		 	        		ePanel.setVisible(true);
		 	        		window.add(ePanel);
		 	        		window.setAlwaysOnTop(true);
		 	        		window.setSize(350,200);
		 	        		window.setLayout(null);
		 	        		window.setLocationRelativeTo(Home.frame);
		 	        		window.setVisible(true);
		 		      	}
		 		      
		 				}
		 			});
		 			
		 			
		 			
		 			
		 		    
		 		    JScrollPane scroll = new JScrollPane(panel);
		 		  

		 		   scroll.getVerticalScrollBar().setUI(new CustomScrollBar());

		 		  
		 		    scroll.getVerticalScrollBar().setUnitIncrement(15);
		 		 
		 		    scroll.setBounds(0, 0, 585, 700);
		 		  
		 		    scroll.setVisible(true);
		 		    // Set the layout for the panel 
		 		    panel.setPreferredSize(new Dimension(400,1000));
		 		    panel.setBounds(0,0,600,700);
		 		    panel.setLayout(null);
		 		    panel.setVisible(true);
		 		  
		 		    // Set the view for the scroll pane
		 		  
		 		    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 		    dialog.add(scroll);
		 			
		 			dialog.setSize(600,700);

		 			dialog.setLayout(null);
		 			dialog.setResizable(false);
		 			 dialog.setLocationRelativeTo(Home.frame);
		 			dialog.setVisible(true);
		 			
		 			
		 			
		 			
		 			
		 			/*
		 			 * 
		 			 * 
		 			 * 
		 			 * END OF UPDATE DIALOG
		 			 * 
		 			 * 
		 			 * 
		 			 * 
		 			 */
		 			
		 		} else {
		 			 //make a error window
	        		JWindow window = new JWindow();
	        		
	        		//make panel
	        		JPanel ePanel = new JPanel();
	        		ePanel.setBorder(BorderFactory.createMatteBorder(9, 1, 1, 1, Color.red));
	        		JLabel errorLabel = new JLabel("No rows selected!");
	        		errorLabel.setFont(new Font("Verdana",Font.PLAIN,15));
	        		errorLabel .setBounds(125,45,250,50);
	        		UpdateBtn.setEnabled(false);
	        		
	        		ImageIcon check = new ImageIcon("exclamation.png");
		    		 Image image = check.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		    		 
		    		 
		    		 JLabel setIcon = new JLabel(new ImageIcon(image));
		    		 ePanel.add(setIcon);
		    		 setIcon.setBounds(10,25,90,90);
		    		 
	        		//make exit btn 
	        		JButton exitBtn = new JButton("Ok");
	        		exitBtn.setBackground(new Color(112,112,112));
	        		exitBtn.setForeground(Color.white);
	        		exitBtn.setFont(new Font("Verdana",Font.PLAIN,15));
	        		exitBtn.setBounds(110,140,140,40);
	        		ePanel.add(exitBtn);
	        		
	        		exitBtn.addActionListener(new ActionListener() {
	        			
	        		

						@Override
						public void actionPerformed(ActionEvent e) {
							window.setVisible(false);
							UpdateBtn.setEnabled(true);
						}
	        			
	        		});
	        		
	        		ePanel.add(errorLabel );	
	        		ePanel.setSize(350,200);
	        		ePanel.setLayout(null);
	        		ePanel.setVisible(true);
	        		window.add(ePanel);
	        		window.setAlwaysOnTop(true);
	        		window.setSize(350,200);
	        		window.setLayout(null);
	        		window.setLocationRelativeTo(Home.frame);
	        		window.setVisible(true);
			        return;
		 		}
		 	});
		 	
		 	//add label for instruction 
		 	JLabel instructLabel = new JLabel("Instruction : Select a row you want to update then click update button on the right corner.");
		 	instructLabel.setBounds(50,85,890,50);
		 	instructLabel.setFont(new Font("Verdana",Font.ITALIC,17));
		 	instructLabel.setForeground(new Color(112,112,112));
			panel.add(instructLabel);
		 	
		 	
		 	/*
		 	 * TABLE CODE
		 	 */
		 	//make a table sorter function 
			TableRowSorter sorter = new TableRowSorter(model);
			
		 	table = new JTable(model);
		 	table.setRowSorter(sorter);
		 	table.setSize(1000,455);
		 	table.setBackground(Color.white);
		 	table.setFont(new Font("Verdana",Font.PLAIN,17));
		 	
		 	
		 	//update table
			updateTable();
		 	//design table
		 	table.setShowGrid(true);
	        table.setGridColor(new Color(0, 0, 0, 0));
	       //disable table editing 
	        table.setDefaultEditor(Object.class, null);
	        //disable reordering in header
	        table.getTableHeader().setReorderingAllowed(false);
	        JTableHeader header = table.getTableHeader();
	        header.setBackground(Color.DARK_GRAY);
	        header.setForeground(new Color(255,255,255));
	        header.setPreferredSize(new Dimension(10,30));
	        header.setBorder(new LineBorder(null, Color.TRANSLUCENT));
	        header.setFont(new Font("Verdana",Font.BOLD,11));
	        
	        // make object to center rows and  data 
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	        centerRenderer.setVerticalAlignment(SwingConstants.CENTER);

	        for (int i = 0; i < columns.length; i++) {
	            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	        }
	        
        
	        //make object for adjusting rows margin
	        DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
	           
				
				private final Insets margin = new Insets(5, 10, 5, 10);

	            @Override
	            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	                Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	                
	                setBorder(BorderFactory.createEmptyBorder(margin.top, margin.left, margin.bottom, margin.right));

	                return rendererComponent;
	            }
	        };

	        // make center in rows
	        table.setDefaultRenderer(Object.class, customRenderer);       
	        table.setRowHeight(25); 
	        //add listener for typing then update or filter table 
	      
	        searchBar.getDocument().addDocumentListener(new DocumentListener() {
	        	
				@Override
				public void insertUpdate(DocumentEvent e) {
					String s = searchBar.getText();
				
					sorter.setRowFilter(new Filter(s));
				
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					String s = searchBar.getText();
					
					sorter.setRowFilter(new Filter(s));
					
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
	        	
	        });
	      //action for search btn 
			searchBtn.addActionListener((e) -> {
					//update table
				String query = searchBar.getText();
				sorter.setRowFilter(new Filter(query));
				 
				
			});
			
			
	 	
		 	JScrollPane scroll = new JScrollPane(table);
		 	scroll.setBorder(BorderFactory.createMatteBorder(0, 2 ,2 ,2, new Color(30,144,255)));
		 	scroll.setBounds(0,130,1200,455);
		 	scroll.getViewport().setBackground(Color.white);
		 	

		 	panel.add(scroll);
		 	
		 	
 	
		 	
		
		panel.setBounds(0, 130, 1200, 700);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, new Color(30,144,255)));
        panel.setVisible(true);
        Home.frame.add(panel);
	  Database db = new Database();
		
		db.loadFromFile();
        
	}
	
	
	
	public void updateTable() {
		
	    model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); //clear row

	    for (int i = 0; i < Database.infos.size(); i++) {
	        Database person = Database.infos.get(i);
	       
	        model.addRow(new Object[]{i + 1, person.getName(), person.getAge(), person.getSex(), person.getBday(),
	                person.getAddress(), person.getCivilStatus(), person.getTelephone(), person.getEmail(),
	                person.getOccupation(), person.getCompany()});
	    }

	    // change table 
	  
	   
	    model.fireTableDataChanged();
	}
	
	//update entry method
	public void updateId(int id) {
		int selectedRowIndex = id - 1;

	    if (selectedRowIndex > Database.infos.size() - 1 || selectedRowIndex < 0) {
	       
	      
	      //make a error window
    		JWindow window = new JWindow();
    		
    		//make panel
    		JPanel ePanel = new JPanel();
    		ePanel.setBorder(BorderFactory.createMatteBorder(9, 1, 1, 1, Color.red));
    		JLabel errorLabel = new JLabel("Entry does not exist!");
    		errorLabel.setFont(new Font("Verdana",Font.PLAIN,15));
    		errorLabel .setBounds(125,45,250,50);
    		searchBtn.setEnabled(false);
    		
    		ImageIcon check = new ImageIcon("exclamation.png");
    		 Image image = check.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    		 
    		 
    		 JLabel setIcon = new JLabel(new ImageIcon(image));
    		 ePanel.add(setIcon);
    		 setIcon.setBounds(10,25,90,90);
    		 
    		//make exit btn 
    		JButton exitBtn = new JButton("Ok");
    		exitBtn.setBackground(new Color(112,112,112));
    		exitBtn.setForeground(Color.white);
    		exitBtn.setFont(new Font("Verdana",Font.PLAIN,15));
    		exitBtn.setBounds(110,140,140,40);
    		ePanel.add(exitBtn);
    		
    		exitBtn.addActionListener(new ActionListener() {
    			
    		

				@Override
				public void actionPerformed(ActionEvent e) {
					window.setVisible(false);
					searchBtn.setEnabled(true);
				}
    			
    		});
    		
    		ePanel.add(errorLabel );	
    		ePanel.setSize(350,200);
    		ePanel.setLayout(null);
    		ePanel.setVisible(true);
    		window.add(ePanel);
    		window.setAlwaysOnTop(true);
    		window.setSize(350,200);
    		window.setLayout(null);
    		window.setLocationRelativeTo(Home.frame);
    		window.setVisible(true);
	        return;
	    }
	    
	    /*
	     * ASK THE USER TO UPDATE THE ENTRY
	     */

	    //get the row of the id 
	    int entryNumber = (int) table.getValueAt(selectedRowIndex, 0);

	    // check if its a valid entry
	    if (entryNumber > 0 && entryNumber <= Database.infos.size()) {
	    	
	    	/*
	    	 * ASK FOR USER TO EDIT
	    	 */
	    	
	    	JDialog updateDialog = new JDialog(Home.frame, "Update entry");
	    	updateDialog.setSize(500,1000);
	    	updateDialog.setLocationRelativeTo(Home.frame);
	    	updateDialog.setVisible(true);
	    	//make textFIELDS
	    	
	    	
	    
			}
	    }
	
	
	//method for getting selected row
	
	public int selectedRow() {
		
		int selectedRow = table.getSelectedRow();
		
		return selectedRow;
	}
	
	class CustomScrollBar extends BasicScrollBarUI {

	    @Override
	    protected JButton createDecreaseButton(int orientation) {
	        return createZeroButton();
	    }

	    @Override
	    protected JButton createIncreaseButton(int orientation) {
	        return createZeroButton();
	    }

	    private JButton createZeroButton() {
	        JButton button = new JButton();
	        button.setPreferredSize(new Dimension(0, 0));
	        return button;
	    }

	    @Override
	    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
	        g.setColor(new Color(89, 89, 89));
	        int arc = 1; 
	        g.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, arc, arc);
	    }

	    @Override
	    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
	        g.setColor(new Color(212, 212, 212)); 
	        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
	    }
 }

}