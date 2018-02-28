package itp341.bhatia.shamit.polease_final_project.model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

// Represents a single user that logs in to the app
public class User implements Serializable{

    private String username;
    private String password;
    private ArrayList<Case> listOfCases = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Case> getListOfCases() {

        return listOfCases;
    }

    public void setListOfCases(ArrayList<Case> listOfCases) {
        this.listOfCases = listOfCases;
    }

    public void addCase(Case c){
        listOfCases.add(c);
        Log.d("BAAA", Integer.toString(listOfCases.size()));
        // Log.d("BAAA", Integer.toString(numCases));

    }
    public Case getCaseAtIndex(ArrayList<Case> listOfCases, int index){
        if (index >= 0 && index <= listOfCases.size()){
            return listOfCases.get(index);
        }
        else{
            return null;
        }
    }

    @Override
    public String toString() {
        return username;
    }
}
