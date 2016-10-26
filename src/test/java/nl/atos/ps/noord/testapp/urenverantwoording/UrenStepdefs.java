package nl.atos.ps.noord.testapp.urenverantwoording;

import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Stel;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nerom on 16-10-2016.
 */
public class UrenStepdefs {
    WebDriver webDriver = new SharedDriver();
    private UrenPagina urenPagina = PageFactory.initElements(this.webDriver,UrenPagina.class);


    @Stel("^Ik ben ingelogd als medewerker met schaal (\\d+)$")
    public void ikBenIngelogdAlsMedewerkerMetSchaal(int schaal) {
        urenPagina.gaNaarPagina("http://localhost:8080/");
        urenPagina.vulGebruikersNaamIn("Vincent Free");
        urenPagina.vulSchaalIn(Integer.toString(schaal));
    }

    @Als("^Ik voor week (\\d+) mijn uren voor maandag t/m zondag invoer$")
    public void ikVoorWeekMijnUrenVoorMaandagTMZondagInvoer(int week) {
        urenPagina.vulWeekIn(Integer.toString(week));
        urenPagina.vulMaandagIn("8");
        urenPagina.vulDinsdagIn("8");
        urenPagina.vulWoensdagIn("8");
        urenPagina.vulDonderdagIn("8");
        urenPagina.vulVrijdagIn("8");
        urenPagina.vulZaterdagIn("0");
        urenPagina.vulZondagIn("0");
        urenPagina.clickOpIndienen();
    }

    @Dan("^Berekend het systeem de correcte lunch en overwerk vergoeding$")
    public void berekendHetSysteemDeCorrecteLunchEnOverwerkVergoeding() {
        Assert.assertTrue(urenPagina.checkMaandagWaarde("8"));
        Assert.assertTrue(urenPagina.checkDinsdagWaarde("8"));
        Assert.assertTrue(urenPagina.checkWoensdagWaarde("8"));
        Assert.assertTrue(urenPagina.checkDonderdagWaarde("8"));
        Assert.assertTrue(urenPagina.checkVrijdagWaarde("8"));
        Assert.assertTrue(urenPagina.checkZaterdagWaarde("0"));
        Assert.assertTrue(urenPagina.checkZondagWaarde("0"));
    }

    @Als("^Ik \"([^\"]*)\" uren voor maandag invul$")
    public void ikUrenVoorMaandagInvul(String maandag) {
        urenPagina.vulMaandagIn(maandag);
    }
    @En("^Ik \"([^\"]*)\" uren voor dinsdag invul$")
    public void ikUrenVoorDinsdagInvul(String dinsdag) {
        urenPagina.vulDinsdagIn(dinsdag);
    }

    @En("^Ik \"([^\"]*)\" uren voor woensdag invul$")
    public void ikUrenVoorWoensdagInvul(String woensdag) {
        urenPagina.vulWoensdagIn(woensdag);
    }

    @En("^Ik \"([^\"]*)\" uren voor donderdag invul$")
    public void ikUrenVoorDonderdagInvul(String donderdag) {
        urenPagina.vulDonderdagIn(donderdag);
    }

    @En("^Ik \"([^\"]*)\" uren voor vrijdag invul$")
    public void ikUrenVoorVrijdagInvul(String vrijdag) {
        urenPagina.vulVrijdagIn(vrijdag);
    }

    @En("^Ik \"([^\"]*)\" uren voor zaterdag invul$")
    public void ikUrenVoorZaterdagInvul(String zaterdag) {
        urenPagina.vulZaterdagIn(zaterdag);
    }

    @En("^Ik \"([^\"]*)\" uren voor zondag invul$")
    public void ikUrenVoorZondagInvul(String zondag) {
        urenPagina.vulZondagIn(zondag);
    }

    @En("^Verwacht ik dat de lunch vergoeding \"([^\"]*)\" bedraagt$")
    public void verwachtIkDatDeLunchVergoedingBedraagt(String lunch) {
        Assert.assertTrue(urenPagina.checkLunchWaarde(lunch));
    }

    @En("^De vergoeding voor het overwerken \"([^\"]*)\" bedraagt$")
    public void deVergoedingVoorHetOverwerkenBedraagt(String overwerken) {
        Assert.assertTrue(urenPagina.checkOverwerkWaarde(overwerken));
    }

    @En("^Het totale bedrag op \"([^\"]*)\" uitkomt$")
    public void hetTotaleBedragOpUitkomt(String totaal) {
        Assert.assertTrue("Uren komen niet overeen.",urenPagina.checkTotaalWaarde(totaal));
    }

    @Dan("^Dien ik het formulier in$")
    public void dienIkHetFormulierIn() {
        urenPagina.clickOpIndienen();
    }

    @En("^Ik wil voor week \"([^\"]*)\" mijn uren invullen$")
    public void ikWilVoorWeekMijnUrenInvullen(String week) {
        urenPagina.vulWeekIn(week);
    }
}
