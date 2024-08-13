package br.com.arthurferreira.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.arthurferreira.domain.Venda;
import br.com.arthurferreira.service.IVendaService;

@Named
@ViewScoped
public class VendaController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Venda venda;
    private Collection<Venda> vendas;

    @Inject
    private IVendaService vendaService;

    private Boolean isUpdate;

    @PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.venda = new Venda();
            this.vendas = vendaService.buscarTodos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar as vendas"));
        }
    }

    public void cancel() {
        try {
            this.isUpdate = false;
            this.venda = new Venda();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
        }
    }

    public void edit(Venda venda) {
        try {
            this.isUpdate = true;
            this.venda = venda;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar a venda"));
        }
    }

    public void delete(Venda venda) {
        try {
            vendaService.excluir(venda);
            vendas.remove(venda);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir a venda"));
        }
    }

    public void add() {
        try {
            vendaService.cadastrar(venda);
            this.vendas = vendaService.buscarTodos();
            this.venda = new Venda();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar a venda"));
        }
    }

    public void update() {
        try {
            vendaService.alterar(this.venda);
            cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Venda atualizada com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar a venda"));
        }
    }

    public String voltarTelaInicial() {
        return "/index.xhtml";
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Collection<Venda> getVendas() {
        return vendas;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }
}
