package com.my.mdemo.dao.hibernate;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.my.mdemo.dao.CategoryDao;
import com.my.mdemo.model.Category;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {
	
	
	@SuppressWarnings("unchecked")
	public List<Category> getCategories(final Category parent) {
		final DetachedCriteria crit = DetachedCriteria.forClass(Category.class)
			.setFetchMode("parent", FetchMode.JOIN)
			.setFetchMode("parent.children",FetchMode.JOIN)
			.setFetchMode("toneCategories", FetchMode.JOIN)
			.setFetchMode("details", FetchMode.JOIN)
			.setFetchMode("children",FetchMode.JOIN);
		if (parent != null) {
			crit.add(Restrictions.eq("parent", parent));
		} else {
			crit.add(Restrictions.isNull("parent"));
		}
		crit.addOrder(Order.asc("idx"));
		return new ArrayList<Category>(new LinkedHashSet<Category>(getHibernateTemplate().findByCriteria(crit)));
	}

	//TODO:Filter based on language..
	public Category getCategory(final int id) {
		final DetachedCriteria crit = DetachedCriteria.forClass(Category.class)
		.add(Restrictions.idEq(id))
					.setFetchMode("children", FetchMode.JOIN)
					.setFetchMode("parent", FetchMode.JOIN)
					.setFetchMode("parent.children", FetchMode.JOIN)
					.setFetchMode("toneCategories", FetchMode.JOIN)
					.setFetchMode("toneCategories.tone", FetchMode.JOIN)
					.setFetchMode("toneCategories.tone.details", FetchMode.JOIN)
					.createAlias("details", "d").createAlias("d.language","l")
					.add(Restrictions.eq("l.code", "en"))
					;
		@SuppressWarnings("unchecked")
		final Category cat = (Category) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(crit));
		
		return cat;
	}
	
	
	public int getSubCategoriesCount(final int parentId){
		final DetachedCriteria crit = DetachedCriteria.forClass(Category.class)
		.add(Restrictions.eq("parent.id", parentId));
		return getHibernateTemplate().findByCriteria(crit).size();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getSubCategories(final int parentId, final int firstResult, final int maxResults ){
		final DetachedCriteria crit = DetachedCriteria.forClass(Category.class);
		crit.add(Restrictions.eq("parent.id", parentId));
		return (List<Category>)getHibernateTemplate().findByCriteria(crit, firstResult, maxResults);
		
	}
}
