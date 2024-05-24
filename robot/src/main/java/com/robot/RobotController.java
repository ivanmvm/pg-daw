package com.robot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RobotController implements Serializable {

    @FXML
    private Label robotStateLabel;

    private Robot robot = new Robot();

    @FXML
    public void moveForward() {
        robot.moveForward();
        updateRobotState();
    }

    @FXML
    public void moveBackward() {
        robot.moveBackward();
        updateRobotState();
    }

    @FXML
    public void turnLeft() {
        robot.turnLeft();
        updateRobotState();
    }

    @FXML
    public void turnRight() {
        robot.turnRight();
        updateRobotState();
    }

    private void updateRobotState() {
        robotStateLabel.setText("Estat del Robot: " + robot.getState());
    }

    public void saveState() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("robot_state.dat"))) {
            oos.writeObject(this); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadState() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("robot_state.dat"))) {
            RobotController loadedController = (RobotController) ois.readObject();
            robot = loadedController.robot; 
            updateRobotState();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}