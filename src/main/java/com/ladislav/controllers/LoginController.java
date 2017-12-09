package com.ladislav.controllers;

import com.ladislav.model.data.SQLAccess;
import com.ladislav.util.SceneManager;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Controller {

  SQLAccess sqlAccess;

  @FXML
  Stage stage;
  @FXML
  TextField userNameText;
  @FXML
  PasswordField passwordField;

  public void showLoginErrorDialog(String message) {
    //TODO implement me
  }

  public void setStage(Stage previousStage) {
    this.stage = previousStage;
  }

  @FXML
  public void onLoginBtnClicked() {

    String username = userNameText.getText();
    String password = passwordField.getText();

    // TODO connect to DB and get SQL access object here?

    try {
      SceneManager.changeScene(stage, getClass().getResource("/view/navigation.fxml"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
