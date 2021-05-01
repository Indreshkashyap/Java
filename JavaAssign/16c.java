// Tracking user visits with Session

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

class SessionInfo implements Serializable {
	String user;
	int count;

	public void SessionInfo() {
		user = null;
		count = 0;
	}


	public void SetUser(String user) {
		this.user = user;
	}


	public String GetUser() {
		return user;
	}

	public void SetVisit() {
		count++;
	}

	public int GetVisit() {
		return count;
	}
}

public class progH extends HttpServlet {

		String HeadBlock = "<html><head><title>Hidden Data Field</title></head><body><form method='get' action='/prog/test9'>Enter Name: <input type='text' name='user'><br/><input type='submit' value='submit'></form><br/><br/>";
		String footBlock = "</body></html>";
	
	public void doGet(HttpServletRequest Req, HttpServletResponse Res) throws IOException, ServletException {
		String retStr = HeadBlock;
		Res.setContentType("text/html");
		PrintWriter out = Res.getWriter();
		String user = "";
		user = Req.getParameter("user");
		if(user!=null && user.length()>0) {
			HttpSession session = null;
			session=Req.getSession(false);
			// if there any previous session
			// then value is not null
			if(session!=null) {
				SessionInfo si = (SessionInfo)session.getAttribute("un");	
				if(user.equals(si.GetUser())) {
					si.SetVisit();	
					retStr+="<b>"+si.GetUser()+"</b> visited "+si.GetVisit()+" times.";
				} else {
					retStr+= "<b>!</b>Provided username is not matched, with stored username.";
				}
			} else {
				session = Req.getSession(true);
				SessionInfo si = new SessionInfo();
				si.SetUser(user);
				si.SetVisit();
				session.setAttribute("un", si);
				retStr+="Welcome <b>"+si.GetUser()+"</b>";
			}	
		}
		retStr += footBlock;
		out.print(retStr);
	}
}
