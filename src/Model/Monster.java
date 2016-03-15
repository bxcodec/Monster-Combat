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
@Table(name = "monster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monster.findAll", query = "SELECT m FROM Monster m"),
    @NamedQuery(name = "Monster.findById", query = "SELECT m FROM Monster m WHERE m.id = :id"),
    @NamedQuery(name = "Monster.findByName", query = "SELECT m FROM Monster m WHERE m.name = :name"),
    @NamedQuery(name = "Monster.findByHp", query = "SELECT m FROM Monster m WHERE m.hp = :hp"),
    @NamedQuery(name = "Monster.findByAp", query = "SELECT m FROM Monster m WHERE m.ap = :ap"),
    @NamedQuery(name = "Monster.findByDp", query = "SELECT m FROM Monster m WHERE m.dp = :dp"),
    @NamedQuery(name = "Monster.findByAvatarUrl", query = "SELECT m FROM Monster m WHERE m.avatarUrl = :avatarUrl")})
public class Monster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Column(name = "avatar_url")
    private String avatarUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monsterId")
    private Collection<MonsterAccount> monsterAccountCollection;

    public Monster() {
    }

    public Monster(Integer id) {
        this.id = id;
    }

    public Monster(Integer id, String name, int hp, int ap, int dp) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.ap = ap;
        this.dp = dp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getLevelHp() {
        int level = 0;
        int lower = 50;
        int upper = 100;
        if (this.hp > upper) {
            level = 3;
        } else if (this.hp > lower) {
            level = 2;
        } else {
            level = 1;
        }
        return level;
    }

    public int getLevelDp() {
        int level = 0;
        int lower = 5;
        int upper = 15;
        if (this.dp > upper) {
            level = 3;
        } else if (this.dp > lower) {
            level = 2;
        } else {
            level = 1;
        }
        return level;
    }

    public int getLevelAp() {
        int level = 0;
        int lower = 10;
        int upper = 20;
        if (this.ap > upper) {
            level = 3;
        } else if (this.ap > lower) {
            level = 2;
        } else {
            level = 1;
        }
        return level;
    }

    public int getLevel() {
        return getLevelAp() + getLevelDp() + getLevelHp();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @XmlTransient
    public Collection<MonsterAccount> getMonsterAccountCollection() {
        return monsterAccountCollection;
    }

    public void setMonsterAccountCollection(Collection<MonsterAccount> monsterAccountCollection) {
        this.monsterAccountCollection = monsterAccountCollection;
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
        if (!(object instanceof Monster)) {
            return false;
        }
        Monster other = (Monster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Monster[ id=" + id + " ]";
    }

}
