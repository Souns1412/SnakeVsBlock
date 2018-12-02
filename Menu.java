import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

public class Menu extends Application {

	
	@Override
	public void start(final Stage thestage) throws Exception {
		
		
		thestage.setTitle("SnakeVsBlock");
		//thestage.getIcons().add(bgimg);
		
		final double C_width=410;
		final double C_height=650;
		Label head1= new Label("Snake");
		Label head2= new Label("  VS");
		Label head3= new Label(" Block");
		
		Group root = new Group();

		
		head1.setFont(Font.font("Avenir LT Std 35 Light",55));
		head1.setTextFill(Color.GOLD);
		head3.setFont(Font.font("Avenir LT Std 35 Light",55));
		head3.setTextFill(Color.GOLD);
		
		head2.setFont(Font.font("Impact",65));
		head2.setTextFill(Color.GOLD);
		
		root.getChildren().addAll(head1,head2,head3);
		
		head1.setTranslateX(130);
		head1.setTranslateY(20);
		
		head3.setTranslateX(125);
		head3.setTranslateY(150);
		
		head2.setTranslateX(150);
		head2.setTranslateY(80);
		//root.getChildren().addAll(flashScreen_node);
		
		Button button1= new Button("New Game");
		//Button button2= new Button("Resume");
		
		final Image img1 = new Image("file:tr2.jpg");
		ImageView I =new ImageView(img1);
		I.setFitWidth(140);
		I.setFitHeight(120);
		
		
		
        Button button3 = new Button("", I);
        
		
		button3.setStyle("-fx-background-color: transparent;");
		
		final Leaderboard L=new Leaderboard();
		
		button3.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
			public void handle(ActionEvent actionEvent) {
		       try {
				L.start(thestage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    }
		});
		
		
		gameplay.Scorekeep Sk=new gameplay.Scorekeep();
		Sk=deserialize(Sk);
		
		Label HighScore=new Label("HighScore: "+Integer.toString(Sk.highscore));
		HighScore.setFont(Font.font("Impact",45));
		HighScore.setTextFill(Color.GOLD);
		HighScore.setTranslateX(80);
		HighScore.setTranslateY(550);
		root.getChildren().add(HighScore);
        
        button1.setStyle("-fx-pref-width: 350px; " + "-fx-font-size: 2em;"+
				"-fx-pref-height: 70px; "+"-fx-background-color: linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
			    + "-fx-background-radius: 30;"+
			 "-fx-background-insets: 0,1,2,3,0;"
			    +"-fx-text-fill: #654b00;"
			    +"-fx-font-weight: bold;"
			    +"-fx-font-size: 14px;"
			    +"-fx-padding: 10 20 10 20;");
		
		
		
		
		
		
		VBox vbox=new VBox(10);
		vbox.getChildren().addAll(button1,button3);
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		vbox.setTranslateX(30);
		vbox.setTranslateY(300);
		
		root.getChildren().add(vbox);
		Scene theScene= new Scene(root, C_width, C_height,Color.BLACK);

		thestage.setScene(theScene);
		thestage.setResizable(false);
		thestage.show();
		
		final choice game = new choice();
		button1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
			public void handle(ActionEvent actionEvent) {
		       try {
				game.start(thestage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    }
		});
		
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
	
	public static void main(String[] args) {
		launch(args);

	}

}


