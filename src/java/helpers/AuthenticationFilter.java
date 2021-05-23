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
import javax.servlet.http.HttpSession;


/**
 *
 * @author JuuzouYT
 */
public class AuthenticationFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse resp,
      FilterChain chain) throws IOException, ServletException {
        
        //HttpSession sess = ((HttpServletRequest) req).getSession(true);
        //String newCurrentPage = ((HttpServletRequest) req).getServletPath();
        
        if (((HttpServletRequest) req).getSession().getAttribute("userId") == null ) {
            //System.out.println("No logeado");
            if (((HttpServletRequest) req).getRequestURI().equals("/ConnectDeal/products.xhtml")){
                ((HttpServletResponse) resp).sendRedirect("/ConnectDeal");
            }
        } else {
            if (((HttpServletRequest) req).getRequestURI().equals("/ConnectDeal/")){
                ((HttpServletResponse) resp).sendRedirect("/ConnectDeal/products.xhtml");
            }
            //System.out.println("Logeado "+sess.getAttribute("userId"));
        }
        chain.doFilter(req, resp);

  }

  public void init(FilterConfig config) throws ServletException {
    //
  }

    @Override
    public void destroy() {
     //
    }

  
}