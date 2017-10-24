package com.example.myapplication;

/**
 * Created by Admin on 10/23/2017.
 */

public class AnimeCharacter {

    String Name;
    String Show;
    String CatchPhase;

    public AnimeCharacter(String name, String show, String catchPhase) {
        this.Name = name;
        this.Show = show;
        this.CatchPhase = catchPhase;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getShow() {
        return Show;
    }

    public void setShow(String show) {
        Show = show;
    }

    public String getCatchPhase() {
        return CatchPhase;
    }

    public void setCatchPhase(String catchPhase) {
        CatchPhase = catchPhase;
    }
}
