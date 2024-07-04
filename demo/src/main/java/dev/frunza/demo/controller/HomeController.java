package dev.frunza.demo.controller;

import org.ietf.jgss.Oid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(Authentication authentication){

        OidcUser oidcUser = (OidcUser) authentication.getPrincipal();

        System.out.println("oidc user: " + oidcUser);
        System.out.println("Hello world");
        System.out.println("oidc user info: " + oidcUser.getUserInfo());
        System.out.println("oidc user email: " + oidcUser.getPreferredUsername());


        return "Hello, user " + oidcUser.getPreferredUsername();
    }

}
