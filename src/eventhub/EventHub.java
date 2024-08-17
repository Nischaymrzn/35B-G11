/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eventhub;

import eventhub.controller.SignupController;
import eventhub.view.user.homePage;
import eventhub.view.Signup;
import eventhub.view.login;
import eventhub.view.user.ticketBookingPage;
public class EventHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//                Signup signup = new Signup();
//                        SignupController controller = new SignupController(signup);
               login newPage=new login();
                newPage.setVisible(true);

//        signup.setVisible(true);
    }
    
}