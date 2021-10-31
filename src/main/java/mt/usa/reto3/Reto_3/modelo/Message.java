/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hldua
 */
@Entity
@Table(name="message")
public class Message implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messsageText;
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"message","reservation"})
    private Ortopedic ortopedic;
    
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"message","reservation"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMesssageText() {
        return messsageText;
    }

    public void setMesssageText(String messsageText) {
        this.messsageText = messsageText;
    }

    public Ortopedic getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortopedic ortopedic) {
        this.ortopedic = ortopedic;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
}
