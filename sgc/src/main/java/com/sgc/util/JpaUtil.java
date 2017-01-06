package com.sgc.util;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public class JpaUtil {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Object entity) {
		entityManager.persist(entity);
	}
	
	public Object update(Object entity) {
		return entityManager.merge(entity);
	}
		
	public void delete(Object entity) {
		entityManager.remove(entity);
	}
	
	public <T> T findById(Class<T> entityClass, Object primaryKey) {
		return entityManager.find(entityClass, primaryKey);
	}
	
	public int queryExecute(String queryString, Map<String, Object> param) {
		Query query = entityManager.createQuery(queryString);
		setParametersOnQuery(query, param);
		return query.executeUpdate();
	}

	public <T> T querySingleResult(String queryString, Map<String, Object> param) {
		Query query = entityManager.createQuery(queryString);
		setParametersOnQuery(query, param);
		return (T) query.getSingleResult();
	}
	
	public <T> List<T> queryResultList(String queryString, Map<String, Object> param) {
		Query query = entityManager.createQuery(queryString);
		setParametersOnQuery(query, param);
		return query.getResultList();
	}
	
	public <T> T namedQuerySingleRresult(String namedQuery, Map<String, Object> param){
		
		//long start = System.currentTimeMillis();
		Query query = entityManager.createNamedQuery(namedQuery);
//		String transaccion = Util.getTransaccion();
//		String trazabilidad = "[" + transaccion + "] ";
//		System.out.println( trazabilidad + query.getQueryString());
		
		setParametersOnQuery(query, param);
		
		T result = (T) query.getSingleResult();
		/*
		try{
			List<UtilParametro> listaTmp = lista;
			for (UtilParametro utilParametro : listaTmp) {
				String parametros = utilParametro.toString2();
				utilBean.imprimirParametrosSP(trazabilidad, parametros, "OUTPUT");
			}
		}catch(Exception e){}
		*/
		//System.out.println( trazabilidad + "Tiempo transcurrido: " + (System.currentTimeMillis() - start) + " ms.");
		return result;
		
	}
	
	public <T> List<T> namedQueryResultList(String namedQuery, Map<String, Object> param){
		
		//long start = System.currentTimeMillis();
		Query query = entityManager.createNamedQuery(namedQuery);
//		String transaccion = Util.getTransaccion();
//		String trazabilidad = "[" + transaccion + "] ";
//		System.out.println( trazabilidad + query.getQueryString());
		
		setParametersOnQuery(query, param);
		
		List<T> result = query.getResultList();
		/*
		try{
			List<UtilParametro> listaTmp = lista;
			for (UtilParametro utilParametro : listaTmp) {
				String parametros = utilParametro.toString2();
				utilBean.imprimirParametrosSP(trazabilidad, parametros, "OUTPUT");
			}
		}catch(Exception e){}
		*/
		//System.out.println( trazabilidad + "Tiempo transcurrido: " + (System.currentTimeMillis() - start) + " ms.");
		return result;
		
	}
	
	public int namedQueryExecute(String namedQuery, Map<String, Object> param) {

		//long start = System.currentTimeMillis();
		Query query = entityManager.createNamedQuery(namedQuery);
//		String transaccion = Util.getTransaccion();
//		String trazabilidad = "[" + transaccion + "] ";
//		System.out.println( trazabilidad + query.getQueryString());
		
		setParametersOnQuery(query, param);
		
		int resultado = query.executeUpdate();
		//System.out.println( trazabilidad + "Tiempo transcurrido: " + (System.currentTimeMillis() - start) + " ms.");
		return resultado;
	}
	
	public void setParametersOnQuery(Query query, Map<String, Object> param){
		//String parametros = "";
		if(param != null) {
			for (Map.Entry<String, Object> elemento : param.entrySet()) {
				//parametros += elemento.getKey() + ": " + elemento.getValue() + ", ";
				query.setParameter(elemento.getKey(), elemento.getValue());
			}
			//utilBean.imprimirParametrosSP(trazabilidad, parametros, "INPUT");
		}
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}