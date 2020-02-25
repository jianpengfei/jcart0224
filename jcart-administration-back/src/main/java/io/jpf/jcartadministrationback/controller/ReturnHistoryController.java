package io.jpf.jcartadministrationback.controller;

import com.sun.org.apache.regexp.internal.RE;
import io.jpf.jcartadministrationback.dto.in.ReturnHistoryCreateInDTO;
import io.jpf.jcartadministrationback.dto.out.ReturnHistoryListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returnhistory")
public class ReturnHistoryController {

    @GetMapping("/getListReturnId")
    public List<ReturnHistoryListOutDTO> getListReturnId(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        return null;
    }
}
