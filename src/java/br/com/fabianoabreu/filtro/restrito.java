package br.com.fabianoabreu.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/web/WEB-INF/jsp/restrito/*")
@WebFilter("/restricao/*")



public class restrito implements Filter { 

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
       
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        
        
        
        System.out.println("entrando filtro 3....");
        
        
        HttpSession session = request.getSession(false);
//        String loginURI = request.getContextPath()+ "/mvc?logica=autenticacao";
//        System.out.println("URI---> "+ loginURI);
       boolean loggedIn = ((session != null) && (session.getAttribute("login") != null));
//        //boolean loginRequest = request.getRequestURI().equals(loginURI);
//        
//        
        System.out.println("Logado = "+loggedIn);

        if (loggedIn) {
            System.out.println("Executou chain.doFilter");
            chain.doFilter(request, response);
            
        } else {
            System.out.println("Reencaminhar para autenticarUser...");
           // response.sendRedirect("mvc?logica=validacao");
           request.getRequestDispatcher("/mvc?logica=validacao").forward(request, response);
// request.getRequestDispatcher("/WEB-INF/jsp/autenticaUser.jsp").forward(request, response);
            //response.sendRedirect(loginURI);
        }
    }
        
//        if (loggedIn || loginRequest) {
//            chain.doFilter(request, response);
//        } else {
//            response.sendRedirect(loginURI);
//        }
//    }

    // ...

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

   
    @Override
    public void destroy() {
        
    }
}