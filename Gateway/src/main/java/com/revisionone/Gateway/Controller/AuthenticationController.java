package com.revisionone.Gateway.Controller;

import com.revisionone.Gateway.Model.AuthenticationResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/Authenticate")
public class AuthenticationController {
    @GetMapping(value = "/login")
    public AuthenticationResponse authenticationResponse(@AuthenticationPrincipal OidcUser oidcUser, Model model, @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient oAuth2AuthorizedClient){
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .userId(oidcUser.getEmail())
                .accessToken(oAuth2AuthorizedClient.getAccessToken().getTokenValue())
                .refreshToken(oAuth2AuthorizedClient.getRefreshToken().getTokenValue())
                .expiresAt(oidcUser.getExpiresAt().getEpochSecond())
                .authorityList(oidcUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .build();
        return authenticationResponse;
    }
}
