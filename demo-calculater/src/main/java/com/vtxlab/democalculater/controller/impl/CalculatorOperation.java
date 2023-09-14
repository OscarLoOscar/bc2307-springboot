package com.vtxlab.democalculater.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorOperation {
        // http://localhost:8080/strings
        @GetMapping(value = "/strings")
        List<String> getStrings();

        // http://localhost:8080/api/v1/add?x=106&y=20
        @GetMapping(value = "/add")
        // public Integer add(@RequestParam int x, @RequestParam int y);
        public Integer add(@RequestParam(name = "salary") int x, //
                        @RequestParam(name = "bonus") int y, //
                        @RequestParam(name = "dividend", required = false,
                                        defaultValue = "100") String z, //
                        @RequestParam int k);


        @GetMapping(value = {"/substract/{x}/{y}/{z}", //
                        "/substract/{x}/{y}"})
        // http://localhost:8080/api/v1/add/{x}/{y}/{z}
        public Integer subStract(@PathVariable(name = "x") int x, // 後面切片編程
                        @PathVariable int y, //
                        @PathVariable(required = false) int z);



}
