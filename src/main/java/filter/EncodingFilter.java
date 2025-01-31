package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

@WebFilter(initParams = {@WebInitParam(name = "charset", value = "UTF-8")})
public class EncodingFilter extends HttpFilter implements Filter {
    String chaset;
	
	public void init(FilterConfig fConfig) throws ServletException {
		chaset = fConfig.getInitParameter("charset");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//
		request.setCharacterEncoding(chaset);
		
		chain.doFilter(request, response);
		
	}
}
