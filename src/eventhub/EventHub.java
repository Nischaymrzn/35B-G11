/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eventhub;

import eventhub.controller.DatabaseConnection;
import eventhub.view.Login;

public class EventHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        Login ss= new Login();
        ss.setVisible(true);
    }
    
}
