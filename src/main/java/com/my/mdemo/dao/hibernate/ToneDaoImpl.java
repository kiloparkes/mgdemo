package com.my.mdemo.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.my.mdemo.dao.ToneDao;
import com.my.mdemo.model.Tone;
import com.my.mdemo.model.ToneCategory;

public class ToneDaoImpl extends HibernateDaoSupport implements ToneDao {

	// distinct will not work with two object in the select clause
	@SuppressWarnings("unused")
	private static String TONE_IN_CATEGORY_QUERY_OLD = 
			"select distinct {t.*}, tc.* from trbt_tone t "
			+ "join trbt_tone_category tc on tc.tone_id = t.id " 
			+ "where tc.category_id = :catId and t.deleted = 0";
	
	
	private static String TONE_IN_CATEGORY_QUERY = 
		"select distinct {t.*} from trbt_tone t "
		+ "join trbt_tone_category tc on tc.tone_id = t.id " 
		+ "where tc.category_id = :catId and t.deleted = 0";
	
	@SuppressWarnings("unused")
	private static String TONE_IN_CATEGORY_COUNT_QUERY = 
		"select count(*) cnt from trbt_tone t "
		+ "join trbt_tone_category tc on tc.tone_id = t.id " 
		+ "where tc.category_id = :catId and t.deleted = 0";
	
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Tone> getTonesOfCategory(final int catId) {
//		// TODO Auto-generated method stub
//		@SuppressWarnings("unused")
//		List<Tone> obj = (List<Tone>)getHibernateTemplate().execute(new HibernateCallback() {
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				SQLQuery query = session.createSQLQuery(TONE_IN_CATEGORY_QUERY_OLD);
//				query.addEntity("t", Tone.class);
//				query.addEntity("tc", ToneCategory.class);
//				
//				query.setInteger("catId", catId);
//				List l = query.list();
//				
//				//filter out the TONE_CATEGORY data... and return the list of tones 
//				ArrayList<Tone> tones = new ArrayList<Tone>();
//				for (Object object : l) {
//					Object[] x = (Object[])object;
//					tones.add((Tone)x[0]);
//				}
//				return tones;
//			}
//		});
//		return obj;
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tone> getTonesOfCategory(final int catId, final int fetchSize, final int startPos) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		List<Tone> obj = (List<Tone>)getHibernateTemplate().execute(new HibernateCallback() {
			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(TONE_IN_CATEGORY_QUERY);
				query.addEntity("t", Tone.class);
				//query.addEntity("tc", ToneCategory.class);
				
				query.setInteger("catId", catId);
				query.setMaxResults(fetchSize);
				query.setFirstResult(startPos);
				
				List l = query.list();
					
				return l;
			}
		});
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTonesOfCategoryCount(final int catId) {
		@SuppressWarnings("unused")
		Object obj = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(TONE_IN_CATEGORY_COUNT_QUERY);
				//query.addEntity("t", Tone.class);
				//query.addEntity("tc", ToneCategory.class);
				
				query.addScalar("cnt", Hibernate.INTEGER);
				query.setInteger("catId", catId);
				Object l = query.uniqueResult();
			
				return l;
			}
		});
		return (Integer)obj;
	}
}
