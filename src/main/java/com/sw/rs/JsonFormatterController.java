package com.sw.rs;


import com.sw.service.JsonFormatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonFormatterController {

    private final JsonFormatterService jsonFormatterService;

    @Autowired
    public JsonFormatterController(JsonFormatterService jsonFormatterService){
        this.jsonFormatterService = jsonFormatterService;
    }
    @PostMapping("/format")
    public String prettyFormatJSONPost(@RequestBody String json){
        String prettyJSON = jsonFormatterService.prettyFormat(json,4);
        return prettyJSON;
    }



}
