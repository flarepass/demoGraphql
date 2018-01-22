package com.example.demographql.test;

import com.example.demographql.test.TestException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wilyanto.salim
 * on 1/22/18.
 */
@RestController
public class AAAController {
    @PreAuthorize("!isAnonymous() and hasAuthority('read-Abc')")
    @RequestMapping(value = "/AAA")
    public void getA() {
        throw new TestException("aaaaaaaaa", "bbbbbbbb");
    }
}
