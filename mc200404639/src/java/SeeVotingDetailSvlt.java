import java.io.IOException;
import JavaClasses.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SeeVotingDetailSvlt extends HttpServlet {

    
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        String id = request.getParameter("id");
            Voter std = MyDBHelper.retriveData(id);
            if(std.getStdID() != null)
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>CS506 Assignment 2</title>");
                out.println("<style>\n" +
    "            div{\n" +
    "                width: 50%;\n" +
    "                padding: 30px;\n" +
    "                margin: 20px auto;\n" +
    "                text-align: center;\n" +
    "            }\n" +
    "            h1{\n" +
    "                margin-bottom: 30px;\n" +
    "            }\n" +
    "            h2{\n" +
    "                margin-bottom: 10px;\n" +
    "            }\n" +
    "            table{\n" +
    "                width: 100%;\n" +
    "                margin: auto;\n" +
    "            }\n" +
    "        </style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div>\n" +
    "            <h1>Voting Application</h1>\n" +
    "            <form action=\"VoteFormSvlt\" method=\"post\">\n" +
    "                <table border=\"1\" cellpadding=\"10\" cellspacing=\"0\">\n" +
    "                    <tr>\n" +
    "                        <td colspan=\"2\"><h3>Application Details</h3></td>\n" +
    "                    </tr>\n" +
    "                    <tr>\n" +
    "                        <th>Student ID</th>\n" +
    "                        <td>" + std.getStdID() + "</td>\n" +
    "                    </tr>\n" +
    "                    <tr>\n" +
    "                        <th>Vote To Party</th>\n" +
    "                        <td>" + std.getCandidate() + "</td>\n" +
    "                    </tr>\n" +
    "                </table>\n" +
    "            </form>\n" +
    "        </div>\n" +
    "        <div>\n" +
    "        	Press 'Back' to go back to Voting Application.<br><br>\n" +
    "        	<a href=\"/TestWeb/index.html\"><button>Back</button></a>\n" +
    "        </div>");
                out.println("</body>");
                out.println("</html>");
            }
            else
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
                        + "<tr>\n" + " <th><h1>Kindly Cast The Vote To See Voting Detail.</h1></th>\n" + "		"
                        + "</tr>\n" + "</table>");
                out.println("</body>");
                out.println("</html>");
            }   
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
