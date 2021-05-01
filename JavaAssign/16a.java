// Program for hidden field in html 
// to store data in it.

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class progF extends HttpServlet {

	String HeadBlock = "<html><head><title>Hidden Data Field</title></head><body><form method='get' action='/prog/test7'>Enter Name: <input type='text' name='name'><br/>";
	//String defaultHidden = "<input type='hidden' name='vdata' value='null:0'>";
	String SubmitBlock = "<input type='submit' value='submit'></form>";
	String footBlock = "</body></html>";
	
	public void doGet(HttpServletRequest Req, HttpServletResponse Res) throws IOException, ServletException {
		String retStr = HeadBlock;
		Res.setContentType("text/html");
		PrintWriter out = Res.getWriter();
		String name = Req.getParameter("name");
		String vdata = Req.getParameter("vdata");
		String fname;
		String strRebuilt="";
		boolean matched = false;
		int visit=-1;

		if(vdata==null) {
			strRebuilt+= "null:0;";
		}else if((name!=null && name.length()!=0) && (!vdata.equals("null:0"))) {
			// Parse the data
		    String[] arrOfStr = vdata.split(";");
			for (String s : arrOfStr) {
            	String[] tmpst = s.split(":");
			 	if(tmpst[0].equals(name)) {
					matched = true;
					fname = tmpst[0];
					visit = Integer.parseInt(tmpst[1]);
					visit++;
					tmpst[1] = Integer.toString(visit);
					strRebuilt+=(tmpst[0]+":"+tmpst[1]+";");
				} else {
					if(tmpst[0].equals("null")) {
						// do nothing
					} else {
						strRebuilt+=(tmpst[0]+":"+tmpst[1]+";");
					}
				}			
			}

        }else{	
			strRebuilt = vdata;
		}
	
		// if new item then add here
		if(!matched && (name!=null && name.length()!=0)) {
			strRebuilt+=(name+":1;");
			fname = name;
			visit = 1;
		}

		retStr+= "<input type='hidden' name='vdata' value='"+strRebuilt+"'>"+SubmitBlock;

		if(visit == 1) {
			   retStr+= "<br/>Welcome "+name+"<br/>";
		} else if(visit > 1 ) { 
			   retStr+= "<br/>"+name+" visited "+ visit +" times.<br/>";
		}
		
		retStr += footBlock;
		out.print(retStr);
	}
}
