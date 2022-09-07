package fr.ensicaen.ecole.genielogiciel.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerModel implements IServerModel{
    public Float parseSalary() throws IOException {
        String host = "https://www.ensicaen.fr/formations/insertion-professionnelle/";
        URL aURL;
        StringBuilder codeHTML = new StringBuilder();
        aURL = new URL(host);
        URLConnection con = aURL.openConnection();
        con.setConnectTimeout(60000);
        con.setReadTimeout(60000);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        con.getInputStream(), StandardCharsets.UTF_8));
        String inputline;
        while ((inputline = in.readLine()) != null) {
            codeHTML.append(inputline).append("\n");
        }
        in.close();


        Pattern p = Pattern.compile("Avec un salaire annuel moyen brut de <strong>([0-9]{2}) ([0-9]{3})");
        Matcher match = p.matcher(codeHTML.toString());
        boolean b = match.find();
        if (match.groupCount() == 1 || !b) {
            return (float) -1.0;
        }
        String salary = match.group(1) + match.group(2);
        return Float.valueOf(salary);
    }
}