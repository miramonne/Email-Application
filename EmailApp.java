public class EmailApp {
    public static void main(String[] args)
    {
        Email em1 = new Email("John", "Doe");
        em1.setAlternateEmail("test@hr.com");
        em1.changePassword("Test123");

        System.out.println("****************");
        System.out.println(em1.showInfo());
    }
}
