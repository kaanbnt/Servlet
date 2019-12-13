import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindPerson implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    static List<Person> personelList = new ArrayList<>();

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String islem = servletRequest.getParameter("islem");
        System.out.println(islem);
        if (islem.equals("kaydet")) {
            String ad = servletRequest.getParameter("ad");
            String soyad = servletRequest.getParameter("soyad");
            Person person = new Person();
            person.setAd(ad);
            person.setSoyad(soyad);
            personelList.add(person);
        } else if (islem.equals("listele")) {
            for (Person person : personelList) {
                String html = person.getAd()+" "+person.getSoyad()+"\n";
                servletResponse.setCharacterEncoding("UTF-8");
                servletResponse.getWriter().write(html);
                System.out.println(person);
            }

        } else {
            System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz! ");
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
