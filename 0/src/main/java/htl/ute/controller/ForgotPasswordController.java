package htl.ute.controller;

import java.io.IOException;

import htl.ute.Services.IUserService;
import htl.ute.Services.Implement.IUserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import htl.ute.model.UserModel;


@WebServlet(urlPatterns = { "/forgotpassword"})
public class ForgotPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/Forgotpassword.jsp");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		IUserService service = new IUserServiceImpl();
		String username = request.getParameter("username").trim();
		String email = request.getParameter("email").trim();
		String alertMsg = "";
		if(username == null || email == null) {
			alertMsg ="Tài khoản hoặc Email không được rỗng!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/Forgotpassword.jsp").forward(request, response);
			return;
		}else {
		UserModel user = service.findPassword(username, email);
		if(!user.getUsername().equals(username) || !user.getEmail().equals(email)) {
			alertMsg ="Không tìm thấy tài khoản!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/Forgotpassword.jsp").forward(request, response);
			return;
		}else {
			alertMsg ="Mật khẩu của bạn là : " + user.getPassword();
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/Forgotpassword.jsp").forward(request, response);
			return;
		}
		}
	}
}
