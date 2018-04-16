package com.emine.down.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author yanming
 * @version 1.0.0
 * @description
 * @date 2018/04/16 11:42
 **/
@Slf4j
@RestController
@RequestMapping("/download")
public class DownLoadService {
    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> get(@RequestParam String counterId, @RequestParam String date) throws UnsupportedEncodingException {
        log.info("开始下载"+counterId+"----"+date);

        String aa = "fafa";
        String filename = "major-"+counterId+"-"+date+".txt";

        String fileName = new String(filename.getBytes("utf-8"),"iso-8859-1");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+fileName);

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(aa.getBytes().length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(new ByteArrayInputStream(aa.getBytes())));
    }
}
