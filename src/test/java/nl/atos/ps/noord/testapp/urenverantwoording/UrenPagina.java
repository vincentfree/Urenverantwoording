package nl.atos.ps.noord.testapp.urenverantwoording;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by nerom on 16-10-2016.
 */
public class UrenPagina {
    private final WebDriver webDriver;
    WebDriverWait wait;

    public UrenPagina(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 3);
    }
    
    @FindBy(id = "schaal")
    WebElement schaalLocatie;
    @FindBy(id = "name")
    WebElement naamLocatie;
    @FindBy(id = "weeknumber")
    WebElement weekLocatie;
    @FindBy(id = "maandag")
    WebElement maandagInvoerLocatie;
    @FindBy(id = "dinsdag")
    WebElement dinsdagInvoerLocatie;
    @FindBy(id = "woensdag")
    WebElement woensdagInvoerLocatie;
    @FindBy(id = "donderdag")
    WebElement donderdagInvoerLocatie;
    @FindBy(id = "vrijdag")
    WebElement vrijdagInvoerLocatie;
    @FindBy(id = "zaterdag")
    WebElement zaterdagInvoerLocatie;
    @FindBy(id = "zondag")
    WebElement zondagInvoerLocatie;
    @FindBy(id = "indienen")
    WebElement indienenLocatie;
    @FindBy(id = "tableMaandag")
    WebElement maandagTabelLocatie;
    @FindBy(id = "tableDinsdag")
    WebElement dinsdagTabelLocatie;
    @FindBy(id = "tableWoensdag")
    WebElement woensdagTabelLocatie;
    @FindBy(id = "tableDonderdag")
    WebElement donderdagTabelLocatie;
    @FindBy(id = "tableVrijdag")
    WebElement vrijdagTabelLocatie;
    @FindBy(id = "tableZaterdag")
    WebElement zaterdagTabelLocatie;
    @FindBy(id = "tableZondag")
    WebElement zondagTabelLocatie;
    @FindBy(id = "tableName")
    WebElement naamTabelLocatie;
    @FindBy(id = "tableWeek")
    WebElement weekTabelLocatie;
    @FindBy(id = "tableLunch")
    WebElement lunchTabelLocatie;
    @FindBy(id = "tableOverwerk")
    WebElement overwerkTabelLocatie;
    @FindBy(id = "tableTotaal")
    WebElement totaalTabelLocatie;

    public UrenPagina vulGebruikersNaamIn(String naam) {
        wait.until(ExpectedConditions.visibilityOf(naamLocatie));
        naamLocatie.clear();
        naamLocatie.sendKeys(naam);
        return this;
    }

    public UrenPagina vulSchaalIn(String schaal) {
        wait.until(ExpectedConditions.visibilityOf(schaalLocatie));
        schaalLocatie.clear();
        schaalLocatie.sendKeys(schaal);
        return this;
    }

    public UrenPagina vulWeekIn(String week) {
        wait.until(ExpectedConditions.visibilityOf(weekLocatie));
        weekLocatie.clear();
        weekLocatie.sendKeys(week);
        return this;
    }

    public UrenPagina vulMaandagIn(String maandag) {
        wait.until(ExpectedConditions.visibilityOf(maandagInvoerLocatie));
        maandagInvoerLocatie.clear();
        maandagInvoerLocatie.sendKeys(maandag);
        return this;
    }

    public UrenPagina vulDinsdagIn(String dinsdag) {
        wait.until(ExpectedConditions.visibilityOf(dinsdagInvoerLocatie));
        dinsdagInvoerLocatie.clear();
        dinsdagInvoerLocatie.sendKeys(dinsdag);
        return this;
    }

    public UrenPagina vulWoensdagIn(String woensdag) {
        wait.until(ExpectedConditions.visibilityOf(woensdagInvoerLocatie));
        woensdagInvoerLocatie.clear();
        woensdagInvoerLocatie.sendKeys(woensdag);
        return this;
    }

    public UrenPagina vulDonderdagIn(String donderdag) {
        donderdagInvoerLocatie.clear();
        donderdagInvoerLocatie.sendKeys(donderdag);
        return this;
    }

    public UrenPagina vulVrijdagIn(String vrijdag) {
        vrijdagInvoerLocatie.clear();
        vrijdagInvoerLocatie.sendKeys(vrijdag);
        return this;
    }

    public UrenPagina vulZaterdagIn(String zaterdag) {
        zaterdagInvoerLocatie.clear();
        zaterdagInvoerLocatie.sendKeys(zaterdag);
        return this;
    }

    public UrenPagina vulZondagIn(String zondag) {
        zondagInvoerLocatie.clear();
        zondagInvoerLocatie.sendKeys(zondag);
        return this;
    }

    public UrenPagina clickOpIndienen() {
        indienenLocatie.submit();
        return new UrenPagina(webDriver);
    }

    public boolean checkMaandagWaarde(String maandag) {
        return maandag.equals(maandagTabelLocatie.getText());
    }

    public boolean checkDinsdagWaarde(String dinsdag) {
        return dinsdag.equals(dinsdagTabelLocatie.getText());
    }

    public boolean checkWoensdagWaarde(String woensdag) {
        return woensdag.equals(woensdagTabelLocatie.getText());
    }

    public boolean checkDonderdagWaarde(String donderdag) {
        return donderdag.equals(donderdagTabelLocatie.getText());
    }

    public boolean checkVrijdagWaarde(String vrijdag) {
        return vrijdag.equals(vrijdagTabelLocatie.getText());
    }

    public boolean checkZaterdagWaarde(String zaterdag) {
        return zaterdag.equals(zaterdagTabelLocatie.getText());
    }

    public boolean checkZondagWaarde(String zondag) {
        return zondag.equals(zondagTabelLocatie.getText());
    }

    public boolean checkNaamWaarde(String naam) {
        return naam.equals(naamTabelLocatie.getText());
    }

    public boolean checkWeekWaarde(String week) {
        return week.equals(weekTabelLocatie.getText());
    }

    public boolean checkLunchWaarde(String lunch) {
        return lunch.equals(lunchTabelLocatie.getText());
    }

    public boolean checkOverwerkWaarde(String overwerk) {
        return overwerk.equals(overwerkTabelLocatie.getText());
    }

    public boolean checkTotaalWaarde(String totaal) {
        return totaal.equals(totaalTabelLocatie.getText());
    }

    public UrenPagina gaNaarPagina(String pagina) {
        webDriver.manage().window().maximize();
        webDriver.get(pagina);
        return this;
    }
}
