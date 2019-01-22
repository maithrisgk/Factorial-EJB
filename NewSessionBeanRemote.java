package s;
import javax.ejb.Remote;

@Remote
public interface NewSessionBeanRemote {

    String show(String name);

    int fact(int n);

}
