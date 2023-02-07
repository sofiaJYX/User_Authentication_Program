/**
 * UserAuthentication reads a file containing users' login info
 * and prompt the user to enter username and password to verify if user exist
 * in the login info. The user has 3 attempts to enter their login credentials.
 *
 * @Developer: Sofia Jia
 * @Contact: yx881396@dal.ca
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class UserAuthentication {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        //enter the file name to read from
        String filename = "inputFile.txt";

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        //initialize hashmaps
        HashMap<String, String> loginInfo = new HashMap<>();
        HashMap<String, String> userInfo = new HashMap<>();

        String fullName, firstName, lastName, username, password;
        while (inputFile.hasNext()) {
            //read each info
            firstName = inputFile.next();
            lastName = inputFile.next();

            username = inputFile.next();
            password = inputFile.next();

            fullName = firstName + " " + lastName;

            //save to hashmap
            loginInfo.put(username, password);
            userInfo.put(username, fullName);
        }


        //check if name and pass exist in map
        int attempt = 2;

        while (attempt >= 0) {
            //prompt user to enter info
            System.out.print("Login: ");
            String inputName = in.next();

            System.out.print("Password: ");
            String inputPassword = in.next();

            if (loginInfo.containsKey(inputName) && loginInfo.containsValue(inputPassword)) {
                //name & pass exist, print success msg
                String currFullName = userInfo.get(inputName);
                System.out.println("Login successful\n" + "Welcome " + currFullName);
                break;
            }
            else if (attempt > 0) {
                System.out.println("Either the username or password is incorrect. You have " + attempt + " more attempt.");

            } else {
                System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
            }
            attempt--;
        }

    }
}
