import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SettingServlet", urlPatterns = {"/setting"})
public class SettingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/setting.jsp");
        rd.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maxRecords = request.getParameter("maxRecords");
        response.addCookie(new Cookie("maxRecords", maxRecords));
        String titleFontSize = request.getParameter("titleFontSize");
        response.addCookie(new Cookie("titleFontSize", titleFontSize));
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("Your preference has been set."
                + "<br/><br/>Max. Records in Table: " + maxRecords
                + "<br/>Title Font Size: " + titleFontSize);

    }
}