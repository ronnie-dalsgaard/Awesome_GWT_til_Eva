package age.server;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import age.shared.model.Room;

public class RoomDAO {
	
	public Room getRoom(int id){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
		
//        @SuppressWarnings("unchecked")
//		List<Room> rooms = session.createQuery("FROM Room").list();
//        for(Room room : rooms){
//        	System.out.println(room);
//        }
        
        Query query = session.createQuery("from Roome where id = :id ");
        query.setParameter("id", id);
        @SuppressWarnings("unchecked")
		List<Room> rooms = query.list();
        Room room = rooms.get(0);
        
        session.flush();
        session.close();
        
        return room;
	}

}
