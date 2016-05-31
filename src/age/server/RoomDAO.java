package age.server;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import age.client.IRoomService;
import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

public class RoomDAO implements IRoomService {
	
	//Room
	@Override public Room createRoom(Room room) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.save(room);
		
		session.flush();
		session.close();
		
		return room; //now with id (auto-increment)
	}
	@Override public Room getRoom(int id){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Room where id = :id");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Room> rooms = query.list();
		Room room = rooms.get(0);
		
		session.flush();
		session.close();
		
		return room;
	}
	@Override public List<Room> getAllRooms() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        @SuppressWarnings("unchecked")
		List<Room> res = session.createQuery("FROM Room").list();
        
        session.flush();
        session.close();
        
        return res;
	}
	@Override public List<Room> getRoomsForBuildning(int buildingId) {
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
	@Override public void updateRoom(Room room) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.update(room);
		
		session.flush();
		session.close();
	}
	@Override public void deleteRoom(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Room room = new Room();
		room.setId(id);
		session.delete(room);
		
		session.flush();
		session.close();
	}
	
	//Building
	@Override public Building createBuilding(Building building) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.save(building);
		
		session.flush();
		session.close();
		
		return building; //now with id (auto-increment)
	}
	@Override public Building getBuilding(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("from Building where id = :id");
        query.setParameter("id", id);
        @SuppressWarnings("unchecked")
		List<Building> buildings = query.list();
        Building building = buildings.get(0);
        
        session.flush();
        session.close();
        
        return building;
	}
	@Override public List<Building> getAllBuildings() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		List<Building> res = session.createQuery("FROM Building").list();
		
		session.flush();
		session.close();
		
		return res;
	}
	@Override public List<Building> getBuildingsForArea(int areaId) {
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
	@Override public void updateBuilding(Building building) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.update(building);
		
		session.flush();
		session.close();
	}
	@Override public void deleteBuilding(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Building building = new Building();
		building.setId(id);
		session.delete(building);
		
		session.flush();
		session.close();
	}
	
	//Area
	@Override public Area createArea(Area area) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.save(area);
		
		session.flush();
		session.close();
		
		return area; //now with id (auto-increment)
	}
	@Override public Area getArea(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Area where id = :id");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Area> areas = query.list();
		Area area = areas.get(0);
		
		session.flush();
		session.close();
		
		return area;
	}
	@Override public List<Area> getAllAreas() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		List<Area> res = session.createQuery("FROM Area").list();
		
		session.flush();
		session.close();
		
		return res;
	}
	@Override public void updateArea(Area area) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.update(area);
		
		session.flush();
		session.close();
	}
	@Override public void deleteArea(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Area area = new Area();
		area.setId(id);
		session.delete(area);
		
		session.flush();
		session.close();
	}
}


