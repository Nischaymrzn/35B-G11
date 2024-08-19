package eventhub.controller;

import eventhub.dao.EventOperations;
import eventhub.model.EventModel;
import eventhub.view.organizer.formfillup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import eventhub.view.organizer.organizerEventsPage;

public class FormFillUpController {
    private formfillup view;
    private organizerEventsPage org;
    private EventOperations eventOps;
    private organizerEventsPage eventsPage;

    public FormFillUpController(formfillup view,organizerEventsPage org) {
        this.org=org;
        
        this.view = view;
        this.eventOps = new EventOperations();

        // Set up action listeners
        this.view.getSubmitButton().addActionListener(new SubmitButtonListener());
        this.view.getUploadButton().addActionListener(new UploadButtonListener());
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                validateAndSubmitForm();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage(), "Form Submission Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class UploadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(view);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    byte[] photo = new byte[(int) file.length()];
                    FileInputStream fis = new FileInputStream(file);
                    fis.read(photo);
                    fis.close();
                    view.setPhoto(photo);
                    view.setFilename(file.getName());
                    view.getLabelForImage().setText(file.getName());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(view, "Error reading file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

   private void validateAndSubmitForm() {
    String eventName = view.getEventNameField().getText();
    String eventType = view.getEventTypeField().getText();
    String eventDate = view.getEventDateField().getText();
    String eventTime = view.getEventTimeField().getText();
    String eventLocation = view.getEventLocationField().getText(); // Added field
    String eventVenue = view.getEventVenueField().getText(); // Added field
    String eventDescription = view.getEventDesciptionField().getText();
    String ticketRate = view.getTicketRateField().getText();
    byte[] photo = view.getPhoto(); // Use the photo byte array
    int organizerId = view.getOrganizerId();

    // Perform validation
    if (eventName.isEmpty() || eventType.isEmpty() || eventDate.isEmpty() || eventTime.isEmpty() ||
        eventLocation.isEmpty() || eventVenue.isEmpty() || eventDescription.isEmpty() || ticketRate.isEmpty() || photo == null) {
        JOptionPane.showMessageDialog(view, "All fields must be filled out", "Form Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int rate = Integer.parseInt(ticketRate);

        // Create EventModel and set values
        EventModel event = new EventModel(organizerId, eventName, eventType, eventDate, eventTime, eventDescription, rate, photo, eventLocation, eventVenue);

        // Save to database
        eventOps.addEvent(event);

        // Inform user of success
        JOptionPane.showMessageDialog(view, "Event submitted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        
        view.dispose();
        org.dispose();
        organizerEventsPage newPage=new organizerEventsPage(org.user);
        newPage.setVisible(true);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(view, "Invalid ticket rate format", "Form Validation Error", JOptionPane.ERROR_MESSAGE);
    }
}
}
