import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class Logout implements SessionAware{

	private Map<String, Object> session;
	
	@Override
    public void setSession(Map map) 
	{
        session = map;
    }
	
	public String execute()
	{
		if(session != null)
		{
			session.remove("currentUser");
		}
		return "success";
	}
}
