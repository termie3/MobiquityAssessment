import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailValidation {
    public static void main(String args[]){
        ArrayList<String> emails = new ArrayList<String>();
        emails.add("testmail@domain.co.in");
        emails.add("testmail@domain.com");
        emails.add("test-mail#@domain.co.in");
        emails.add("test_mail@domain.com");
        emails.add("tesTmail@domaincom");
        //Add invalid emails in list
        emails.add("@yahoo.com");
        emails.add("12jtestEmail#domain.com");
        //Regular Expression
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        //Iterate emails array list
        for(String email : emails){
            //Create instance of matcher
            Matcher matcher = pattern.matcher(email);
            System.out.println(email +" : "+ matcher.matches()+"\n");
        }
    }
}
