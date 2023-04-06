package dominio;

public class Persona {
    private int idPerson;
    private String namePerson;
    private String surnamePerson;
    private int yearsPerson;
    private String emailPerson;

    public Persona() {
    }

    public Persona(int idPerson) {
        this.idPerson = idPerson;
    }

    public Persona(int idPerson, String namePerson, String surnamePerson, int yearsPerson, String emailPerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.surnamePerson = surnamePerson;
        this.yearsPerson = yearsPerson;
        this.emailPerson = emailPerson;
    }
    
    
    public Persona(String namePerson, String surnamePerson, int yearsPerson, String emailPerson) {
        this.namePerson = namePerson;
        this.surnamePerson = surnamePerson;
        this.yearsPerson = yearsPerson;
        this.emailPerson = emailPerson;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getSurnamePerson() {
        return surnamePerson;
    }

    public void setSurnamePerson(String surnamePerson) {
        this.surnamePerson = surnamePerson;
    }

    public int getYearsPerson() {
        return yearsPerson;
    }

    public void setYearsPerson(int yearsPerson) {
        this.yearsPerson = yearsPerson;
    }

    public String getEmailPerson() {
        return emailPerson;
    }

    public void setEmailPerson(String emailPerson) {
        this.emailPerson = emailPerson;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPerson=" + idPerson + ", namePerson=" + namePerson + ", surnamePerson=" + surnamePerson + ", yearsPerson=" + yearsPerson + ", emailPerson=" + emailPerson + '}';
    }
    
    
}
