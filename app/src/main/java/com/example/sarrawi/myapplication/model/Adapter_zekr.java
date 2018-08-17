package com.example.sarrawi.myapplication.model;

public class Adapter_zekr {
    private int ID_zekr;
    private int Name_ID;
    private String Description;
    private String hint;
    private String counter;
    private String Qat;

    public Adapter_zekr(int ID_zekr, int name_ID, String description, String hint, String counter) {
        this.ID_zekr = ID_zekr;
        Name_ID = name_ID;
        Description = description;
        this.hint = hint;
        this.counter = counter;
    }

    public Adapter_zekr(int name_ID) {
        Name_ID = name_ID;
    }

    public Adapter_zekr() {
    }

    public int getID_zekr() {
        return ID_zekr;
    }

    public void setID_zekr(int ID_zekr) {
        this.ID_zekr = ID_zekr;
    }

    public int getName_ID() {
        return Name_ID;
    }

    public void setName_ID(int name_ID) {
        Name_ID = name_ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getQat() {
        return Qat;
    }

    public void setQat(String qat) {
        Qat = qat;
    }
}
