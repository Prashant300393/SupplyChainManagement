package com.amdocs.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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


}