/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.IOException;
import javax.servlet.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class AuthenticationFilter implements Filter{
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws IOException, ServletException{
        
       // HttpSession sess =  ((HttpServletRequest) req).getSession(true);
        //String newCirrentPage = ((HttpServletRequest) req).getServletPath();
        if(((HttpServletRequest) req).getSession().getAttribute("userId")==null){
            if(((HttpServletRequest) req).getRequestURI().equals("/ConnectDealv2/Usuario.xhtml")){
                ((HttpServletResponse) resp).sendRedirect("/ConnectDealv2");
                
            }
            if(((HttpServletRequest) req).getRequestURI().equals("/ConnectDealv2/Calendario.xhtml")){
                ((HttpServletResponse) resp).sendRedirect("/ConnectDealv2");   
            }
            if(((HttpServletRequest) req).getRequestURI().equals("/ConnectDealv2/Product.xhtml")){
                ((HttpServletResponse) resp).sendRedirect("/ConnectDealv2");
            }
            if(((HttpServletRequest) req).getRequestURI().equals("/ConnectDealv2/index.xhtml")){
                ((HttpServletResponse) resp).sendRedirect("/ConnectDealv2");
            }
            if(((HttpServletRequest) req).getRequestURI().equals("/ConnectDealv2/addDeal.xhtml")){
                ((HttpServletResponse) resp).sendRedirect("/ConnectDealv2");
            }
        }else{
            if(((HttpServletRequest) req).getRequestURI().equals("/ConnectDealv2/")){
                ((HttpServletResponse) resp).sendRedirect("/ConnectDealv2/Usuario.xhtml");
        }
    }
    chain.doFilter(req, resp);
}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void destroy() {
        
    }
}
