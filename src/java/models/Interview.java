/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "tb_tr_interview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interview.findAll", query = "SELECT i FROM Interview i")
    , @NamedQuery(name = "Interview.findById", query = "SELECT i FROM Interview i WHERE i.id = :id")
    , @NamedQuery(name = "Interview.findByDate", query = "SELECT i FROM Interview i WHERE i.date = :date")
    , @NamedQuery(name = "Interview.findByTime", query = "SELECT i FROM Interview i WHERE i.time = :time")
    , @NamedQuery(name = "Interview.findByLocation", query = "SELECT i FROM Interview i WHERE i.location = :location")
    , @NamedQuery(name = "Interview.findByDepartment", query = "SELECT i FROM Interview i WHERE i.department = :department")
    , @NamedQuery(name = "Interview.findByPic", query = "SELECT i FROM Interview i WHERE i.pic = :pic")
    , @NamedQuery(name = "Interview.findByIsAccepted", query = "SELECT i FROM Interview i WHERE i.isAccepted = :isAccepted")})
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "department")
    private String department;
    @Basic(optional = false)
    @Column(name = "pic")
    private String pic;
    @Column(name = "is_accepted")
    private Boolean isAccepted;
    @JoinColumn(name = "participant", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Participant participant;
    @JoinColumn(name = "client", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    public Interview() {
    }

    public Interview(String id) {
        this.id = id;
    }

    public Interview(String id, Date date, Date time, String location, String department, String pic, Boolean isAccepted, Participant participant, Client client) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.location = location;
        this.department = department;
        this.pic = pic;
        this.isAccepted = isAccepted;
        this.participant = participant;
        this.client = client;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        if (!(object instanceof Interview)) {
            return false;
        }
        Interview other = (Interview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Interview[ id=" + id + " ]";
    }
    
}
