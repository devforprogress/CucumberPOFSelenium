package StepDefinitions;

import PageObject.AddCustomerPage;
import PageObject.DashBoardPage;
import PageObject.LogInPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.readConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public LogInPage logInPage;
    public DashBoardPage dashBoardPage;
    public AddCustomerPage addCustomerPage;
    public  String filePath = "emailIDList.txt";

    public readConfig readConfig;
    public String url;

//    public void hardWaitFor(int sec) {
//
//        try {
//            Thread.sleep(Duration.ofSeconds(sec));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public String generateRandomEmailID(){

         String emailID = RandomStringUtils.randomAlphabetic(5)+"@gmail.com";
         return emailID;
    }




        public boolean writeInTextFile(String textToWrite) {
        boolean write = false;


            // Call the method to update the file with the new content
            updateFileContent(filePath, textToWrite);

            write = true;
            return write;
        }

        public  void updateFileContent(String filePath, String newContent) {
            try {
                // Create a FileWriter instance with the given file path
                FileWriter fileWriter = new FileWriter(filePath);

                // Write the new content to the file
                fileWriter.write(newContent);

                // Close the FileWriter to save changes
                fileWriter.close();

                System.out.println("File content updated successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }




    // Call the method to read the file content and store it in a variable



    public static String readFileContent(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return contentBuilder.toString();
    }



    public String newEmailID;

    public String copyOfEmailID;
    public WebDriverWait wait10;

    public static Logger log;



}
