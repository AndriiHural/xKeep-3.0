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
 * Головний фільтр для виводу статичних частин html сторінки
 */
@WebFilter(filterName = "IndexFilter", value = {"/", "/login", "/user/*", "/register","/note/*","/shared-notes"})
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

        String path=request.getRequestURI();
        System.out.println(path);
        
        //Перевірка чи користувач зайшов під своїм емайлом, якщо ні то його буде перекдати на головну.


        IndexView indexView = new IndexView();
        indexView.outTopPage(out);
        if (user == null) {
            indexView.outMenu(out);
        }else {
            indexView.outMenu_Login(out);
        }
        //servlet
        // Не зареєстрований користувач має доступ до  адрес "/" "/login" "/register"
        // і виконується відповідний сервлет.
        // Якщо він заходить на недоступне йому посилання здійснюєть переадресація "/"
        // Якщо він заходить як авторизований користувач виконується відповідний сервлет.
        if (user == null) {
            switch (path) {
                case "/":
                case "/login":
                case "/register":
                    System.out.println(request.getRequestURI());
                    chain.doFilter(request, response);
                    break;
                default:
                    response.sendRedirect("/");
                    break;
            }
        }else {
            chain.doFilter(request, response);
        }

        //низ html сторінки
        indexView.outBottomPage(out);


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
