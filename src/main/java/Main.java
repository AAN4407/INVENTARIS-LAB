import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Aira Althafeliq Nurfirly - 2401439
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app_view.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 700, 600);

            primaryStage.setTitle("INVENTARIS LAB");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.setMinWidth(650);
            primaryStage.setMinHeight(550);

            primaryStage.show();

            System.out.println("Application started successfully!");

        } catch (Exception e) {
            System.err.println("Error loading application: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
