package org.acme.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Compra extends Default{
    
    @Column
    LocalDateTime datetime;

    @Column
    Double totalcompra;

    @JoinColumn(name = "id_endereco")
    @OneToOne
    Endereco endereco;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    Usuario usuario;
    
    @JoinColumn(name="id_meioPagamento")
    @OneToOne
    MeioPagamento meioPagamento;

    @JoinColumn(name="id_itemCompra")
    @OneToMany
    List<ItemCompra> itemCompras;

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public List<ItemCompra> getItemCompras() {
        return itemCompras;
    }

    public void setItemCompras(List<ItemCompra> itemCompras) {
        this.itemCompras = itemCompras;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Double getTotalcompra() {
        return totalcompra;
    }

    public void setTotalcompra(Double totalcompra) {
        this.totalcompra = totalcompra;
    }
   
}
