package com.lordy.userclient.web;

import com.lordy.commons.web.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;

    @Value("${security.oauth2.access-token-uri}")
    private String accessToeknUri;

    @PostMapping("login")
    public Response login(@RequestParam("username") String username, @RequestParam("password") String password){
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setAccessTokenUri(accessToeknUri);
        resourceDetails.setClientId(oAuth2ClientProperties.getClientId());
        resourceDetails.setClientSecret(oAuth2ClientProperties.getClientSecret());
        resourceDetails.setUsername(username);
        resourceDetails.setPassword(password);
        OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
        template.setAccessTokenProvider(new ResourceOwnerPasswordAccessTokenProvider());
        return Response.dataSuccess(template.getAccessToken());
    }
}
