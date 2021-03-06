package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.models.User;
import ua.ivfr.it.lms.views.IndexView;
import ua.ivfr.it.lms.views.PathHtmlSingleton;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Головний фільтр для виводу статичних частин html сторінк
 */
@WebFilter(filterName = "IndexFilter", value = {"/", "/login", "/user/*", "/register","/note/*","/shared-notes/*","/admin/*"})
public class IndexFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PathHtmlSingleton pathHtmlSingleton = PathHtmlSingleton.getInstance();
//        System.out.println("Filter path\t" + pathHtmlSingleton.getPath());
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        System.out.println(request.getRequestURI());


        //Перевірка чи користувач зайшов під своїм емайлом, якщо ні то його буде перекдати на головну.
        if (user == null) {
            switch (request.getRequestURI()) {
                case "/":
                case "/login":
                case "/register":
                    break;
                default:
                    response.sendRedirect("/");
                    break;
            }
        }

        IndexView indexView = new IndexView();
        indexView.outTopPage(out);
        if (user == null) {
            indexView.outMenu(out);
        }else {
            if(user.getRole()==1){
            indexView.outMenu_Admin(out);
            }
            else {
                indexView.outMenu_Login(out);
            }
        }
        //servlet
        chain.doFilter(request, response);
        //низ html сторінки
        indexView.outBottomPage(out);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
