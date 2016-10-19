/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohit
 */

public class MealData{
    String mealName;
    ArrayList<String> mealItems;
    
    private String parsetoString(String mealName, ArrayList<String> recipes){
        String out = mealName + "\t";
        for(String x: recipes)
            out += (x + ";");
        return out;
    }
    public void addMeal(String mealName, ArrayList<String> recipes){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("mealList.txt", true))) {
        //    out.println(parsetoString(mealName, recipes));  
            bw.write(parsetoString(mealName, recipes)+'\n');
            bw.close();
            System.out.print("Done");
        }catch (IOException e) {
        }
    }  
    public ArrayList<String> mealNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
	try {
            String line;
            br = new BufferedReader(new FileReader("mealList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split("\t");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }    
    public void getMeal(String mealName){
        BufferedReader br = null;
        this.mealName = null;
        this.mealItems = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("mealList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split("\t");
                if(x[0].equals(mealName)){
                    this.mealName = mealName;
                    this.mealItems = new ArrayList<>(Arrays.asList(x[1].split("; ")));
                }
            }
	} catch (IOException e) {
        }
    }
    public String getMealItems(String mealName) {
        String mealItems1 = null;
        try {
            String line;
            
            BufferedReader br;
            br = new BufferedReader(new FileReader("mealList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split("\t");
                if(x[0].equals(mealName)){
                    mealItems1 = x[1];
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MealData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MealData.class.getName()).log(Level.SEVERE, null, ex);
        }
            return mealItems1;
    }
    public void editMeal(String oldmealName, String newmealName, ArrayList<String> mealList){
        try {
            // Open the file that is the first
            FileInputStream fstream = new FileInputStream("mealList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split("\t");
                if (tokens.length > 0) {
                    // token[0] contains meal names
                    if (tokens[0].equals(oldmealName)) {  
                        System.out.print("here");
                        String newLine = parsetoString(newmealName, mealList);
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("mealList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void removeMeal(String mealName ){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("mealList.txt");
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
                    if (!tokens[0].equals(mealName)) {  
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("mealList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public ArrayList<String> getRecipes(){
        return this.mealItems;
    }
}