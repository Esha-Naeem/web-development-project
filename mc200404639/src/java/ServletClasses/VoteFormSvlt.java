
package ServletClasses;
import JavaClasses.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoteFormSvlt extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
          String id = request.getParameter("id");
            String party = request.getParameter("party");
            ManageVoter voterManager = new ManageVoter();
            boolean isSubmitted = voterManager.getVotingDetails(id);
            if(isSubmitted)
            {
                alreadyCasted(out);
            }
            else
            {
                boolean count = voterManager.insertVoterData(id, party);
                sucessfullyCasted(out,count);
        }
    }

    }
    protected void sucessfullyCasted(PrintWriter out, boolean count)
    {
        if(count)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CS506 Assignment 2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table border=\"1\" cellpadding=\"10\" "
                    + "cellspacing=\"0\" "
                    + "style=\"margin: auto;width: 50%;\">\n" + "                      "
                    + "<tr>\n" + " <th><h1>Your Vote Casted Sucessfully.</h1></th>\n" + "		"
                    + "</tr>\n" + "</table>");
            out.println("</body>");
            out.println("</html>");
        }
        else
            out.println("Record Not Inserted");
    }
    
    protected void alreadyCasted(PrintWriter out)
    {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CS506 Assignment 2</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<table border=\"1\" cellpadding=\"10\" "
                + "cellspacing=\"0\" "
                + "style=\"margin: auto;width: 50%;\">\n" + "                      "
                + "<tr>\n" + " <th><h1>You Already Casted the Vote!</h1></th>\n" + "		"
                + "</tr>\n" + "</table>");
        out.println("</body>");
        out.println("</html>");
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
public String getServletInfo(){
    return"short description" ;
}
}