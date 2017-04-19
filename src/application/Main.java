package application;
	
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	Button btn_skritt, btn_profil, btn_kart, btn_trophy;
	Scene scn_profil, scn_skritt, scn_kart;
	boolean anonym;
	@FXML
	CheckBox anonym_checkbox;
	Stage window;
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage){
		try {
			Parent profil_fxml =FXMLLoader.load(getClass().getResource("FXMLprofil.fxml"));
			//Parent skritt_fxml =FXMLLoader.load(getClass().getResource("FXMLskritt.fxml"));
		//	Parent kart_fxml =FXMLLoader.load(getClass().getResource("FXMLskritt.fxml"));
			window= primaryStage;
			window.setTitle("Fitnessapp");
			
			scn_profil = new Scene(profil_fxml,414,736);
	//		scn_skritt = new Scene(skritt_fxml,414,736);
			
			window.setScene(scn_profil);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	@FXML
	public void ButtonClicked(ActionEvent event) throws IOException{
		Stage stage;
		Parent root;
		if(event.getSource()==btn_skritt){
			stage=(Stage) btn_skritt.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLskritt.fxml"));
		}
		else if(event.getSource()==btn_kart){
			stage=(Stage) btn_kart.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLkart.fxml"));
		}
		else if(event.getSource()==btn_trophy){
			stage= (Stage) btn_trophy.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLtrofeer.fxml"));
		}
		else{
			
			stage= (Stage) btn_profil.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLprofil.fxml"));
			//anonym_checkbox= (CheckBox) root.lookup("#anonym_checkbox");
			//anonym_checkbox.setSelected(anonym);
	
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		System.out.println("ButtonClicked called, event: " + event.toString());
	}

	@FXML
	public void anonymToggle(ActionEvent event){
		anonym=!anonym;
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
