package ehu.isad;

import ehu.isad.controllers.ui.NagKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent root;
  private Stage stage;
  private NagKud nagkud;

  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;
    loadUI();

    stage.setTitle("Azterketa");
    stage.setScene(new Scene(root,1208,400));
    stage.show();
  }

  private void loadUI() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/proba.fxml"));
    root = loader.load();
    nagkud = loader.getController();
  }

  private void stageSetup(){
    stage.setScene(new Scene(root));
    stage.setTitle("Azterketa");
    stage.getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));
    stage.setResizable(false);
  }


  public static void main(String[] args) {
    launch(args);
  }
}
