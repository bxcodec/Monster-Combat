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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "monster_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonsterAccount.findAll", query = "SELECT m FROM MonsterAccount m"),
    @NamedQuery(name = "MonsterAccount.findById", query = "SELECT m FROM MonsterAccount m WHERE m.id = :id"),
    @NamedQuery(name = "MonsterAccount.findByName", query = "SELECT m FROM MonsterAccount m WHERE m.name = :name"),
    @NamedQuery(name = "MonsterAccount.findByHp", query = "SELECT m FROM MonsterAccount m WHERE m.hp = :hp"),
    @NamedQuery(name = "MonsterAccount.findByAp", query = "SELECT m FROM MonsterAccount m WHERE m.ap = :ap"),
    @NamedQuery(name = "MonsterAccount.findByDp", query = "SELECT m FROM MonsterAccount m WHERE m.dp = :dp"),
    @NamedQuery(name = "MonsterAccount.findByWinPoint", query = "SELECT m FROM MonsterAccount m WHERE m.winPoint = :winPoint"),
    @NamedQuery(name = "MonsterAccount.findByCoin", query = "SELECT m FROM MonsterAccount m WHERE m.coin = :coin")})
public class MonsterAccount implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "win_point")
    private int winPoint;
    @Basic(optional = false)
    @Column(name = "coin")
    private int coin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monsterAccount")
    private Collection<MonsterItem> monsterItemCollection;
    @JoinColumn(name = "monster_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Monster monsterId;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;

    public MonsterAccount() {
    }

    public MonsterAccount(Integer id) {
        this.id = id;
    }
    public MonsterAccount(Account akun_baru, Monster momon, String monster_name, int monster_hp, int monster_ap, int  monster_dp, int monster_winPoint, int monster_coin) {
    
    this.accountId = akun_baru;
    this.monsterId= momon;
    this.name= monster_name;
    this.hp= monster_hp;
    this.ap= monster_ap;
    this.dp= monster_dp;
    this.winPoint= monster_winPoint;
    this.coin= monster_coin;
    }

    public MonsterAccount(Integer id, String name, int hp, int ap, int dp, int winPoint, int coin) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.ap = ap;
        this.dp = dp;
        this.winPoint = winPoint;
        this.coin = coin;
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

    public int getWinPoint() {
        return winPoint;
    }

    public void setWinPoint(int winPoint) {
        this.winPoint = winPoint;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    @XmlTransient
    public Collection<MonsterItem> getMonsterItemCollection() {
        return monsterItemCollection;
    }

    public void setMonsterItemCollection(Collection<MonsterItem> monsterItemCollection) {
        this.monsterItemCollection = monsterItemCollection;
    }

    public Monster getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Monster monsterId) {
        this.monsterId = monsterId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
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
        if (!(object instanceof MonsterAccount)) {
            return false;
        }
        MonsterAccount other = (MonsterAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.MonsterAccount[ id=" + id + " ]";
    }
    
}
