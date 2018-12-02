


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

public class PauseScrn extends Application {

	
	@Override
	public void start(final Stage thestage) throws Exception {
		
		thestage.setTitle("SnakeVsBlock");
		
		
		final double C_width=400;
		final double C_height=600;
		Label head1= new Label("Paused");
		head1.setFont(Font.font("Avenir LT Std 35 Light",55));
		head1.setTextFill(Color.GOLD);
		
		Group root = new Group();

		Label Score= new Label("SCORE");
		Score.setFont(Font.font("Stencil",35));
		Score.setTextFill(Color.GOLD);
		
		root.getChildren().addAll(head1,Score);
		
		head1.setTranslateX(120);
		head1.setTranslateY(20);
		
		Score.setTranslateX(150);
		Score.setTranslateY(120);
		
		Button button1= new Button("Return to Main Menu");
		
		
		
		final Image img1 = new Image("file:restart.jpg");
		
		ImageView I=new ImageView(img1);
		I.setFitWidth(75);
		I.setFitHeight(75);
		//I.setTranslateY(300);
		
		gameplay.Scorekeep s=new gameplay.Scorekeep();
				s=deserialize(s);
		
		Label abc=new Label(Integer.toString(s.Score));
		abc.setFont(Font.font("Stencil",35));
		abc.setTextFill(Color.GOLD);
		abc.setTranslateX(190);
		abc.setTranslateY(170);
		root.getChildren().add(abc);
		
		int flag=0;
		
		int h=s.highscore;
		if(s.Score>h){
			flag=1;
			s.highscore=s.Score;
			serialize(s);
			
		}
		
		s=deserialize(s);
		Label High=new Label("");
		if(flag==0){
		High.setText("High Score: "+ Integer.toString(s.highscore));
		}
		else{
			High.setText("New High Score: "+ Integer.toString(s.highscore));	
		}
		High.setFont(Font.font("Stencil",35));
		High.setTextFill(Color.GOLD);
		High.setTranslateX(80);
		High.setTranslateY(550);
		root.getChildren().add(High);
		
		Button B=new Button("Restart");
		B.setTranslateX(83);
		B.setTranslateY(340);
		
		root.getChildren().add(B);
		 final Menu M=new Menu(); 
		 button1.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
				public void handle(ActionEvent actionEvent) {
			       try {
					M.start(thestage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			    }
			});
		
		final gameplay g= new gameplay();
		B.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
			public void handle(ActionEvent actionEvent) {
		       try {
				g.start(thestage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    }
		});
		
		B.setStyle("-fx-pref-width: 250px; " + "-fx-font-size: 2em;"+
					"-fx-pref-height: 70px; "+"-fx-background-color: linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
				    + "-fx-background-radius: 30;"+
				 "-fx-background-insets: 0,1,2,3,0;"
				    +"-fx-text-fill: #654b00;"
				    +"-fx-font-weight: bold;"
				    +"-fx-font-size: 14px;"
				    +"-fx-padding: 10 20 10 20;");
		  
		
        button1.setStyle("-fx-pref-width: 250px; " + "-fx-font-size: 2em;"+
				"-fx-pref-height: 70px; "+"-fx-background-color: linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
			    + "-fx-background-radius: 30;"+
			 "-fx-background-insets: 0,1,2,3,0;"
			    +"-fx-text-fill: #654b00;"
			    +"-fx-font-weight: bold;"
			    +"-fx-font-size: 14px;"
			    +"-fx-padding: 10 20 10 20;");
		
		
		VBox vbox=new VBox(30);
		vbox.getChildren().addAll(button1);
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		vbox.setTranslateX(80);
		vbox.setTranslateY(250);
		
		root.getChildren().add(vbox);
		Scene theScene= new Scene(root, C_width, C_height,Color.BLACK);

		thestage.setScene(theScene);
		thestage.setResizable(false);
		thestage.show();
		
		
	}
	public static gameplay.Scorekeep deserialize(gameplay.Scorekeep Sk) throws IOException, ClassNotFoundException{
		ObjectInputStream in=null;
		try{
			in=new ObjectInputStream(new FileInputStream("Sk.txt"));
			Sk=(gameplay.Scorekeep)in.readObject();
		}finally{
			in.close();
		}
		
		return Sk;
	}
	public static void serialize(gameplay.Scorekeep Sk) throws IOException{
		ObjectOutputStream out=null;
		try{
			out=new ObjectOutputStream(new FileOutputStream("Sk.txt"));
			out.writeObject(Sk);
		}finally{
			out.close();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
