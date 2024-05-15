package org.acme.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class MeioPagamento extends Default {
    
    @Enumerated
    TipoPagamento meioPagamento;

    @JoinColumn(name = "id_cartao")
    @ManyToOne
    Cartao cartao;
 
    public TipoPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(TipoPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    
}
