/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

/**
 *
 * @author mohit
 */
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    String recipeName;
    ArrayList<String> ing;
    ArrayList<String> method;
    
    private String parsetoString(String recipeName, ArrayList<String> ing, ArrayList<String> method){
        String out = recipeName + "\t";
        for(String x: ing)
            out += (x + ",");
        out += "\t";
        for(String x: method)
            out += (x + "-->");
        return out;
    }
    public void addRecipe(String recipeName, ArrayList<String> ing, ArrayList<String> method){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recipeList.txt", true)))) {
            out.println(parsetoString(recipeName, ing, method));  
        }catch (IOException e) {
            e.printStackTrace();
        }
    }  
    public ArrayList<String> repNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<>();
	try {
            String line;
            br = new BufferedReader(new FileReader("recipeList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split("\t");
                list.add(x[0]);
            }
	} catch (IOException e) {
        }       
        return list;       
    }    
    public void getRecipe(String recipeName){
        BufferedReader br = null;
        this.recipeName = null;
        this.ing = null;
        this.method = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("recipeList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split("\t");
                if(x[0].equals(recipeName)){
                    this.recipeName = recipeName;
                    this.method = new ArrayList<>(Arrays.asList(x[2].split("-->")));
                }
            }
	} catch (IOException e) {
        }
    }
    public ArrayList<String> getIngredientsList(String recipeName) {
        ArrayList<String> ingredients1 = null;
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader("recipeList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split("\t");
                if(x[0].equals(recipeName)){
                    if(x[1]!=null){
                       ingredients1 = new ArrayList<>(Arrays.asList(x[1].split(",")));
                    }
                    else{
                        return null;
                    }
                }}
            } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredients1;
    }
    public void editRecipe(String oldRecipeName, String newRecipeName, ArrayList<String> ing, ArrayList<String> method ){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("recipeList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    if (tokens[0].equals(oldRecipeName)) {  
                        String newLine = parsetoString(newRecipeName, ing, method);
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
            FileWriter fstreamWrite = new FileWriter("recipeList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void removeRecipe(String RecipeName ){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("recipeList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split("\t");
                if (tokens.length > 0) {
                    if (!tokens[0].equals(RecipeName)) {  
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("recipeList.txt");
            try (BufferedWriter out = new BufferedWriter(fstreamWrite)) {
                out.write(fileContent.toString());
                //Close the input stream
                // in.close();
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public ArrayList<String> getMethod(){
        return this.method;
    }
}