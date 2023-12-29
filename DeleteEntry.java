package AddressBookSystemGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;



public class DeleteEntry {
		static JPanel panel = new JPanel();
		
		
		static Object[][] data = {
	             
	               
	 	};
	 	 
	 	 static JTable table;
	 	 static JButton deleteIdBtn;
	 	static JButton refresh;
		static String[] columns = {"ID","Name","Age","Sex","Birthday","Address","Civil Status","Telephone","Email","Occupation"
	 			,"Company"};
		static DefaultTableModel model = new DefaultTableModel(data,columns);
		
		public void deleteEntry() {
			
		
			//make label for enter if to delete
			JLabel introLabel = new JLabel("Enter ID to Delete : ");
			introLabel.setBounds(50,15,200,50);
			introLabel.setFont(new Font("Verdana",Font.PLAIN,17));
			introLabel.setForeground(new Color(112,112,112));
			panel.add(introLabel);
			
			//make input field for th index
			JTextField idToDelete = new JTextField();
			idToDelete.setBounds(230,25,250,40);
			idToDelete.setMargin(new Insets(5,10,10,10));
			idToDelete.setFont(new Font("Verdana",Font.PLAIN,16));
			panel.add(idToDelete);
			
			
			//make label for enter if to delete
			JLabel searchLabel = new JLabel("Search By Name  ");
			searchLabel.setBounds(720,8,200,50);
			searchLabel.setFont(new Font("Verdana",Font.PLAIN,17));
			searchLabel.setForeground(new Color(112,112,112));
			panel.add(searchLabel);
			
			
			JTextField searchBar = new JTextField();
			searchBar.setBounds(720,50,250,40);
			searchBar.setMargin(new Insets(5,10,10,10));
			searchBar.setFont(new Font("Verdana",Font.PLAIN,16));
			panel.add(searchBar);
			
			//add label for instruction 
		 	JLabel instructLabel = new JLabel("Instruction : Enter the id of the entry that you want to delete.");
		 	instructLabel.setBounds(50,85,890,50);
		 	instructLabel.setFont(new Font("Verdana",Font.ITALIC,17));
		 	instructLabel.setForeground(new Color(112,112,112));
			panel.add(instructLabel);
			
			//make button for delete id
			
		    deleteIdBtn = new JButton("Delete");
			deleteIdBtn.setBounds(490,25,150,40);
			deleteIdBtn.setBackground(new Color(112,112,112));
			deleteIdBtn.setForeground(Color.white);
			deleteIdBtn.setMargin(new Insets(8,10,10,10));
			deleteIdBtn.setFocusable(false);
			deleteIdBtn.setFont(new Font("Verdana",Font.PLAIN,18));
			panel.add(deleteIdBtn);
			
			
			//function for the delete btn 
			deleteIdBtn.addActionListener((e) -> {
				
			
					
			deleteIdBtn.setEnabled(false);
				
				
				//yes btn
				String input = idToDelete.getText();
				int convertInput = 0;
				
				try {
					convertInput = Integer.parseInt(input);
					//after parsing call the method
					deleteId(convertInput ,input);
					
					System.out.println("Input " + input);
					System.out.println("convert in " +convertInput);
					System.out.println(Database.infos.size());
				}catch(Exception e1) {
					System.out.println(Database.infos.size());
					System.out.println(e1);
					//make a error window
	        		JWindow window = new JWindow();
	        		
	        		//make panel
	        		JPanel ePanel = new JPanel();
	        		ePanel.setBorder(BorderFactory.createMatteBorder(9, 1, 1, 1, Color.red));
	        		JLabel errorLabel = new JLabel("Invalid input!");
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
							deleteIdBtn.setEnabled(true);
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
				
				
			
				
				
				
				
				
				
				
				
				
				
				
				//no btn
				});
		
			
			//make a refresh btn
			refresh = new JButton("Refresh");
			refresh.setBackground(Color.DARK_GRAY);
		 	refresh.setForeground(Color.white);
		 	refresh.setFocusable(false);
		 	refresh.setFont(new Font("Verdana",Font.PLAIN,15));
		 	refresh.setBounds(1030,50,140,40);
		 	panel.add(refresh);
		 	
		 	refresh.addActionListener((e) -> {
		 		System.out.println(Database.infos.size());
		 		updateTable();
		 	});
		
		 
		 	
		
		 
		 	TableRowSorter sort = new TableRowSorter<>(model);
		 	table = new JTable(model);
		 	
		 	table.setSize(1000,455);
		 	table.setBackground(Color.white);
		 	table.setFont(new Font("Verdana",Font.PLAIN,17));
		 	table.setRowSorter(sort);
		 	
		 	
		 	
		 	searchBar.getDocument().addDocumentListener(new DocumentListener() {
	        	
				@Override
				public void insertUpdate(DocumentEvent e) {
					String s = searchBar.getText();
				
					sort.setRowFilter(new Filter(s));
				
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					String s = searchBar.getText();
					
					sort.setRowFilter(new Filter(s));
					
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
				
					
				}
	        	
	        });
		 	
		 	
		 	
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
	        
	      
	        
	        
	    
			
			
		 	JScrollPane scroll = new JScrollPane(table);
		 	scroll.setBorder(BorderFactory.createMatteBorder(0, 2 ,2 ,2, new Color(255,0,0)));
		 	scroll.setBounds(0,130,1200,455);
		 	scroll.getViewport().setBackground(Color.white);
		 	

		 	panel.add(scroll);
		 	
		 	
 	
		 	
		 	
			panel.setBounds(0, 130, 1200, 700);
	        panel.setBackground(Color.white);
	        panel.setLayout(null);
	        panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, new Color(255,0,0)));
	        panel.setVisible(true);
	        Home.frame.add(panel);
	       
		}
		public static void updateTable() {
			
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
		
		
		public static void deleteId(int id ,String input) {
			
			
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
        		deleteIdBtn.setEnabled(false);
        		
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
						deleteIdBtn.setEnabled(true);
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

		    //get the row of the id 
		    int entryNumber = (int) table.getValueAt(selectedRowIndex, 0);

		    // check if its a valid entry
		    if (entryNumber > 0 && entryNumber <= Database.infos.size()) {
		    	
		    	
		    	
		    	//ask the user first for confirmation
				JWindow confirmWindow = new JWindow();
				JPanel confirmPanel = new JPanel();
				
				
				//make label
				
				Label label = new Label("      Do you really want to delete entry no." + id+"?");
				label.setBounds(0,0,350,40); 
				
				label.setForeground(new Color(0,0,0));
				label.setFont(new Font("Verdana",Font.BOLD,16));
				label.setBackground(new Color(255,207,51));
				confirmPanel.add(label);
				
				Label labelName = new Label("Name : " + table.getValueAt(Integer.parseInt(input) - 1 ,1 ));
				labelName.setBounds(95,50,190,40); 
				labelName.setForeground(new Color(235, 64, 52));
				labelName.setFont(new Font("Verdana",Font.BOLD,16));
				
				confirmPanel.add(labelName);
				
				//MAKE BUTTON
				
				JButton yesBtn = new JButton("Yes");
				yesBtn.setBounds(10,100,160,40);
				yesBtn.setBackground(new Color(112,112,112));
				yesBtn.setFont(new Font("Verdana",Font.PLAIN,16));
				yesBtn.setForeground(Color.white);
				yesBtn.setFocusable(false);
				confirmPanel.add(yesBtn);
				
				JButton noBtn = new JButton("No");
				noBtn.setBounds(180,100,160,40);
				noBtn.setFont(new Font("Verdana",Font.PLAIN,16));
				noBtn.setBackground(new Color(112,112,112));
				noBtn.setForeground(Color.white);
				noBtn.setFocusable(false);
				confirmPanel.add(noBtn);
				
				confirmWindow.add(confirmPanel);
				confirmPanel.setSize(350,150);
				confirmPanel.setLayout(null);
				confirmPanel.setBackground(Color.white);
				confirmPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(255,207,51)) );
				
				
				
				
				
				
				
				confirmWindow.setSize(350,150);
				confirmWindow.setLocationRelativeTo(Home.frame);
				confirmWindow.setLayout(null);
				confirmWindow.setVisible(true);
				
				//if yes then deletee
				
				yesBtn.addActionListener((e) -> {
					  Database.infos.remove(entryNumber - 1);
					  confirmWindow.setVisible(false);
					  Database db = new Database();
				        db.saveToFile();
					  updateTable();
					  
					  
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
 		    		 
 		    		 JLabel successLabel = new JLabel("Entry deleted successfully");
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
											
								ViewEntry.updateTable();
								deleteIdBtn.setEnabled(true);
							}
 		    			 
 		    		 });
 		    		 
 		    		 successWindow.add(successPanel);
 		    		 
 		    		 successWindow.setBackground(Color.LIGHT_GRAY);
 		    		 successWindow.setAlwaysOnTop(true);
 		    		 successWindow.setSize(320,170);
 		    		 successWindow.setLayout(null);
 		    		 successWindow.setLocationRelativeTo(Home.frame);
 		    		 successWindow.setVisible(true);
				});
				
				noBtn.addActionListener((e) -> {
					confirmWindow.setVisible(false);	
					deleteIdBtn.setEnabled(true);
					
				});

		        
		       
				Database db = new Database();
				
				db.loadFromFile();
		    }
		}
}
