package com.ladislav.controllers;

import com.ladislav.model.data.SQLAccess;
import javafx.fxml.FXML;
import javafx.stage.Stage;

// TODO think of making new member dialog instead of scene
public class NewMemberController implements Controller {

  @FXML
  Stage stage;

  SQLAccess dataAccess;

  @Override
  public void setStage(Stage stage) {
    this.stage = stage;
  }

  @Override
  public void setDao(SQLAccess dao) {
    dataAccess = dao;
  }
}
