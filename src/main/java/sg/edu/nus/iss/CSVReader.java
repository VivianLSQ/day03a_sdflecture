package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public List<Employee> readCSV(String fileName) throws IOException{
        BufferedReader br =null;

        //placeholder for us to read data
        String line = "";
        List<Employee> employees = new ArrayList<Employee>();

        br = new BufferedReader(new FileReader(fileName));

        //skip the FILE_HEADER
        //Skip the first line (staff No. full name,etc.)
        line = br.readLine();

        //read each line of CSV Record
        //Format them into emplotee object
        //Add the employee object into list of employees
        //Inserting line =br.readLine in the while condition allows us to ensure that the line read ends
            //else the alternative is to insert it in the loop
        //Instead of using Scanner
        while((line =br.readLine()) != null){
            String [] lineData = line.split(CSVWriter.COMMA_DELIMITER);
            if(lineData.length > 0){
                Employee emp = new Employee(lineData[0],lineData[1],lineData[2], lineData[3], lineData[4],Integer.parseInt(lineData[5]));

                employees.add(emp);

            }
        }
        //close BufferedReader
        br.close(); 

    return employees;

        
    }

    }
    
