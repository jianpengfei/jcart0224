package io.jpf.jcartadministrationback.controller;

import io.jpf.jcartadministrationback.dto.in.AdministratorLoginDTO;
import io.jpf.jcartadministrationback.dto.in.AdministratorUpdateProfileInDTO;
import io.jpf.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/login")
    public String login(AdministratorLoginDTO AdministratorLoginDTO){

        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(Integer administratorId){
        return null;
    }

    @PostMapping("/updateProdfile")
    public void updateProdfile(@RequestParam AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){


    }
}
