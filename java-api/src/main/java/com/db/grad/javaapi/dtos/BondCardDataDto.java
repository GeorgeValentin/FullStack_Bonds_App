package com.db.grad.javaapi.dtos;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Client;
import com.db.grad.javaapi.model.Issuer;

import java.util.Date;

public class BondCardDataDto {
    private Integer bondId;
    private String cusip;
    private String isin;
    private String issuerName;
    private String clientName;
    private Date bondMaturityDate;

    public BondCardDataDto(Bond bond) {
        this.bondId = bond.getBondId();
        this.cusip = bond.getCusip();
        this.isin = bond.getIsin();
        this.bondMaturityDate = bond.getBondMaturityDate();

        Client client = bond.getClient();
        if(client != null) {
            this.clientName = client.getBondHolder();
        }

        Issuer issuer = client.getIssuer();

        if(issuer != null) {
            this.issuerName = issuer.getIssuerName();
        }
    }

    public Integer getBondId() {
        return bondId;
    }

    public void setBondId(Integer bondId) {
        this.bondId = bondId;
    }

    public Date getBondMaturityDate() {
        return bondMaturityDate;
    }

    public void setBondMaturityDate(Date bondMaturityDate) {
        this.bondMaturityDate = bondMaturityDate;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
