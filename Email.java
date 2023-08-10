import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    String department;
    private int mailBoxCapacity;
    private String alternateEmail;
    private final int defaultPasswordLength = 16;
    private String companySuffix = "company.com";
    private int mailCapacity = 1000;
    private String email;
    //constructor for the first name and last name
    public Email(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        setDepartment();
        this.password = generatePassword(defaultPasswordLength);
        String email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "."+companySuffix;
        this.email = email;
        System.out.println("Email was created: " + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println(this.password);
        System.out.println("Email: " + email);

    }
    //ask for the department
    public void setDepartment()
    {
        System.out.println("Type the department code: ");
        System.out.println("1. Sales\n2. Marketing\n3. Accounting\n4. None");
        Scanner in = new Scanner(System.in);

        try {
            int input = in.nextInt();
            switch (input) {
                case 1:
                    department = "Sales";
                    break;
                case 2:
                    department = "Marketing";
                    break;
                case 3:
                    department = "Accounting";
                    break;
                default:
                    department = "None";
                    break;
            }
        } catch (InputMismatchException e) {

            if(this.department == null)
            {
                System.out.println("Please ensure that you entered a number");
            }

        }
    }


    //random password
    private String generatePassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
        char[] passwd = new char[length];
        Random random = new Random(); // Create a Random object

        for(int i = 0; i < length; i++) {
            int rand = random.nextInt(passwordSet.length());
            passwd[i] = passwordSet.charAt(rand);
        }
        return new String(passwd);
    }

    //set the mailbox capacity
    public void setMailBoxCapacity(int capacity)
    {
        this.mailCapacity = capacity;
    }

    //set the alternate mail
    public void setAlternateEmail(String alternateEmail)
    {
        this.alternateEmail = alternateEmail;
    }
    //change the password
    public void changePassword(String password)
    {
        this.password = password;
    }
    public int getMailBoxCapacity()
    {
        return mailBoxCapacity;
    }
    public String getAlternateEmail()
    {
        return alternateEmail;
    }
    public String getPassword()
    {
        return password;
    }
    public String showInfo()
    {
        return "Name: " + this.firstName + " " + this.lastName +
                "\nEmail: " + this.email + "\nAlternate Email: " + getAlternateEmail() +
                "\nCapacity: " + this.mailCapacity;
    }

}
