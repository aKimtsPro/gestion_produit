package bstorm.akimts.gestion_produit.config.security.jwt;

import bstorm.akimts.gestion_produit.models.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static bstorm.akimts.gestion_produit.config.security.SecurityConstants.*;

@Component
public class JwtTokenProvider {

    private final UserDetailsService service;

    public JwtTokenProvider(UserDetailsService service) {
        this.service = service;
    }

    public String createToken(String username, List<String> roles){
        String token = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date( System.currentTimeMillis() + EXPIRATION_TIME))
                .withClaim("roles", roles)
                .sign(Algorithm.HMAC512(JWT_KEY));

        return TOKEN_PREFIX + token;
    }

    public String resolveToken(HttpServletRequest request){
        String bearer = request.getHeader(HEADER_KEY);
        if(bearer != null && bearer.startsWith(TOKEN_PREFIX)){
            return bearer.substring( TOKEN_PREFIX.length() );
        }

        return null;
    }

    public boolean validateToken(String token){
        try {
            // Verification nnécessaire
            DecodedJWT decodedJWT = JWT.require( Algorithm.HMAC512(JWT_KEY) )
                    .build()
                    .verify( token.replace(TOKEN_PREFIX, "") );

            // Verification contextuelle
            String username = decodedJWT.getSubject();
            UserDetails user = service.loadUserByUsername(username);
            Date expiration = decodedJWT.getExpiresAt();

            return username != null && expiration.after(new Date());
        }
        catch ( JWTVerificationException | UsernameNotFoundException ex){
            return false;
        }


    }
    public String getUsername(String token) {
        return JWT.decode(token).getSubject();
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = service.loadUserByUsername( getUsername(token) );
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(),null, userDetails.getAuthorities());
    }
}
