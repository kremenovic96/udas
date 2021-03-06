package com.ladislav.controllers;

import com.ladislav.model.data.MemberDAO;
import com.ladislav.model.data.SQLAccess;
import com.ladislav.model.member.Member;
import com.ladislav.util.SceneManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MemberMgmtController implements Controller, Initializable {

  private SQLAccess dataAccess;

  @FXML
  private Stage stage;

  @FXML
  TableView<Member> membersTableView;

  @FXML TableColumn<Member, String> nameCol;
  @FXML TableColumn<Member, String> surnameCol;
  @FXML TableColumn<Member, String> cityCol;
  @FXML TableColumn<Member, String> addressCol;
  @FXML TableColumn<Member, String> phoneOneCol;
  @FXML TableColumn<Member, String> phoneTwoCol;

  public void setStage(Stage stage) {
    this.stage = stage;
  }

  public void setDao(SQLAccess dao) {
    dataAccess = dao;
  }

  public void onBackBtnClicked(ActionEvent actionEvent) throws IOException {
    SceneManager.changeScene(stage, getClass().getResource("/view/navigation.fxml"));
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    surnameCol.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
    cityCol.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
    addressCol.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
    phoneOneCol.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
    phoneTwoCol.setCellValueFactory(cellData -> cellData.getValue().phoneNumber2Property());
    membersTableView.setEditable(false);

  }

  @FXML
  public void onSearchButtonClicked(ActionEvent actionEvent) {
    ObservableList<Member> memberObservableList = null;
    try {
      System.out.println(dataAccess.getAllMembers());
      memberObservableList = FXCollections.observableArrayList(dataAccess.getAllMembers());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    membersTableView.setItems(memberObservableList);
  }
}
