package pl.converter.javaee2.text;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/text")
public class TextServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        String text = req.getParameter("text");
        String palindromString;

        if (palindrom(text)){
            palindromString = "TAK";
        }else {
            palindromString = "NIE";
        }

        writer.println("WPROWADZONY TEKST: ");
        writer.println(text);
        writer.println("Ilość znaków: " + text.length());
        writer.println("Ilość znaków bez spacji: " + text.replace(" ", "").length());
        writer.println("Ilość słów: " + text.split(" ").length);
        writer.println("Palindrom: " + palindromString);
    }

    private boolean palindrom(String value) {
        StringBuilder stringBuilder = new StringBuilder((value));
        return value.equals(stringBuilder.reverse().toString());
    }


}
