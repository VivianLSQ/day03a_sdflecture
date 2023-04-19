package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

    File newDirectory = new File(dirPath);
    if (newDirectory.exists()){
        System.out.println("Directory does not exist");
    }else {
        newDirectory.mkdir();
    }

    File myFile = new File(dirPathFileName); 
    if(myFile .exists()){
        System.out.println("File" + myFile + " already exists");
    } else {
        myFile.createNewFile();
    }

    //Instantiate the new clas from CSV Writer
    CSVWriter csvWriter = new CSVWriter();
    //Generate Employee to use it locally
    List<Employee> empList = csvWriter.generateEmployees();
    csvWriter.writeToCSV(empList, dirPathFileName); 

    //Instantiate the new class from CSV Reader; and to read CSV 
    CSVReader csvReader = new CSVReader();
    List<Employee> retrievedList = csvReader.readCSV(dirPathFileName);
    System.out.println(retrievedList.toString()); 
}
}
