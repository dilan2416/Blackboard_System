package lib;
public abstract class User {
    String name;
    int ID;
    String gender;

    // constructor
    User() {

    }
    // methods
    // name
    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    // ID
    void setID(int ID) {
        this.ID = ID;
    }

    int getID() {
        return this.ID;
    }

    // gender
    void setGender(String gender) {
        this.gender = gender;
    }

    String getGender() {
        return this.gender;
    }

}


