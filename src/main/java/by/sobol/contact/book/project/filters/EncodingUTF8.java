package by.sobol.contact.book.project.filters;

import java.io.IOException;

import javax.servlet.*;

public class EncodingUTF8 implements Filter {

	private String encoding;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (encoding != null) {
			if (!encoding.equalsIgnoreCase(request.getCharacterEncoding())) {
				request.setCharacterEncoding(encoding);
				if (!encoding.equalsIgnoreCase(response.getCharacterEncoding())) {
					response.setCharacterEncoding(encoding);
				}
			}
			chain.doFilter(request, response);
		}

	}
}