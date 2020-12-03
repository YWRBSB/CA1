
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 *
 * @author Yuri
 */
public class CA1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String fileName = "people1.txt"; // String my file name
        BufferedReader reader = new BufferedReader(new FileReader(fileName)); // Using a Buffered Reader to read my file txt
        String line = null;
        int count = 1; //  variable to control my loop
        int age;
        String name;
        String gender;
        String s = "";
        String title = "";
        String status = "";
        String[] div = null;
        try {
            while ((line = reader.readLine()) != null) {  // The loop starts reading line by line in my file txt
                if (count == 1) {
                    name = line;
                    if (name.matches("[0-9]+")) { // check if the name is a real name
                        System.out.println("Please enter a valid name");
                    } else {
                        div = name.split(" ");
                    }

                } else if (count == 2) {
                    age = Integer.parseInt(line); // Validate the status by the age 
                    if (age >= 0 && age <= 18) {
                        status = "School";
                    } else if (age >= 19 && age <= 25) {
                        status = "College";
                    } else if (age >= 26 && age <= 66) {
                        status = "Worker";
                    } else if (age >= 67 && age <= 100) {
                        status = "Retired";
                    }

                    if ((age > 100) || (age < 0)) { // check if the age is between 0 - 100

                        System.out.println("Please enter a valid age");
                    }
                } else if (count == 3) {
                    // check if the gender is M,F or T and ignore case
                    gender = line;
                    if (!gender.equalsIgnoreCase("m") && (!gender.equalsIgnoreCase("f")) && (!gender.equalsIgnoreCase("t"))) {
                        System.out.println("Please enter a valid gender");
                    } else if (gender.equalsIgnoreCase("m")) {
                        s = "Mr. ";
                    } else if (gender.equalsIgnoreCase("f")) {
                        s = "Ms. ";
                    } else if (gender.equalsIgnoreCase("t")) {
                        s = "Mx ";
                    }
                    if (div != null) {
                        s = s + div[1] + ", " + div[0].substring(0, 1); // format the output on my status.txt
                    }
                    count = 0;
                }

                count = count + 1;
                FileWriter myWriter = new FileWriter("status.txt");  // Create a file named status.txt
                myWriter.write(s + "\r\n" + status); // Write the Surname and the first letter of the name + status
                myWriter.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");  // excepction if the program can not find the file
        } finally {
            reader.close();
        }

    }
}
