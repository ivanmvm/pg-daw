package com.robot;

import java.io.Serializable;

public class Robot implements Serializable {
    private int x;
    private int y;
    private String direction;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.direction = "Nord";
    }

    public void moveForward() {
        if (direction.equals("Nord")) y++;
        else if (direction.equals("Sud")) y--;
        else if (direction.equals("Est")) x++;
        else if (direction.equals("Oest")) x--;
    }

    public void moveBackward() {
        if (direction.equals("Nord")) y--;
        else if (direction.equals("Sud")) y++;
        else if (direction.equals("Est")) x--;
        else if (direction.equals("Oest")) x++;
    }

    public void turnLeft() {
        switch (direction) {
            case "Nord": direction = "Oest"; break;
            case "Sud": direction = "Est"; break;
            case "Est": direction = "Nord"; break;
            case "Oest": direction = "Sud"; break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case "Nord": direction = "Est"; break;
            case "Sud": direction = "Oest"; break;
            case "Est": direction = "Sud"; break;
            case "Oest": direction = "Nord"; break;
        }
    }

    public String getState() {
        return "(" + x + ", " + y + ") Direcció: " + direction;
    }
}