/*
 *     Name :  Iman Syahputra Situmorang
 *     NIM  :  11113064
 *     Date :  18/December/2014
 
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Takiya
 */
@Embeddable
public class MonsterItemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "item_id")
    private int itemId;

    public MonsterItemPK() {
    }

    public MonsterItemPK(int id, int itemId) {
        this.id = id;
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) itemId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonsterItemPK)) {
            return false;
        }
        MonsterItemPK other = (MonsterItemPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.MonsterItemPK[ id=" + id + ", itemId=" + itemId + " ]";
    }
    
}
