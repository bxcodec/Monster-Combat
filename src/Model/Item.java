/*
 *     Name :  Iman Syahputra Situmorang
 *     NIM  :  11113064
 *     Date :  18/December/2014
 
 */

package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Takiya
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByKind", query = "SELECT i FROM Item i WHERE i.kind = :kind"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByHp", query = "SELECT i FROM Item i WHERE i.hp = :hp"),
    @NamedQuery(name = "Item.findByAp", query = "SELECT i FROM Item i WHERE i.ap = :ap"),
    @NamedQuery(name = "Item.findByDp", query = "SELECT i FROM Item i WHERE i.dp = :dp"),
    @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"),
    @NamedQuery(name = "Item.findByAvatarUrl", query = "SELECT i FROM Item i WHERE i.avatarUrl = :avatarUrl")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "kind")
    private String kind;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "hp")
    private int hp;
    @Basic(optional = false)
    @Column(name = "ap")
    private int ap;
    @Basic(optional = false)
    @Column(name = "dp")
    private int dp;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "avatar_url")
    private String avatarUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<MonsterItem> monsterItemCollection;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

        public Item(int hp, int ap, int dp, int price) {
        this.hp = hp;
        this.ap = ap;
        this.dp = dp;
        this.price = price;
    }

    
    public Item(Integer id, String kind, String name, int hp, int ap, int dp, int price, String avatarUrl) {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.hp = hp;
        this.ap = ap;
        this.dp = dp;
        this.price = price;
        this.avatarUrl = avatarUrl;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @XmlTransient
    public Collection<MonsterItem> getMonsterItemCollection() {
        return monsterItemCollection;
    }

    public void setMonsterItemCollection(Collection<MonsterItem> monsterItemCollection) {
        this.monsterItemCollection = monsterItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Item[ id=" + id + " ]";
    }
    
}
