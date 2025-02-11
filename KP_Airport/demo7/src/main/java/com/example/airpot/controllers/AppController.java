package com.example.airpot.controllers;

import java.security.Principal;
import java.util.List;

import com.example.airpot.models.airport1;
import com.example.airpot.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/airports")
public class AppController {
    @Autowired
    private AirportService server;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String vieHomePage(Model model, @RequestParam(name = "keyword", required = false) String keyword, Principal principal) {
        System.out.println("Keyword: " + keyword);
        List<airport1> listAirports = server.listAll(keyword);
        model.addAttribute("listAirports", listAirports);
        model.addAttribute("keyword", keyword);
        model.addAttribute("user", server.getUserByPrincipal(principal));
        return "index";

    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewAirpotForm(Model model) {
        airport1 airport1 = new airport1();
        model.addAttribute("Airpot1", airport1);
        return "new_airport";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAirpot(@ModelAttribute("Airpot1") airport1 airport1) {
        server.save(airport1);
        return "redirect:/airports/";
    }

    @RequestMapping(value = "/edit/{AirportID}", method = RequestMethod.GET)
    public ModelAndView showEditAirpotForm(@PathVariable(name = "AirportID") Long AirportID) {
        ModelAndView mav = new ModelAndView("edit_Airpot");
        airport1 airport1 = server.get(AirportID);
        mav.addObject("Airpot1", airport1);
        return mav;
    }

    @RequestMapping(value = "/delete/{AirportID}", method = RequestMethod.GET)
    public String daleteAirpot1(@PathVariable(name = "AirportID") Long AirportID) {
        server.delete(AirportID);
        return "redirect:/airports/";
    }
}
