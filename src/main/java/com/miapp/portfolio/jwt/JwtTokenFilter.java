
package com.miapp.portfolio.jwt;

import com.miapp.portfolio.model.User;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter{
    
    @Autowired private JwtTokenUtil jwtUtil;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        if (!hasAuthHeader(request)) {
           filterChain.doFilter(request, response);
           return;
        }
        
        String accessToken = getAccessToken(request);
        
        if(!jwtUtil.ValidateAccessToken(accessToken)){
           filterChain.doFilter(request, response);
           return;
        }
        
        setAuthenticationContext(accessToken, request);
        filterChain.doFilter(request, response);
    } 
    
    private boolean hasAuthHeader(HttpServletRequest request){
        
        String header = request.getHeader("Authorization");
        return !(ObjectUtils.isEmpty(header) || !header.startsWith("Bearer"));
    }
    
    private String getAccessToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        
        return header.split(" ")[1].trim();
        
    }
 
    private void setAuthenticationContext(String accessToken, HttpServletRequest request) {
        
        UserDetails userDetails = getUserDetails(accessToken);
        
        UsernamePasswordAuthenticationToken authentication = 
                new UsernamePasswordAuthenticationToken(userDetails, null, null);
        
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private UserDetails getUserDetails(String accessToken) {
        User userDetails = new User();
        
        String[] subjetsDetails = jwtUtil.getSubject(accessToken).split(",");
        
        userDetails.setId(Long.parseLong(subjetsDetails[0]));
        userDetails.setEmail(subjetsDetails[1]);
        
        return userDetails;
    }
}
