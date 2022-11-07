import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CookieServlet extends HttpServlet
{
    private int i=1;
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws IOException, ServletException
{ response.setContentType("text/html");
PrintWriter out = response.getWriter();
String k=String.valueOf(i);
Cookie c = new Cookie("visit",k);
response.addCookie(c);
int j=Integer.parseInt(c.getValue());
if(j==1)
{
out.println("This is the first time you are visiting this page");
}
else
{ synchronized(CookieServlet.this)
{ out.println("You visited this page "+i+" times");
}
}
i++;
}
}