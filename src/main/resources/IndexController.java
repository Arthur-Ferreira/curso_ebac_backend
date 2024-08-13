<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:p="http://primefaces.org/ui">

<h:head>
    <title>Vendas</title>
</h:head>
<h:body>
    <h:form id="vendaForm">
        <p:growl id="growl" showDetail="true" />
        <p:panel header="Cadastro de Vendas">
            <h:panelGrid columns="2">
                <h:outputLabel value="Produto:" for="produto" />
                <p:inputText id="produto" value="#{vendaController.venda.produto}" />

                <h:outputLabel value="Quantidade:" for="quantidade" />
                <p:inputText id="quantidade" value="#{vendaController.venda.quantidade}" />

                <h:outputLabel value="Preço Total:" for="precoTotal" />
                <p:inputText id="precoTotal" value="#{vendaController.venda.precoTotal}" />
            </h:panelGrid>
            <p:commandButton value="Salvar" action="#{vendaController.add}" update="@form" />
            <p:commandButton value="Cancelar" action="#{vendaController.cancel}" update="@form" />
        </p:panel>
        <p:dataTable value="#{vendaController.vendas}" var="venda" selectionMode="single" selection="#{vendaController.venda}">
            <p:column headerText="Produto">
                <h:outputText value="#{venda.produto}" />
            </p:column>
            <p:column headerText="Quantidade">
                <h:outputText value="#{venda.quantidade}" />
            </p:column>
            <p:column headerText="Preço Total">
                <h:outputText value="#{venda.precoTotal}" />
            </p:column>
            <p:column headerText="Ações">
                <p:commandButton value="Editar" action="#{vendaController.edit(venda)}" update="@form" />
                <p:commandButton value="Excluir" action="#{vendaController.delete(venda)}" update="@form" />
            </p:column>
        </p:dataTable>
    </h:form>
</h:body>
</html>
