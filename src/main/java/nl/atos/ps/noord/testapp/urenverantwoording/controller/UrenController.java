package nl.atos.ps.noord.testapp.urenverantwoording.controller;

import nl.atos.ps.noord.testapp.urenverantwoording.pojo.VerantwoordingsData;
import nl.atos.ps.noord.testapp.urenverantwoording.pojo.WeeklyExtras;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vincent Free on 3-8-2016.
 */

@Controller
//@RestController
public class UrenController {

    VerantwoordingsData myData = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getVerantwoordingsData(VerantwoordingsData verantwoordingsData, BindingResult bindingResult, Model model) {
        Map<String, Integer> week = new HashMap<>();
        WeeklyExtras extras = new WeeklyExtras();
        if (myData != null) {
            weekMap(week, myData);
            verantwoordingsData = myData;
            week.forEach(model::addAttribute);
            week.forEach((k, v) -> extras.addUpLunchMoney(calculateLunchValue(v)));
            week.forEach((k, v) -> extras.addUpOverWorkHours(overWorkHours(v)));
            extras.setExidedHours(exidedHours(week));
            model.addAttribute("modalData", verantwoordingsData);
            model.addAttribute("verantwoordingsData", verantwoordingsData);
            model.addAttribute("name", verantwoordingsData.getName());
            model.addAttribute("weeknumber", verantwoordingsData.getWeeknumber());
            model.addAttribute("lunch", extras.getLunchMoney());
            model.addAttribute("overwerken", extras.getOverWorkHours());
            //TODO weekend uren toevoegen aan vergoeding
            model.addAttribute("totaal", (extras.overworkCosts() + extras.getLunchMoney()));

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

    private int exidedHours(Map<String, Integer> map) {
        final Integer[] total = {0};
        int result = 0;
        map.forEach((k, v) -> {
            total[0] += total[0] + v;
        });
        if (total[0] > 40) {
            result = (total[0] - 40);
        }
        return result;
    }

    private void weekMap(Map<String, Integer> map, VerantwoordingsData data) {
        map.put("maandag", data.getMaandag());
        map.put("dinsdag", data.getDinsdag());
        map.put("woensdag", data.getWoensdag());
        map.put("donderdag", data.getDonderdag());
        map.put("vrijdag", data.getVrijdag());
        map.put("zaterdag", data.getZaterdag());
        map.put("zondag", data.getZondag());
    }


}
