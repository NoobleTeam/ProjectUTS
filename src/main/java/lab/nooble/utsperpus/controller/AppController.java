/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.nooble.utsperpus.controller;

import lab.nooble.utsperpus.entity.Perpus;
import lab.nooble.utsperpus.repo.PerpusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Toshiba
 */
@Controller
public class AppController {
    @Autowired
    private PerpusRepo perpusRepo;
    
    @RequestMapping("/")
    public String listbuku(Model model){
    model.addAttribute("listbuku", perpusRepo.findAll());
    return "listbuku";
    }
    
    @RequestMapping(value ="/tambah", method = RequestMethod.GET)
    public void addData(@ModelAttribute("prps") Perpus prps, BindingResult bind){}
    
    @RequestMapping(value = "/tambah", method = RequestMethod.POST)
    public String addDataProcessing(@ModelAttribute("prps") Perpus prps, BindingResult bind){
        System.out.println(prps.getId_buku());
        System.out.println(prps.getJudul_buku());
        System.out.println(prps.getPenulis());
        // proses simpan data
        perpusRepo.save(prps);
        return "redirect:/";
    }
    @RequestMapping("/hapus")
    public String hapusData(@RequestParam("id_buku") String id_buku){
        perpusRepo.delete(id_buku);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public void geteditdata(@RequestParam("id_buku") String id_buku, Model model){
        Perpus data = perpusRepo.findOne(id_buku);
        model.addAttribute("prps", data);
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveeditdata(@ModelAttribute("prps") Perpus prps, BindingResult result){
        System.out.println("id_buku : " + prps.getId_buku());
        System.out.println("judul_buku : " + prps.getJudul_buku());
        System.out.println("penulis : " + prps.getPenulis());
        perpusRepo.save(prps);
        return "redirect:/";
    }
}
