package nl.atos.ps.noord.testapp.urenverantwoording.controller;

import nl.atos.ps.noord.testapp.urenverantwoording.VerantwoordingsData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;

/**
 * Created by Vincent Free on 3-8-2016.
 */

@Controller
//@RestController
public class UrenController {

    VerantwoordingsData myData = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getVerantwoordingsData(VerantwoordingsData verantwoordingsData, BindingResult bindingResult, Model model) {

        int lunchMoney = 0;
        int overWorkHours = 0;

        if (myData != null) {
            verantwoordingsData = myData;
            model.addAttribute("modalData", verantwoordingsData);
            model.addAttribute("verantwoordingsData", verantwoordingsData);
            model.addAttribute("maandag", verantwoordingsData.getMaandag());
            lunchMoney += calculateLunchValue(verantwoordingsData.getMaandag());
            overWorkHours += overWorkHours(verantwoordingsData.getMaandag());
            model.addAttribute("dinsdag", verantwoordingsData.getDinsdag());
            lunchMoney += calculateLunchValue(verantwoordingsData.getDinsdag());
            overWorkHours += overWorkHours(verantwoordingsData.getDinsdag());
            model.addAttribute("woensdag", verantwoordingsData.getWoensdag());
            lunchMoney += calculateLunchValue(verantwoordingsData.getWoensdag());
            overWorkHours += overWorkHours(verantwoordingsData.getWoensdag());
            model.addAttribute("donderdag", verantwoordingsData.getDonderdag());
            lunchMoney += calculateLunchValue(verantwoordingsData.getDonderdag());
            overWorkHours += overWorkHours(verantwoordingsData.getDonderdag());
            model.addAttribute("vrijdag", verantwoordingsData.getVrijdag());
            lunchMoney += calculateLunchValue(verantwoordingsData.getVrijdag());
            overWorkHours += overWorkHours(verantwoordingsData.getVrijdag());
            model.addAttribute("zaterdag", verantwoordingsData.getZaterdag());
            lunchMoney += calculateLunchValue(verantwoordingsData.getZaterdag());
            overWorkHours += overWorkHours(verantwoordingsData.getZaterdag());
            model.addAttribute("zondag", verantwoordingsData.getZondag());
            lunchMoney += calculateLunchValue(verantwoordingsData.getZondag());
            overWorkHours += overWorkHours(verantwoordingsData.getZondag());
            myData.setLunch(lunchMoney);
            model.addAttribute("name", verantwoordingsData.getName());
            model.addAttribute("weeknumber", verantwoordingsData.getWeeknumber());
            model.addAttribute("lunch", lunchMoney);
            model.addAttribute("overwerken", overWorkHours);

        } else {
            model.addAttribute("maandag", verantwoordingsData.getMaandag());
            model.addAttribute("dinsdag", verantwoordingsData.getDinsdag());
            model.addAttribute("woensdag", verantwoordingsData.getWoensdag());
            model.addAttribute("donderdag", verantwoordingsData.getDonderdag());
            model.addAttribute("vrijdag", verantwoordingsData.getVrijdag());
            model.addAttribute("zaterdag", verantwoordingsData.getZaterdag());
            model.addAttribute("zondag", verantwoordingsData.getZondag());
            model.addAttribute("name", verantwoordingsData.getName());
            model.addAttribute("weeknumber", verantwoordingsData.getWeeknumber());
        }
        return "uren";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String getResultSet(Model model) {
        model.addAttribute("resultSet", myData);
        return "results";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String setVerantwoordingsData(@Valid VerantwoordingsData verantwoordingsData, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "uren";
        }

        myData = verantwoordingsData;
        model.addAttribute("maandag", verantwoordingsData.getMaandag());
        model.addAttribute("dinsdag", verantwoordingsData.getDinsdag());
        model.addAttribute("woensdag", verantwoordingsData.getWoensdag());
        model.addAttribute("donderdag", verantwoordingsData.getDonderdag());
        model.addAttribute("vrijdag", verantwoordingsData.getVrijdag());
        model.addAttribute("zaterdag", verantwoordingsData.getZaterdag());
        model.addAttribute("zondag", verantwoordingsData.getZondag());
        model.addAttribute("name", verantwoordingsData.getName());
        model.addAttribute("weeknumber", verantwoordingsData.getWeeknumber());

        return "redirect:/";

        //return "result";//+verantwoordingsData.getDinsdag();
    }

    private int calculateLunchValue(int value) {
        if (value >= 12) {
            return 15;
        }
        return 0;
    }

    private int overWorkHours(int value) {
        if (value > 8) {
            return (value - 8);
        }
        return 0;
    }
}
