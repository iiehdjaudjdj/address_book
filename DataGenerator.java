package AddressBookSystemGUI;

import java.util.Random;

public class DataGenerator {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String name = generateRandomName();
            String age = generateRandomAge();
            String sex = generateRandomSex();
            String bday = generateRandomBirthday();
            String address = generateRandomAddress();
            String civil = generateRandomCivilStatus();
            String telephone = generateRandomTelephone();
            String email = generateRandomEmail(name);
            String occupation = generateRandomOccupation();
            String company = generateRandomCompany();

            String entry = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                    name, age, sex, bday, address, civil, telephone, email, occupation, company);

            System.out.println(entry);
        }
    }

    private static String generateRandomName() {
    	 String[] firstNames = {
    		    "Aiden", "Aria", "Caleb", "Charlotte", "Elijah", "Eva", "Gabriel", "Grace", "Isaac", "Isla",
    		    "Liam", "Luna", "Mason", "Mila", "Noah", "Nora", "Oliver", "Olivia", "Sophia", "Sebastian",
    		    "Zoe", "Zachary", "Hazel", "Henry", "Amelia", "Archer", "Avery", "Benjamin", "Chloe", "Dylan",
    		    "Ellie", "Finn", "Harper", "Jackson", "Lucy"
    		};
    	 String[] lastNames = {
    		    "Anderson", "Bennett", "Carter", "Cooper", "Evans", "Fisher", "Garcia", "Hayes", "Hudson", "Jordan",
    		    "Kennedy", "Lewis", "Mitchell", "Morgan", "Perez", "Reed", "Simmons", "Thompson", "Turner", "Ward",
    		    "Williams", "Taylor", "Walker", "Smith", "Miller", "Martin", "Harris", "Gomez", "Gordon", "Clark",
    		    "Barnes", "Bailey", "Diaz", "Fowler", "Grant"
    		};

        Random random = new Random();
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];

        return firstName + " " + lastName;
    }

    private static String generateRandomAge() {
        Random random = new Random();
        return Integer.toString(18 + random.nextInt(20)); 
    }

    private static String generateRandomSex() {
        String[] sexes = {"Male", "Female"};
        Random random = new Random();
        return sexes[random.nextInt(sexes.length)];
    }

    private static String generateRandomBirthday() {
        Random random = new Random();
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        int year = 1980 + random.nextInt(20);

        return String.format("%02d-%02d-%04d", month, day, year);
    }

    private static String generateRandomAddress() {
        String[] countries = {"Philippines","USA", "Canada", "UK", "Australia", "Germany", "France", "Japan", "China", "Brazil", "India"};
        Random random = new Random();
        String country = countries[random.nextInt(countries.length)];

        return country;
    }

    private static String generateRandomCivilStatus() {
        String[] statuses = {"Single", "Married", "Divorced", "Widowed"};
        Random random = new Random();
        return statuses[random.nextInt(statuses.length)];
    }

    private static String generateRandomTelephone() {
        Random random = new Random();
        return "09" + (100000000 + random.nextInt(900000000));
    }

    private static String generateRandomEmail(String name) {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "example.com", "domain.com"};
        Random random = new Random();
        String domain = domains[random.nextInt(domains.length)];

        return name.toLowerCase().replace(" ", "") + "@" + domain;
    }

    private static String generateRandomOccupation() {
        String[] occupations = {"Developer", "Teacher", "Engineer", "Doctor", "Artist", "Writer", "Chef", "Lawyer", "Scientist", "Athlete"};
        Random random = new Random();
        return occupations[random.nextInt(occupations.length)];
    }

    private static String generateRandomCompany() {
        String[] companies = {"Tech Solutions", "Innovate Corp", "Global Enterprises", "Creative Designs", "FutureTech", "Smart Solutions", "Solutions Ltd", "Tech Innovations", "Elite Systems", "Data Dynamics"};
        Random random = new Random();
        return companies[random.nextInt(companies.length)];
    }
}
