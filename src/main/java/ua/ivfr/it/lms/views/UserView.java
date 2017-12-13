package ua.ivfr.it.lms.views;


import ua.ivfr.it.lms.models.User;

import java.io.PrintWriter;
import java.util.List;

public class UserView {

    public void outUsertable(PrintWriter out, List<User> users){
        for (User user :users) {
            String active=null;
            if(user.getRole()!=3){
                active="glyphicon glyphicon-ok";
            }
            else active="glyphicon glyphicon-remove";
            out.println("<tr>\n" +
                    "                <td>"+user.getId()+"</td>\n" +
                    "                <td>"+user.getEmail()+"</td>\n" +
                    "                <td>"+user.getPassword()+"</td>\n" +
                    "                <td>"+user.getName()+"</td>\n" +
                    "                <td>"+user.getData_registered_()+"</td>\n" +
                    "                <td>"+user.getRole()+"</td>\n" +
                    "                <td><form action=\"/admin\" method=\"POST\" class=\"form_size\">\n" +
                    "<button href=\"/admin/block\" type=\"submit\" name=\"id\" value=\""+user.getId()+"\" class=\"btn  btn-default\" aria-label=\"Left Align\">\n" +
                    "        <span class=\""+active+ "\" aria-hidden=\"true\">\n" +
                    "        </span>\n" +
                    "</button></td>\n" +
                    "                <td>"+"<!-- Trigger the modal with a button -->\n" +
                    "<button type=\"button\" class=\"btn btn-info btn-lg\" data-toggle=\"modal\" data-target=\"#myModal"+user.getId()+"\">Edit</button>\n" +
                    "<form action=\"/admin\" method=\"POST\" class=\"form-horizontal\">\n" +
                    "<!-- Modal -->\n" +
                    "<div id=\"myModal"+user.getId()+"\" class=\"modal fade\" role=\"dialog\">\n" +
                    "    <div class=\"modal-dialog\">\n" +
                    "        <!-- Modal content-->\n" +
                    "        <div class=\"modal-content\">\n" +
                    "            <div class=\"modal-header\">\n" +
                    "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
                    "                <h4 class=\"modal-title\">Modal Header</h4>\n" +
                    "            </div>\n" +
                    "            <div class=\"modal-body\">\n" +
                    "                <label for=\"email\">Email</label>\n" +
                    "                <input type=\"text\" class=\"form-control\" id=\"email\" name=\"email\" value=\""+user.getEmail()+"\">\n" +
                    "\n" +
                    "                <label for=\"password\">Password</label>\n" +
                    "                <input type=\"text\" class=\"form-control\" id=\"password\" name=\"password\" value=\""+user.getPassword()+"\">\n" +
                    "\n" +
                    "                <label for=\"name\">Name</label>\n" +
                    "                <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" value=\""+user.getName()+"\">\n" +
                    "                <p></p>\n" +
                    "                <div class=\"col-lg-2 \">\n" +
                    "                <button href=\"/admin/edit\" type=\"submit\" name=\"id\" value=\""+user.getId()+"\" class=\"btn btn-primary btn-block\">Змінити</button>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "</form>"+"</td>\n" +
                    "            </tr>");
        }
    }


}

