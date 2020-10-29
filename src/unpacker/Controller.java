package unpacker;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {
	Parent root;
	@FXML
	private Label lblStatus;

	@FXML
	private TextField txtUserName;

	@FXML
	private TextField txtPassword;

	@FXML
	private Button loginBtn;
	
	@FXML
	private Button registerBtn;
	
	public void Login(ActionEvent event) throws Exception {
		
		loginBtn.setOnAction((ActionEvent e) -> {
		
				lblStatus.setStyle("-fx-text-fill: #008000");
				lblStatus.setText("Login Success");
				Stage primaryStage = new Stage();
//				try {
//					//root = FXMLLoader.load(getClass().getResource("/unpacker/Unpack.fxml"));
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				TableView tableView = new TableView();

			    TableColumn<Person, String> column1 = new TableColumn<>("First Name");
			    column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));


			    TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
			    column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));


			    tableView.getColumns().add(column1);
			    tableView.getColumns().add(column2);

			    tableView.getItems().add(new Person("John", "Doe"));
			    tableView.getItems().add(new Person("Jane", "Deer"));

			    VBox vbox = new VBox(tableView);

			    Scene scene = new Scene(vbox);

			    primaryStage.setScene(scene);

			    primaryStage.show();
			    
			    //System.out.println(Reader.getJson());
			    
//				if (txtUserName.getText().matches(
//						"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
//						&& txtPassword.getText().matches(
//								"(?=.*[a-z].*[a-z])(?=.*[A-Z].*[A-Z])(?=.*[0-9].*[0-9])(?=.*(?=.*[$&+,:;=?@#|'<>.^*()%!-]))^.*")) {
//			} else {
//				lblStatus.setStyle("-fx-text-fill: #FF0000");
//				lblStatus.setText("Login Failed");
//			}
		});
	}
	
	public void Register(ActionEvent event) throws Exception {
		
		registerBtn.setOnAction((ActionEvent e) -> {
			if (txtUserName.getText().length() > 3) {
				if (txtPassword.getText().length() > 3) {
					
				}
			}
		});
	}
		
}
