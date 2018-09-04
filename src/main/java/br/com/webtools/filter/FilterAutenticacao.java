package br.com.webtools.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.webtools.entidades.Pessoa;
import br.com.webtools.jpautil.JPAUtil;

@WebFilter(urlPatterns= {"/*"})//INFORMA QUE ESSA CLASS EH UM FILTER
public class FilterAutenticacao implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) // ESSE NETODO É EXCUTADO EM TODAS AS REQUISIÇÕES
			throws IOException, ServletException {
		System.out.println("Invocando filter");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		Pessoa usuarioLogado = (Pessoa) session.getAttribute("usuarioLogado");
		
		String url = req.getServletPath();
		
		if(!url.equalsIgnoreCase("index.jsf") && usuarioLogado == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsf");
			dispatcher.forward(request, response);
			return;
		}else {
			//EXECUTA AS AÇÕES DE RESQUEST E DO RESPONSE
			chain.doFilter(request, response);
		}
		
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException { // É EXECUTADO QUANDO SUBIMOS O SERVIDOR
		JPAUtil.getEntityManager();
		
	} // implements Filter INTERFACE PADRÃO DO FILTER

}
