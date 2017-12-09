package com.ladislav.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;

// TODO think of making new member dialog instead of scene layout
public class NewMemberController implements Controller {

  @FXML
  Stage stage;


  @Override
  public void setStage(Stage stage) {
    this.stage = stage;
  }
}
