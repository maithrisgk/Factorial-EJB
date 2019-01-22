package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import s.NewSessionBeanRemote;

@WebServlet(name="helloo", urlPatterns={"/helloo"})
public class helloo extends HttpServlet {
    @EJB
    private NewSessionBeanRemote newSessionBean1;
    @EJB
    private NewSessionBeanRemote newSessionBean;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s1=request.getParameter("name");
        String s2=newSessionBean.show(s1);
        int nn=Integer.parseInt(request.getParameter("num"));
        int n1=newSessionBean1.fact(nn);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        {
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>" + s2 +"</h1>");
            out.println("<h1>" + n1+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        finally
        {
            out.close();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
