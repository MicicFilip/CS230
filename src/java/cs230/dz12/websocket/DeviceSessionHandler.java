/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz12.websocket;

import cs230.dz12.model.Student;
import java.io.IOException;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;

/**
 *
 * @author Filip
 */
@ApplicationScoped
public class DeviceSessionHandler {

    private int studentId = 0;
    private final Set<Session> sessions = new HashSet<>();
    private final Set<Student> students = new HashSet<>();

    public void addSession(Session session) {
        sessions.add(session);
        for (Student student : students) {
            JsonObject addMessage = createAddMessage(student);
            sendToSession(session, addMessage);
        }
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public List<Student> getDevices() {
        return new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        student.setId(studentId);
        students.add(student);
        studentId++;
        JsonObject addMessage = createAddMessage(student);
        sendToAllConnectedSessions(addMessage);
    }

    public void removeStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            students.remove(student);
            JsonProvider provider = JsonProvider.provider();
            JsonObject removeMessage = provider.createObjectBuilder()
                    .add("action", "remove")
                    .add("id", id)
                    .build();
            sendToAllConnectedSessions(removeMessage);
        }

    }

    public void toggleStudent(int id) {
        JsonProvider provider = JsonProvider.provider();
        Student student = getStudentById(id);
        if (student != null) {
            if ("On".equals(student.getStatus())) {
                student.setStatus("Off");
            } else {
                student.setStatus("On");
            }
            JsonObject updateDevMessage = provider.createObjectBuilder()
                    .add("action", "toggle")
                    .add("id", student.getId())
                    .add("status", student.getStatus())
                    .build();
            sendToAllConnectedSessions(updateDevMessage);
        }
    }

    private Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private JsonObject createAddMessage(Student student) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject addMessage = provider.createObjectBuilder()
                .add("action", "add")
                .add("id", student.getId())
                .add("ime", student.getIme())
                .add("prezime", student.getPrezime())
                .add("fakultet", student.getFakultet())
                .add("status", student.getStatus())
                .build();
        return addMessage;

    }

    private void sendToAllConnectedSessions(JsonObject message) {
        for (Session session : sessions) {
            sendToSession(session, message);
        }
    }

    private void sendToSession(Session session, JsonObject message) {
        try {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException ex) {
            sessions.remove(session);
            Logger.getLogger(DeviceSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
