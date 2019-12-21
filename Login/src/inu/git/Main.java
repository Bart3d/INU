package inu.git;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;

public class Main extends Application {
	
	private String[] system = new String[] {"Produkcyjne", "Testowe", "Deweloperskie"};
	private String[] users = new String[] {"adam.nowak", "ewa.cudna", "jan.kowalski"};

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
//		borderPane.setBorder(new Border(new BorderStroke(
//				Color.DODGERBLUE,
//				BorderStrokeStyle.SOLID,
//				CornerRadii.EMPTY,
//				new BorderWidths(5))));
		
		FlowPane topInfo = new FlowPane();
		GridPane centerGrid = new GridPane();
		HBox bottomButtons = new HBox();
		
		Label title = new Label("Logowanie do systemu......");
		topInfo.setPadding(new Insets(30, 10, 30, 10));
		
		topInfo.getChildren().add(title);
		
		Separator sep = new Separator(Orientation.HORIZONTAL);
		VBox topBox = new VBox(topInfo, sep);
		
//		borderPane.setTop(topInfo);
		borderPane.setTop(topBox);
		
		
		
		centerGrid.setHgap(30);
		centerGrid.setVgap(10);
		centerGrid.setPadding(new Insets(10, 10, 10, 20));
		
		Label environment = new Label("Œrodowisko:");
		Label user = new Label("U¿ytkownik:");
		Label password = new Label("Has³o:");
		
		ChoiceBox<String> environmentBox = new ChoiceBox<>();
		environmentBox.setPrefWidth(150);
		environmentBox.getItems().addAll(system);
		
		ComboBox<String> userBox = new ComboBox<>();
		userBox.setPrefWidth(150);
		userBox.getItems().addAll(users);
		userBox.setEditable(true);
		
		PasswordField passwordField = new PasswordField();
		passwordField.setPrefWidth(150);
		
		
		centerGrid.add(environment, 0, 0);
		centerGrid.add(user, 0, 1);
		centerGrid.add(password, 0, 2);

		centerGrid.add(environmentBox, 1, 0);
		centerGrid.add(userBox, 1, 1);
		centerGrid.add(passwordField, 1, 2);
		
		borderPane.setCenter(centerGrid);
		
		Button btn1 = new Button("Login");
		Button btn2 = new Button("Anuluj");
		btn1.setPadding(new Insets(5, 10, 5, 10));
		btn2.setPadding(new Insets(5, 10, 5, 10));
		
		bottomButtons.setSpacing(10);
		bottomButtons.setPadding(new Insets(0, 20, 10, 20)); 
		bottomButtons.getChildren().addAll(btn1, btn2);
		
		borderPane.setBottom(bottomButtons);
	    
	    // Alignment.		
//	    BorderPane.setAlignment(btn1, Pos.TOP_RIGHT);
	    BorderPane.setMargin(bottomButtons, new Insets(10, 10, 10, 10));
		bottomButtons.setAlignment(Pos.CENTER_RIGHT);

		

		Scene scene = new Scene(borderPane, 300, 300);
		scene.setOnMouseClicked(e -> stage_Clicked(e, borderPane));
		primaryStage.setScene(scene);
		primaryStage.setTitle("                                       Logowanie");
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UTILITY);	// remove maximize and minimize buttons
		primaryStage.show();

	}

	int i = 0;

	public void stage_Clicked(MouseEvent e, BorderPane borderPane) {

	}
}
