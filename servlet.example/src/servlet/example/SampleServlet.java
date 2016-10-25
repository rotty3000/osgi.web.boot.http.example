package servlet.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

import custom.reqcap.annotations.GogoJLine;

@Component(
	immediate = true,
	property = {
		HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/*"
	},
	service = Servlet.class
)
@GogoJLine
public class SampleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter writer = response.getWriter();

		writer.println("<h2>Hello You!</h2>");
	}

}