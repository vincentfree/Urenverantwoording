package nl.atos.ps.noord.testapp.urenverantwoording.pojo;

/**
 * Created by nerom on 4-10-2016.
 */
public class WeeklyExtras {

    private int lunchMoney = 0;
    private int overWorkHours = 0;
    private int exidedHours = 0;

    public int getLunchMoney() {
        return lunchMoney;
    }

    public void setLunchMoney(int lunchMoney) {
        this.lunchMoney = lunchMoney;
    }

    public void addUpLunchMoney(int addition) {
        this.lunchMoney += addition;
    }

    public int getOverWorkHours() {
        if (overWorkHours>40)
        return overWorkHours-40;
        else return 0;
    }

    public void setOverWorkHours(int overWorkHours) {
        this.overWorkHours = overWorkHours;
    }

    public void addUpOverWorkHours(int addition) {
        this.overWorkHours += addition;
    }

    public int getExidedHours() {
        return exidedHours;
    }

    public void setExidedHours(int exidedHours) {
        this.exidedHours = exidedHours;
    }

    public int overworkCosts() {
        return (getHoursAboveQuota() * 30);
    }

    /**
     *
     * @return
     */
    public int getHoursAboveQuota() {
        if (exidedHours > 5) {
            return exidedHours - 5;
        } else {
            return 0;
        }
    }
}