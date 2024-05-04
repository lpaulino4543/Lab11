import java.util.Scanner;

public class SocSecProcessor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter social security number: ");
        String ssn = scanner.nextLine();

        try{
            if(isValid(ssn)){
                System.out.println("Name: " + name);
                System.out.println("Social Security Number: " + ssn);
            }
        }catch (SocSecException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static boolean isValid(String ssn) throws SocSecException{
        if(ssn.length() != 11){
            throw new SocSecException("Number of characters must be 11.");
        }

        for(int i = 0; i < ssn.length(); i++){
            char c = ssn.charAt(i);
            if(i == 3 || i == 6){
                if(c != '-'){
                    throw new SocSecException("Dashes in the wrong spots");

                }
            }else{
                if (!Character.isDigit(c)){
                    throw new SocSecException("Non-digits in the SSN");
                }
            }
        }
      return true;
    }
}
