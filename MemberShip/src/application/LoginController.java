package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	@FXML TextField txtId;
	@FXML PasswordField txtPwd;
	@FXML Button btnLogin, btnReg, btnCancel, btnClose;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void btnLoginAction(ActionEvent event) {
		DBconnection connDB = new DBconnection();
		Connection conn = connDB.getConnection();
		
		try {
            String sql = "select COUNT(*) from smember";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getInt(1) > 0) {
                    System.out.println("DB OK");
                } else {
                    System.out.println("DB..");
                }
            }

            stmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB Conn Error");
        }
	}
	public void btnCancelAction(ActionEvent event) {
		txtId.setText("");
		txtPwd.setText("");
	}
	public void btnRegAction(ActionEvent event) {
		try {
			Stage stage = (Stage) btnClose.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("sdsd.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			stage.setTitle("회원관리 프로그램");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void btnCloseAction(ActionEvent event) {
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
	}
	
}
