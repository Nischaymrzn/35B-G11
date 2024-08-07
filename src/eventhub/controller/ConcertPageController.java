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
public class ConcertPageController {
    private EventOperations eventDAO = new EventOperations();
    public ArrayList<EventModel> myEventList = new ArrayList<>();

    public ConcertPageController() {

        this.myEventList = eventDAO.getAllConcerts();
}
    
}
