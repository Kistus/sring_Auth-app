package com.example.testing;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import java.util.Date;

@Component
public class JwtCore {

    @Value("${testing.app.secret}")
    private String secret;

    @Value("${testing.app.lifetime}")
    private int lifetime;

    public String generateToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        return Jwts.builder().setSubject((userDetails.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + lifetime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getNameFromJwt(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

}
