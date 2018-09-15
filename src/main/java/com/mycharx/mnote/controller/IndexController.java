package com.mycharx.mnote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Index controller.
 *
 * @author 张卜亢
 * @date 2018.09.06 13:55:46
 */
@Controller
public class IndexController {
    /**
     * Index string.
     *
     * @return the string
     */
    @RequestMapping("")
    public String index() {
        return "Hello Word!";
    }
}
