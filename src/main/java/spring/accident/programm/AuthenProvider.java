/**
 * Package spring.accident.programm for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.programm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import spring.accident.models.Officer;

import java.util.ArrayList;
import java.util.List;

/**
 * Class AuthenProvider - execute Authentication check and return UsernamePasswordAuthenticationToken
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.04.2020
 */
@Component
public class AuthenProvider implements AuthenticationProvider {

    @Autowired
    Logic logic;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        Officer officer = logic.checkUser(name, password);
        if (officer != null) {
            return new UsernamePasswordAuthenticationToken(
                    name, password, new ArrayList<GrantedAuthority>(List.of(officer.getRole())));
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
