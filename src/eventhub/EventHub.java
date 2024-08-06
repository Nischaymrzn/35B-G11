/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eventhub;

import eventhub.controller.SignupController;
import eventhub.view.user.homePage;
import eventhub.view.Signup;
public class EventHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Signup signup = new Signup();
                        SignupController controller = new SignupController(signup);

        signup.setVisible(true);
    }
    
}