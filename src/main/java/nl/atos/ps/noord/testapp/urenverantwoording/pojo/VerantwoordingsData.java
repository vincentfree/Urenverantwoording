package nl.atos.ps.noord.testapp.urenverantwoording.pojo;

import javax.validation.constraints.*;

/**
 * Created by Vincent Free on 3-8-2016.
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
    private int lunch;
    private int overwerken;


    //@NotNull
    @Size(min=2, max=30)
    private String name;

    //@NotNull
    @DecimalMin("1")
    @DecimalMax("52")
    private int weeknumber;

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

    public int getWeeknumber() {
        return weeknumber;
    }

    public void setWeeknumber(int weeknumber) {
        this.weeknumber = weeknumber;
    }

    public int getLunch() {
        return lunch;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    public int getOverwerken() {
        return overwerken;
    }

    public void setOverwerken(int overwerken) {
        this.overwerken = overwerken;
    }
}
