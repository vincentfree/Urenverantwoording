package nl.atos.ps.noord.testapp.urenverantwoording.controller;

import nl.atos.ps.noord.testapp.urenverantwoording.VerantwoordingsData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

/**
 * Created by nerom on 3-8-2016.
 */

@Controller
//@RestController
public class UrenController {

    VerantwoordingsData myData =null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getVerantwoordingsData(VerantwoordingsData verantwoordingsData, Model model) {
        if (myData != null) {
            verantwoordingsData = myData;
            model.addAttribute("modalData", verantwoordingsData);
            model.addAttribute("maandag", verantwoordingsData.getMaandag());
            model.addAttribute("dinsdag", verantwoordingsData.getDinsdag());
            model.addAttribute("woensdag", verantwoordingsData.getWoensdag());
            model.addAttribute("donderdag", verantwoordingsData.getDonderdag());
            model.addAttribute("vrijdag", verantwoordingsData.getVrijdag());
            model.addAttribute("zaterdag", verantwoordingsData.getZaterdag());
            model.addAttribute("zondag", verantwoordingsData.getZondag());
            model.addAttribute("name", verantwoordingsData.getName());
        } else {
            model.addAttribute("maandag", verantwoordingsData.getMaandag());
            model.addAttribute("dinsdag", verantwoordingsData.getDinsdag());
            model.addAttribute("woensdag", verantwoordingsData.getWoensdag());
            model.addAttribute("donderdag", verantwoordingsData.getDonderdag());
            model.addAttribute("vrijdag", verantwoordingsData.getVrijdag());
            model.addAttribute("zaterdag", verantwoordingsData.getZaterdag());
            model.addAttribute("zondag", verantwoordingsData.getZondag());
            model.addAttribute("name", verantwoordingsData.getName());
        }
        return "uren";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String getResultSet(Model model) {
        model.addAttribute("resultSet", myData);
        return "results";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String setVerantwoordingsData(@Valid VerantwoordingsData verantwoordingsData, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "uren";
        }

        myData = verantwoordingsData;
        model.addAttribute("maandag",verantwoordingsData.getMaandag());
        model.addAttribute("dinsdag",verantwoordingsData.getDinsdag());
        model.addAttribute("woensdag",verantwoordingsData.getWoensdag());
        model.addAttribute("donderdag",verantwoordingsData.getDonderdag());
        model.addAttribute("vrijdag",verantwoordingsData.getVrijdag());
        model.addAttribute("zaterdag",verantwoordingsData.getZaterdag());
        model.addAttribute("zondag",verantwoordingsData.getZondag());

        return "redirect:/";

        //return "result";//+verantwoordingsData.getDinsdag();
    }

}
