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
	Button btn_skritt, btn_profil, btn_kart, btn_trophy, btn_semer_skritt, btn_semer_konk_nord, btn_semer_konk_oslo, btn_pameld_trd_oslo, btn_pameld_trd_nord, btn_meldav_konk;
	Scene scn_profil, scn_skritt, scn_kart;
	static boolean anonym;
	static int skritt = 0;
	static boolean pameldt_trd_nord=false;
	static boolean pameldt_trd_oslo=false;
	@FXML
	static CheckBox anonym_checkbox;
	@FXML
	TextField antall_skritt_textfield;
	Stage window;
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage){
		try {
			Parent profil_fxml =FXMLLoader.load(getClass().getResource("FXMLprofil_zero.fxml"));
			window= primaryStage;
			window.setTitle("Fitnessapp");
			
			scn_profil = new Scene(profil_fxml,414,736);
			
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
			if(pameldt_trd_nord==true){
				stage=(Stage)btn_kart.getScene().getWindow();
				root= FXMLLoader.load(getClass().getResource("FXMLkart_alle_nord.fxml"));
			}
			else if(pameldt_trd_oslo==true){
				stage=(Stage)btn_kart.getScene().getWindow();
				root= FXMLLoader.load(getClass().getResource("FXMLkart_alle_oslo.fxml"));	
			}
			else{
			stage=(Stage) btn_kart.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLkart.fxml"));}
		}
		else if(event.getSource()==btn_trophy){
			stage= (Stage) btn_trophy.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLtrofeer.fxml"));
		}
		else if(event.getSource()==btn_semer_skritt){
			stage= (Stage) btn_semer_skritt.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLprofil_skritt_semer.fxml"));
		}
		else if(event.getSource()==btn_semer_konk_nord){
			stage= (Stage) btn_semer_konk_nord.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLprofil_konk_semer_nord.fxml"));
		}
		else if(event.getSource()==btn_semer_konk_oslo){
			stage= (Stage) btn_semer_konk_oslo.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLprofil_konk_semer_oslo.fxml"));
		}
		else if(event.getSource()==btn_pameld_trd_oslo){
			stage=(Stage)btn_pameld_trd_oslo.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLkart_alle_oslo.fxml"));
			pameldt_trd_oslo=true;
			
		}
		else if(event.getSource()==btn_pameld_trd_nord){
			stage=(Stage)btn_pameld_trd_nord.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLkart_alle_nord.fxml"));
			pameldt_trd_nord=true;
		}
		else if(event.getSource()==btn_meldav_konk){
			stage=(Stage)btn_meldav_konk.getScene().getWindow();
			root=FXMLLoader.load(getClass().getResource("FXMLprofil_zero.fxml"));
			pameldt_trd_nord=false;
			pameldt_trd_oslo=false;
		}
		else{
			if(pameldt_trd_nord==true){
				stage=(Stage)btn_profil.getScene().getWindow();
				root= FXMLLoader.load(getClass().getResource("FXMLprofil_trd_nord.fxml"));
			}
			else if(pameldt_trd_oslo==true){
				stage=(Stage)btn_profil.getScene().getWindow();
				root= FXMLLoader.load(getClass().getResource("FXMLprofil_trd_oslo.fxml"));	
			}
			else{
			stage= (Stage) btn_profil.getScene().getWindow();
			root= FXMLLoader.load(getClass().getResource("FXMLprofil_zero.fxml"));
	//		anonym_checkbox= (CheckBox) root.lookup("#anonym_checkbox");
			//anonym_checkbox = (CheckBox) root.getChildrenUnmodifiable().get(13);
//			anonym_checkbox.setSelected(anonym);
	
			}}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		System.out.println("ButtonClicked called, event: " + event.toString());
	}

	@FXML
	public void anonymToggle(ActionEvent event){
		anonym=!anonym;
	}
	
	@FXML
	public void stepRegistration(ActionEvent event){
		skritt = Integer.valueOf(antall_skritt_textfield.getText());
		System.out.println("stepRegistration called, skritt= " + skritt);
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
