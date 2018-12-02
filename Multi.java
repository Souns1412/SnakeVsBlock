import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
//import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
//import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import java.util.concurrent.TimeUnit;
//import javafx.scene.shape.Circle;
//import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;

public class Multi extends Application{
	
	private Pane root= new Pane();
	private final Random random = new Random();
	
	Label Scount1=new Label("0");
	Label time1=new Label("0");
	int Sc1=0;
	
	Label Scount2=new Label("0");
	Label time2=new Label("0");
	int Sc2=0;
	
	
	
	//----------Magnet-----------------
		final Image m= new Image("file:magnet.jpg");
		ImagePattern magnet= new ImagePattern(m);
		private  ArrayList<Magnet> M=new ArrayList<Magnet>();
	
	//----------Shield-----------------
	final Image s= new Image("file:shield.jpg");
	ImagePattern shield= new ImagePattern(s);
	private  ArrayList<Shield> Sh=new ArrayList<Shield>();
	//------------BOMB----------------------------
	final Image b= new Image("file:bomb.jpg");
	ImagePattern bomb = new ImagePattern(b);
	private  ArrayList<DestBlock> DB=new ArrayList<DestBlock>();
	//---------------COIN-----------------------
	final Image c= new Image("file:coin.jpg");
	ImagePattern coinicon = new ImagePattern(c);
	private  ArrayList<Coin> coinlist=new ArrayList<Coin>();
	private  ArrayList<Label> cL=new ArrayList<Label>();
	//-------------------------------------------------
	
	
	//------------Snake1---------------------
	
	private Snake player= new Snake(306,450,12,Color.GOLD);
	Label Len=new Label(Integer.toString( player.length));
	private  ArrayList<Snake> Souns =new ArrayList<Snake>();
	//----------------------------------------
	
	//------------Snake2---------------------
	
		private Snake player2= new Snake(106,450,12,Color.RED );
		Label Len2=new Label(Integer.toString( player.length));
		private ArrayList<Snake> Souns2 =new ArrayList<Snake>();
	//----------------------------------------
		
	
	
	
	private static ArrayList<Wall> wallarray =new ArrayList<Wall>();
	
	//----------------Brick-----------------
	private static ArrayList<Brick> arr=new ArrayList<Brick>();
	private static ArrayList<Label> L=new ArrayList<Label>();
	//-------------------------------------------------------
	
	
	
	
	private Parent createContent(){
		root.setPrefSize(410, 650);
		return root;
	}
	
	
	@Override
	public void start(Stage thestage) throws Exception{
		
		
		
		
		
		final Scene theScene= new Scene(createContent(), Color.BLACK);
		final Image bg= new Image("file:blackscreen.jpg");
		
		 BackgroundImage backgroundimage = new BackgroundImage(bg,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundPosition.DEFAULT,
	                BackgroundSize.DEFAULT);
		 root.setBackground(new Background(backgroundimage));
		 
		thestage.setTitle("SnakeVsBlock");
		thestage.setResizable(false);
		thestage.show();
		
		
		Scount1.setTranslateX(380);
		Scount1.setTranslateY(30);
		Scount1.setFont(Font.font("Impact",40));
		Scount1.setTextFill(Color.WHITE);
		root.getChildren().add(Scount1);
		
		time1.setTranslateX(360);
		time1.setTranslateY(160);
		time1.setFont(Font.font("Impact",40));
		time1.setTextFill(Color.BLACK);
		root.getChildren().add(time1);
		
		Scount2.setTranslateX(30);
		Scount2.setTranslateY(30);
		Scount2.setFont(Font.font("Impact",40));
		Scount2.setTextFill(Color.WHITE);
		root.getChildren().add(Scount2);
		
		time2.setTranslateX(50);
		time2.setTranslateY(160);
		time2.setFont(Font.font("Impact",40));
		time2.setTextFill(Color.BLACK);
		root.getChildren().add(time2);
		
		
		
		Souns.add(player);
		Len.setTranslateX(302);
		Len.setTranslateY(420);
		Len.setFont(Font.font("Impact",13));
		Len.setTextFill(Color.WHITE);
		
		Souns2.add(player2);
		Len2.setTranslateX(102);
		Len2.setTranslateY(420);
		Len2.setFont(Font.font("Impact",13));
		Len2.setTextFill(Color.WHITE);
		
		double cx=Souns.get(0).getTranslateX();
		double cy=Souns.get(Souns.size()-1).getTranslateY();
		for(int o=0; o<3;o++){
			Snake tail=new Snake(cx,cy+24,12,Color.GOLD);
			Souns.add(tail);
			cy+=24;
			
		}
		
		double cx2=Souns2.get(0).getTranslateX();
		double cy2=Souns2.get(Souns2.size()-1).getTranslateY();
		for(int o=0; o<3;o++){
			Snake tail=new Snake(cx2,cy2+24,12,Color.RED);
			Souns2.add(tail);
			cy2+=24;
			
		}
		
		root.getChildren().addAll(Souns);
		root.getChildren().addAll(Len);
		
		root.getChildren().addAll(Souns2);
		root.getChildren().addAll(Len2);
		
		
		thestage.setScene(theScene);
		thestage.setResizable(false);
		//thestage.show();
		
		
		
		
		
		
		new AnimationTimer() {
			
			int count=0;
			double gamespeed =2;
			int divider1=30;
			int divider2=100;
        	int sety=100;
        	int setx=2;
        	int timer=600,shieldflag=0;
        	int timer2=600,shieldflag2=0;
	            
        		@Override
	            public void handle(long now) {
	            	
        			if(shieldflag==1){
        				timer-=2;
        				
        				time1.setText(Integer.toString(timer/100));
        				time1.setTextFill(Color.WHITE);
        				
        			}
        			
        			if(shieldflag2==1){
        				timer2-=2;
        				
        				time2.setText(Integer.toString(timer2/100));
        				time2.setTextFill(Color.WHITE);
        				
        			}
        			
        			if(timer==0){
        				shieldflag=0;
        				timer=600;
        				
        				time1.setTextFill(Color.BLACK);
        			}
        			if(timer2==0){
        				shieldflag2=0;
        				timer2=600;
        				
        				time2.setTextFill(Color.BLACK);
        			}
        			
        			
        			//-----------Magnet Collision--------------
        			for(int p=0; p<M.size();p++){
        				M.get(p).setLayoutY(M.get(p).getLayoutY()+gamespeed);
        				Magnet m=M.get(p);
        				
        				int chooser=0;
        				if(Souns.get(0).getBoundsInParent().intersects(m.getBoundsInParent())){
        					chooser=1;
        				}
        				
        				else if (Souns2.get(0).getBoundsInParent().intersects(m.getBoundsInParent())){
        					chooser=2;
        					}
        				
        				if(chooser==1)
        					{
        					ArrayList<Coin> temp1=new ArrayList<Coin>();
        					ArrayList<Label> temp2=new ArrayList<Label>();
        					M.remove(p);
        					root.getChildren().remove(m);
        					
        					for(int k=0; k<coinlist.size();k++){
    							Coin j=coinlist.get(k);
    							Label h=cL.get(k);
    						if(coinlist.get(k).getLayoutY()>=-20 &&coinlist.get(k).getLayoutY()<=650){
    							temp1.add(j);
    							temp2.add(h);
    							
    							
    						}
    						
    						for(int y=0; y<temp1.size();y++){
    							FadeTransition ft = new FadeTransition(Duration.millis(1000), temp1.get(y));
	            			     ft.setFromValue(1.0);
	            			     ft.setToValue(0);
	            			     ft.setCycleCount(1);
	            			     ft.setAutoReverse(false);
	            			 
	            			     ft.play();
    						TranslateTransition T= new TranslateTransition();
    						T.setDuration(Duration.seconds(1));
    						T.setToX(0);
    						T.setToY(450);
    						T.setAutoReverse(false);
    						T.setNode(temp1.get(y));
    						T.play();
    						//T.setNode(temp2.get(y));
    						}
    					}
        				
        				double cx=Souns.get(Souns.size()-1).getTranslateX();
        				double cy=Souns.get(Souns.size()-1).getTranslateY();
    					
        				for(int y=0; y<temp1.size();y++){
    						Coin C=temp1.get(y);
    						Souns.get(0).length+=C.value;
        					Len.setText(Integer.toString(Souns.get(0).length));
        					
        					
        					for(int o=0; o<C.value;o++){
        						Snake tail=new Snake(cx,cy+24,12,Color.GOLD);
        						Souns.add(tail);
        						root.getChildren().add(tail);
        						cy+=24;
        						
        					}
    						coinlist.remove(coinlist.indexOf(temp1.get(y)));
    						cL.remove(cL.indexOf(temp2.get(y)));
    					}
    					
    					temp1.clear();
    					temp2.clear();
        					
        				}
        				
        				if(chooser==2)
        				{
        					ArrayList<Coin> temp1=new ArrayList<Coin>();
        					ArrayList<Label> temp2=new ArrayList<Label>();
        					M.remove(p);
        					root.getChildren().remove(m);
        					
        					for(int k=0; k<coinlist.size();k++){
    							Coin j=coinlist.get(k);
    							Label h=cL.get(k);
    						if(coinlist.get(k).getLayoutY()>=-20 &&coinlist.get(k).getLayoutY()<=650){
    							temp1.add(j);
    							temp2.add(h);
    							
    							
    						}
    						
    						for(int y=0; y<temp1.size();y++){
    							FadeTransition ft = new FadeTransition(Duration.millis(1000), temp1.get(y));
	            			     ft.setFromValue(1.0);
	            			     ft.setToValue(0);
	            			     ft.setCycleCount(1);
	            			     ft.setAutoReverse(false);
	            			 
	            			     ft.play();
    						TranslateTransition T= new TranslateTransition();
    						T.setDuration(Duration.seconds(1));
    						T.setToX(0);
    						T.setToY(450);
    						T.setAutoReverse(false);
    						T.setNode(temp1.get(y));
    						T.play();
    						
    						}
    					}
        				
        				double cx=Souns2.get(Souns2.size()-1).getTranslateX();
        				double cy=Souns2.get(Souns2.size()-1).getTranslateY();
    					
        				for(int y=0; y<temp1.size();y++){
    						Coin C=temp1.get(y);
    						Souns2.get(0).length+=C.value;
        					Len2.setText(Integer.toString(Souns2.get(0).length));
        					
        					
        					for(int o=0; o<C.value;o++){
        						Snake tail=new Snake(cx,cy+24,12,Color.RED);
        						Souns2.add(tail);
        						root.getChildren().add(tail);
        						cy+=24;
        						
        					}
    						coinlist.remove(coinlist.indexOf(temp1.get(y)));
    						cL.remove(cL.indexOf(temp2.get(y)));
    					}
    					
    					temp1.clear();
    					temp2.clear();
        					
        				}
        				
        				
        				
        				
        				if(m.getLayoutY()>=740){
	            			M.remove(p);
	            			root.getChildren().remove(m);
	            		}
        			}
        			
        			//-----------Shield Collision--------------
        			
        			for(int p=0; p<Sh.size();p++){
        				
        				int chooser=0;
        				Sh.get(p).setLayoutY(Sh.get(p).getLayoutY()+gamespeed);
        				Shield s=Sh.get(p);
        				
        				if(Souns.get(0).getBoundsInParent().intersects(s.getBoundsInParent())){
        					chooser=1;
        				}
        				else if(Souns2.get(0).getBoundsInParent().intersects(s.getBoundsInParent())){
        					chooser=2;
        				}
        					
        				if(chooser==1)
        				{
        					shieldflag=1;
        					Sh.remove(p);
        					root.getChildren().remove(s);
        					
        				}
        				if(chooser==2)
        				{
        					shieldflag2=1;
        					Sh.remove(p);
        					root.getChildren().remove(s);
        					
        				}
        				
        				if(s.getLayoutY()>=740){
	            			Sh.remove(p);
	            			root.getChildren().remove(s);
	            		}
        			}
        			//-------------Bomb Collision----------------
        			for(int p=0; p<DB.size();p++){
        				DB.get(p).setLayoutY(DB.get(p).getLayoutY()+gamespeed);
        				
        				DestBlock B=DB.get(p);
        				int chooser=0;
        				
        				if(Souns.get(0).getBoundsInParent().intersects(B.getBoundsInParent())){
        					chooser=1;
        				}
        				else if(Souns2.get(0).getBoundsInParent().intersects(B.getBoundsInParent())){
        					chooser=2;
        				}
        				
        				
        				if(chooser==1||chooser==2)
        				{
        					ArrayList<Brick> temp1=new ArrayList<Brick>();
        					ArrayList<Label> temp2=new ArrayList<Label>();
        					DB.remove(p);
        					root.getChildren().remove(B);
        					for(int k=0; k<arr.size();k++){
        							Brick j=arr.get(k);
        							Label h=L.get(k);
        						if(arr.get(k).getLayoutY()>=-20 &&arr.get(k).getLayoutY()<=650){
        							temp1.add(j);
        							temp2.add(h);
        							root.getChildren().removeAll(j,h);
        							
        						}
        					}
        					for(int y=0; y<temp1.size();y++){
        						arr.remove(arr.indexOf(temp1.get(y)));
        						L.remove(L.indexOf(temp2.get(y)));
        					}
        					
        					temp1.clear();
        					temp2.clear();
        				}
        				
        				if(B.getLayoutY()>=740){
	            			DB.remove(p);
	            			
	            			root.getChildren().removeAll(B);
	            		}
	            		
        				
        			}
        			//----------------------------------------------
        			//--------------- Wall collision---------------
        			
        			for(int p=0; p<wallarray.size();p++){
        				wallarray.get(p).setLayoutY(wallarray.get(p).getLayoutY()+gamespeed);
        				Wall wl=wallarray.get(p);
        				if(wl.getLayoutY()>=850){
	            			wallarray.remove(p);
	            			root.getChildren().remove(wl);
	            		}
        				
        			}
        			
        			
        			//System.out.println("coin:"+coinlist.size());
        			double cx=Souns.get(0).getTranslateX();
        			double cy=Souns.get(Souns.size()-1).getTranslateY();
        			
        			double cx2=Souns2.get(0).getTranslateX();
        			double cy2=Souns2.get(Souns2.size()-1).getTranslateY();
        			
        			
        			
        			//------------------ COIN COLLISION------------
        			
        			for(int a=0; a<coinlist.size();a++){
        				
        				int chooser=0;
        				coinlist.get(a).setLayoutY(coinlist.get(a).getLayoutY()+gamespeed);
        				cL.get(a).setLayoutY(cL.get(a).getLayoutY()+gamespeed);
        				
        				Coin C=coinlist.get(a);
        				Label v=cL.get(a);
        				
        				if(C.getLayoutY()>=740){
	            			coinlist.remove(a);
	            			cL.remove(a);
	            			root.getChildren().removeAll(C,v);
	            		}
        				
        				if(Souns.get(0).getBoundsInParent().intersects(C.getBoundsInParent())){
        					chooser=1;
        				}
        				else if(Souns2.get(0).getBoundsInParent().intersects(C.getBoundsInParent())){
        					chooser=2;
        				}
        				
        				if(chooser==1)
        				{
        					
        					coinlist.remove(a);
        					cL.remove(a);
        					root.getChildren().removeAll(C,v);
        					Souns.get(0).length+=C.value;
        					
        					
        					//break;
        					Len.setText(Integer.toString(Souns.get(0).length));
        					//System.out.println(Souns.get(0).length);
        					
        					for(int o=0; o<C.value;o++){
        						Snake tail=new Snake(cx,cy+24,12,Color.GOLD);
        						Souns.add(tail);
        						root.getChildren().add(tail);
        						cy+=24;
        						
        					}
        					
        					
        				}
        				if(chooser==2)
        				{
        					
        					coinlist.remove(a);
        					cL.remove(a);
        					root.getChildren().removeAll(C,v);
        					Souns2.get(0).length+=C.value;
        					
        					Len2.setText(Integer.toString(Souns2.get(0).length));
        					
        					for(int o=0; o<C.value;o++){
        						Snake tail=new Snake(cx2,cy2+24,12,Color.RED);
        						Souns2.add(tail);
        						root.getChildren().add(tail);
        						cy2+=24;
        						
        					}
        					
        					
        				}
        				
        			}
        			//-----------------------------------------------------
        			
        			
        			//---------- BLOCK COLLISION ----------------------------
        			
        			//System.out.println(arr.size());
        			
        			for(int i=0;i<arr.size();i++){
        				int chooser=0;
        				
	            		arr.get(i).setLayoutY(arr.get(i).getLayoutY()+gamespeed);
	            		L.get(i).setLayoutY(L.get(i).getLayoutY()+gamespeed);
	            		
	            		Brick B=arr.get(i);
	            		Label la=L.get(i);
	            		
	            		if(B.getLayoutY()>=740){
	            			arr.remove(i);
	            			L.remove(i);
	            			root.getChildren().removeAll(B,la);
	            		}
	            		
	            		if(Souns.get(0).getBoundsInParent().intersects(B.getBoundsInParent()) ){
	            			chooser=1;
	            		}
	            		if(Souns2.get(0).getBoundsInParent().intersects(B.getBoundsInParent())){
	            			chooser=2;
	            		}
	            		
	            		if(chooser==1)
	            		{
	            			
	            			
	            			arr.remove(i);
	            			L.remove(i);
	            			if(shieldflag==1){
	            				FadeTransition ft = new FadeTransition(Duration.millis(1000), B);
	            			     ft.setFromValue(1.0);
	            			     ft.setToValue(0);
	            			     ft.setCycleCount(1);
	            			     ft.setAutoReverse(false);
	            			 
	            			     ft.play();
	            			     FadeTransition f = new FadeTransition(Duration.millis(1000), la);
	            			     f.setFromValue(1.0);
	            			     f.setToValue(0);
	            			     f.setCycleCount(1);
	            			     f.setAutoReverse(false);
	            			 
	            			     f.play();
	            				//root.getChildren().removeAll(B,la);
	            				Sc1+=B.value;
	        					Scount1.setText(Integer.toString(Sc1));
	        					
	            			}
	            			if(shieldflag==0){
	            			if(B.value<Souns.get(0).length){
	            				Sc1+=B.value;
	        					Scount1.setText(Integer.toString(Sc1));
	        					if(shieldflag==0)
	            				Souns.get(0).length-=B.value;
	        					Len.setText(Integer.toString(Souns.get(0).length));
	            				for(int o=0; o<B.value;o++){
	            					
	            					Snake g=Souns.get(Souns.size()-1);
	            					Souns.remove(Souns.size()-1);
	            					root.getChildren().remove(g);
	            				}
	            				
	            				FadeTransition ft = new FadeTransition(Duration.millis(1000), B);
	            			     ft.setFromValue(1.0);
	            			     ft.setToValue(0);
	            			     ft.setCycleCount(1);
	            			     ft.setAutoReverse(false);
	            			 
	            			     ft.play();
	            			     FadeTransition f = new FadeTransition(Duration.millis(1000), la);
	            			     f.setFromValue(1.0);
	            			     f.setToValue(0);
	            			     f.setCycleCount(1);
	            			     f.setAutoReverse(false);
	            			 
	            			     f.play();
	            			     
	            			     
	            				//root.getChildren().removeAll(B,la);
	            			}
	            			
	            			else{
	            				player.dead=true;
	            				root.getChildren().removeAll(Souns);
	            				
	            				
	            				Platform.exit();
	            			}
	            		}
	            			
	            			//break;
	            		
	            		}
	            		
	            		
	            		if(chooser==2)
	            		{
	            			
	            			
	            			arr.remove(i);
	            			L.remove(i);
	            			if(shieldflag2==1){
	            				FadeTransition ft = new FadeTransition(Duration.millis(1000), B);
	            			     ft.setFromValue(1.0);
	            			     ft.setToValue(0);
	            			     ft.setCycleCount(1);
	            			     ft.setAutoReverse(false);
	            			 
	            			     ft.play();
	            			     FadeTransition f = new FadeTransition(Duration.millis(1000), la);
	            			     f.setFromValue(1.0);
	            			     f.setToValue(0);
	            			     f.setCycleCount(1);
	            			     f.setAutoReverse(false);
	            			 
	            			     f.play();
	            				//root.getChildren().removeAll(B,la);
	            				Sc2+=B.value;
	        					Scount2.setText(Integer.toString(Sc2));
	        					
	            			}
	            			if(shieldflag2==0){
	            			if(B.value<Souns2.get(0).length){
	            				Sc2+=B.value;
	        					Scount2.setText(Integer.toString(Sc2));
	        					if(shieldflag2==0)
	            				Souns2.get(0).length-=B.value;
	        					Len2.setText(Integer.toString(Souns2.get(0).length));
	            				for(int o=0; o<B.value;o++){
	            					
	            					Snake g=Souns2.get(Souns2.size()-1);
	            					Souns2.remove(Souns2.size()-1);
	            					root.getChildren().remove(g);
	            				}
	            				
	            				FadeTransition ft = new FadeTransition(Duration.millis(1000), B);
	            			     ft.setFromValue(1.0);
	            			     ft.setToValue(0);
	            			     ft.setCycleCount(1);
	            			     ft.setAutoReverse(false);
	            			 
	            			     ft.play();
	            			     FadeTransition f = new FadeTransition(Duration.millis(1000), la);
	            			     f.setFromValue(1.0);
	            			     f.setToValue(0);
	            			     f.setCycleCount(1);
	            			     f.setAutoReverse(false);
	            			 
	            			     f.play();
	            			     
	            			     
	            				
	            			}
	            			
	            			else{
	            				player2.dead=true;
	            				root.getChildren().removeAll(Souns2);
	            				
	            				Platform.exit();
	            			}
	            		}
	            			
	            			
	            		
	            		}
	            		
	            		
	            		
	            		
	            	}
        			
        			//-------------------------------------------------
        			
        			
        			
        			sety-=200;
        			
        			//---------------- Magnet Generation-------------------
        			
        			int mx=20;
        			int pos4=random.nextInt(3);
        			if(pos4==0){
        				mx=random.nextInt(60)+20;
        			}
        			if(pos4==1){
        				mx=random.nextInt(140)+90;
        			}
        			if(pos4==2){
        				mx=random.nextInt(210)+172;
        			}
        			if(pos4==3){
        				mx=random.nextInt(290)+252;
        			}
        			
        			int my=sety+130;
        			int mf= random.nextInt(100);
        			
        			if(mf>=0&&mf<=20){
        				
        				
        				Magnet m=new Magnet(20,30,magnet);
        				m.setLayoutX(mx);
	        			m.setLayoutY(my);
	        	
	        			M.add(m);
	        			root.getChildren().add(m);	
        			}
        			
        			//---------------- Shield Generation-------------------
        			int shx=20;
        			int pos3=random.nextInt(3);
        			if(pos3==0){
        				shx=random.nextInt(60)+20;
        			}
        			if(pos3==1){
        				shx=random.nextInt(140)+90;
        			}
        			if(pos3==2){
        				shx=random.nextInt(210)+172;
        			}
        			if(pos3==3){
        				shx=random.nextInt(290)+252;
        			}
        			
        			int shy=sety+130;
        			int sf= random.nextInt(100);
        			
        			if(sf>=0&&sf<=20){
        				
        				
        				Shield s=new Shield(18,shield);
        				s.setLayoutX(shx);
	        			s.setLayoutY(shy);
	        	
	        			Sh.add(s);
	        			root.getChildren().add(s);	
        			} 
        			
        			
        			
        			//---------------- Bomb Generation-------------------
        			int bombx=20;
        			int pos2=random.nextInt(3);
        			if(pos2==0){
        				bombx=random.nextInt(60)+20;
        			}
        			if(pos2==1){
        				bombx=random.nextInt(140)+90;
        			}
        			if(pos2==2){
        				bombx=random.nextInt(210)+172;
        			}
        			if(pos2==3){
        				bombx=random.nextInt(290)+252;
        			}
        			
        			int bomby=sety-30;
        			int bf= random.nextInt(100);
        			
        			if(bf>=0&&bf<=20){
        				
        				
        				DestBlock db=new DestBlock(25,35,bomb);
        				db.setLayoutX(bombx);
	        			db.setLayoutY(bomby);
	        	
	        			DB.add(db);
	        			root.getChildren().addAll(db);	
        			}
        			
        			
        		//-------------------------------------------------------------	
        			
        			
        			
        			//--------------------- Coin generation---------------
        			if(gamespeed==2){
        				divider1=30;
        				divider2=50;
        			}
        			else if(gamespeed==3){
        				divider1=25;
        				divider2=40;
        			}
        			else if(gamespeed==4){
        				divider1=20;
        				divider2=30;
        			}
        			else{
        				divider1=15;
        				divider2=20;
        			}
        			
        			if(count%divider1==0){
        			int coinx=20;
        			int pos=random.nextInt(4);
        			if(pos==0){
        				coinx=random.nextInt(60)+20;
        			}
        			if(pos==1){
        				coinx=random.nextInt(140)+90;
        			}
        			if(pos==2){
        				coinx=random.nextInt(210)+172;
        			}
        			if(pos==3){
        				coinx=random.nextInt(290)+252;
        			}
        			if(pos==4){
        				coinx=random.nextInt(380)+322;
        			}
        			//=random.nextInt(375)+25;
        			int coiny=-75;
        			int cf= random.nextInt(100);
        			
        			if(cf>=0&&cf<=60){
        				int coinval=random.nextInt(5)+1;
        				
        				Coin c1=new Coin(coinval,10,coinicon);
        				c1.setLayoutX(coinx);
	        			c1.setLayoutY(coiny);
	        			
	        			
	        			coinlist.add(c1);
	        			
	        			Label coinvalue=new Label(Integer.toString(coinval));
	        			coinvalue.setLayoutX(coinx-3);
	        			coinvalue.setLayoutY(coiny-5);
	        			coinvalue.setFont(Font.font("Impact",10));
	        			cL.add(coinvalue);
	        			root.getChildren().addAll(c1,coinvalue);
	        			
	        			
	        			
        			
	        			

        			}
        			}
        			
        			//---------------Wall generation---------------
        			
        			
        			
        			
        			if(count%(divider2+50)==0){
        			double wax=0;
        			
        			
        		
        			int way=-150;
        			for(int p=0;p<4;p++){
        				int wf= random.nextInt(3);
        			
        				if(wf==1||wf==2){
        					int pos1=random.nextInt(4);
                			if(pos1==0){
                				wax=80;
                			}
                			if(pos1==1){
                				wax=163;
                			}
                			if(pos1==2){
                				wax=246.5;
                			}
                			if(pos1==3){
                				wax=326;
                			}
	        				Wall w=new Wall(4,random.nextInt(100)+50, Color.GRAY);
	        				w.setArcHeight(10);
	        				w.setArcWidth(10);
	        				
	        				w.setLayoutX(wax);
		        			w.setLayoutY(way);
		        			
		        			wallarray.add(w);
		        			
		        			root.getChildren().addAll(w);
        				}
        			}
        			
        			}
        			
        			if(count%(divider2+50)==0){
	        		//---------------- BLOCK GNERATION--------------
        			
        			int f=0;
        			int val=0;
        			for(int i=0;i<5;i++){
	        			
	        			int rr=random.nextInt(2);
	        			
	        			if(rr==1){
	        				
	        			if(f==0){
	        			val=random.nextInt(Souns.get(0).length)+1;
	        			f=1;
	        			}
	        			else{
	        				val=random.nextInt(50)+1;
	        			}
	        			Brick r1=new Brick(val,78,78);
	        			
	        			String text=Integer.toString(val);
	        			
	        			Label l=new Label(text);
	        			
	        			l.setLayoutX(setx+30);
	        			l.setLayoutY(-75+26);
	        			l.setFont(Font.font("Impact",20));
	        			
	        			r1.setLayoutX(setx);
	        			r1.setLayoutY(-75);
	        			//r1.setFill(Color.BLACK);
	        			r1.setArcHeight(30);
	        			r1.setArcWidth(30);
	        			if(val%5==0){
	        				r1.setFill(Color.SALMON);
	        			}
	        			if(val%5==1){
	        				r1.setFill(Color.CRIMSON);
	        			}
	        			if(val%5==2){
	        				r1.setFill(Color.HOTPINK);
	        			}
	        			if(val%5==3){
	        				r1.setFill(Color.ORANGE);
	        			}
	        			if(val%5==4){
	        				r1.setFill(Color.STEELBLUE);
	        			}
	        			//if(count%20==0){
	        			arr.add(r1);
	        			L.add(l);
	        			
	        			root.getChildren().addAll(r1,l);
	        			
	        			}
	        				
	        			setx+=82;
	        		}
        			//-----------------------------------------------------
	        		setx=2;
        			}
        			count++;
        			}
        			
        			
	            }.start();
	            
	           
	            theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
	    			
	    			public void handle(KeyEvent e){
	    				
	    				switch(e.getCode()){
	    					
	    				case LEFT:
	    					
	    					int f=0;
	    					
	    					for(Wall w: wallarray){
	    						if(w.getBoundsInParent().getMaxY()>=Souns.get(0).getBoundsInParent().getMinY() &&w.getBoundsInParent().getMinY()-50<=Souns.get(0).getBoundsInParent().getMinY() && w.getBoundsInParent().getMaxX()<Souns.get(0).getBoundsInParent().getMinX() ){
	    							if(Souns.get(0).getBoundsInParent().getMinX()-10<w.getBoundsInParent().getMaxX()){
	    								f=1;
	    							}
	    							
	    						}
	    					}
	    					if(f==0){
	    					
	    						for(Snake S:Souns){
	    							
		        					if(S==Souns.get(0)){
		        						Len.setTranslateX(Len.getTranslateX()-7);
		        					}
		        					S.setTranslateX(S.getTranslateX()-7);
		        					
	    							//playervel.set(-200);
		        				}
	    					}
	    					else{}
	    					
	    					break;
	    				
	    				
	    				case RIGHT:
	    					
	    				int f1=0;
    					
	    				//int shift=0;
    					for(Wall w: wallarray){
    						if(w.getBoundsInParent().getMaxY()>=Souns.get(0).getBoundsInParent().getMinY() && w.getBoundsInParent().getMinY()-50<=Souns.get(0).getBoundsInParent().getMinY() && w.getBoundsInParent().getMinX()>Souns.get(0).getBoundsInParent().getMaxX() ){
    							if(Souns.get(0).getBoundsInParent().getMaxX()+10>=w.getBoundsInParent().getMinX()){
    								
     								f1=1;
    							}
    						}
    					}
    					
    					if(f1==0){
    						//playervel.set(200);
    						
    						for(Snake S:Souns){
	    						if(S==Souns.get(0)){
	        						Len.setTranslateX(Len.getTranslateX()+7);
	        					}
	        					S.setTranslateX(S.getTranslateX()+7);
	        					
	        				}
	        				
    					}
    					
    						
    					else{}
    					
    					break;
    					
	    				case D:
	    					
		    				int f2=0;
	    					
		    				
	    					for(Wall w: wallarray){
	    						if(w.getBoundsInParent().getMaxY()>=Souns2.get(0).getBoundsInParent().getMinY() && w.getBoundsInParent().getMinY()-50<=Souns2.get(0).getBoundsInParent().getMinY() && w.getBoundsInParent().getMinX()>Souns2.get(0).getBoundsInParent().getMaxX() ){
	    							if(Souns2.get(0).getBoundsInParent().getMaxX()+10>=w.getBoundsInParent().getMinX()){
	    								
	     								f2=1;
	    							}
	    						}
	    					}
	    					
	    					if(f2==0){
	    						//playervel.set(200);
	    						
	    						for(Snake S:Souns2){
		    						if(S==Souns2.get(0)){
		        						Len2.setTranslateX(Len2.getTranslateX()+7);
		        					}
		        					S.setTranslateX(S.getTranslateX()+7);
		        					
		        				}
		        				
	    					}
	    					
	    						
	    					else{}
	    					
	    					break;
	    				
	    					case A:
	    					
	    					int f3=0;
	    					
	    					for(Wall w: wallarray){
	    						if(w.getBoundsInParent().getMaxY()>=Souns2.get(0).getBoundsInParent().getMinY() &&w.getBoundsInParent().getMinY()-50<=Souns2.get(0).getBoundsInParent().getMinY() && w.getBoundsInParent().getMaxX()<Souns2.get(0).getBoundsInParent().getMinX() ){
	    							if(Souns2.get(0).getBoundsInParent().getMinX()-10<w.getBoundsInParent().getMaxX()){
	    								f3=1;
	    							}
	    							
	    						}
	    					}
	    					if(f3==0){
	    					
	    						for(Snake S:Souns2){
	    							
		        					if(S==Souns2.get(0)){
		        						Len2.setTranslateX(Len2.getTranslateX()-7);
		        					}
		        					S.setTranslateX(S.getTranslateX()-7);
		        					
	    							//playervel.set(-200);
		        				}
	    					}
	    					else{}
	    					
	    					break;
	    				
    					
						default:
							break;
	    				}	
	    			}
	    		});
	            
	            theScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
	    			
	    			public void handle(KeyEvent e){
	    				
	    				switch(e.getCode()){
	    				case LEFT:
	    					//playervel.set(0);
	    					
	    				case RIGHT:
	    					//playervel.set(0);
						default:
							break;
	    					
						
	    				}	
	    			}
	    		});
	     
	          
		thestage.show();
	}
	
	private class Brick extends Rectangle{
		int value;
		//Snake S;
		Brick(int v, int w, int h){
			super(w,h);
			value=v;
		}
		
	}
	
	
	
	private class Snake extends Circle{
		boolean dead;
		int length;
		Snake(double a, double y, int r, Color color){
			super(r,color);
			setTranslateX(a);
			setTranslateY(y);
			dead=false;
			length=4;
		}
		
		void left(){
			
			setTranslateX(getTranslateX() -20);
		}
		
		void right(){
			setTranslateX(getTranslateX() +20);
		}
	}
	
	private class Coin extends Circle{
		int value;
		
		Coin(int v, int r, ImagePattern x){
			super(r);
			value=v;
			this.setFill(x);
		}
	}
	
	private class Wall extends Rectangle{
		
		Wall(int width, int length, Color c  ){
			super(width, length);
			this.setFill(c);
		}
	}
	
	private  class DestBlock extends Rectangle{
		DestBlock(int w, int h, ImagePattern b){
			super(w,h);
			this.setFill(b);
		}
	}
	
	private class Shield extends Circle{
		Shield(int r, ImagePattern b){
			super(r);
			this.setFill(b);
		}
	}
	
	private class Magnet extends Rectangle{
		Magnet(int a,int b, ImagePattern v){
			super(a,b);
			this.setFill(v);
		}
	}
	
	public static class Leader implements Serializable{
		ArrayList<Integer> L;
		
		Leader(ArrayList<Integer>p){
			L=p;
		}
		Leader(){
			L=new ArrayList<Integer>();
			
		}
	}
	/*
	public static class Dates implements Serializable{
		ArrayList<String> S;
		
		Dates(ArrayList<String>p){
			S=p;
		}
		Dates(){
			S=new ArrayList<String>();
			
		}
	}
	
	public static void serialize(Leader L1) throws IOException{
		ObjectOutputStream out=null;
		try{
			out=new ObjectOutputStream(new FileOutputStream("Leaderboard.txt"));
			out.writeObject(L1);
		}finally{
			out.close();
		}
		
	}
	
	public static Leader deserialize(Leader L1) throws IOException, ClassNotFoundException{
		ObjectInputStream in=null;
		try{
			in=new ObjectInputStream(new FileInputStream("Leaderboard.txt"));
			L1=(Leader)in.readObject();
		}finally{
			in.close();
		}
		
		return L1;
	}
	*/
	public static void main(String[] args) {
		
		launch(args);
	}

}
