import java.util.Scanner;
public class RemoveLeadingZeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a numeric string with leading zeros:");
        String input = scanner.nextLine();
        String output = input.replaceFirst("^0+(?!$)", "");
        System.out.println("Output: " + output);
        scanner.close();
    }
}
