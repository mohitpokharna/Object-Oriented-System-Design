/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueensgui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author mohit
 */
public class Nqueensgui extends Application {

    private static boolean answer = true;

    @Override
    public void start(Stage primaryStage) {
        String color = "light brown"; 
        Label label1 = new Label();
        label1.setText("Enter the number of Queens");
        TextField number = new TextField();
        HBox hb = new HBox(label1, number);
        hb.setPadding(new Insets(20, 20, 20, 20));
        hb.setSpacing(20);
        Button btn1 = new Button();
        Button btn2 = new Button();
        btn1.setText("Next");
        btn2.setText("Exit");        
        btn1.setOnAction((ActionEvent event) -> {
            int n = Integer.parseInt(number.getText());
            solveNQueens(n);
        });
        btn2.setOnAction(e->primaryStage.close());
        HBox hb2 = new HBox(btn1, btn2);
        hb2.setPadding(new Insets(20, 20, 20, 20));
        hb2.setAlignment(Pos.CENTER_RIGHT);
        hb2.setSpacing(20);
        VBox vb = new VBox(hb, hb2);
        vb.setAlignment(Pos.CENTER);
        BorderPane root = new BorderPane();
        root.setCenter(vb); 
        Scene scene = new Scene(root, 450, 350,Color.BEIGE);
        primaryStage.setTitle("NQueens Problem");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param position
     */
    
    public static HBox createHBox(Pos position ){
    
        HBox newHBox = new HBox();
        newHBox.setSpacing(20);
        newHBox.setAlignment(position);
        newHBox.setPadding(new Insets(20, 20, 20, 20));
        return newHBox;
    }

    private void solveNQueens(int n) {
        
        Chessboard C = new Chessboard(n);
        C.callplaceNqueens();
        ArrayList<Chessboardgui> solutions = C.solutions;
        int i = 0;
        boolean next = true; 
        System.out.println(solutions.size());
        if(solutions.isEmpty())
            System.out.println("No results found");
        while((i < solutions.size()) && (next)){
            Chessboardgui solution = solutions.get(i);
            GridPane newBoard = solution.createChessboard();
            next = this.input(newBoard);
            if(!next) System.out.println("Exit");
            i++;
        }

    }
    
    public boolean input(GridPane board){
    
        Stage window = new Stage();
        BorderPane layout = new BorderPane();
        layout.setCenter(board);
        Button next = new Button("Next");
        Button quit = new Button("Quit");
        next.setOnAction(e -> {
            answer = true;
            window.close();
        });
        quit.setOnAction(e -> {   
            answer = false;    
            window.close();
        });
        HBox options = createHBox(Pos.BOTTOM_CENTER);
        options.getChildren().addAll(next, quit);
        layout.setBottom(options);
        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
        
        return answer;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}