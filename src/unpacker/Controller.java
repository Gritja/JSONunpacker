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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
			
			if (Users.loginUser(txtUserName.getText(), txtPassword.getText()))
			{
				lblStatus.setStyle("-fx-text-fill: #008000");
				lblStatus.setText("Login Success");
				Stage primaryStage = new Stage();
//				try {
//					//root = FXMLLoader.load(getClass().getResource("/unpacker/Unpack.fxml"));
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				Reader r = new Reader ();
				Unpacker u = new Unpacker ();

				TreeView treeView = new TreeView();
				
				TreeItem root = new TreeItem("Root");
				treeView.setRoot(root);
				u.Unpack(r, root);
				
			    VBox vbox = new VBox(treeView);

			    Scene scene = new Scene(vbox);

			    primaryStage.setScene(scene);

			    primaryStage.show();
			}
			    
			    //System.out.println(Reader.getJson());
			    
			    //kolla igenom arraylis(users) efter txtUserName.getText.matches och sedan om password.getText.matches?
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
					if (txtUserName.getText().matches(
							"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
							Users.addUser(txtUserName.getText(), txtPassword.getText());
					} else {
						//Invalid email prompt!
						System.out.println("Invalid email adress.");
					}
					//gå igenom listan, lägg till användaren, sedan add.arraylist(users?) > uppdatera, write to file? borde funka skitbra!
				}
			}
		});
	}
		
}
