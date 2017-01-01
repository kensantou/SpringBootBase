package com.santy.controller;

import com.santy.model.mydata.MyDataService;
import com.santy.model.mydata.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    MyDataService myDataService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<MyData> myDataList = myDataService.findAll();
        model.addAttribute("msg", myDataList.get(0));
        return "index";
    }


}
