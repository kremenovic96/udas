package com.ladislav.controllers;

import com.ladislav.util.SceneManager;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MemberMgmtController implements Controller {

  @FXML
  Stage stage;

  public void setStage(Stage stage) {
    this.stage = stage;
  }

  public void onBackBtnClicked(ActionEvent actionEvent) throws IOException {
    SceneManager.changeScene(stage, getClass().getResource("/view/navigation.fxml"));
  }
}
