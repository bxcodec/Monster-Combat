/*
 *     Name :  Iman Syahputra Situmorang
 *     NIM  :  11113064
 *     Date :  18/December/2014
 
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Takiya
 */
@Entity
@Table(name = "monster_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonsterItem.findAll", query = "SELECT m FROM MonsterItem m"),
    @NamedQuery(name = "MonsterItem.findById", query = "SELECT m FROM MonsterItem m WHERE m.monsterItemPK.id = :id"),
    @NamedQuery(name = "MonsterItem.findByMonsterId", query = "SELECT m FROM MonsterItem m WHERE m.monsterId = :monsterId"),
    @NamedQuery(name = "MonsterItem.findByItemId", query = "SELECT m FROM MonsterItem m WHERE m.monsterItemPK.itemId = :itemId")})
public class MonsterItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MonsterItemPK monsterItemPK;
    @Basic(optional = false)
    @Column(name = "monster_id")
    private int monsterId;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MonsterAccount monsterAccount;
    @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public MonsterItem() {
    }
    
    
    public MonsterItem( MonsterAccount satu , Item dua) {
        this.monsterAccount = satu;
        this.monsterId = satu.getMonsterId().getId();
        this.item = dua;
        
    }

    public MonsterItem(MonsterItemPK monsterItemPK) {
        this.monsterItemPK = monsterItemPK;
    }

    public MonsterItem(MonsterItemPK monsterItemPK, int monsterId) {
        this.monsterItemPK = monsterItemPK;
        this.monsterId = monsterId;
    }

    public MonsterItem(int id, int itemId) {
        this.monsterItemPK = new MonsterItemPK(id, itemId);
    }

    public MonsterItemPK getMonsterItemPK() {
        return monsterItemPK;
    }

    public void setMonsterItemPK(MonsterItemPK monsterItemPK) {
        this.monsterItemPK = monsterItemPK;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public MonsterAccount getMonsterAccount() {
        return monsterAccount;
    }

    public void setMonsterAccount(MonsterAccount monsterAccount) {
        this.monsterAccount = monsterAccount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monsterItemPK != null ? monsterItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonsterItem)) {
            return false;
        }
        MonsterItem other = (MonsterItem) object;
        if ((this.monsterItemPK == null && other.monsterItemPK != null) || (this.monsterItemPK != null && !this.monsterItemPK.equals(other.monsterItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.MonsterItem[ monsterItemPK=" + monsterItemPK + " ]";
    }
  
    public void setItemId (int id) {
    
        this.item.setId(id);
    }
    
}
