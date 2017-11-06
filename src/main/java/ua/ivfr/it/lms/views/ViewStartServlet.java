package ua.ivfr.it.lms.views;

public class ViewStartServlet {
    public static String getTopPage(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <title>xKeep 3.0</title>\n" +
                "\n" +
                "    <!-- Bootstrap -->\n" +
                "    <link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- Вставка HTML5 поєднується з Respond.js для підтримки в IE8 елементів HTML5 та медіа-запитів -->\n" +
                "    <!-- ЗАСТЕРЕЖЕННЯ: файл Respond.js не працює, якщо ви проглядаєте сторінку відкривши її з файлової системи -->\n" +
                "    <!--[if lt IE 9]>\n" +
                "      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n" +
                "      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n" +
                "    <![endif]-->\n" +
                "  </head>\n" +
                "  <body>";
    }
    public static String getBootomPage(){
        return " <!-- jQuery (потрібно для JavaScript плагінів Bootstrap) -->\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n" +
                "    <!-- Підключення мінімізованої збірки всіх плагінів jQuery. Можна підключати додаткові плагіни, якщо потрібно -->\n" +
                "    <script src=\"/js/bootstrap.min.js\"></script>\n" +
                "  </body>\n" +
                "</html>";
    }

    public static String getMenu(){
        return "<nav class=\"navbar navbar-inverse navbar-top\" role=\"navigation\">\n" +
                "      <div class=\"container\">\n" +
                "        <div class=\"navbar-header\">\n" +
                "          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n" +
                "            <span class=\"sr-only\">Toggle navigation</span>\n" +
                "            <span class=\"icon-bar\"></span>\n" +
                "            <span class=\"icon-bar\"></span>\n" +
                "            <span class=\"icon-bar\"></span>\n" +
                "          </button>\n" +
                "          <a class=\"navbar-brand\" href=\"\\\">x.Keep</a>\n" +
                "        </div>\n" +
                "        <div id=\"navbar\" class=\"collapse navbar-collapse\">\n" +
                "          <ul class=\"nav navbar-nav\">\n" +
                "            <li class=\"active\"><a href=\"#\">Стартова</a></li>\n" +
                "            <li><a href=\"#about\">Про сайт</a></li>\n" +
                "            <li><a href=\"#contact\">Контакти</a></li>\n" +
                "          </ul>\n" +
                "           " +
                "<div id=\"navbar\" class=\"navbar-collapse collapse\">\n" +
                "          <ul class=\"nav navbar-nav navbar-right\">\n" +
                "            <li><a href=\"#\">Налаштування</a></li>\n" +
                "            <li><a href=\"/login\">Вхід</a></li>\n" +
                "          </ul>\n" +
                "          <form class=\"navbar-form navbar-right\">\n" +
                "            <input type=\"text\" class=\"form-control\" placeholder=\"Пошук...\">\n" +
                "          </form>\n" +
                "        </div>" +

                "        </div><!--/.nav-collapse -->\n" +
                "      </div>\n" +
                "    </nav>";
    }
}
