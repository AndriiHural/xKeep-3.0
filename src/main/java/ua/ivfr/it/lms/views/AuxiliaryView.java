package ua.ivfr.it.lms.views;

import java.io.PrintWriter;

public class AuxiliaryView {

    public void outCloseTable(PrintWriter out){
        out.println("            </tbody>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</div>");
    }

}
