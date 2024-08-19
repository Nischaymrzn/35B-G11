
package eventhub.controller;

import eventhub.dao.EventOperations;
import eventhub.dao.UserOperations;
import eventhub.model.EventModel;
import eventhub.model.UserModel;
import java.util.ArrayList;







public class UserDetailsController {
    private UserOperations eventDAO = new UserOperations();
    public ArrayList<UserModel> myEventList = new ArrayList<>();

    public UserDetailsController() {

        this.myEventList = eventDAO.getAllClients();
        
}
}