package s;
import javax.ejb.Stateless;

@Stateless
public class NewSessionBean implements NewSessionBeanRemote {

    public String show(String name) {
        return "hai \n" + name;
    }

    public int fact(int n) {
        int fact=1;
        for(int i=1;i<=n;i++)
        {
            fact=fact*i;
        }
        return fact;
    }

}
