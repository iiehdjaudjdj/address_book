package AddressBookSystemGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Database {
		private String name,age,sex,bday,address,civil,telephone,email,occupation,company;
		
			static int id = 0;
			
			static List<Database> infos = new ArrayList<>();
			
			
			
			Database() {
				
			}
			
			Database(String name, String age, String sex,String bday,String address,String civil,String telephone
					,String email, String occupation, String company) {
				
				this.name = name;
				this.address = address;
				this.sex = sex;
				this.age = age;
				this.bday = bday;
				this.civil = civil;
				this.telephone = telephone;
				this.email = email;
				this.occupation = occupation;
				this.company = company;
			}
			//make setters and getters
			
			/*
			 * name
			 */
			public void setName(String name) {
				this.name = name;
			}
			
			public String getName() {
				return name;
			}
			
			/*
			 * address
			 */
			
			public void setAddress(String address) {
				this.address = address;
			}
			
			public String getAddress() {
				return address;
			}
			
			/*
			 * sex
			 */
			
			public void setSex(String sex) {
				this.sex = sex;
			}
			
			public 	String getSex() {
				return sex;
			}
			
			/*
			 * bday
			 */
			
			public void setBday(String bday) {
				this.bday = bday;
			}
			
			public String getBday() {
				return bday;
			}
			
			/*
			 * age
			 */
			
			public void setAge(String age) {
				this.age = age;
			}
			
			public String getAge() {
				return age;
			}
			
			/*
			 * civilstats
			 */
			
			public void setCivilStatus(String civil) {
				this.civil= civil;
			}
			
			public String getCivilStatus() {
				return civil;
			}
			
			/*
			 * telco
			 */
			
			public void setTelephone(String telephone) {
				this.telephone = telephone;
			}
			
			public String getTelephone() {
				return telephone;
			}
			/*
			 * email
			 */
			
			public void setEmail(String email) {
				this.email = email;
			}
			
			public String getEmail() {
				return email;
			}
			/*
			 * occu
			 */
			
			public void setOccupation(String occupation) {
				this.occupation = occupation;
			}
			
			public String getOccupation() {
				return occupation;
			}
			
			
			
			/*
			 * company
			 */
			
			public void setCompany(String company) {
				this.company = company;
			}
			
			public String getCompany() {
				return company;
			}
			
			
			public static void insertData(String name, String age, String sex,String bday,String address,String civil,String telephone
					,String email, String occupation, String company) {
				
				
				Database insert = new Database(name,age,sex,bday,address,civil,telephone,email,occupation,company);
				infos.add(insert);
				id++;
			}
			
			public void updateData(String name, String age, String sex,String bday,String address,String civil,String telephone
					,String email, String occupation, String company , int row) {
				Database insert = new Database(name,age,sex,bday,address,civil,telephone,email,occupation,company);
				
			    for (int i = 0; i < infos.size(); i++) {
			        Database existingEntry = infos.get(i);

			      
			        if (i != row && isSameEntry(existingEntry, insert)) {
			            
			            return; 
			        }
			    }
				infos.set(row, insert);
				
				saveToFile();
			
				
			}
			
			private boolean isSameEntry(Database entry1, Database entry2) {
			    return entry1.getName().equals(entry2.getName()) && entry1.getAge().equals(entry2.getAge())
			            && entry1.getSex().equals(entry2.getSex()) && entry1.getBday().equals(entry2.getBday())
			            && entry1.getAddress().equals(entry2.getAddress()) && entry1.getCivilStatus().equals(entry2.getCivilStatus())
			            && entry1.getTelephone().equals(entry2.getTelephone()) && entry1.getEmail().equals(entry2.getEmail())
			            && entry1.getOccupation().equals(entry2.getOccupation()) && entry1.getCompany().equals(entry2.getCompany());
			}
			
			
			
			public void saveToFile() {
		        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", false))) {
		            for (Database person : Database.infos) {
		                writer.println(String.join(",", person.getName(), person.getAge(), person.getSex(), person.getBday(),
		                        person.getAddress(), person.getCivilStatus(), person.getTelephone(), person.getEmail(),
		                        person.getOccupation(), person.getCompany()));
		            }
		            
		           
		            
		        } catch (IOException ex) {
		           
		        }
		    }
			
			public void loadFromFile() {
			    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
			        String line;
			        Database.infos.clear(); 
			        while ((line = reader.readLine()) != null) {
			            String[] parts = line.split(",");
			            if (parts.length >= 10) { 
			                String name = parts[0];
			                String age = parts[1];
			                String sex = parts[2];
			                String bday = parts[3];
			                String address = parts[4];
			                String civil = parts[5];
			                String telephone = parts[6];
			                String email = parts[7];
			                String occupation = parts[8];
			                String company = parts[9];

			                Database.insertData(name, age, sex, bday, address, civil, telephone, email, occupation, company);
			            }
			        }
			        ViewEntry.updateTable();
			       
			        
			      
			    } catch (IOException | NumberFormatException ex) {
			      
			        ex.printStackTrace();
			    }
			}


}
