package com.bookingsystem.accountservice.facade;

import com.bookingsystem.accountservice.service.RedirectService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "urlShortener")
public class RedirectResource {
    private RedirectService redirectService;

    public RedirectResource(final RedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @PostMapping
    public ResponseEntity<String> shortenUlr(@RequestBody final String longUrl) {
        final String shortenKey = redirectService.createRedirectMapping(longUrl);
        return ResponseEntity.status(HttpStatus.OK).body(shortenKey);
    }

    @GetMapping("/{shortKey}")
    public void redirect(@PathVariable String shortKey, HttpServletResponse httpServletResponse) {
        final String longUrl = redirectService.getLongUrl(shortKey);
        httpServletResponse.setHeader("Location", longUrl);
        httpServletResponse.setStatus(302);
    }
}
