package com.amdocs.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.amdocs.dao.IPurchaseOrderDao;
import com.amdocs.model.PurchaseDtl;
import com.amdocs.model.PurchaseOrder;

@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return (Integer) ht.save(po);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return ht.loadAll(PurchaseOrder.class);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
		ht.delete(new PurchaseOrder(id));
	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder po) {
		ht.update(po);
	}

	@Override
	public Integer savePurchaseDtl(PurchaseDtl dtl) {
		return (Integer)ht.save(dtl);
	}


	@Override
	public void deletePurchaseDtl(Integer id) {
		PurchaseDtl dtl = new PurchaseDtl();
		dtl.setId(id);
		ht.delete(dtl);
	}

	@Override
	public void updatePoStatus(Integer poId, String status) {

		ht.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException 
			{
				String hql = " update "+PurchaseOrder.class.getName()+" set poStatus=:poStatus where id=:id ";
				int count = session.createQuery(hql)
						.setParameter("poStatus", status)
						.setParameter("id", poId)
						.executeUpdate();
				return count;
			}
		});
	}

	@Override
	public List<Object[]> getPurchaseIdAndCode() {
		List<Object[]> result = 
				ht.execute(new HibernateCallback<List<Object[ ]>>() {

					@SuppressWarnings({ "rawtypes", "unchecked" })
					@Override
					public List<Object[]> doInHibernate(Session session) throws HibernateException 
					{

						/*				String hql = " select id, poOrderCode from "+PurchaseOrder.class.getName()+" where poStatus = 'INVOICED' ";
										Query query = session.createQuery(hql);
										List<Object[ ]> list = query.list();
										return list;
						 */	
						
						// get CriteriaBuilder using SESSION
						CriteriaBuilder builder = session.getCriteriaBuilder();
						// set Output type
						CriteriaQuery<Object[ ]> query = builder.createQuery(Object[ ].class);
						// set From 
						Root<PurchaseOrder> root = query.from(PurchaseOrder.class);
						// specify select clause
						query.multiselect(root.get("id"), root.get("poOrderCode"));
						
						// where condition
						query.where(builder.equal(root.get("poStatus"), "INVOICED"));
						
						// execute query
						Query<Object[ ]> q = session.createQuery(query);
						
						List<Object[ ]> list = q.list();
						
						return list;
					}
				});
		return result ;
	}

}