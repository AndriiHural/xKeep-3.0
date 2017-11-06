package ua.ivfr.it.lms.views;

public class ViewLoginServlet {
    public static String getLogin() {
        return "<div class=\"container\">\n" +
                "\n" +
                "      <form class=\"form-signin\" role=\"form\">\n" +
                "        <h2 class=\"form-signin-heading\">Вхід</h2>\n" +
                "        <label for=\"inputEmail\" class=\"sr-only\">Імейл</label>\n" +
                "        <input type=\"email\" id=\"inputEmail\" class=\"form-control\" placeholder=\"Імейл\" required autofocus>\n" +
                "        <label for=\"inputPassword\" class=\"sr-only\">Пароль</label>\n" +
                "        <input type=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Пароль\" required>\n" +
                "        <div class=\"checkbox\">\n" +
                "          <label>\n" +
                "            <input type=\"checkbox\" value=\"remember-me\"> Запам'ятати мене\n" +
                "          </label>\n" +
                "        </div>\n" +
                "        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Вхід</button>\n" +
                "      </form>\n" +
                "\n" +
                "    </div> <!-- /container -->";
    }
}
