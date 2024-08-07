package eventhub.controller;

import eventhub.dao.EventOperations;
import eventhub.model.EventModel;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class OrganizerEventPageController {
    private EventOperations eventDAO = new EventOperations();
    public ArrayList<EventModel> myEventList = new ArrayList<>();

    public OrganizerEventPageController(int organizerId) {

        this.myEventList = eventDAO.getAllOrganizerEvents(organizerId);
}
    
}