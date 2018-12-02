//import gameplay.Leader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Leaderboard extends Application {

	
	@Override
	public void start(final Stage thestage) throws Exception {
		
		thestage.setTitle("SnakeVsBlock");
		final double C_width=410;
		final double C_height=650;
		Label head= new Label("Leaderboard");
		Group root = new Group();

		
		head.setFont(Font.font("Impact",60));
		head.setTextFill(Color.GOLD);
		root.getChildren().add(head);
		head.setTranslateX(50);
		head.setTranslateY(20);
		
		final Image a= new Image("file:Group15.png");
		ImageView P= new ImageView(a);
		P.setFitWidth(395);
		P.setFitHeight(40);
		
		P.setTranslateY(600);
		
		
		Button B4= new Button("",P);
		B4.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(B4);
        
        final Menu M=new Menu(); 
        
        B4.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
			public void handle(ActionEvent actionEvent) {
		       try {
				M.start(thestage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    }
		});
        
		
		Button[] Bu=new Button[10];
		
		Bu[0]= new Button("1");
		Bu[1]= new Button("2");
		Bu[2]= new Button("3");
		Bu[3]= new Button("4");
		Bu[4]= new Button("5");
		Bu[5]= new Button("6");
		Bu[6]= new Button("7");
		Bu[7]= new Button("8");
		Bu[8]= new Button("9");
		Bu[9]= new Button("10");
	
		Button[] But=new Button[10];
		
		But[0]= new Button("3/12/18");
		But[1]= new Button("3/12/18");
		But[2]= new Button("3/12/18");
		But[3]= new Button("3/12/18");
		But[4]= new Button("3/12/18");
		But[5]= new Button("3/12/18");
		But[6]= new Button("3/12/18");
		But[7]= new Button("3/12/18");
		But[8]= new Button("3/12/18");
		But[9]= new Button("3/12/18");
		
		Button[] B= new Button[10];
		
		gameplay.Leader l=new gameplay.Leader();
		l=deserialize(l);
		
		
		for(int i=0; i<10; i++){
			if(i>=l.L.size()){
				B[i]=new Button("0");
			}
			B[i]= new Button(Integer.toString(l.L.get(i)));
		}
		
		String p1="-fx-pref-width: 120px; " + "-fx-font-size: 2em;"+
				"-fx-pref-height: 5px; "+"-fx-background-color: linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
			    + "-fx-background-radius: 30;"+
			 "-fx-background-insets: 0,1,2,3,0;"
			    +"-fx-text-fill: #654b00;"
			    +"-fx-font-weight: bold;"
			    +"-fx-font-size: 11px;"
			    +"-fx-padding: 10 20 10 20;";
		
		String p="-fx-pref-height: 20px; " + "-fx-font-size: 2em;"+
		"-fx-pref-height: 5px; "+"-fx-background-color: linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
	    + "-fx-background-radius: 30;"+
	 "-fx-background-insets: 0,1,2,3,0;"
	    +"-fx-text-fill: #654b00;"
	    +"-fx-font-weight: bold;"
	    +"-fx-font-size: 11px;"
	    +"-fx-padding: 10 20 10 20;";
		
		String s="-fx-pref-width:150px; " + "-fx-font-size: 2em;"+
				"-fx-pref-height: 5px; "+"-fx-background-color: linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
			    + "-fx-background-radius: 30;"+
			 "-fx-background-insets: 0,1,2,3,0;"
			    +"-fx-text-fill: #654b00;"
			    +"-fx-font-weight: bold;"
			    +"-fx-font-size: 11px;"
			    +"-fx-padding: 10 20 10 20;";
		
		for(int i=0;i<10; i++){
			But[i].setStyle(p1);
			Bu[i].setStyle(p);
			B[i].setStyle(s);
		}
		
		VBox v=new VBox(5);
		v.getChildren().addAll(B[0],B[1],B[2],B[3],B[4],B[5],B[6],B[7],B[8],B[9]);
		v.setAlignment(Pos.BOTTOM_CENTER);
		v.setTranslateX(120);
		v.setTranslateY(150);
		root.getChildren().add(v);
		
		VBox v1=new VBox(5);
		v1.getChildren().addAll(But[0],But[1],But[2],But[3],But[4],But[5],But[6],But[7],But[8],But[9]);
		v1.setAlignment(Pos.BOTTOM_CENTER);
		v1.setTranslateX(280);
		v1.setTranslateY(150);
		root.getChildren().add(v1);
		
		VBox vbox=new VBox(5);
		vbox.getChildren().addAll(Bu[0],Bu[1],Bu[2],Bu[3],Bu[4],Bu[5],Bu[6],Bu[7],Bu[8],Bu[9]);
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		vbox.setTranslateX(20);
		vbox.setTranslateY(150);
		
		root.getChildren().add(vbox);
		Scene theScene= new Scene(root, C_width, C_height,Color.BLACK);
		thestage.setScene(theScene);
		thestage.setResizable(false);
		thestage.show();
		
		
	}
	public static gameplay.Leader deserialize(gameplay.Leader L1) throws IOException, ClassNotFoundException{
		ObjectInputStream in=null;
		try{
			in=new ObjectInputStream(new FileInputStream("Leaderboard.txt"));
			L1=(gameplay.Leader)in.readObject();
		}finally{
			in.close();
		}
		return L1;
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}