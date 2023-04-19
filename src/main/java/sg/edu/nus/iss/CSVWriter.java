package sg.edu.nus.iss;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEWLINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "staffNo, fullName, department, role, emailAddress, salary";
    //Because class is static, you call NEWLINE_SEPARATOR in any document without instantiation 

    public List<Employee> employees = null;
     public List<Employee> generateEmployees(){
        employees = new ArrayList<>();
    
        //Note: every data should be  in ""
        Employee emp1 = new Employee ("12344", "Bryan", "Customer Relation", "Relationship Manager", "bryan@visa.com", 10000);
        Employee emp2 = new Employee ("45764", "Sally", "Project Manager", "External Manager", "sally@visa.com", 9000);
        Employee emp3 = new Employee ("56567", "Carl", "Test Engineer", "Trainee", "carl@visa.com", 8000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        return employees;

     }

     public void writeToCSV(List<Employee> employees, String fileName) throws IOException{
        FileWriter fileWriter = new FileWriter(fileName);

        //write FILE_HEADER
        fileWriter.append(FILE_HEADER.toString());
        fileWriter.append(NEWLINE_SEPARATOR); 

        //iterate through employees to write each employee record to file
        for(Employee emp: employees){
            fileWriter.append(emp.getStaffNo());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getFullName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getDepartment());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getRole());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getEmailAddress());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(emp.getSalary())); //need to convert Integer to String as append can only take String
            fileWriter.append(NEWLINE_SEPARATOR);
        }
        //should be able to use "write" instead of "append"
        //recommended to do each individually, if not you must made edits to .employee

        //flush and close the filewriter 
        fileWriter.flush();
        fileWriter.close();
     }
     //use the main function to call this class, cannot be done here 


    
}
