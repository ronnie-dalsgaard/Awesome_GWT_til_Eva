package age.server;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import age.client.IRoomService;
import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

@SuppressWarnings("serial")
public class RoomServiceImpl extends RemoteServiceServlet implements IRoomService{

	@Override
	public Room getRoom(int id) {
		// TODO - This is just for testing
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
		
        @SuppressWarnings("unchecked")
		List<Room> rooms = session.createQuery("FROM Room").list();
        for(Room room : rooms){
        	System.out.println(room);
        }
        
        @SuppressWarnings("unchecked")
		List<Building> buildings = session.createQuery("FROM Building").list();
        for(Building building : buildings){
        	System.out.println(building);
        }
        
        @SuppressWarnings("unchecked")
		List<Area> areas = session.createQuery("FROM Area").list();
        for(Area area : areas){
        	System.out.println(area);
        }
        
        session.flush();
        session.close();
        
        Room r = rooms.get(0);
        r.setName(buildings.get(0).getName());
        return r;
	}

}
