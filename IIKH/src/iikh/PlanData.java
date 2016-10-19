/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author mohit
 */
public class PlanData {
   
    String planName;
    ArrayList<String> plans;
    
    private String parsetoString(String planName, ArrayList<String> recipes){
        String out = planName + "\t";
        for(String x: recipes)
            out += (x + ", ");
        return out;
    }
    public void addPlan(String planName, ArrayList<String> recipes){
        System.out.println("..in addplan");
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planList.txt", true)))) {
            out.println(parsetoString(planName, recipes));  
            System.out.print("..in addplan");
        }catch (IOException e) {
        }
    }  
    public ArrayList<String> planNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<>();
	try {
            String line;
            br = new BufferedReader(new FileReader("planList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split("\t");
                list.add(x[0]);
            }
	} catch (IOException e) {
        }       
        return list;       
    }    
    public void getPlan(String planName){
        BufferedReader br = null;
        this.planName = null;
        this.plans = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("planList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split("\t");
                if(x[0].equals(planName)){
                    this.planName = planName;
                    this.plans = new ArrayList<>(Arrays.asList(x[1].split(", ")));
                }
            }
	} catch (IOException e) {
        }
    }
    public void removePlan(String planName ){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("planList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
              //  System.out.println(strLine);
                String tokens[] = strLine.split("\t");
                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID
                    if (!tokens[0].equals(planName)) {  
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("planList.txt");
            try (BufferedWriter out = new BufferedWriter(fstreamWrite)) {
                out.write(fileContent.toString());
                //Close the input stream
                // in.close();
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public ArrayList<String> getPlans(){
        return this.plans;
    }
}