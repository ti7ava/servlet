/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Renato
 */

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    
       
public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain)
throws IOException, ServletException {
    //toda requisicao entra aqui
long tempoInicial = System.currentTimeMillis();
System.out.println("Filtro1");



//depois o fluxo é encaminhado para o destino correto
chain.doFilter(request, response);

//na volta executa aqui para baixo
long tempoFinal = System.currentTimeMillis();
String uri = ((HttpServletRequest)request).getRequestURI();
String parametros = ((HttpServletRequest) request)
.getParameter("logica");
System.out.println("Tempo da requisicao de " + uri
+ "?logica="
+ parametros + " demorou (ms): "
+ (tempoFinal - tempoInicial));
        
    }

    @Override
    public void destroy() {
        
    }
    
    
    
}
