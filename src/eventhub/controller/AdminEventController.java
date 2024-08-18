/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventhub.controller;

import eventhub.dao.EventOperations;
import eventhub.model.EventModel;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class AdminEventController {
    private EventOperations eventDAO = new EventOperations();
    public ArrayList<EventModel> myEventList = new ArrayList<>();

    public AdminEventController() {

        this.myEventList = eventDAO.getAllEvents();
}
    
}
