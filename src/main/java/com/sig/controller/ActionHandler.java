package com.sig.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Save File":
                System.out.println("Save File");
                break;
            case "Load File":
                System.out.println("Load File");
                break;
            case "Exit":
                System.out.println("Exit Program");
                System.exit(0);
                break;
            case "New Invoice":
                System.out.println("New Invoice");
                break;
            case "Delete Invoice":
                System.out.println("Delete Invoice");
                break;
            case "New Item":
                System.out.println("New Item");
                break;
            case "Delete Item":
                System.out.println("Delete Item");
                break;
            default:
                System.out.println("Action!!!");
        }
    }

}
