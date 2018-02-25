package com.ladislav.controllers;

import com.ladislav.model.data.SQLAccess;
import javafx.stage.Stage;

public interface Controller {

  void setStage(Stage stage);

  void setDao(SQLAccess dao);
}
