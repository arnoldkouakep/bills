package cm.beni.main.julia.security.configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void afterPropertiesSet() {
		setRealmName("Julia");
		super.afterPropertiesSet();
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServerException {
		response.addHeader("Julia-Authentification", "Base - " + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("Http Status 401 : " + authException.getMessage());
	}

}
