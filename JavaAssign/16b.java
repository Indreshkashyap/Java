// Tracking user visits with url Re-writing

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class progG extends HttpServlet {

		String HeadBlock = "<html><head><title>URL Re-writing</title></head><body><form method='get' action='/prog/test8;";
		String SubmitBlock = "'>Enter Name: <input type='text' name='name'><br/><input type='submit' value='submit'></form>";
		String footBlock = "</body></html>";
	
	public void doGet(HttpServletRequest Req, HttpServletResponse Res) throws IOException, ServletException {
		String retStr = HeadBlock;
		Res.setContentType("text/html");
		PrintWriter out = Res.getWriter();
		String name = Req.getParameter("name");
		String tst = Req.getRequestURL().toString();
		String[] vData = Req.getRequestURL().toString().split(";");
		String vCounter = "";
		String temp = "";
		int c, visit = -1;
		String fname;
		String[] tmpst;
		boolean matched = false;
		String DEBUG;
		if(vData.length<=1) {
			vCounter += "null:0;";
		} else {
			if(name.equals("")) {	
				if(!vData[1].equals("null:0")) { // store old data because name is null
					for(c=1;c<vData.length;c++) {
						temp += vData[c]+";";
					}
					vCounter += temp;
				} else {
					vCounter += "null:0;";
				}	
			} else {
				if(!vData[1].equals("null:0")) {	
					for(c=1;c<vData.length;c++) {
						tmpst = vData[c].split(":");
						if(tmpst[0].equals(name)) {
							matched = true;
							fname = tmpst[0];
							visit = Integer.parseInt(tmpst[1]);
							visit++;
							vCounter+=tmpst[0]+":"+visit+";";
						} else {
							vCounter+=tmpst[0]+":"+tmpst[1]+";";
						}
					}
				} else {
					vCounter = name+":1;";
					visit = 1;
					matched = true;
				}
			}
		} 

		if(!matched && (name!=null && name.length()!=0)) {
			vCounter+=(name+":1;");
			fname = name;
			visit = 1;		
		} 

		retStr += vCounter; 
		retStr += SubmitBlock;

        if(visit == 1) {
			retStr+= "<br/>Welcome <b>"+name+"</b><br/>";
	    } else if(visit > 1 ) { 
		    retStr+= "<br/><b>"+name+"</b> visited "+ visit +" times.<br/>";
		}   

		retStr += footBlock;
		out.print(retStr);
	}
}
