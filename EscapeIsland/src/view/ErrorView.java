/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import escapeIsland.EscapeIsland;
import java.io.PrintWriter;

/**
 *
 * @author Austi
 */
public class ErrorView {

    private static PrintWriter console = EscapeIsland.getOutput();
    private static PrintWriter log = EscapeIsland.getLogFile();

public static void display(String className, String errorMessage) {

        console.println(
                "\n--- ERROR ---------------------------------"
              + "\n" + errorMessage
              + "\n-------------------------------------------");

        log.printf("%n%n%s", className + " - " + errorMessage);
    }
}
