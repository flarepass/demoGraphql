package com.example.demographql.user;

import com.example.demographql.exception.TestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wilyanto.salim
 * on 1/22/18.
 */
@RestController
public class AAAController {
    @RequestMapping(value = "/AAA")
    public void getA() {
        throw new TestException("aaaaaaaaa", "bbbbbbbb");
    }
}
