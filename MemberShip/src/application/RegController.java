package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegController implements Initializable {
	@FXML Button btnClose,btnCancel,btnReg;
	@FXML TextField txtId,txtSnum,txtPhone,txtMajor,txtName,txtAddress;
	@FXML PasswordField txtPwd1,txtPwd2;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void btnCloseAction(Event event) {
		try {
			Stage stage = (Stage) btnClose.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("sds.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			stage.setTitle("회원관리 프로그램");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void btnCancelAction(Event event) {
		txtId.setText("");
		txtSnum.setText("");
		txtPhone.setText("");
		txtMajor.setText("");
		txtName.setText("");
		txtAddress.setText("");
		txtPwd1.setText("");
		txtPwd2.setText("");
	}
	public void btnRegAction(Event event) {
		
	}
}
