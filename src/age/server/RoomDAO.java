package age.server;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import age.shared.model.Area;
import age.shared.model.Building;
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
        
        Query query = session.createQuery("from Room where id = :id");
        query.setParameter("id", id);
        @SuppressWarnings("unchecked")
		List<Room> rooms = query.list();
        Room room = rooms.get(0);
        
        session.flush();
        session.close();
        
        return room;
	}

	public List<Area> getAllAreas() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        @SuppressWarnings("unchecked")
		List<Area> res = session.createQuery("FROM Area").list();
        
        session.flush();
        session.close();
        
        return res;
	}

	public List<Building> getAllBuildings() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        @SuppressWarnings("unchecked")
		List<Building> res = session.createQuery("FROM Building").list();
        
        session.flush();
        session.close();
        
        return res;
	}

	public List<Room> getAllRooms() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        @SuppressWarnings("unchecked")
		List<Room> res = session.createQuery("FROM Room").list();
        
        session.flush();
        session.close();
        
        return res;
	}

	public List<Room> getRoomsForBuildning(int buildingId) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("from Room where buildingId = :buildingId");
        query.setParameter("buildingId", buildingId);
        @SuppressWarnings("unchecked")
		List<Room> res = query.list();
        
        session.flush();
        session.close();
        
        return res;
	}

	public List<Building> getBuildingsForArea(int areaId) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("from Building where areaId = :areaId");
        query.setParameter("areaId", areaId);
        @SuppressWarnings("unchecked")
		List<Building> res = query.list();
        
        session.flush();
        session.close();
        
        return res;
	}

}


