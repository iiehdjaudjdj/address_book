package AddressBookSystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;




public class AddEntry {
	static Database getDb = new Database();
	static JPanel panel = new JPanel();
	static JScrollPane scroll = new JScrollPane(panel);
    public static void addEntry() {
    ViewEntry.viewEntry();
    ViewEntry.panel.setVisible(false);
        //font for the text
        Font txtFont = new Font("Verdana",Font.PLAIN,15);
        //font for fields
        Font fieldFont = new Font("Verdana",Font.PLAIN,16);
        
        int marginLeftLabel = 290;
        int marginLeftField = 490;
        //name label
        JLabel nameLabel = new JLabel("Full name :");
        nameLabel.setBounds(marginLeftLabel, 40, 100, 50);
        nameLabel.setFont(txtFont);
        nameLabel.setForeground(new Color(112,112,112));
        panel.add(nameLabel);
        
        //name input 
        JTextField nameField = new JTextField();
        nameField.setBounds(marginLeftField , 40, 450, 50);
        nameField.setMargin(new Insets(10,10,10,10));
        nameField.setFont(fieldFont);
        panel.add(nameField);
        
      //age label
        JLabel ageLabel = new JLabel("Age :");
        ageLabel.setBounds(marginLeftLabel, 120, 80, 50);
        ageLabel.setFont(txtFont);
        ageLabel.setForeground(new Color(112,112,112));
        panel.add(ageLabel);
        
        //age input 
        JTextField ageField = new JTextField();
        ageField.setBounds(marginLeftField , 120, 150, 50);
        ageField.setMargin(new Insets(10,10,10,10));
        ageField.setFont(fieldFont);
        panel.add(ageField);
        
        
        //sex label
        
      
        JLabel sexLabel = new JLabel("Sex :");
        sexLabel.setBounds(marginLeftLabel, 200, 80, 50);
        sexLabel.setFont(txtFont);
        sexLabel.setForeground(new Color(112,112,112));
        panel.add(sexLabel);
        
        
        //make radio button and button group
        ButtonGroup btnGroup = new ButtonGroup();
        //male 
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(marginLeftField , 200, 100, 50);
        male.setFocusable(false);
        male.setBackground(null);
        male.setFont(new Font("Verdana",Font.PLAIN,14));
        //female
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(590, 200, 100, 50);
        female.setFocusable(false);
        female.setBackground(null);
        female.setFont(new Font("Verdana",Font.PLAIN,14));
        btnGroup.add(male);
        btnGroup.add(female);
        
        panel.add(male);
        panel.add(female);
        
        
        //birthday label
        JLabel bdayLabel = new JLabel("Birthday :");
        bdayLabel.setBounds(marginLeftLabel, 280, 80, 50);
        bdayLabel.setFont(txtFont);
        bdayLabel.setForeground(new Color(112,112,112));
        panel.add(bdayLabel);
        
        
        //input label for month 
        JTextField monthField = new JTextField();
        monthField.setBounds(490, 280, 50, 50);
        monthField.setMargin(new Insets(10,10,10,10));
        monthField.setFont(fieldFont);
        panel.add(monthField);
        
      //input label for date  
        JTextField dateField = new JTextField();
        dateField.setBounds(570, 280, 50, 50);
        dateField.setMargin(new Insets(10,10,10,10));
        dateField.setFont(fieldFont);
        panel.add(dateField);
        
        
        
      //input label for year 
        JTextField yearField = new JTextField();
        yearField.setBounds(650, 280, 120, 50);
        yearField.setMargin(new Insets(1,33,1,1));
        yearField.setFont(fieldFont);
        panel.add(yearField);
        
        
        //label for the format
        
        JLabel formatLabel = new JLabel("MM         DD              YYYY");
        formatLabel.setBounds(500, 320, 280, 50);
        formatLabel.setFont(new Font("Verdana",Font.PLAIN,17));
        formatLabel.setForeground(new Color(112,112,112));
        panel.add(formatLabel);
        
        JLabel dash = new JLabel("-             -");
        dash.setFont(new Font("Verdana",Font.PLAIN,17));
        dash.setBounds(550, 280, 120, 50);
        dash.setForeground(new Color(112,112,112));
        panel.add(dash);
        
        
        //ADDRESS LABEL
        
        JLabel addressLabel = new JLabel("Address :");
        addressLabel.setBounds(marginLeftLabel, 400, 80, 50);
        addressLabel.setFont(txtFont);
        addressLabel.setForeground(new Color(112,112,112));
        panel.add(addressLabel);
        
        //address input field 
        JTextField addressField = new JTextField();
        addressField.setBounds(marginLeftField , 400, 450, 50);
        addressField.setMargin(new Insets(10,10,10,10));
        addressField.setFont(fieldFont);
        panel.add(addressField);
        
        
        
        //civil status LABEL
        
        JLabel civilLabel = new JLabel("Civil status :");
        civilLabel .setBounds(marginLeftLabel, 480, 150, 50);
        civilLabel .setFont(txtFont);
        civilLabel .setForeground(new Color(112,112,112));
        panel.add(civilLabel );
        
        //civil status input field 
        JTextField civilField = new JTextField();
        civilField.setBounds(marginLeftField , 480, 150, 50);
        civilField.setMargin(new Insets(10,10,10,10));
        civilField.setFont(fieldFont);
        panel.add(civilField);
        
        
        //telephone label
        
        
        JLabel telLabel = new JLabel("Telephone :");
        telLabel.setBounds(marginLeftLabel, 550, 150, 50);
        telLabel.setFont(txtFont);
        telLabel.setForeground(new Color(112,112,112));
        panel.add(telLabel);
        
        //telephone input field 
        JTextField telField = new JTextField();
        telField.setBounds(marginLeftField , 550, 150, 50);
        telField.setMargin(new Insets(10,10,10,10));
        telField.setFont(fieldFont);
        panel.add(telField);
        
        
        //emaillabel
        
        
        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(marginLeftLabel, 620, 150, 50);
        emailLabel.setFont(txtFont);
        emailLabel.setForeground(new Color(112,112,112));
        panel.add(emailLabel);
        
        //email  input field 
        JTextField emailField = new JTextField();
        emailField.setBounds(marginLeftField , 620, 450, 50);
        emailField.setMargin(new Insets(10,10,10,10));
        emailField.setFont(fieldFont);
        panel.add(emailField);
        
        

        //occupation label
        
        
        JLabel occuLabel = new JLabel("Occupation :");
        occuLabel.setBounds(marginLeftLabel, 690, 150, 50);
        occuLabel.setFont(txtFont);
        occuLabel.setForeground(new Color(112,112,112));
        panel.add(occuLabel);
        
        //occupation input field 
        JTextField occuField = new JTextField();
        occuField.setBounds(marginLeftField , 690, 450, 50);
        occuField.setMargin(new Insets(10,10,10,10));
        occuField.setFont(fieldFont);
        panel.add(occuField );
        
        
        //company label
        
        
        JLabel companyLabel = new JLabel("Company : ");
        companyLabel.setBounds(marginLeftLabel, 760, 150, 50);
        companyLabel.setFont(txtFont);
        companyLabel.setForeground(new Color(112,112,112));
        panel.add(companyLabel);
        
        //occupation input field 
        JTextField companyField = new JTextField();
        companyField.setBounds(marginLeftField , 760, 450, 50);
        companyField.setMargin(new Insets(10,10,10,10));
        companyField.setFont(fieldFont);
        panel.add(companyField );
        
        
        
        //button for submit
        
        JButton submit = new JButton("Submit");
        submit.setBounds(330, 870, 560, 50);
        submit.setForeground(new Color(255,255,255));
        submit.setBackground(new Color(112,112,112));
        submit.setFocusable(false);
        submit.setFont(new Font("Verdana",Font.PLAIN,14));
        panel.add(submit);
        
        submit.addActionListener((e) -> {
        	submit.setEnabled(false);
        	//get data
        	String getName = nameField.getText();
        	//get age
        	String getAge = ageField.getText();
        	
        	//get bday
        	String getMonth = monthField.getText();
        	String getDate = dateField.getText();
        	String getYear = yearField.getText();	
        	
        	//get Address
        	String getAddress = addressField.getText();
        	
        	//get civil
        	String getCivil = civilField.getText();
        	
        	//get telephone
        	String getTelephone = telField.getText();
        	
        	//get email
        	String getEmail = emailField.getText();
        	
        	//get occcupation
        	String getOccupation = occuField.getText();
        	
        	//get company
        	String getCompany = companyField.getText();
        	
        	String getSex;
        	
        	/*
        	 * 
        	 * CHECK IF THE FIELDS ARE NOT EMPTY
        	 * 
        	 * 
        	 */
        	
        	
        	if(!(getName.isEmpty() || getAge.isEmpty() || getMonth.isEmpty() ||getDate.isEmpty() ||getYear.isEmpty() ||  getAddress.isEmpty() ||
        			!(male.isSelected() || female.isSelected()) || getCivil.isEmpty() || getTelephone.isEmpty() || getEmail.isEmpty() || getOccupation.isEmpty() || getCompany.isEmpty())) {
        		//IF THE FIELDS ARE NOT EMPTY then proceed for checking
        		
        		if(male.isSelected()) {
        			getSex = "Male";
        		} else {
        			getSex = "Female";
        		}
        		
        		//compile the bday
        		
        		String compileBday = getMonth + "-" + getDate + "-" + getYear;
        		
        		
        		
        		//make a windows to comfirm the data inputted
        		
        		String conName   =  "Name                  : " + getName;
        		String conAge    =	"Age                     : "+ getAge;
        		String conAdd    = 	"Address               : " + getAddress;
        		String conSex    =	"Sex                     : " + getSex;
        		String conBday   =	"Birthday               : " + compileBday;		
        		String conCivil	 =	"Civil status 	          : "+ getCivil;
        		String conCompany=	"Company     	         : " + getCompany;
        		String conOccu   =	"Occupation           : "+ getOccupation;
        		String conEmail	 =	"Email                   : " + getEmail ;
        		String conTel    =  "Telephone            : " + getTelephone;
        		
        		//ask the user if this infos are correct
        		JWindow confirmInfo = new JWindow();
        		JPanel panelWindow = new JPanel();
        		JPanel titleBg = new JPanel();
        		
        		panelWindow.add(titleBg);
        		titleBg.setSize(500,35);
        		titleBg.setBackground(new Color(255,207,51));
        		titleBg.setBorder(BorderFactory.createMatteBorder(2,2,0,2, new Color(255,207,51)));
        		
        		
        		panelWindow.setBackground(Color.white);
        		panelWindow.setBorder(BorderFactory.createMatteBorder(9, 2, 2, 2, new Color(255,207,51)));
        		//confirm label
        		JLabel confirmLabel = new JLabel("Is this information correct? ");
        		confirmLabel.setFont(new Font("Verdana",Font.PLAIN,15));
        		confirmLabel.setBounds(150,50,350,50);
        		
        		titleBg.add(confirmLabel);	
        		
        		int marginLeft = 100;
        		//make separate labels
        		JLabel nameInfo = new JLabel(conName);
        		nameInfo.setFont(new Font("Verdana",Font.PLAIN,15));
        		nameInfo.setBounds(marginLeft,50,350,30);
        		panelWindow.add(nameInfo);
        	
        		JLabel ageInfo = new JLabel(conAge);
        		ageInfo .setFont(new Font("Verdana",Font.PLAIN,15));
        		ageInfo .setBounds(marginLeft,80,350,30);
        		panelWindow.add(ageInfo );
        		
        		JLabel addInfo = new JLabel(conAdd);
        		addInfo.setFont(new Font("Verdana",Font.PLAIN,15));
        		addInfo.setBounds(marginLeft,110,350,30);
        		panelWindow.add(addInfo);
        		
        		JLabel sexInfo = new JLabel(conSex);
        		sexInfo.setFont(new Font("Verdana",Font.PLAIN,15));
        		sexInfo.setBounds(marginLeft,140,350,30);
        		panelWindow.add(sexInfo);
        		
        		JLabel bdayInfo = new JLabel(conBday);
        		bdayInfo.setFont(new Font("Verdana",Font.PLAIN,15));
        		bdayInfo.setBounds(marginLeft,170,350,30);
        		panelWindow.add(bdayInfo);
        		
        		JLabel civilInfo = new JLabel(conCivil);
        		civilInfo.setFont(new Font("Verdana",Font.PLAIN,15));
        		civilInfo.setBounds(marginLeft,200,350,30);
        		panelWindow.add(civilInfo);
        		
        		JLabel companyInfo = new JLabel(conCompany);
        		companyInfo.setFont(new Font("Verdana",Font.PLAIN,15));
        		companyInfo.setBounds(marginLeft,230,350,30);
        		panelWindow.add(companyInfo);
        		
        		JLabel occuInfo = new JLabel(conOccu);
        		occuInfo.setFont(new Font("Verdana",Font.PLAIN,15));
        		occuInfo.setBounds(marginLeft,260,350,30);
        		panelWindow.add(occuInfo);
        		
        		JLabel emailInfo = new JLabel(conEmail);
        		emailInfo .setFont(new Font("Verdana",Font.PLAIN,15));
        		emailInfo .setBounds(marginLeft,290,350,30);
        		panelWindow.add(emailInfo );
        		
        		JLabel telInfo = new JLabel(conTel);
        		telInfo.setFont(new Font("Verdana",Font.PLAIN,15));
        		telInfo .setBounds(marginLeft,320,350,30);
        		panelWindow.add(telInfo);
        		//make yes btn 
        		JButton yesBtn = new JButton("Yes");
        		 yesBtn.setBackground(new Color(112,112,112));
        		 yesBtn.setForeground(Color.white);
        		 yesBtn.setFont(new Font("Verdana",Font.PLAIN,15));
        		 yesBtn.setBounds(65,390,160,40);
        		 panelWindow.add( yesBtn);
        		
        		////make no btn 
        		JButton noBtn = new JButton("No");
        		 noBtn.setBackground(new Color(112,112,112));
        		 noBtn.setForeground(Color.white);
        		 noBtn.setFont(new Font("Verdana",Font.PLAIN,15));
        		 noBtn.setBounds(280,390,160,40);
        		 panelWindow.add( noBtn);
        		     //no btn action
        		     noBtn.addActionListener(new ActionListener() {
        		    	 public void actionPerformed(ActionEvent e) {
        		    		 confirmInfo.setVisible(false);
        		    		 submit.setEnabled(true);
        		    	 }
        		     });
        		     //yes btn
        		     yesBtn.addActionListener(new ActionListener() {
        		    	 public void actionPerformed(ActionEvent e) {
        		    		 System.out.println(Database.infos.size()); 
        		    		 //insert the inputted data in the database
        		    		 if(Database.infos.size() > 99) {
        		    			 confirmInfo.setVisible(false);
        		    			//make a error window
        		         		JWindow window = new JWindow();
        		         		
        		         		//make panel
        		         		JPanel ePanel = new JPanel();
        		         		ePanel.setBorder(BorderFactory.createMatteBorder(9, 1, 1, 1, Color.red));
        		         		JLabel errorLabel = new JLabel("Database is full!");
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
        		 						 submit.setEnabled(true);
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
        		    		 } else {
        		    			 //add the entry 
        		    			 
        		    			 
        		    		 Database person = new Database(getName, getAge, getSex, compileBday, getAddress, getCivil, getTelephone, getEmail, getOccupation, getCompany);
        		    	    Database.insertData(getName, getAge, getSex, compileBday, getAddress, getCivil, getTelephone, getEmail, getOccupation, getCompany);
        		    		ViewEntry.updateTable();
        		    		ViewEntry.panel.setVisible(false);
        		    		 System.out.println(Database.infos.size());
        		    		//insert the data in a txt file
								getDb.saveToFile();
        		    		 //hide the confirm window and show 
        		    		 confirmInfo.setVisible(false);
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
        		    		 
        		    		 JLabel successLabel = new JLabel("Entry added successfully!");
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
									submit.setEnabled(true);
									
								
									
									nameField.setText("");
									ageField.setText("");
									addressField.setText("");
									btnGroup.clearSelection();
									monthField.setText("");
									dateField.setText("");
									yearField.setText("");
									civilField.setText("");
									telField.setText("");
									occuField.setText("");
									emailField.setText("");
									companyField.setText("");
									
									
									ViewEntry.updateTable();
									
								}
        		    			 
        		    		 });
        		    		 
        		    		 successWindow.add(successPanel);
        		    		 
        		    		 successWindow.setBackground(Color.LIGHT_GRAY);
        		    		 successWindow.setAlwaysOnTop(true);
        		    		 successWindow.setSize(320,170);
        		    		 successWindow.setLayout(null);
        		    		 successWindow.setLocationRelativeTo(Home.frame);
        		    		 successWindow.setVisible(true);
        		    	 }
        		    	 }
        		     });
        		     
        		confirmInfo.add(panelWindow);
        		panelWindow.setSize(500,460);
        		panelWindow.setLayout(null);
        		panelWindow.setVisible(true);
        		confirmInfo.setLocation(530,220);
        		confirmInfo.setSize(500,460);
        		confirmInfo.setLayout(null);
        		confirmInfo.setAlwaysOnTop(true);
        		confirmInfo.setVisible(true);
        		
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
						 submit.setEnabled(true);
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
        });
        
        
        
        
       
        scroll.setBounds(0, 130, 1190, 600);
        scroll.setBorder(null);
        scroll.setVisible(true);
       
        scroll.getVerticalScrollBar().setUI(new CustomScrollBar());
        scroll.getVerticalScrollBar().setUnitIncrement(15);
        
        // Hide horizontal scrollbar
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      
        panel.setPreferredSize(new Dimension(1000, 950));

        scroll.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(170, 255, 0)));
        panel.setBounds(0, 0, 1000, 700);
        panel.setBackground(Color.white);
        panel.setLayout(null);
       
        panel.setVisible(true);

        Home.frame.add(scroll);
    }
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
        g.setColor(new Color(170, 255, 0));
        int arc = 0; 
        g.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, arc, arc);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(new Color(200, 200, 200)); 
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }
}

