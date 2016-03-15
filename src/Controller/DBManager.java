/*
 *     Name :  Iman Syahputra Situmorang
 *     NIM  :  11113064
 *     Date :  09/December/2014
 
 */
package Controller;

import Model.Account;
import Model.Item;
import Model.Monster;
import Model.MonsterAccount;
import Model.MonsterItem;
import Model.MonsterItemPK;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author Takiya
 */
public class DBManager {

    private EntityManagerFactory managerFactory = null;
    private EntityManager manager = null;

    public DBManager() {
        managerFactory = Persistence.createEntityManagerFactory("MonsterCombatPU");
        manager = managerFactory.createEntityManager();
    }

    public EntityManager getManager() {
        return this.manager;
    }

    public Monster findById(int idmonster) {
        Monster mons = null;
        manager.getTransaction().begin();

        mons = manager.find(Monster.class, idmonster);

        manager.getTransaction().commit();
        return mons;
    }

    public Item findByIdItem(int idItem) {
        Item baru = null;
//        manager.getTransaction().begin();

        baru = manager.find(Item.class, idItem);

//        manager.getTransaction().commit();
        return baru;
    }

    public void updateAkunMonster(MonsterAccount baru) {
        manager.getTransaction().begin();

//        System.out.println(baru.getId());
        MonsterAccount momon = manager.find(MonsterAccount.class, baru.getId());
        //MstMonster momon = findById(baru.getId());
//        System.out.println(momon.getName());

//        momon.setName(baru.getName());
        momon.setAp(baru.getAp());
        momon.setDp(baru.getDp());
        momon.setHp(baru.getHp());
        momon.setCoin(baru.getCoin());
        manager.merge(momon);
        manager.flush();
        manager.getTransaction().commit();
    }

    public void updateAkunMonsterBuyItem(MonsterAccount baru) {
        manager.getTransaction().begin();

//        System.out.println(baru.getId());
        MonsterAccount momon = manager.find(MonsterAccount.class, baru.getId());
        //MstMonster momon = findById(baru.getId());
//        System.out.println(momon.getName());

//        momon.setName(baru.getName());
        momon.setAp(baru.getAp());
        momon.setDp(baru.getDp());
        momon.setHp(baru.getHp());
        momon.setCoin(baru.getCoin());
        manager.merge(momon);
        manager.flush();
        manager.getTransaction().commit();
    }

    public void updateMonster(Monster baru) {
        manager.getTransaction().begin();

//        System.out.println(baru.getId());
        Monster momon = manager.find(Monster.class, baru.getId());
        //MstMonster momon = findById(baru.getId());
//        System.out.println(momon.getName());

        momon.setName(baru.getName());
        momon.setAp(baru.getAp());
        momon.setDp(baru.getDp());
        momon.setHp(baru.getHp());
        manager.merge(momon);
        manager.flush();
        manager.getTransaction().commit();
    }

    public ArrayList<Monster> loadMonster() {

//        Object[] coloumnNames={"Monster" , "Name" , "AP", "HP" , "DP"};
//        ArrayList <ImageIcon> icon = new ArrayList<ImageIcon>();
        Vector<Monster> result = null;
        result = (Vector<Monster>) manager.createQuery("SELECT m FROM Monster m").setHint(QueryHints.REFRESH, HintValues.TRUE).getResultList();
//        System.out.println(result.isEmpty());
        ArrayList<Monster> listMonster = new ArrayList<Monster>();

        for (Monster temp : result) {
            listMonster.add(temp);
            //    System.out.println(temp.getName());
        }
//        listMonster.add(momon);

        return listMonster;
    }

    public ArrayList<MonsterItem> loadItemMonster(int idMakun) {

        List<MonsterItem> result = null;
        result = (List<MonsterItem>) manager.createQuery("SELECT m FROM MonsterItem m where m.monsterItemPK.id  = :idMakun").setParameter("idMakun", idMakun).setHint(QueryHints.REFRESH, HintValues.TRUE).getResultList();
//        result = (List<MonsterItem>) manager.createQuery("SELECT m FROM MonsterItem m ").setHint(QueryHints.REFRESH, HintValues.TRUE).getResultList();
        ArrayList<MonsterItem> listItem = new ArrayList<MonsterItem>();
        MonsterItem temp = null;
//        System.out.println("SIZE : " + result.size());
        for (int i = 0; i < result.size(); i++) {
            temp = result.get(i);
            listItem.add(temp);
//            System.out.println("TEST TEST DALAM ");
        }
        return listItem;
    }

    public Account getAccountByUsername(String _username) {
        Account akun = null;
        try {
            akun = (Account) manager.createQuery("SELECT a FROM Account a WHERE a.username = :_username").setParameter("_username", _username).getSingleResult();
        } catch (NoResultException ie) {
            akun = null;
        }
        return akun;
    }

    public void updateAccount(Account akun) {

    }

    public void createAccount(Account akun) {
        manager.getTransaction().begin();
        manager.persist(akun);
        manager.getTransaction().commit();
    }

    public void delMonsterItem(MonsterItemPK pk) {

        manager.getTransaction().begin();
        MonsterItem monster = manager.find(MonsterItem.class, pk);

        manager.remove(monster);

        manager.getTransaction().commit();
    }

    public void updateMonsterItem(int idItemBaru, MonsterItem old) {

        manager.getTransaction().begin();
//        old.setItem(item.getItem());

//        old.setMonsterAccount(item.getMonsterAccount());
//        old.setMonsterId(item.getMonsterId());
//        old.setMonsterItemPK(item.getMonsterItemPK());
        int baru = idItemBaru;
        int lama = old.getItem().getId();
        int akun = old.getMonsterAccount().getId();

        MonsterItemPK PK = new MonsterItemPK(old.getMonsterAccount().getId(), old.getItem().getId());

//                    MonsterItem newItem = new MonsterItem(PK, akunBaru.getMonsterId().getId());
//        old.setMonsterItemPK(PK);
        old.setItemId(baru);
        manager.merge(old);
//        manager.flush();
        manager.getTransaction().commit();

    }

    public void createMonsterItem(MonsterItem item) {
        manager.getTransaction().begin();

        manager.persist(item);
        manager.getTransaction().commit();
    }

    public MonsterItem getMonsterItemByPK(MonsterItemPK pk) {
        MonsterItem Mitem = null;

        try {
            Mitem = (MonsterItem) manager.find(MonsterItem.class, pk);
        } catch (NoResultException ie) {

            Mitem = null;
        }

        return Mitem;
    }

    public void createMonsterAccount(MonsterAccount Makun) {
        manager.getTransaction().begin();
        manager.persist(Makun);
        manager.getTransaction().commit();
    }

    public MonsterAccount getAkunMonsterbyUser(int akun) {
//        manager.getTransaction().begin();
        MonsterAccount akunMonster = new MonsterAccount();

        try {
            akunMonster = (MonsterAccount) manager.createQuery("SELECT m FROM MonsterAccount m WHERE m.accountId.id = :akun").setParameter("akun", akun).setHint(QueryHints.REFRESH, HintValues.TRUE).getSingleResult();

        } catch (NoResultException io) {
            akunMonster = null;
        }
//        manager.getTransaction().commit();

        return akunMonster;
    }

    public void updateMonsterAccount(MonsterAccount baru) {
        manager.getTransaction().begin();

//        System.out.println(baru.getId());
        MonsterAccount momon = manager.find(MonsterAccount.class, baru.getId());
        //MstMonster momon = findById(baru.getId());
//        System.out.println(momon.getName());

        momon.setName(baru.getName());
        momon.setAp(baru.getAp());
        momon.setDp(baru.getDp());
        momon.setHp(baru.getHp());
        momon.setAccountId(baru.getAccountId());
        momon.setMonsterId(baru.getMonsterId());
        momon.setCoin(baru.getCoin());
        momon.setWinPoint(baru.getWinPoint());
        manager.merge(momon);

        manager.flush();

        manager.getTransaction()
                .commit();
    }

    public ArrayList<Item> loadItem() {

//        Object[] coloumnNames={"Monster" , "Name" , "AP", "HP" , "DP"};
//        ArrayList <ImageIcon> icon = new ArrayList<ImageIcon>();
        Vector<Item> result = null;
        result = (Vector<Item>) manager.createQuery("SELECT i FROM Item i").setHint(QueryHints.REFRESH, HintValues.TRUE).getResultList();
//        System.out.println(result.isEmpty());
        ArrayList<Item> listMonster = new ArrayList<Item>();

        for (Item temp : result) {
            listMonster.add(temp);
            //    System.out.println(temp.getName());
        }
//        listMonster.add(momon);

        return listMonster;
    }

    public MonsterItem getItemByType(String type) {
        MonsterItem item = new MonsterItem();

        try {
            item = (MonsterItem) manager.createQuery("SELECT m FROM MonsterItem m WHERE m.item.kind =:type").setParameter("type", type).getSingleResult();
        } catch (NoResultException ie) {
            item = null;
        }

        return item;

    }
    
    
    public ArrayList <MonsterItem> getAllItemByType(String type) {
        List <MonsterItem> item = null;


            item = (List <MonsterItem>) manager.createQuery("SELECT m FROM MonsterItem m WHERE m.item.kind =:type").setParameter("type", type).getResultList();
            
         ArrayList <MonsterItem> items = new ArrayList<MonsterItem>();
            
            for (MonsterItem itemTemp : item) {
            items.add(itemTemp);
            
            }
        return items;

    }

}
