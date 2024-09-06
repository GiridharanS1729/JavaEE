import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String css = "body { background: linear-gradient(135deg, #000,#333); font-family: Arial, sans-serif; margin: 0; }"
                   + ".container { margin-top: 100px; text-align: center; color: white; }"
                   + ".container h1 { font-size: 48px; animation: fadeIn 1s ease-in-out; }"
                   + ".container p { font-size: 20px; margin-top: 20px; }"
                   + "@keyframes fadeIn { from { opacity: 0; } to { opacity: 1; } }"
                   + ".welcome { color: #34eb86; background-color: #333; padding: 20px; border-radius: 10px; display: inline-block; }"
                   + "a { display: inline-block; padding: 10px 20px; background-color: #007BFF; color: white; text-decoration: none; border-radius: 5px; margin-top: 20px; }"
                   + "a:hover { background-color: #0056b3; transition: 0.3s; }"
                   + ".error-box { background-color: #ff4b4b; padding: 20px; border-radius: 10px; display: inline-block; color: white; }"
                   + "@keyframes shake { 0% { transform: translateX(0); } 25% { transform: translateX(-10px); } 50% { transform: translateX(10px); } 75% { transform: translateX(-10px); } 100% { transform: translateX(0); } }";
   
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (isValidUsername(username) && isValidPassword(password)) {
            out.println("<html>");
            out.println("<head><title>Login Successful</title>");
            out.println("<style>" + css + "</style></head>");
            out.println("<body>");
            out.println("<div class='container'><h1>Welcome, " + username + "!</h1>");
            out.println("<div class='welcome'><p>Login successful!</p></div>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<html>");
            out.println("<head><title>Login Failed</title>");
            out.println("<style>" + css + "</style></head>");
            out.println("<body>");
            out.println("<div class='container'><h1>Login Failed</h1>");
            out.println("<div class='error-box'><p>Invalid username or password.</p></div><br/>");
            out.println("<a href='index.html'>Try Again</a></div>");
            out.println("</body>");
            out.println("</html>");
        }

        out.close();
    }

    private boolean isValidUsername(String username) {
        return username != null && username.matches("^[a-zA-Z0-9]{3,15}$");
    }

    private boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$");
    }
}
