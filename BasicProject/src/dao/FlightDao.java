package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class FlightDao {
	private FlightDao(){}
	private static FlightDao instance;
	public static FlightDao getInstance(){
		if(instance == null){
			instance = new FlightDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String,Object>>  selectFlightList(int dept, int arri){ //항공편 검색	
		String sql = " SELECT A.FLIGHT_CODE"
				+ ", A.PLANE_CODE"
				+ ", (SELECT PORT_NAME FROM AIRPORT WHERE A.PORT_DEPT = PORT_CODE) DEPT_NAME"
				+ ", (SELECT PORT_NAME FROM AIRPORT WHERE A.PORT_ARRI = PORT_CODE) ARRI_NAME"
				+ ", A.FLIGHT_COST1"
				+ ", A.FLIGHT_COST2"
				+ ", A.FLIGHT_COST3"
				+ ", A.DEPT_TIME"
				+ ", A.ARRI_TIME"
				+ " FROM FLIGHT A"
				+ " WHERE SUBSTR(A.PORT_DEPT,-2) = ?"
				+ " AND SUBSTR(A.PORT_ARRI,-2) = ?"
				+ " ORDER BY A.DEPT_TIME"; 
		List<Object> param = new ArrayList<>();
		param.add(dept); 
		param.add(arri);
		
		return jdbc.selectList(sql, param);
	}
		
	public List<Map<String ,Object>> FlightList(){
		String sql = " SELECT PORT_CODE , PORT_NAME "
				+ " FROM AIRPORT";
		
		return jdbc.selectList(sql);
	}

	
	public List<Map<String ,Object>> adminairPlane(){ //비행기 목록보기
		String sql ="SELECT *"
				+ " FROM AIRLINE";
		
		return jdbc.selectList(sql);
		
	}
	
	public List<Map<String ,Object>> adminairport(){ //공항 목록 보기 
		
		String sql ="SELECT *"
				+ " FROM AIRPORT";
		
		return jdbc.selectList(sql);
	}
	
	public int AdminFlight(Object planecode ,Object portdept ,Object portarri,
			int flightcost1,int flightcost2, int flightcost3,Object depttime ,Object arritime){
		
		String sql = "INSERT INTO FLIGHT(FLIGHT_CODE,PLANE_CODE,PORT_DEPT"
				+ " ,PORT_ARRI,FLIGHT_COST1,FLIGHT_COST2"
				+ " ,FLIGHT_COST3,DEPT_TIME,ARRI_TIME)"
				+ " VALUES( 'F'||(SELECT NVL(MAX(SUBSTR(FLIGHT_CODE,2)), 0) + 1 FROM FLIGHT)"
				+ " , ?"
				+ " , ?"
				+ " , ?"
				+ " , ?"
				+ " , ?"
				+ " , ?"
				+ " , ?"
				+ " , ?)";
		List<Object> param = new ArrayList<>();
		param.add(planecode);
		param.add(portdept);
		param.add(portarri);
		param.add(flightcost1);
		param.add(flightcost2);
		param.add(flightcost3);
		param.add(depttime);
		param.add(arritime);
		
		return jdbc.update(sql, param);
	}
	
	public int AdminDeleteFlight(Object num){
		String sql = "DELETE FROM FLIGHT"
				+ " WHERE FLIGHT_CODE =?";
		List<Object> param = new ArrayList<>();
		param.add(num);
		
		return jdbc.update(sql, param);
	}
	
	public int AdminUpdateFlight(Object planecode ,Object portdept ,Object portarri,
			int flightcost1,int flightcost2, int flightcost3,
			Object depttime ,Object arritime,Object num){
		String sql = "UPDATE FLIGHT"
				+ " SET PLANE_CODE = ?"
				+ " ,PORT_DEPT = ?"
				+ " ,PORT_ARRI = ?"
				+ " ,FLIGHT_COST1 = ?"
				+ " ,FLIGHT_COST2 = ?"
				+ " ,FLIGHT_COST3 = ?"
				+ " ,DEPT_TIME = ?"
				+ " ,ARRI_TIME = ?"
				+ " WHERE FLIGHT_CODE= ?";
		List<Object> param = new ArrayList<>();
		param.add(planecode);
		param.add(portdept);
		param.add(portarri);
		param.add(flightcost1);
		param.add(flightcost2);
		param.add(flightcost3);
		param.add(depttime);
		param.add(arritime);
		param.add(num);
		
		return jdbc.update(sql, param);
	}
	
}
