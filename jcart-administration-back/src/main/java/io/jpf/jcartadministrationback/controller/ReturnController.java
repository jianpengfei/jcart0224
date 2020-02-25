package io.jpf.jcartadministrationback.controller;

import io.jpf.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.jpf.jcartadministrationback.dto.in.ReturnUpdateInDTO;
import io.jpf.jcartadministrationback.dto.out.PageOutDTO;
import io.jpf.jcartadministrationback.dto.out.ReturnListOutDTO;
import io.jpf.jcartadministrationback.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {


    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                               @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnsId){
        return null;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateInDTO returnUpdateInDTO){
    }


}
