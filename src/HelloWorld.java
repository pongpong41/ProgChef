
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class HelloWorld extends Application {

	@Override
	public void start(Stage primaryStage) {
		//P.47
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		Text welcome = new Text("Welcome");
		grid.add(welcome, 0, 0, 2, 1);
		
		Label user = new Label("User Name");
		grid.add(user, 0, 1);
		TextField usert = new TextField();
		grid.add(usert, 1, 1);
		
		Label pas = new Label("Password");
		grid.add(pas, 0, 2);
		TextField past = new TextField();
		grid.add(past, 1, 2);
		
		HBox button = new HBox(10);
		button.setAlignment(Pos.BOTTOM_RIGHT);
		Button signbtn = new Button("Sign in");
		signbtn.setPrefWidth(65);
		Button exitbtn = new Button("Exit");
		exitbtn.setPrefWidth(65);
		button.getChildren().addAll(signbtn,exitbtn);
		grid.add(button, 1, 4);
		
		usert.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					usert.setText("");
				}
			}
		});
		
		signbtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signbtn.setPrefWidth(75);
			}
		});
		
		signbtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				signbtn.setPrefWidth(65);
			}
		});
		
		exitbtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				exitbtn.setPrefWidth(75);
			}
		});
		
		exitbtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				exitbtn.setPrefWidth(65);
			}
		});
		
		signbtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Welcome Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Welcome, " + usert.getText() + ".");
				alert.showAndWait();
			}
		});
		
		exitbtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				primaryStage.close();
			}
		});
		
		Scene scene = new Scene(grid,350,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Welcome");
		primaryStage.show();		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
