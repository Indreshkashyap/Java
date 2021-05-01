// tracking user visits with cookie
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;


public class progI extends HttpServlet {

		String HeadBlock = "<html><head><title>Hidden Data Field</title></head><body><form method='get' action='/prog/test10'>Enter Name: <input type='text' name='user'><br/><input type='submit' value='submit'></form><br/><br/>";
		String footBlock = "</body></html>";
	
	public void doGet(HttpServletRequest Req, HttpServletResponse Res) throws IOException, ServletException {
		String retStr = HeadBlock;
		Res.setContentType("text/html");
		PrintWriter out = Res.getWriter();
		boolean matched = false;
		Cookie ck = null;
	 	Cookie[] cookies = null;
		cookies = Req.getCookies();
		String user = "";
		int visits;
		user = Req.getParameter("user");
		if(user!=null && user.length()>0) {
			if(cookies!=null) {
				for(int i=0;i<cookies.length;i++) {
					if(user.equals(cookies[i].getName())) {
						matched = true;
						visits=Integer.parseInt(cookies[i].getValue());
						visits++;
						cookies[i].setValue(Integer.toString(visits));	
						Res.addCookie(cookies[i]);
						retStr+= "<b>"+user+"</b> visited "+visits+" times.";
						break;	
					}
				}

			}
			if(!matched) {
				// set cookies
				ck = new Cookie(user, "0");
				Res.addCookie(ck);
				retStr+= "Welcome <b>"+user+"</b>";
			}
		}		
		retStr += footBlock;
		out.print(retStr);
	}
}
