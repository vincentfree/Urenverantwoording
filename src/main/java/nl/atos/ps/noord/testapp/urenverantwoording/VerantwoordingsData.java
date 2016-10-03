package nl.atos.ps.noord.testapp.urenverantwoording;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by nerom on 3-8-2016.
 */
public class VerantwoordingsData {

    @NotNull
    private int maandag;
    @NotNull
    private int dinsdag;
    @NotNull
    private int woensdag;
    @NotNull
    private int donderdag;
    @NotNull
    private int vrijdag;

    private int zaterdag;
    private int zondag;

    //@NotNull
    @Size(min=2, max=30)
    private String name;

    public VerantwoordingsData() {}

    /*public VerantwoordingsData(int maandag, int dinsdag, int woensdag, int donderdag, int vrijdag, int zaterdag, int zondag) {
        this.maandag = maandag;
        this.dinsdag = dinsdag;
        this.woensdag = woensdag;
        this.donderdag = donderdag;
        this.vrijdag = vrijdag;
        this.zaterdag = zaterdag;
        this.zondag = zondag;
    }*/

    public int getMaandag() {
        return maandag;
    }

    public void setMaandag(int maandag) {
        this.maandag = maandag;
    }

    public int getDinsdag() {
        return dinsdag;
    }

    public void setDinsdag(int dinsdag) {
        this.dinsdag = dinsdag;
    }

    public int getWoensdag() {
        return woensdag;
    }

    public void setWoensdag(int woensdag) {
        this.woensdag = woensdag;
    }

    public int getDonderdag() {
        return donderdag;
    }

    public void setDonderdag(int donderdag) {
        this.donderdag = donderdag;
    }

    public int getVrijdag() {
        return vrijdag;
    }

    public void setVrijdag(int vrijdag) {
        this.vrijdag = vrijdag;
    }

    public int getZaterdag() {
        return zaterdag;
    }

    public void setZaterdag(int zaterdag) {
        this.zaterdag = zaterdag;
    }

    public int getZondag() {
        return zondag;
    }

    public void setZondag(int zondag) {
        this.zondag = zondag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
