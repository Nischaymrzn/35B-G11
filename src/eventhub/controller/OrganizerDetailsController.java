/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventhub.controller;

import eventhub.dao.EventOperations;
import eventhub.dao.UserOperations;
import eventhub.model.EventModel;
import eventhub.model.UserModel;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class OrganizerDetailsController {
    private UserOperations eventDAO = new UserOperations();
    public ArrayList<UserModel> myEventList = new ArrayList<>();

    public OrganizerDetailsController() {

        this.myEventList = eventDAO.getAllOrganizers();
        System.out.println(myEventList);
}
}
