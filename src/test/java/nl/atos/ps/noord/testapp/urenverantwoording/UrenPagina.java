package nl.atos.ps.noord.testapp.urenverantwoording;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by nerom on 16-10-2016.
 */
public class UrenPagina {
    private final WebDriver webDriver;

    public UrenPagina(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //private By schaalLocatie = By.id("schaal");
    @FindBy(id = "schaal")
    WebElement schaalLocatie;
    @FindBy(id = "schaal")
    private By naamLocatie = By.id("gebruikersnaam");
    private By weekLocatie = By.id("week");
    private By maandagInvoerLocatie = By.id("maandag");
    private By dinsdagInvoerLocatie = By.id("dinsdag");
    private By woensdagInvoerLocatie = By.id("woensdag");
    private By donderdagInvoerLocatie = By.id("donderdag");
    private By vrijdagInvoerLocatie = By.id("vrijdag");
    private By zaterdagInvoerLocatie = By.id("zaterdag");
    private By zondagInvoerLocatie = By.id("zondag");
    private By indienenLocatie = By.id("Indienen");
    private By maandagTabelLocatie = By.id("tableMaandag");
    private By dinsdagTabelLocatie = By.id("tableDinsdag");
    private By woensdagTabelLocatie = By.id("tableWoensdag");
    private By donderdagTabelLocatie = By.id("tableDonderdag");
    private By vrijdagTabelLocatie = By.id("tableVrijdag");
    private By zaterdagTabelLocatie = By.id("tableZaterdag");
    private By zondagTabelLocatie = By.id("tableZondag");
    private By naamTabelLocatie = By.id("tableName");
    private By weekTabelLocatie = By.id("tableWeek");
    private By lunchTabelLocatie = By.id("tableLunch");
    private By overwerkTabelLocatie = By.id("tableOverwerk");
    private By totaalTabelLocatie = By.id("tableTotaal");

    public void vulGebruikersNaamIn(String naam) {
        webDriver.findElement(naamLocatie).sendKeys(naam);
        //return this;
    }

    public UrenPagina vulSchaalIn(String schaal) {
        schaalLocatie.sendKeys(schaal);
        return this;
    }

    public UrenPagina vulWeekIn(String week) {
        webDriver.findElement(weekLocatie).sendKeys(week);
        return this;
    }

    public UrenPagina vulMaandagIn(String maandag) {
        webDriver.findElement(maandagInvoerLocatie).sendKeys(maandag);
        return this;
    }

    public UrenPagina vulDinsdagIn(String dinsdag) {
        webDriver.findElement(dinsdagInvoerLocatie);
        return this;
    }

    public UrenPagina vulWoensdagIn(String woensdag){
        webDriver.findElement(woensdagInvoerLocatie);
        return this;
    }
    public UrenPagina vulDonderdagIn(String donderdag){
        webDriver.findElement(donderdagInvoerLocatie);
        return this;
    }
    public UrenPagina vulVrijdagIn(String vrijdag){
        webDriver.findElement(vrijdagInvoerLocatie);
        return this;
    }
    public UrenPagina vulZaterdagIn(String zaterdag){
        webDriver.findElement(zaterdagInvoerLocatie);
        return this;
    }
    public UrenPagina vulZondagIn(String zondag){
        webDriver.findElement(zondagInvoerLocatie);
        return this;
    }
    public UrenPagina clickOpIndienen(){
        webDriver.findElement(indienenLocatie).submit();
        return new UrenPagina((SharedDriver) webDriver);
    }
    public boolean checkMaandagWaarde(String maandag){
        return maandag.equals(webDriver.findElement(maandagTabelLocatie).getText());
    }
    public boolean checkDinsdagWaarde(String dinsdag){
        return dinsdag.equals(webDriver.findElement(dinsdagTabelLocatie).getText());
    }
    public boolean checkWoensdagWaarde(String woensdag){
        return woensdag.equals(webDriver.findElement(woensdagTabelLocatie).getText());
    }
    public boolean checkDonderdagWaarde(String donderdag){
        return donderdag.equals(webDriver.findElement(donderdagTabelLocatie).getText());
    }
    public boolean checkVrijdagWaarde(String vrijdag){
        return vrijdag.equals(webDriver.findElement(vrijdagTabelLocatie).getText());
    }
    public boolean checkZaterdagWaarde(String zaterdag){
        return zaterdag.equals(webDriver.findElement(zaterdagTabelLocatie).getText());
    }
    public boolean checkZondagWaarde(String zondag){
        return zondag.equals(webDriver.findElement(zondagTabelLocatie).getText());
    }
    public boolean checkNaamWaarde(String naam){
        return naam.equals(webDriver.findElement(naamTabelLocatie).getText());
    }
    public boolean checkWeekWaarde(String week){
        return week.equals(webDriver.findElement(weekTabelLocatie).getText());
    }
    public boolean checkLunchWaarde(String lunch){
        return lunch.equals(webDriver.findElement(lunchTabelLocatie).getText());
    }
    public boolean checkOverwerkWaarde(String overwerk){
        return overwerk.equals(webDriver.findElement(overwerkTabelLocatie).getText());
    }
    public boolean checkTotaalWaarde(String totaal){
        return totaal.equals(webDriver.findElement(totaalTabelLocatie).getText());
    }

    public UrenPagina gaNaarPagina(String pagina) {
        webDriver.manage().window().maximize();
        webDriver.get(pagina);
        return this;
    }
}
