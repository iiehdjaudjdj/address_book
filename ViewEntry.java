package AddressBookSystemGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;



public class ViewEntry {
		static JPanel panel = new JPanel();
	
		static Object[][] data = {
	             
	               
	 	};
	 	 
	 	 static JTable table;
	 	 
	 	static JButton refresh;
		static String[] columns = {"ID","Name","Age","Sex","Birthday","Address","Civil Status","Telephone","Email","Occupation"
	 			,"Company"};
		static DefaultTableModel model = new DefaultTableModel(data,columns);
		static 	 JButton searchBtn;
		static String getSearchItem = "name";
		public static void viewEntry() {
			
			
			
				//make a refresh btn
    			refresh = new JButton("Refresh");
    			refresh.setBackground(Color.DARK_GRAY);
    		 	refresh.setForeground(Color.white);
    		 	refresh.setFocusable(false);
    		 	refresh.setFont(new Font("Verdana",Font.PLAIN,15));
    		 	refresh.setBounds(1030,10,140,40);
    		 	panel.add(refresh);
    		 	
    		 	refresh.addActionListener((e) -> {
    		 		System.out.println(Database.infos.size());
    		 		updateTable();
    		 	});
			
    		 
    		 	JTextField searchBar = new JTextField();
    			 
    			
    			searchBar.setBounds(270,21,250,40);
    			searchBar.setMargin(new Insets(5,10,10,10));
    			searchBar.setFont(new Font("Verdana",Font.PLAIN,16));
    			panel.add(searchBar);
    			//if the panel is not visible then clear the text
    			
    			//make label for enter if to delete
    			JLabel introLabel = new JLabel("Search by : ");
    			introLabel.setBounds(50,13,200,50);
    			introLabel.setFont(new Font("Verdana",Font.PLAIN,17));
    			introLabel.setForeground(new Color(112,112,112));
    			panel.add(introLabel);
    			
    			String[] dataToSearch = {"ID","Name","Age","Sex","Birthday","Address","Civil Status","Telephone","Email","Occupation"
    					,"Company"};
    			
    			//make jcombo box,
    			JComboBox<String> chooseSearch = new JComboBox<>(dataToSearch);
    			chooseSearch.setBounds(160,25,100,30);
    			//design the combo box
    			
    			panel.add(chooseSearch);
    			
    		
    			
    			//make search action
    				searchBtn = new JButton("Search");
    				searchBtn.setBounds(540,21,150,40);
    				searchBtn.setBackground(new Color(112,112,112));
    				searchBtn.setForeground(Color.white);
    				searchBtn.setMargin(new Insets(8,10,10,10));
    				searchBtn.setFocusable(false);
    				searchBtn.setFont(new Font("Verdana",Font.PLAIN,18));
    				panel.add(searchBtn);
    				
    				
    				
    		
    		 
    		 	
    		 	table = new JTable(model);
    		 	
    		 	table.setSize(1000,455);
    		 	table.setBackground(Color.white);
    		 	table.setFont(new Font("Verdana",Font.PLAIN,17));
    		 	
    		 	
    		 	
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
    	        
    	        
    	        TableRowSorter tableSort = new TableRowSorter(model);
    	        // make center in rows
    	        table.setDefaultRenderer(Object.class, customRenderer);    
    	        table.setRowSorter(tableSort);
    	        table.setRowHeight(25); 
    	        
    	        //typing listener
    	        
    	        searchBar.getDocument().addDocumentListener(new DocumentListener() {

					@Override
					public void insertUpdate(DocumentEvent e) {
						int itemSelected = chooseSearch.getSelectedIndex();
						String search = searchBar.getText();
					
						tableSort.setRowFilter(new viewSearchFilter(search,itemSelected));
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						int itemSelected = chooseSearch.getSelectedIndex();
						
						String search = searchBar.getText();
						tableSort.setRowFilter(new viewSearchFilter(search,itemSelected));
					
						
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						
					}
    	        	
    	        });
		 	
    		 	JScrollPane scroll = new JScrollPane(table);
    		 	scroll.setBorder(BorderFactory.createMatteBorder(0, 2 ,2 ,2, new Color(255,207,51)));
    		 	scroll.setBounds(0,80,1200,505);
    		 	scroll.getViewport().setBackground(Color.white);
    		 	

    		 	panel.add(scroll);
    		 	
    		 	
	 	
    		 	
    		 	
				panel.setBounds(0, 130, 1200, 700);
		        panel.setBackground(Color.white);
		        panel.setLayout(null);
		        panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2,2, new Color(255,207,51)));
		        panel.setVisible(true);
		        Home.frame.add(panel);
		    	Database db = new Database();
				
				db.loadFromFile();
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
		
		
		
		
	
}



