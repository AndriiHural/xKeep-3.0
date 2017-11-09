package ua.ivfr.it.lms.views;


import ua.ivfr.it.lms.models.User;

import java.io.PrintWriter;

public class UserView {

    public void outNameUser(PrintWriter out) {
        User user = new User(1, "fdgsd", "sfdg", "ghfh", "hdfgh");
        out.println("<H1>" + user.toString() + "</H1>");
    }
}

