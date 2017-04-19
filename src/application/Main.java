package application;
	
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@FXML
	Button btn_skritt, btn_profil;
	Scene scene1, scene2;
	Stage window;
	// DatePickers need to store variables before submitting, as they are event-based
	LocalDate dato_val, sluttdato_val;
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage){
		try {
			Parent profil =FXMLLoader.load(getClass().getResource("FXMLprofil.fxml"));
			Parent skritt_fxml =FXMLLoader.load(getClass().getResource("FXMLskritt.fxml"));
			window= primaryStage;
			window.setTitle("Fitnessapp");
/*			
			AnchorPane a1 = new AnchorPane();
			a1.setPrefSize(414, 736);
			//t1.setContent(a1);

			Label skritt= new Label("Antall skritt:");
			Label km = new Label("KM:");
			Label dato= new Label("Dato");
			
			TextField skritt_input = new TextField();
			skritt_input.setPromptText("Antall");
			skritt_input.setPrefWidth(250.0);
			
			TextField km_input = new TextField();
			km_input.setPromptText("KM");
			km_input.setPrefWidth(200.0);
			//attachValidation(room_input, "^[A-Za-zæøåÆØÅ\\-]+ [0-9]+$");
			
		//	Button skritt_button_scn1 = new Button("Skritt");
			//Button kart_button_scn1 = new Button("Kart");
			//Button profil_button_scn1= new Button("Profil");
			//profil_button_scn1.setOnAction(event->ButtonClicked(event));
			
			
			
			
		    AnchorPane.setTopAnchor(skritt, 32.0);
		    AnchorPane.setLeftAnchor(skritt, 35.0);
		    AnchorPane.setTopAnchor(km, 87.0);
		    AnchorPane.setLeftAnchor(km, 50.0);
		    AnchorPane.setTopAnchor(dato, 137.0);
		    AnchorPane.setLeftAnchor(dato, 49.0);
		    AnchorPane.setTopAnchor(skritt_button_scn1, (double) 690);
		    AnchorPane.setRightAnchor(skritt_button_scn1, 322.00);
		    AnchorPane.setTopAnchor(kart_button_scn1, 690.00);
		    AnchorPane.setRightAnchor(kart_button_scn1, 175.00);
		    AnchorPane.setTopAnchor(profil_button_scn1, 690.00);
		    AnchorPane.setRightAnchor(profil_button_scn1, 60.00);
		    
		   
		    AnchorPane.setTopAnchor(skritt_input, 27.0);
		    AnchorPane.setLeftAnchor(skritt_input, 112.0);
		    AnchorPane.setTopAnchor(km_input, 82.0);
		    AnchorPane.setLeftAnchor(km_input, 112.0);
		    AnchorPane.setTopAnchor(date_input, 137.0);
		    AnchorPane.setLeftAnchor(date_input, 116.0);
		   
		    a1.getChildren().addAll(skritt, km, dato, skritt_input, km_input,  date_input,
		    		skritt_button_scn1, kart_button_scn1, profil_button_scn1);
		    
		    AnchorPane a2 = new AnchorPane();
			a2.setPrefSize(414, 736);
			TextField profil_navn = new TextField();
			profil_navn.setPromptText("Ditt navn");
			profil_navn.setPrefWidth(250.0);
		    AnchorPane.setTopAnchor(profil_navn, 27.0);
		    AnchorPane.setLeftAnchor(profil_navn, 112.0);
		    a2.getChildren().addAll(profil_navn);
		    
		    */
			scene1 = new Scene(profil,414,736);
			scene2 = new Scene(skritt_fxml,414,736);
		
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			window.setScene(scene2);
			
			//primaryStage.setScene(scene1);
			window.show();
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void ButtonClicked(ActionEvent event) throws IOException{
		Stage stage;
		Parent root;
		if(event.getSource()==btn_profil){
			stage=(Stage) btn_profil.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLprofil.fxml"));
		}
		else{
			stage= (Stage) btn_skritt.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLskritt.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		System.out.println("ButtonClicked called, event: " + event.toString());
//		if(event.getSource()==profil_button_scn1)
		//	window.setScene(scene1);
//		else
	//		window.setScene(scene1);
	}


	
	
	
	private void Button(String string) {
		// TODO Auto-generated method stub
		
	}
	private void attachValidation(TextField input, String pattern) {
		input.focusedProperty().addListener((observable, oldValue, newValue) -> {
			String text = input.getText();
			if (text.length() > 0 && !text.matches(pattern))
				markError(input);
			else
				markOk(input);
		});
	}

	private void markError(TextField room_input) {
		room_input.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
	}
	private void markOk(TextField room_input) {
		room_input.setStyle("");
	}
}
