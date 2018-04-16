package com.emine.down.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yanming
 * @version 1.0.0
 * @description
 * @date 2018/04/16 11:42
 **/
@Slf4j
@RestController
@RequestMapping("/download")
public class DownLoadController {
    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public ModelAndView get()  {
        return new ModelAndView("index.html");
    }
}
