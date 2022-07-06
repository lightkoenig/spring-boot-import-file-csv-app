package com.project.springbootimportfilecsvapp.controller;


import com.project.springbootimportfilecsvapp.entity.Betriebsstelle;
import com.project.springbootimportfilecsvapp.repository.BetriebsstelleRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/betriebsstelle/aamp")
public class BetriebsstelleController {

    private final BetriebsstelleRepo betriebsstelleRepo;

    public BetriebsstelleController(BetriebsstelleRepo betriebsstelleRepo) {
        this.betriebsstelleRepo = betriebsstelleRepo;
    }

    @GetMapping("")
    public List<Betriebsstelle> index(){
        return betriebsstelleRepo.findAll();
    }

}
